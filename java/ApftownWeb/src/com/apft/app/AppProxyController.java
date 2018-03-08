package com.apft.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.util.PasswordUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apft.core.ApplicationContextUtil;
import com.apft.mvc.controller.reg.LoginController;
import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserAccountEntity;
import com.apft.mvc.model.TbUserEntity;
import com.apft.pay.alipay.util.AlipayNotify;
import com.apft.pay.alipay.util.PayUtil;
import com.apft.utils.Base64;
import com.apft.utils.Encrypt;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;
import com.apft.utils.StringUtil;
import com.apft.utils.ZLConfigure;
import com.apft.utils.ZLStringUtils;
import com.apft.utils.ZLUtils;
import com.apft.utils.ZToken;




/**
 * 
 * @ClassName: M3AppController.java
 * @Description: TODO
 * 
 * @author Administrator
 * @version V1.0
 * @Date 2015-6-10 上午10:58:03
 */
@Controller
@RequestMapping("/appproxy")
public class AppProxyController {
	
	public static final int ERR_CODE_NOSIGIN = -500;
	
	
	
	@Autowired
	private CommDao dao;

	/**
	 * 登录方法
	 */
	@RequestMapping(params = "v3")
	@ResponseBody
	public void ProxyCore3(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/json;charset=UTF-8");  

        String reqCmd, respCmd;  
		JSONObject reqObject = null;  

        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));  
            StringBuffer sb = new StringBuffer();  
            String temp;  
            while ((temp = br.readLine()) != null) {  
                sb.append(temp);  
            }  
            br.close();  
            
            reqCmd = sb.toString();  
            System.out.println(">>>:" + reqCmd);  
            
            JSONObject respObject = null;
            try{
            	reqObject = JSON.parseObject(reqCmd);
            	
            	///////encrypt at here
            	String strBase64 = (String)reqObject.get(Encrypt.ENC_KEY);
            	byte [] btData = Base64.decode(strBase64);
            	
            	String strJson = Encrypt.FrameDecrypt(btData, Encrypt.QLFG_KEY);
            	
            	reqObject = JSON.parseObject(strJson);
            	///////////
            	
            	
            	respObject = parseAppCmd(reqObject,request, response);
            	respCmd = respObject.toString();
            	
            	////////// wirte encrypt at here 
            	btData = Encrypt.FrameEncrypt(respCmd, Encrypt.QLFG_KEY);
            	strBase64 = Base64.encode(btData);
            	respObject.clear();
            	respObject.put(Encrypt.ENC_KEY, strBase64);
            	
            	respCmd = respObject.toString();
            	
            	
            	//////////////////////
            }catch(Exception ej){
            	ej.printStackTrace();
            	respCmd = "{\"cmd\":\"error\",\"ret\":-1,\"msg\":\"unkown\"}";
            }
            
            
            if (null != respCmd)
            	System.out.println("<<<:" + respCmd);  
            
            PrintWriter pw = response.getWriter();  
            pw.write(respCmd);  
            pw.flush();  
            pw.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  

        }
	}	
	
/*public static void main(String[] args) {
	String str = "[    {        \"y\": \"tb_res\",    },    ]";
	JSONArray reqObject = new JSONArray();
}*/
	/**
	 * 登录方法
	 */
	@RequestMapping(params = "v1")
	@ResponseBody
	public void ProxyCore(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/json;charset=UTF-8");  
        
        String reqCmd, respCmd;  
		JSONObject reqObject = null;  

        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));  
            StringBuffer sb = new StringBuffer();  
            String temp;  
            while ((temp = br.readLine()) != null) {  
                sb.append(temp);  
            }  
            br.close();  
            
            reqCmd = sb.toString();
            if (reqCmd.length()==0){
            	reqCmd = request.getParameter("postdata");
            }
            System.out.println(">>>:" + reqCmd);  
            
            JSONObject respObject = null;
            try{
            	reqObject = JSON.parseObject(reqCmd);
            	
            	respObject = parseAppCmd(reqObject,request, response);
            	
            	respCmd = respObject.toString();
            }catch(Exception ej){
            	ej.printStackTrace();
            	respCmd = "{\"cmd\":\"error\",\"ret\":-1,\"msg\":\"unkown\"}";
            }
            
            if (null != respCmd)
            	System.out.println("<<<:" + respCmd);  
            
            PrintWriter pw = response.getWriter();  
            pw.write(respCmd);  
            pw.flush();  
            pw.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  

        }
	}
	//,ModelMap model
	@RequestMapping(params = "orderDetail")
	/*@ResponseBody*/
	public void orderDetail(HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject respObject = new JSONObject();
		String v_amount =   (String) request.getParameter("v_amount"); 
		
		String proName = "123456";
		String proInfo = "123456";
		String price = "50.0";
		String serialNo = "alipay-20161019160402-583612";
		
		PayUtil pay=new PayUtil();
		String info=pay.pay(proName, proInfo, price, serialNo);
				//("test", "testtest", "0.01", "das");
		//request.setAttribute("info", "123");
		//response.set
		respObject.put("info", info);
		
		//request
		PrintWriter pw = response.getWriter();  
        pw.write(respObject.toString());  
        pw.flush();  
        pw.close(); 
	}
	
	
	@RequestMapping(params = "dataValidation")
	public void dataValidation(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
		
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号	
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//支付宝交易号	
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		//异步通知ID
		String notify_id=request.getParameter("notify_id");
		//sign
		String sign=request.getParameter("sign");
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		
		if(notify_id!=""&&notify_id!=null){////判断接受的post通知中有无notify_id，如果有则是异步通知。
			if(AlipayNotify.verifyResponse(notify_id).equals("true"))//判断成功之后使用getResponse方法判断是否是支付宝发来的异步通知。
			{
				if(AlipayNotify.getSignVeryfy(params, sign))//使用支付宝公钥验签
				{
					//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
					if(trade_status.equals("TRADE_FINISHED")){
						//判断该笔订单是否在商户网站中已经做过处理
							//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
							//如果有做过处理，不执行商户的业务程序
						//注意：
						//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
						//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
						
					} else if (trade_status.equals("TRADE_SUCCESS")){
						//判断该笔订单是否在商户网站中已经做过处理
							//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
							//如果有做过处理，不执行商户的业务程序
						//注意：
						//付款完成后，支付宝系统发送该交易状态通知
						//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
					}
					//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
					System.out.print("success");//请不要修改或删除
					
					//调试打印log
					//AlipayCore.logResult("notify_url success!","notify_url");
				}
				else//验证签名失败
				{
					System.out.print("sign fail");
				}
			}
			else//验证是否来自支付宝的通知失败
			{
				System.out.print("response fail");
			}
		}
		else{
			System.out.print("no notify message");
		}
	}
	
	
	
	
	private void setJsonCmdRet(JSONObject respObject, int ret, String msg, String token){
		respObject.put("ret", ret);
		if (ret!=0)
			respObject.put("msg", msg);
		if (ret >=0)
			respObject.put("tk", token);
		else
			respObject.remove("tk");
	}
	

	private JSONObject parseAppCmd(JSONObject reqCmd,HttpServletRequest request, HttpServletResponse response)throws Exception{
		JSONObject respObject = new JSONObject();
		
		String cmd = reqCmd.getString("cmd");
		String os = reqCmd.getString("os");
		String tk = reqCmd.getString("tk");
		
		respObject.put("cmd", cmd);
		
		if (cmd.equals("login")){
//			respObject.put("tk", tk);

			String username = reqCmd.getString("username");
			if (null != username)
				username = username.trim();
			String password = reqCmd.getString("password");
			if (null != password)
				password = password.trim();
			
			if(username!= null && !"".equals(username) && password!= null && !"".equals(password)){
				/*TbUserEntity rUsers = (TbUserEntity) dao.queryForEntity("select * from tb_user where user_name= '"+username+"'", TbUserEntity.class);
				
				if (null == rUsers.getId())
					rUsers = (TbUserEntity) dao.queryForEntity("select * from tb_user where user_reg_mobile= '"+username+"'", TbUserEntity.class);
				
				if (null == rUsers.getId())
					rUsers = (TbUserEntity) dao.queryForEntity("select * from tb_user where user_reg_email= '"+username+"'", TbUserEntity.class);
				*/
				//调用登录
				String ip = ZLUtils.getIpAddr(request);
				String userAgent = request.getHeader("user-agent");
				if(null != userAgent && userAgent.length() > 1000)
					userAgent = userAgent.substring(0, 1000);
				
				List<Object> lstPara = new ArrayList<Object>();
				lstPara.add(username);
				lstPara.add(PasswordUtil.encrypt(password));
				lstPara.add(ip);
				lstPara.add(userAgent);
				/*lstPara.add(0);
				lstPara.add("id");
				List<Object> result = dao.callProc("pc_user_signin", lstPara, 2);*/
				lstPara.add(0);
				lstPara.add(0);
				lstPara.add("uid");
				lstPara.add("cid");
				lstPara.add("signin_type");
				List<Object> result = dao.callProc("pc_user_signin_comp", lstPara, 4);
				//List result = tbUserService.loginByPc(username, PasswordUtil.encrypt(password),ip,userAgent);
				//获取存储结果的内容 有code 有user的id
				int code = (Integer)result.get(0);
				String userId = (String) result.get(1);
				String compId = (String) result.get(2);
				String signType = (String) result.get(3); 
				TbUserEntity rUsers = null;
				if(code >= 0){
					if(userId != null){
						LoginController loginMethods = ApplicationContextUtil.getContext().getBean(LoginController.class);
						rUsers = loginMethods.setUserAllUnits(request, response, userId, compId, signType);
					}
				}	
				if (null == rUsers || null == rUsers.getId()) {
					setJsonCmdRet(respObject,-3,"用户名不存在",null);
				} else {
					String cuserpwd = rUsers.getUserPwd();
					if(rUsers.getTbUserPersonalEntity() != null && !rUsers.getTbUserPersonalEntity().equals("")){
						cuserpwd = rUsers.getTbUserPersonalEntity().getUserPwd();
						respObject.put("useridPer", rUsers.getTbUserPersonalEntity().getId());
					}
						String pwdciphertext = PasswordUtil.encrypt(password);
					if (cuserpwd.equals(pwdciphertext)) {
						
						SessionUtil.setSessionUser(rUsers);
						
						ZToken token = ApplicationContextUtil.getContext().getBean(ZToken.class);
						
						String tokenCode = token.writeToken(request, response, ZToken.ZTOKEN_USER_KEY, rUsers.getId());
						
						String name = rUsers.getUserName();
						if(null != name && name.length() > 0){}
						else
							name = "";
						
						String realname = rUsers.getUserRealName();
						if(null != realname && realname.length() > 0){}
						else
							realname = "";
							
						respObject.put("userid", rUsers.getId());
						respObject.put("username", name);
						respObject.put("usercat", rUsers.getUserCat()+" ");
						respObject.put("userimg", rUsers.getUserImg());
						respObject.put("userrealname", realname);
						respObject.put("usermobile", rUsers.getUserRegMobile());
						
						respObject.put("cartcount", 0);//czl tdService.getCartCount(rUsers.getId()));
						
						
						
						/*//矿业大会  App第一次登陆给20矿业币
						String useract = "select count(id) from tb_user_act_log where user_id='"+rUsers.getId()+"' and act_type='signin' and act_data2='app' ";
						int useractCnt = dao.queryForCount(useract, CommDao.CACHE_NO_TIME);
						if(useractCnt == 0){
							String addgift = "INSERT tb_user_gift_certificate(id,user_id,name,act,type,maximum_units,status,price,date_begin,date_end,data,remark)"+
												" VALUES(f_zluuid(), '"+rUsers.getId()+"', '矿业币',59, 1059, 0.01,0,20, CURDATE(),DATE_ADD(CURDATE(),INTERVAL 9 month), null, '矿业币，用来兑换活动礼品')";
							dao.update(addgift);
						}*/
						//otherService.recordUserAct(rUsers.getId(), ip, "signin", userAgent, "app", null);
//czl						otherService.userAct(request, response, "app-singin", null);
							
						
						
						
						
						
						//分享需要的fm
						String sharefm = rUsers.getUserName();
						if(!StringUtil.isNull(sharefm)){ //user_name 不是空
							if( StringUtil.isChina(sharefm) ){ // 判断是不是汉字
								
								if(!StringUtil.isNull(rUsers.getUserRegMobile())){//手机号不是空
									sharefm = rUsers.getUserRegMobile();
								}else if(!StringUtil.isNull(rUsers.getUserRegEmail())){//email不是空
									sharefm = rUsers.getUserRegEmail();
								}
								
							}
						}else if(!StringUtil.isNull(rUsers.getUserRegMobile())){//手机号不是空
							sharefm = rUsers.getUserRegMobile();
						}else if(!StringUtil.isNull(rUsers.getUserRegEmail())){//email不是空
							sharefm = rUsers.getUserRegEmail();
						}
						
						
						
						
						setJsonCmdRet(respObject,0,"success",tokenCode);
					} else {
						setJsonCmdRet(respObject,-2,"密码错误",null);
					}
				}
			}else{
				//验证token 
				ZToken ztk = ApplicationContextUtil.getContext().getBean(ZToken.class);//ApplicationContextUtil.getContext().getBean(ZToken.class);
				TbUserEntity cuser = ztk.signToken(tk);
				
				if (cuser != null){
					String tokenCode = ztk.encodeToken(cuser.getId(), null);
					
					tokenCode = ztk.writeToken(request, response, ZToken.ZTOKEN_USER_KEY, cuser.getId());
					SessionUtil.setSessionUser(cuser);
					
					setJsonCmdRet(respObject,0,"success",tokenCode);
					
				}else{
					SessionUtil.setSessionUser(null);
					setJsonCmdRet(respObject,-3,"token invalid!",null);
				}
			}			
		}else if (cmd.equals("logout")){
			
			//删除session中的user
			SessionUtil.setSessionUser(null);
			
			ZToken ztk = ApplicationContextUtil.getContext().getBean(ZToken.class);//ApplicationContextUtil.getContext().getBean(ZToken.class);
			ztk.removeToken(request, response, ZToken.ZTOKEN_USER_KEY, null);
			
			setJsonCmdRet(respObject,0,"success",null);

		}else if(cmd.equals("getaccount")){//查询账户总资产
			TbUserEntity user = SessionUtil.getSessionUser();
			if(null == user){
				setJsonCmdRet(respObject,ERR_CODE_NOSIGIN,"请先登录",null);
				return respObject;
			}/*else{
//				user = (TbUserEntity) dao.queryForEntity("select * from tb_user where id='"+user.getId()+"'", TbUserEntity.class, CommDao.CACHE_NO_TIME);
			}*/
			respObject.put("user", user);
			String userId = user.getId();
			if(user.getTbUserPersonalEntity() != null)
				userId = user.getTbUserPersonalEntity().getId();
			String roleMapSql = "select ur.id as uid,ac.name,ac.id,ac.logo,ur.status from tb_user_role ur,tv_audit_company ac where ur.company_id=ac.id and  ac.lg=0 and ur.user_id='"+userId+"' and (ur.status='300' or ur.status='200') ORDER BY FIELD(ur.status, 300 ,200) limit 1";
			Map<String, Object> roleMap=dao.queryForMap(roleMapSql, CommDao.CACHE_MAX_TIME);
			
			respObject.put("roleMap", roleMap);
			
			TbUserAccountEntity tbUerAccount = (TbUserAccountEntity) dao.queryForEntity("select * from tb_user_account where id='"+user.getId()+"'", TbUserAccountEntity.class, CommDao.CACHE_MIN_TIME);
			respObject.put("tbUerAccount", tbUerAccount);
			
/////////////////////////////////////////////
			double dTotalAssets = tbUerAccount.getAvailableBalance()+tbUerAccount.getFeesAmt()+tbUerAccount.getFreezingBalance();
			
			//代收利息(payment_interest)、本金（payment_amount）
			String sql="select (select sum(pay_money) from tb_user_assets where user_id ='"+user.getId()+"' and status = '1') pm,sum(payment_interest) dslx from tb_prd_income where user_id='"+user.getId()+"' and status=0";
			try{
			
				List<Map<String, Object>> mapList = dao.queryForList(sql, CommDao.CACHE_MAX_TIME);
				if (mapList != null && mapList.size()>0){
					Map<String, Object> mapItem = mapList.get(0);
					dTotalAssets += (Double)mapItem.get("pm");
				}
			}catch(Exception e){}
/////////////////////////////////////////////////			
			
			respObject.put("totalasset", dTotalAssets);//???
			
			String yesSql = "select IFNULL(sum(opt_amount),0) yesterdayicome from tb_user_account_log where user_id='"+user.getId()+"' and TO_DAYS( NOW( ) ) - TO_DAYS( create_time) <= 0 and (cat = 2 or (cat>=200 and cat<210))";
			
			respObject.put("yesterdayicome", dao.queryForMap(yesSql, CommDao.CACHE_MAX_TIME).get("yesterdayicome"));//???
			
			String userName = user.getUserName();
			String imgStr = user.getUserImg();
			String logoStr = "";
			if(user.getTbUserPersonalEntity() != null && !user.getTbUserPersonalEntity().equals("")){
				Map<String, Object> logo = dao.queryForMap("SELECT logo FROM tb_audit_company WHERE id = '"+user.getId()+"'", CommDao.CACHE_NO_TIME);
				logoStr = logo.get("logo").toString();
				imgStr = user.getTbUserPersonalEntity().getUserImg();
				respObject.put("logo", logoStr);
				respObject.put("compName", user.getUserName());
				userName = user.getTbUserPersonalEntity().getUserName();
			}
			respObject.put("userName", userName);
			respObject.put("userImg", imgStr);
			
			setJsonCmdRet(respObject,0,"success",null);
		}else if(cmd.equals("setuserinfo")){//修改用户信息
			TbUserEntity user = SessionUtil.getSessionUser();
			if (user == null){
				String userid = reqCmd.getString("userid");
				if(null != userid && userid.length() > 0)
					user = (TbUserEntity) dao.queryForEntity("select * from tb_user where id='"+userid+"'", TbUserEntity.class, CommDao.CACHE_MAX_TIME);
			}
			if(null == user){
				setJsonCmdRet(respObject,ERR_CODE_NOSIGIN,"请先登录",null);
				return respObject;
			}
			
			StringBuffer strBuf = new StringBuffer("UPDATE tb_user SET ");
			int first = 0;
			JSONObject obj = reqCmd.getJSONObject("col");
			 for (Map.Entry<String, Object> entry : obj.entrySet()) {
		            if (first>0)
	                    strBuf.append(',');
	                strBuf.append(entry.getKey());
	                strBuf.append("='");
	                strBuf.append(entry.getValue());
	                strBuf.append("\'");
	                first++;
		        }
            	
            strBuf.append(" WHERE id='");
            strBuf.append(user.getId());
            strBuf.append('\'');
			
            int up = 0;
			try {
				dao.update(strBuf.toString());
				
				TbUserEntity tbUser = (TbUserEntity) dao.queryForEntity("select * from tb_user where id='"+user.getId()+"'", TbUserEntity.class, CommDao.CACHE_NO_TIME);
				SessionUtil.setSessionUser(tbUser);
				
				up = 1;
			} catch (Exception e) {
				setJsonCmdRet(respObject,-2,"修改用户信息失败。。。。",null);
			}
			if(up > 0 )
				setJsonCmdRet(respObject,0,"修改用户信息成功！！",null);
		}else if(cmd.equals("setpwd")){//修改登录密码
			TbUserEntity user = SessionUtil.getSessionUser();
			if(null == user){
				setJsonCmdRet(respObject,ERR_CODE_NOSIGIN,"请先登录",null);
				return respObject;
			}else{
				user = (TbUserEntity) dao.queryForEntity("SELECT * FROM tb_user WHERE id='"+user.getId()+"'", TbUserEntity.class, CommDao.CACHE_MAX_TIME);
			}
			
			String pwd_old = reqCmd.getString("pwd_old");//登录旧密码
			String pwd_new = reqCmd.getString("pwd_new");//登录新密码
			
			//判断登录旧密码不为空
			if(null != pwd_old && pwd_old.length() > 0){
				pwd_old = PasswordUtil.encrypt(pwd_old);//加密登录旧密码
			
				//判断登录旧密码与数据库登录密码是否相同
				if(pwd_old.equals(user.getUserPwd())){
					
					//判断新登录密码不为空
					if(null != pwd_new && pwd_new.length() > 0){
						pwd_new = PasswordUtil.encrypt(pwd_new);
						
						int up = 0;
						try {
							up = dao.update("update tb_user set user_pwd='"+pwd_new+"' where id='"+user.getId()+"'");
							
						} catch (Exception e) {
							setJsonCmdRet(respObject,-2,"登录密码修改失败。。。。",null);
						}
						if(up > 0 )
							setJsonCmdRet(respObject,0,"登录密码修改成功！",null);
					}
				}else
					setJsonCmdRet(respObject,-3,"登录旧密码不正确",null);
			}
		}else if(cmd.equals("feedback")){//意见反馈
			String msg = reqCmd.getString("msg");//意见内容
			TbUserEntity user = SessionUtil.getSessionUser();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt = new Date(System.currentTimeMillis());
			
			dao.insert("tb_user_feedback", "user_id",user.getId(),"data",msg,"data2",os,"insert_time",sdf.format(dt));
			
			setJsonCmdRet(respObject,0,"success",null);
		}
		else if(cmd.equals("getmsg")){//站内信
			String userid = reqCmd.getString("userid");
			Long lTime = reqCmd.getLong("t");
			String sql = "select type,msg_title title,msg_content content,create_time time from tb_user_msg um where user_id='"+userid
					+"' and (cat&1)=1 and UNIX_TIMESTAMP(create_time)>"+lTime.longValue()+" order by (create_time) DESC limit 50;";
			List<Map<String, Object>> msglist = dao.queryForList(sql,CommDao.CACHE_MAX_TIME);
			
			for (Map<String, Object> map : msglist) {
				map.put("fmt", "txt");
				map.put("ico", "http://goldenlend.com/m5/img/app/msg_type/"+map.get("type")+".png");//"+map.get("type")+"
			}
			
			respObject.put("t", System.currentTimeMillis()/1000);
			respObject.put("msglist", msglist);
			setJsonCmdRet(respObject,0,"success",null);
		}
		
////////////////// App 第三版////////////////////////////////////////////
		
		else if(cmd.equals("getmenu")){// 活 菜单
			
			String strLg = reqCmd.getString("lg");
			
			Long lastTimeClient = reqCmd.getLong("time");
			
			String CurrentClassFilePath = this.getClass().getResource("").getPath();    
			CurrentClassFilePath = URLDecoder.decode(CurrentClassFilePath, "utf-8");
			int lastpath=CurrentClassFilePath.lastIndexOf("classes/");
		    String web_rootPath=CurrentClassFilePath.substring(0,lastpath);
		    
		    String strAppLabel = reqCmd.getString("applabel");
		    if ( null == strAppLabel || strAppLabel.length()==0)
		    	strAppLabel="";
		    else
		    	strAppLabel = '_'+strAppLabel;
		   
		    web_rootPath += "classes/appmenu" + strAppLabel;
		    if (SiteOEM.__DEBUG__() )
		    	web_rootPath += "_test";
		    
		    if (null != strLg && strLg.length()>0){
		    	
		    	request.getSession().setAttribute("SF_LG", strLg);
		    	
		    	if  (!strLg.equals("cn"))
		    		web_rootPath += '_' + strLg;
		    }
		    
		    web_rootPath += ".json";
		    File file=new File(web_rootPath);
		    if(file.isFile() && file.exists()){ //判断文件是否存在

        	  long lastTimeServer = file.lastModified()/1000;
        	  if (lastTimeServer > lastTimeClient.longValue()){
                  InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");
                  BufferedReader bufferedReader = new BufferedReader(read);
                  StringBuffer strBuf = new StringBuffer();
                  String lineTxt = null;
                  while((lineTxt = bufferedReader.readLine()) != null){
                	  strBuf.append(lineTxt);
                  }
                  read.close();
          		
                  JSONObject jsonObject = new JSONObject();

                  respObject =  jsonObject.parseObject(strBuf.toString());
                  respObject.put("time", lastTimeServer);
                  
                  setJsonCmdRet(respObject,0,"success",null);
                  
        	  }else{
        		  setJsonCmdRet(respObject,-2,"null",null);
        	  }
		    }else{
		    	setJsonCmdRet(respObject,-1,"null",null);
		    	
		    }
		}
		// 20160513--LIAO   购物车
		else if(cmd.equals("getcart")){
			
			String userid = reqCmd.getString("userid");
			if(null != userid && userid.length() > 0){
				int cartCount = 0;//czl tdService.getCartCount(userid);
				
				respObject.put("cartcount", cartCount);
				setJsonCmdRet(respObject,0,"success",null);
			}
			setJsonCmdRet(respObject,-1,"error",null);
		}else if (cmd.equals("getidx")){
			//"filter":["Home","Mall","Flagship","TradingFloor","CrowdFunding","Train","Meeting","News"]
			JSONArray jsonFilter = (JSONArray)reqCmd.get("filter");
			respObject.put("filter", jsonFilter);
			
			String path = "http://"+request.getServerName()+"/"+ZLConfigure.getInstance().getProjectName();
			
			if (null != jsonFilter){
				for(int i=0; i<jsonFilter.size(); i++){
					String strPage = (String)jsonFilter.get(i);
					JSONObject jsonPage = new JSONObject();
					
					JSONObject jsonObj = readJson(strPage+".json");
					if(null != jsonObj){
						JSONArray jsonContentOut = new JSONArray();
						JSONArray jsonContentModel = (JSONArray)jsonObj.get("content");
						
						for (Object o : jsonContentModel) {
							JSONObject content = (JSONObject)o;
							int modelNo = content.getIntValue("modelNo");
							String floorNo = content.getString("floorNo");
							String floorName = content.getString("floorName");
							String sql = content.getString("sql");
							String infoUrl = content.getString("infoUrl");
							
							jsonContentOut.add(getFloor(modelNo, floorNo, floorName, sql, path+infoUrl));
						}
						jsonPage.put("banner", jsonObj.get("banner"));
						jsonPage.put("content", jsonContentOut);
					}
					
					respObject.put(strPage, jsonPage);
				}
				setJsonCmdRet(respObject,0,"success",null);
			}else
				setJsonCmdRet(respObject,-1,"error",null);
		}else if(cmd.equals("getfloor")){
			//banner
			JSONObject jsonBanner = new JSONObject();
			jsonBanner.put("height", "40");
			jsonBanner.put("width", "60");
			jsonBanner.put("images", new String[]{"http://www.miningcircle.com/img/m/home/l1.jpg","http://www.miningcircle.com/img/m/home/l2.jpg","http://www.miningcircle.com/img/m/home/l3.jpg"});
			respObject.put("banner", jsonBanner);

			String path = "http://"+request.getRemoteHost() +request.getContextPath();
			
			JSONArray jsonContent = new JSONArray();
			
			String [] floorName = {"贵金属","有色金属","黑色金属","能源矿产","稀土分散","非金属 ","矿用设备","耗材药剂"};//,"专业服务"
			for(int f=0; f<floorName.length; f++){
				String strfloor = readJson("floor"+f+".json").toString();//读取模板文件
				strfloor = strfloor.replace("{`FLOOR}", "0"+f+"F");
				strfloor = strfloor.replace("{`FLOORNAME}", floorName[f]);

				//商城
				String mallSQL = "SELECT id, img, title, price,title2,sold_quantity FROM tb_res " +
						"WHERE mineral IN (select catid from tb_mineral where (catid&0xffff)="+(1<<f)+") and status >= '0' and cat_id = '3200' order by update_time desc LIMIT 12";
				List<Map<String, Object>> malllst = dao.queryForList(mallSQL,CommDao.CACHE_MAX_TIME);
				
				for (int i = 0; i < malllst.size(); i++) {
					Map<String, Object> m = malllst.get(i);
					strfloor = strfloor.replace("{`IMG#"+i+"}", m.get("img").toString());
					strfloor = strfloor.replace("{`URL#"+i+"}", path + "/i.do?o="+m.get("id"));
					strfloor = strfloor.replace("{`TITLE#"+i+"}", m.get("TITLE").toString());
					strfloor = strfloor.replace("{`TITLE2#"+i+"}", m.get("TITLE2").toString());
					strfloor = strfloor.replace("{`PRICE#"+i+"}", m.get("PRICE").toString());
				}
				
				JSONObject jsonObj = new JSONObject();
				jsonObj = JSONObject.parseObject(strfloor);
				
				jsonContent.add(jsonObj);				
			}
			
			respObject.put("content", jsonContent);
	
			setJsonCmdRet(respObject,0,"success",null);
		}else if(cmd.equals("qrcodevalid")){
			
			
			String allurl = reqCmd.getString("no");//二维码连接
			
			String cate = reqCmd.getString("cate");//cate=gift 领取礼品,cate=ticket 验证门票
			
			String no = "";
			if(null != allurl){
				if(allurl.indexOf("n=") > 0){
					no = allurl.substring(allurl.indexOf("n=")+2, allurl.length());
					List<Map<String, Object>> userlst = dao.queryForList("select u.id,u.user_cat,u.insert_time,u.user_reg_mobile,ac.name,ac.contact " +
																  " FROM tb_user u,tb_audit_company ac " +
																  " where u.id=ac.id and ac.no='"+no+"' ", CommDao.CACHE_NO_TIME);		
					if(userlst.size()>0){
						Map<String, Object> userinfo = userlst.get(0);
						respObject.put("userinfo", userinfo);
						if("ticket".equals(cate)){//验证门票
							
							List<Map<String, Object>> ticketinfo = dao.queryForList("select * from tb_user_gift_certificate where user_id='"+userinfo.get("id")+"' and act='60' and type='1060'", CommDao.CACHE_NO_TIME);
							
							if(ticketinfo.size() > 0){
								respObject.put("ticketinfo", ticketinfo.get(0));
								
								String status = ticketinfo.get(0).get("status").toString();
								if(status.equals("0")){
									
									int upret = dao.update("update tb_user_gift_certificate set status=1 where id='"+ticketinfo.get(0).get("id")+"' ");
									setJsonCmdRet(respObject,0,"您的门票已通过！",null);
								}else{
									setJsonCmdRet(respObject,-1,"您的门票已使用",null);
								}
							}else{
								setJsonCmdRet(respObject,-1,"您是老用户，目前没有门票",null);
							}
							
							
							
							
							
							/*
							
							int house_loan3 = ((Integer)userinfo.get("house_loan3")).intValue();
							
							if( house_loan3 == 0 ){
									
								int uptiket = dao.update("update tb_audit_mine_guarantee set house_loan3=1 where id='"+userinfo.get("id")+"' and house_loan3=0");
								
								setJsonCmdRet(respObject,0,"您的门票已通过！",null);
							}else{
								setJsonCmdRet(respObject,-1,"您的门票已使用",null);
							}*/
						}else if(("gift".equals(cate))){//领取礼品
							
							List<Map<String, Object>> giftinfo = dao.queryForList("select * from tb_user_gift_certificate where user_id='"+userinfo.get("id")+"' and act='10030' and type='10030'", CommDao.CACHE_NO_TIME);
							
							if(giftinfo.size() > 0){
								respObject.put("giftinfo", giftinfo.get(0));
								
								String status = giftinfo.get(0).get("status").toString();
								if(status.equals("0")){
									
									int upret = dao.update("update tb_user_gift_certificate set status=1 where id='"+giftinfo.get(0).get("id")+"' ");
									if(upret>0)
										setJsonCmdRet(respObject,0,"恭喜您，领取成功！",null);
									else
										setJsonCmdRet(respObject,-1,"抱歉，领取失败",null);
								}else{
									setJsonCmdRet(respObject,-1,"抱歉，您已经领取过了",null);
								}
							}else{
								setJsonCmdRet(respObject,-1,"您目前没有礼品可领",null);
							}
						}else{
							setJsonCmdRet(respObject,-1,"error,Parameter error",null);
						}
					}else
						setJsonCmdRet(respObject,-10,"error,NO USER",null);
				}else
					setJsonCmdRet(respObject,-10,"error,不合法的二维码",null);
			}else
				setJsonCmdRet(respObject,-10,"error,URL ERROR",null);
		}
		else if(cmd.equals("keywords")){
			
			JSONArray array = new JSONArray();
			array.add("金");
			array.add("锰");
			array.add("煤");
			array.add("钢球");
			array.add("铁");
			
			respObject.put("phrase", array);
			
			setJsonCmdRet(respObject,0,"success",null);
			
		}else if(cmd.equals("timer")){
			TbUserEntity user = SessionUtil.getSessionUser();
			if(null != user)
				setJsonCmdRet(respObject,0,"success",null);
			else
				setJsonCmdRet(respObject,ERR_CODE_NOSIGIN,"请先登录",null);
		}else if(cmd.equals("chkver")){//升级
			String strOS = reqCmd.getString("os");
			int ver = ZLConfigure.getInstance().getAppVer(strOS);
			
			respObject.put("ver", ZLConfigure.getInstance().getValue(strOS+"_viewver"));
			respObject.put("vcode", ver);
			respObject.put("url", ZLConfigure.getInstance().getValue(strOS+"_down"));
			
			setJsonCmdRet(respObject,0,"success",null);
		}else if(cmd.equals("getcenter")){// 活 菜单
			TbUserEntity tbUser = SessionUtil.getSessionUser();
			String strLg = reqCmd.getString("lg");
			String CurrentClassFilePath = this.getClass().getResource("").getPath();    
			CurrentClassFilePath = URLDecoder.decode(CurrentClassFilePath, "utf-8");
			int lastpath=CurrentClassFilePath.lastIndexOf("classes/");
		    String web_rootPath=CurrentClassFilePath.substring(0,lastpath);
		    String strAppLabel = reqCmd.getString("applabel");
		    if ( null == strAppLabel || strAppLabel.length()==0)
		    	strAppLabel="";
		    else
		    	strAppLabel = '_'+strAppLabel;
		    web_rootPath += "classes/appmenu" + strAppLabel;
		    if (SiteOEM.__DEBUG__() )
		    	web_rootPath += "_test";
	    	if (null != strLg && strLg.length()>0){
		    	if  (!strLg.equals("cn"))
		    		web_rootPath += '_' + strLg;
	    	}
		    web_rootPath += ".json";
		    File file=new File(web_rootPath);
		    if(file.isFile() && file.exists()){ //判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");
				BufferedReader bufferedReader = new BufferedReader(read);
				StringBuffer strBuf = new StringBuffer();
				String lineTxt = null;
				while((lineTxt = bufferedReader.readLine()) != null){
					strBuf.append(lineTxt);
				}
				read.close();
				JSONObject jsonObject = new JSONObject();
				JSONObject jsonData = JSONObject.parseObject(strBuf.toString());
				Map<String, Object> mapData = (Map)jsonData;
				String jsonPickStr = "usercenter";
				if(tbUser != null){
					if(tbUser.getTbUserPersonalEntity() != null && !tbUser.getTbUserPersonalEntity().equals("")){
						jsonPickStr = "compcenter";
					}else{
						jsonPickStr = "personcenter";
					}
				}
				String centerData = "{\"usercenter\":" + mapData.get(jsonPickStr).toString() + "}";
				respObject =  jsonObject.parseObject(centerData);
				setJsonCmdRet(respObject,0,"success",null);
		    }else{
		    	setJsonCmdRet(respObject,-1,"null",null);
		    }
		}else if (cmd.equals("switch")){
			TbUserEntity tbUser = SessionUtil.getSessionUser();
			if(tbUser != null){
				LoginController loginMethods = ApplicationContextUtil.getContext().getBean(LoginController.class);
				if(tbUser.getTbUserPersonalEntity() != null ){
					loginMethods.setUserAllUnits(request, response, tbUser.getTbUserPersonalEntity().getId(), tbUser.getId(), "1");
					setJsonCmdRet(respObject,0,"success",null);
				}else{
					Map<String, Object> compMap = dao.queryForMap("SELECT company_id FROM tb_user_role WHERE user_id = '"+tbUser.getId()+"' AND status = '300'", CommDao.CACHE_NO_TIME);
					if(compMap != null){
						loginMethods.setUserAllUnits(request, response, tbUser.getId(), compMap.get("company_id").toString(), "2");
						setJsonCmdRet(respObject,0,"success",null);
					}else{
						setJsonCmdRet(respObject,-1,"null",null);
					}
				}
			}else{
				setJsonCmdRet(respObject,ERR_CODE_NOSIGIN,"请先登录",null);
			}
		}else if (cmd.equals("dismissal")){
			TbUserEntity tbUser = SessionUtil.getSessionUser();
			if(tbUser != null){
				String uid = tbUser.getId();
				if(tbUser.getTbUserPersonalEntity() != null && !tbUser.getTbUserPersonalEntity().equals(""))
					uid = tbUser.getTbUserPersonalEntity().getId();
				String checkSelf = "SELECT cat FROM tb_user_role WHERE user_id = '"+uid+"' AND status = '300' ";
				Map<String, Object> selfSta = dao.queryForMap(checkSelf, CommDao.CACHE_NO_TIME);
				if(selfSta != null && selfSta.get("cat").toString().equals("0")){
					String sql = "SELECT COUNT(*) FROM tb_user_role WHERE company_id = (SELECT company_id FROM tb_user_role WHERE user_id = '"+uid+"' AND status = '300' ) AND cat = '0'";
					int count = dao.queryForCount(sql, CommDao.CACHE_NO_TIME);
					if(count<=1){
						setJsonCmdRet(respObject,-2,"唯一管理员,不能离开",null);
						return respObject;
					}
				}
				int ret = dao.update("UPDATE tb_user_role SET status = '-200' WHERE user_id = '"+uid+"' AND status = '300' ");
				if(ret >= 0)
					setJsonCmdRet(respObject,0,"success",null);
				else
					setJsonCmdRet(respObject,-1,"null",null);
			}else{
				setJsonCmdRet(respObject,ERR_CODE_NOSIGIN,"请先登录",null);
			}
		}
		return respObject;
	}

	

	
	public JSONObject readJson(String jsonName){
		StringBuffer strBuf = new StringBuffer();
		
		String CurrentClassFilePath = this.getClass().getResource("").getPath();    
		CurrentClassFilePath = URLDecoder.decode(CurrentClassFilePath);
		int lastpath = CurrentClassFilePath.lastIndexOf("classes/");
	    String web_rootPath = CurrentClassFilePath.substring(0,lastpath+8);
		
	    try{
	    	File file = new File(web_rootPath+jsonName);
		    if(file.isFile() && file.exists()){ //判断文件是否存在
		    	InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");
	            BufferedReader bufferedReader = new BufferedReader(read);
	           
	            String lineTxt = null;
	            while((lineTxt = bufferedReader.readLine()) != null){
	          	  strBuf.append(lineTxt);
	            }
	            read.close();
		    }
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return JSONObject.parseObject(strBuf.toString());
	}
	
	
	/***
	 * 
	 * @param modelNo 模板编号
	 * @param strFloorNo 第几楼层
	 * @param strFloorName 楼层名称
	 * @param strSQL 该楼城的数据来源
	 * @return
	 */
	public JSONObject getFloor(int modelNo, String strFloorNo, String strFloorName, String strSQL, String infoUrl){
		JSONObject jsonObj = new JSONObject();
		
		String strfloor = readJson("floor"+modelNo+".json").toString();//读取模板文件
		strfloor = strfloor.replace("{`FLOOR}", strFloorNo);
		strfloor = strfloor.replace("{`FLOORNAME}", strFloorName);

		List<Map<String, Object>> malllst = dao.queryForList(strSQL,CommDao.CACHE_MAX_TIME);
		
		
		int i = 0;
		do{
			
			if(malllst.size() > i){
			
				Map<String, Object> m = malllst.get(i);

				Object img = m.get("img");
				if(null != img)
					strfloor = strfloor.replace("{`IMG#"+i+"}", m.get("img").toString());
				else
					strfloor = strfloor.replace("{`IMG#"+i+"}", "");
				
				strfloor = strfloor.replace("{`URL#"+i+"}", infoUrl+m.get("id")+"&newpage=newpage");

				String strTitle = ZLStringUtils.Str2Json(m.get("title").toString());
				strfloor = strfloor.replace("{`TITLE#"+i+"}", strTitle);
				
				Object title2 = m.get("title2");
				if(null != title2)
					strfloor = strfloor.replace("{`TITLE2#"+i+"}", m.get("title2").toString());
				else
					strfloor = strfloor.replace("{`TITLE2#"+i+"}", "");
				
				Object price = m.get("price");
				if(null != price)
					strfloor = strfloor.replace("{`PRICE#"+i+"}", "￥"+price.toString());
				else
					strfloor = strfloor.replace("{`PRICE#"+i+"}", "");
			}else{//set null
				if (strfloor.indexOf("URL#"+i+"}")<0)
					break;
				strfloor = strfloor.replace("{`IMG#"+i+"}", "");
				strfloor = strfloor.replace("{`URL#"+i+"}", "");
				strfloor = strfloor.replace("{`TITLE#"+i+"}", "");
				strfloor = strfloor.replace("{`TITLE2#"+i+"}", "");
				strfloor = strfloor.replace("{`PRICE#"+i+"}", "");
				
			}
			
			i++;
		}while(true);
		
		/*
		if(malllst.size() > 0){
			for (int i = 0; i < malllst.size(); i++) {
				
				Map<String, Object> m = malllst.get(i);
				if(m.isEmpty() == false){
					Object img = m.get("img");
					if(null != img)
						strfloor = strfloor.replace("{`IMG#"+i+"}", m.get("img").toString());
					else
						strfloor = strfloor.replace("{`IMG#"+i+"}", "");
					
					strfloor = strfloor.replace("{`URL#"+i+"}", infoUrl+m.get("id")+"&newpage=newpage");
	
					String strTitle = ZLStringUtils.Str2Json(m.get("title").toString());
					strfloor = strfloor.replace("{`TITLE#"+i+"}", strTitle);
					
					Object title2 = m.get("title2");
					if(null != title2)
						strfloor = strfloor.replace("{`TITLE2#"+i+"}", m.get("title2").toString());
					else
						strfloor = strfloor.replace("{`TITLE2#"+i+"}", "");
					
					Object price = m.get("price");
					if(null != price)
						strfloor = strfloor.replace("{`PRICE#"+i+"}", "￥"+price.toString());
					else
						strfloor = strfloor.replace("{`PRICE#"+i+"}", "");
				}else{
					
				}
				

	
			}
		}*/
		
		jsonObj = JSONObject.parseObject(strfloor);
		
		return jsonObj;
	}	
	
}
