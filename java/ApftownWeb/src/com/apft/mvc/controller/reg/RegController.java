package com.apft.mvc.controller.reg;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.core.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.AjaxJson;
import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserEmailChkEntity;
import com.apft.mvc.model.TbUserEntity;
import com.apft.utils.CRC16;
import com.apft.utils.JavaMail;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;
import com.apft.utils.StringUtil;
import com.apft.utils.ZLConfigure;
import com.apft.utils.ZLUtils;
import com.apft.utils.sms.MsgNotify;
import com.apft.utils.sms.example.SingletonClient;



@Controller
public class RegController {
	
	@Autowired
	CommDao commDao;
	
	//注册
	@RequestMapping(value="regui")
	public ModelAndView regui(HttpServletRequest request,HttpServletResponse response){
		
		String fm = request.getParameter("fm");
		if(!StringUtil.isNull(fm))
			request.getSession().setAttribute("fm", fm);
		String nm = request.getParameter("nm");
		if(!StringUtil.isNull(nm))
			request.getSession().setAttribute("nm", nm);
		
		
		// 如果session里有用户 那么跳转到index方法
		if (SessionUtil.getSessionUser() != null) {
			try {
				response.sendRedirect("index.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			// 如果session里没用户 则跳转注册页面
			return new ModelAndView("/reg/regui");
		}
	}
	
	
	//将第一个页面的数据存放到tbUser并存到session中
	@RequestMapping(value = "reg")
	public ModelAndView reg(HttpServletRequest request,HttpServletResponse response){
		//接收用户名
		String name = request.getParameter("userName");
		//接收密码
		String pswd = request.getParameter("userPwd");
		//接收手机号或者手机号
		String user_reg_email = request.getParameter("user_reg_email");
		//接收推荐码
		String userFrom = request.getParameter("userFrom");
		userFrom = StringUtil.isNull(userFrom)?null:userFrom;
		//接收图形验证码
		String imgCode = request.getParameter("imgCode");
		Pattern regexE = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
	    Pattern regexM = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
	    int type=0;
	    TbUserEntity tbUser = new TbUserEntity();
	    //将用户名，密码，手机号，推荐码放到tbUser里
	    tbUser.setUserName(name);
	    tbUser.setUserPwd(PasswordUtil.encrypt(pswd));
	    tbUser.setUserFrom(userFrom);
	    if(null!=user_reg_email && user_reg_email.length()>0){
		     if(user_reg_email.contains("@") && user_reg_email.contains(".")){
		    	Matcher m=regexE.matcher(user_reg_email);
		    	boolean p=m.matches();
		    	if(p){
		    		type=1;
		    		tbUser.setUserRegEmail(user_reg_email);		
		    	}
		     }else{
		    	 Matcher q=regexE.matcher(user_reg_email);
		    	 boolean e =q.matches();
		    	 if(e){
		    		 type=0;
		    		 tbUser.setUserRegMobile(user_reg_email);
		    	 }
		     }
	    	
	    }
		
		//tbUser.setUserRegMobile(user_reg_email);
		//将tbUser放入session里(reg2里需要)
		request.getSession().setAttribute("tbUserRegister", tbUser);
		//单独取手机号和图形验证码(reg2需要)
		//request.setAttribute("userRegMobile", userRegMobile);
		request.setAttribute("type", type);
		request.setAttribute("user_reg_email", user_reg_email);
		request.setAttribute("name", name);
		//单独取得imgCode
		request.setAttribute("imgCode", imgCode);
		//产生6位的短信验证码
		String sms6 = StringUtil.getRandomString(6);
		//将产生的6位验证码存入session,kqum
		request.getSession().setAttribute("randomSMS", sms6);
		return new ModelAndView("/reg/reg2");
	}

	
	//检查用户名，手机号，邮箱是否注册过
	//regui.js里userName,userRegMobile调用
	@RequestMapping(value = "ckUserRepeat")
	@ResponseBody
	public Boolean ckUserRepeat(HttpServletRequest request){
		Boolean bl = false;
		//接收用户名
		String userName = request.getParameter("userName");
		//接收手机号
		String userMobile = request.getParameter("userRegMobile");
		//接收邮箱
		String userEmail = request.getParameter("userRegEmail");
		List<Object> lstPara = new ArrayList<Object>();
		//判断有没有用户名传过来，有就将用户名添加到集合中,没有就添加空
		lstPara.add(StringUtil.isNull(userName)?null:userName);
		//判断有没有手机号传过来，有就将手机号添加到集合中,没有就添加空
		lstPara.add(StringUtil.isNull(userMobile)?null:userMobile);
		//判断有没有邮箱传过来，有就将邮箱添加到集合中,没有就添加空
		lstPara.add(StringUtil.isNull(userEmail)?null:userEmail);
		lstPara.add("ret");
		//调用存储过程
		List<Object> lstRet = commDao.callProc("pc_reg_user_check", lstPara, 1);
		int ret = Integer.parseInt(lstRet.get(0).toString());
		if(ret > 0){
			bl = true;
		} 
		return bl;
	}
	
	/**
	 * 验证邮箱否占用
	 * 
	 * @param tbUser
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/checkEmail")
	@ResponseBody
	public Boolean checkEmail(TbUserEntity tbUser, HttpServletRequest request) {
		String user_reg_email = request.getParameter("user_reg_email");
		
		Boolean bl = false;
		
	    Pattern regexE = Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
	    Matcher matcherE = regexE.matcher(user_reg_email);
	    
	    Pattern regexM = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
	    Matcher matcherM = regexM.matcher(user_reg_email);
		
	    Boolean check = false;
	    if(user_reg_email.contains("@") && user_reg_email.contains(".")){
	    	check = matcherE.matches();
	    	
	    	 if(check == true){
	 	    	int extEmail = commDao.queryForCount("select count(*) from tb_user where user_reg_email='"+user_reg_email+"'",0);
	 			if (extEmail == 0) {
	 				return bl = true;
	 			}
	    	 }
	    }else{
	    	check = matcherM.matches();
	    	 
	    	 if(check == true){
	 			int extMobile = commDao.queryForCount("select count(*) from tb_user where user_reg_mobile='"+user_reg_email+"'",0);
	 			if (extMobile == 0) {
	 				return bl = true;
	 			}
	 	    }
	    }
		
		return bl;
	}

	

	//验证图形验证码是不是填写正确
	@RequestMapping(value = "imgCode")
	@ResponseBody
	public boolean imgCode(HttpServletRequest request,HttpServletResponse response){
		boolean bl = false;
		//接收图形验证码
		String strImgCode = request.getParameter("imgCode");
		//获取随机的图形验证码
		String strRandeCode = (String) request.getSession().getAttribute("randCode");
		//比较输入的验证码和产生的验证码
		if(!StringUtil.isNull(strRandeCode) && strImgCode.equals(strRandeCode)){
			bl = true;
		}
		return bl;	
	}
	
	//判断短信是不是正确
	@RequestMapping(value="checkCaptcha")
	@ResponseBody
	public boolean checkCaptcha(HttpServletRequest request){
		//reg中存到session中的，现在取出来
		String randomSMS = (String) request.getSession().getAttribute("randomSMS");
		String smsCode = request.getParameter("smsCode");
		if(!StringUtil.isNull(randomSMS) && randomSMS.equals(smsCode)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	/**
	 * 发送短信验证码
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "sendMessage")
	@ResponseBody
	public AjaxJson sendMessage(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String message = "0";
		String sms6 = (String) request.getSession().getAttribute("randomSMS");
		String mobilePhone = (String) request.getParameter("mobilePhone");
		System.out.println(sms6);
		String nosms = request.getParameter("nosms");
		
		if (null == nosms || !nosms.equals("1")){//矿业大会着陆页注册不要验证图形验证码
			if(imgCode(request, response) == false){
				j.setMsg("-3");
				j.setSuccess(false);
				return j;
			}
		}
		
		TbUserEntity tbUser = (TbUserEntity) request.getSession().getAttribute("tbUserRegister");
		
		try {
			if(null == tbUser){
				tbUser = SessionUtil.getSessionUser();
			}
			
			if (tbUser == null ) {
//				response.sendRedirect(URL_REGISTER_UI);
			}else{
				System.out.println("注册发送短信验证码--sendMessage----"+mobilePhone+" : "+sms6);					
				MsgNotify.sendSMSCheckCode(mobilePhone, sms6);
				if (null !=mobilePhone && !(mobilePhone.equals(tbUser.getUserRegMobile()))) {
					tbUser.setUserRegMobile(mobilePhone);
				}
				message = "2";
				j.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 发送语音验证码
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "sendVoice")
	@ResponseBody
	public AjaxJson sendVoice(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		Object nosms = request.getParameter("nosms");
		if (null == nosms || !nosms.equals("1")){
			if(imgCode(request, response) == false){
				j.setSuccess(false);
				return j;
			}
		}
		
		String message = "0";
		String mobilePhone = (String) request.getParameter("mobilePhone");
		TbUserEntity tbUser = (TbUserEntity) request.getSession().getAttribute("tbUserRegister");
		String sms6 = (String) request.getSession().getAttribute("randomSMS");
		
		String wxgt = (String) request.getParameter("wxgt");
		try{
			//微信注册发语音，不需要判断session里的tbUser
			if(wxgt != null && wxgt.length() > 0){
				System.out.println("注册发送语音--sendVoice----"+mobilePhone+" : "+sms6);				
				SingletonClient.getClient().sendVoice(new String[] { mobilePhone }, sms6, "", "GBK", 5, System.currentTimeMillis());
				message = "1";
			}else{
				if(null == tbUser){
					response.sendRedirect("regui.do");
				}else{
					System.out.println("注册发送语音--sendVoice----"+mobilePhone+" : "+sms6);				
					SingletonClient.getClient().sendVoice(new String[] { mobilePhone }, sms6, "", "GBK", 5, System.currentTimeMillis());
					if (!(mobilePhone.equals(tbUser.getUserRegMobile()))) {
						tbUser.setUserRegMobile(mobilePhone);
					}
					message = "1";
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		j.setMsg(message);
		return j;
	}
	
	
	@RequestMapping(value="reg2")
	public ModelAndView reg2(HttpServletRequest request,HttpServletResponse response){
		boolean bl = checkCaptcha(request);
		if(bl == true){
			TbUserEntity tbUser = (TbUserEntity) request.getSession().getAttribute("tbUserRegister");
			List<Object> list = new ArrayList<Object>();
			list.add(tbUser.getRegName());
			list.add(tbUser.getUserRegMobile());
			list.add(null);
			list.add(tbUser.getUserPwd());
			list.add("0");
			list.add("apftown");
			list.add(null);
			list.add(ZLUtils.getIpAddr(request));
			list.add(null);
			list.add("ret");
			list.add("uid");
			List<Object> lst = commDao.callProc("pc_user_register", list, 2);
			int ret= Integer.parseInt( lst.get(0).toString());
			if(ret == 1){
				request.getSession().removeAttribute("randomSMS");
				
				String userId = (String) lst.get(1);
				String sql = "SELECT * FROM tb_user WHERE id = '"+userId+"'";
				try {
					TbUserEntity user = (TbUserEntity) commDao.queryForEntity(sql, TbUserEntity.class, 0);
					SessionUtil.setSessionUser(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView("/reg/regSuccess");
			}
		}
		
		try {
			response.sendRedirect("regui.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	/*********************	邮箱	************************************************/
	/**
	 * 发送邮件
	 * @param regEmail
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sendMail")
	@ResponseBody
	public AjaxJson sendMail(String regEmail,String uid,String act,String uname,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		Boolean bl = false; 
		
		String strUID = ZLUtils.UUIDgenerate();
		long t = System.currentTimeMillis();
		
		try {
			TbUserEntity ssUser = (TbUserEntity) request.getSession().getAttribute("tbUserRegister");
			if(null != ssUser && !StringUtil.isNull(ssUser.getUserRegEmail()) && ("reg").equals(act)){
				bl = true;
			}else{
				if(StringUtil.isNull(uid)){
					
					Map<String, Object> existEmail = commDao.queryForMap("select count(*) cnt,id from tb_user where user_reg_email='"+regEmail+"'",0);
					if(Integer.parseInt(existEmail.get("cnt").toString()) == 0 ){
						
						if(!StringUtil.isNull(ssUser.getUserRegEmail()) && ("reg").equals(act)){
							bl = true;
						}else
							j.setMsg("-2");//该邮箱没有注册
					}else{
						
						if(("findpwd").equals(act)){
							ssUser = (TbUserEntity) commDao.queryForEntity("select * from tb_user where id='"+existEmail.get("id")+"'", TbUserEntity.class,0);
							if(null != ssUser)
								bl = true;
						}else{
							if(!StringUtil.isNull(ssUser.getUserRegEmail()) && ("reg").equals(act))
								j.setMsg("-1");//邮箱已存在
							else{
								uid= (String) existEmail.get("id");
								bl = true;
							}
						}
					}
				}else{
					ssUser = (TbUserEntity) commDao.queryForEntity("select * from tb_user where id='"+uid+"'", TbUserEntity.class,0);
					bl = true;
				}
			}
			
			if(bl){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", strUID);
				map.put("user_id", StringUtil.isNull(ssUser.getId())?null:ssUser.getId());
				map.put("user_name", StringUtil.isNull(ssUser.getUserName())?null:ssUser.getUserName());
				map.put("user_cat", ssUser.getUserCat());
				map.put("user_email", regEmail);
				map.put("user_pwd", ssUser.getUserPwd());
				map.put("user_from", StringUtil.isNull(ssUser.getUserFrom())?null:ssUser.getUserFrom());
				map.put("website", StringUtil.isNull(ssUser.getWebsite())?null:ssUser.getWebsite());
				map.put("act", act);
				map.put("t", Long.toString(t));
				map.put("c", Integer.toString(checkMailCode(strUID, t, act)));
				map.put("status",0);
				int add = commDao.insert("tb_user_email_chk", map);
				sendMailRegisterSuccess(uname,regEmail,strUID,act,request);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		j.setSuccess(bl);
		return j;
	}

	public void sendMailRegisterSuccess(String userName,String email,String chid,String act,HttpServletRequest request){
		if (email != null && email.length() > 0){
			
			Properties properties = loadMailProperties();
			
			//点击链接回应
			long t = System.currentTimeMillis()/1000;
			
			String url= request.getScheme()+"://"+request.getServerName();
			int duankou = request.getServerPort();
			if(duankou != 80)
				url += ":"+duankou;
			
			HttpSession session = request.getSession();
			String abroad=(String) session.getAttribute("abroad");
			String mregAt = (String) session.getAttribute("at");
			Map<String, Object> invit=(Map<String, Object>) session.getAttribute("invit");
			String roleId=null;
			if(invit!=null){
				roleId=(String) invit.get("roleId");
				session.removeAttribute("invit");
			}
			url += "/"+ZLConfigure.getInstance().getProjectName()+"callmail.do?id="+chid+"&act="+act+"&t="+t+"&c="+checkMailCode(chid,t,act)+"&lg="+SiteOEM.getSOEM().getLg();
			
			if(!StringUtil.isNull(mregAt))
				url += "&at="+mregAt;
			
			String reg_author = properties.getProperty("reg_author");
			String reg_title = "";
			String reg_content = "";
			
			if(act.equals("findmoneypwd")){
				String sms6 = StringUtil.getRandomString(6);
				url = sms6;
				request.getSession().setAttribute("randomSMS",sms6);
			}
			
			if(SiteOEM.getSOEM().isLgEn()){//是不是英文
				
				reg_title = properties.getProperty("en_"+act+"_title");
				reg_content = properties.getProperty("en_"+act+"_content");
				
			}else{
				
				reg_title = properties.getProperty(act+"_title");
				reg_content = properties.getProperty(act+"_content");
				
			}
			System.out.println("发送邮件-------"+url);			
			String emailName = "";
			if(null != userName && userName.length() > 0)
				 emailName = userName;
			else
				emailName = email;
			reg_content = reg_content.replace("{$userName}", emailName);
			reg_content = reg_content.replace("{$lian()}", url);
			reg_content = reg_content.replace("{$title()}", reg_title);
			
			if(act.equals("reg")){
				if(!StringUtil.isNull(mregAt)){
					reg_content = reg_content.replace("欢迎您加盟三亚亚太金融(基金)小镇!", "欢迎您加盟三亚亚太金融(基金)小镇!<br><span style=\"font-size: 20px;font-family: 微软雅黑;color: #de850e;\">您的验证码为：</span><span style=\"color: #d41858;font-size: 22px;\">"+session.getAttribute("randomSMS")+"</span>");
				}else{
					reg_content = reg_content.replace("{$code()}", (String) session.getAttribute("randomSMS"));
				}
			}
			
			
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(currentTime);
			
			reg_content = reg_content.replace("{$now()}", dateString);
			
			
			JavaMail se = new JavaMail(false);
			se.doSendHtmlEmail(reg_author,reg_title, reg_content, email);
			
		}
	}
	
	@RequestMapping(value = "callmail")
	public ModelAndView callmail(HttpServletRequest request,HttpServletResponse response){
		
		
		
		String id = request.getParameter("id");
		long t = Long.parseLong(request.getParameter("t"));
		String act = request.getParameter("act");
		int c = Integer.parseInt(request.getParameter("c"));
		
		Properties properties = loadMailProperties();
		HttpSession session = request.getSession();
		session.removeAttribute("abroad");
		String abroad=request.getParameter("abroad");
		String invit=request.getParameter("invit");
		request.setAttribute("abroad", abroad); 
		int reg_valid_time = Integer.parseInt(properties.getProperty("reg_valid_time"));
		int code = checkMailCode(id,t,act);
		long time = System.currentTimeMillis()/1000;
		try{
			
			if(code == c){//参数 有效
				if(time - t < reg_valid_time ){//判断 时间 有效
					
					
					TbUserEmailChkEntity emailchk = (TbUserEmailChkEntity) commDao.queryForEntity("select * from tb_user_email_chk where id='"+id+"'", TbUserEmailChkEntity.class, 0);
					
					request.setAttribute("email", emailchk.getUserEmail());
					if(null != emailchk){
						int status = emailchk.getStatus();
						
						request.setAttribute("status", status);
						if(status == -1){// status：-1 过期,0 待审核,1 OK  是否有效
							return new ModelAndView("/user/binding-1");						
						}else if(status == 0){
							
							if(act.trim().equals("bind")){// act 动作
								//修改 status
								int upret = commDao.update("update tb_user_email_chk set status=1 where id='"+id+"'");
								
								// 修改 tb_user
								List<Object> lstPara = new ArrayList<Object>();
								lstPara.add(emailchk.getUserId());
								lstPara.add(7);
								lstPara.add(emailchk.getUserEmail());
								lstPara.add("");
								lstPara.add(0);
								List<Object> lst = commDao.callProc("pc_set_user_status", lstPara, 1);
								SessionUtil.setSessionUser((TbUserEntity)commDao.queryForObject("select * from tb_user where id='"+emailchk.getUserId()+"'", TbUserEntity.class, 0));
								//userService.setUserStatus(emailchk.getUserId(), 7, emailchk.getUserEmail(), "");
								//userService.reloadSigninUser();
								
								if(lst.size() > 0){
									Integer ret = (Integer) lst.get(0);
									request.setAttribute("status", ret);
									if(ret == 0){
										return new ModelAndView("/user/binding1");
									}else {//if(ss == -1){//邮箱已存在
										return new ModelAndView("/user/binding-1");
									}
								}
								
								
							}else if(act.trim().equals("reg")){
								
								String at = request.getParameter("at");
								
								//修改 status
								int upret = commDao.update("update tb_user_email_chk set status=1 where id='"+id+"'");
								
								
								List<Object> lstPara = new ArrayList<Object>();
								lstPara.add(emailchk.getUserName());
								lstPara.add(null);
								lstPara.add(emailchk.getUserEmail());
								if(!StringUtil.isNull(emailchk.getUserPwd()) )
									lstPara.add(emailchk.getUserPwd());
								else
									lstPara.add(PasswordUtil.encrypt(emailchk.getUserEmail()));
								lstPara.add(emailchk.getUserCat());
								lstPara.add(emailchk.getWebsite());
								lstPara.add(emailchk.getUserFrom());
								lstPara.add(ZLUtils.getIpAddr(request));
								lstPara.add("mc");
								lstPara.add(0);
								lstPara.add("id");
								List<Object> lst = commDao.callProc("pc_user_register", lstPara, 2);
								if(lst.size() > 0){
									int ret = (Integer) lst.get(0);
									if(ret > 0){
										String uid = (String)lst.get(1);
										request.setAttribute("uid", uid);
										
										TbUserEntity tbUser = (TbUserEntity) commDao.queryForEntity("select * from tb_user where id='"+uid+"'", TbUserEntity.class,0);
										request.getSession().setAttribute("tbUserRegister", tbUser);
										SessionUtil.setSessionUser(tbUser);
										
										sendMail(emailchk.getUserEmail(), emailchk.getId(), "reged", emailchk.getUserName(), request);
										
										if(!StringUtil.isNull(at)){
											return new ModelAndView("/m/regen/reg3");
										}
										else{
											//查询邀请信息
											request.setAttribute("invit", invit);
											if(invit!=null){
												Map<String, Object> invitCom=commDao.queryForMap(" select ur.id,ac.name from tb_user_role ur,tv_audit_company ac where ur.company_id=ac.id and ac.lg=0 and ur.id='"+invit+"'",0);
													if(invitCom!=null){
														String invitComName=(String) invitCom.get("name");
														request.setAttribute("invitComName", invitComName);
													}
											}
											return new ModelAndView("/reg/regSuccess");
										}
										
									}else {//if(ss == -1){//邮箱已存在
										request.setAttribute("status", "-2");
										return new ModelAndView("/user/binding-1");
									}

								}
								
							}else if(act.trim().equals("findpwd")){//找回密码
								//修改
								
								request.setAttribute("emailchk", emailchk);
								
								sendMail(emailchk.getUserEmail(), emailchk.getUserId(), "findpwded", emailchk.getUserName(), request);
								
								return new ModelAndView("/reg/setPwd");
							}
						}
						else if(status == 1){//已处理
							return new ModelAndView("/user/binding1");
						}
					}
				}else{
					return new ModelAndView("/reg/regSuccess");
				}
			}else{
				return new ModelAndView("/reg/regSuccess");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Properties loadMailProperties(){
		Properties properties = new Properties();
		InputStream in = null;
		//UserCookieUtil.class.getResourceAsStream("MailServer");
   		try {
   			in = this.getClass().getResourceAsStream("/MailServer.properties");
   			if (in == null){
   				System.out.println("读取用户session的配置文件错误！使用默认值");
   			}
   			else {
   				properties.load(in);
   				
   				return properties;
   			}
   		} catch (IOException e) {
   			e.printStackTrace();
   		}finally{
   			try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
   		}
   		return null;
	}
	public int checkMailCode(String userid,long t,String act){
		
		byte [] btData = null;
		
		Properties properties = loadMailProperties();
		int reg_sign_label = Integer.parseInt(properties.getProperty("reg_sign_label"));	

		btData = (userid+t+act+"mc.com").getBytes();
		
		return CRC16.doCRC16(btData)^reg_sign_label;
	}
	
	
	
	
	
	
}
