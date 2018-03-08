package com.apft.utils;


import javax.servlet.http.*;

/** 
 * SiteOEM 网站OEM多语言跨平台实用类 
 * @author stkking@qq.com 
 * @date 2017-02-26 
 */  

public class SiteOEM{
	final static String _SF_KEY = "_SOEM_";//
	
	final static short _SF_TYPE_MC = 0;//miningcircle
	final static short _SF_TYPE_GL = 1;//goldenlend
	final static short _SF_TYPE_AF = 2;//apecfinance
	final static short _SF_TYPE_QE = 3;//qedu
	final static short _SF_TYPE_AT = 4;//apftown
	

	public String	_lg = "cn";//cn,en,es
	public String	_UAP = null;
	public boolean	_isMobile = false;
	public byte	_MobileForce = 0; //0auto 1pc 2mobile
	
	public short	_Type = 0;//0:miningcircle 1:goldenlend 2:apecfinance 3:qedu 4:apftown

	public String	_Name = "三亚亚太金融(基金)小镇";
	public String	_Seo_Name = "三亚亚太金融(基金)小镇";
	public String	_Slogan = _Name + "=互联网+基金";
	public String 	_NameEn = "GoldenLend";//MiningCircle KuangYeQuan | GoldenLend
	public String 	_Website = "http://www.apftown.com";
	public String 	_Address = "海南省三亚市海棠湾亚太金融(基金)小镇";
	public String 	_Tel = "400-088-1124";
	public String 	_EMail = "info@apftown.com";
	public String 	_IconPath = "/gl_favicon.ico";
	public String 	_LogoPath = "/img/comm/logo.png";
	
	private boolean _isChanged = false;

	/*
	 * 用户取自己的SiteOEM对象
	 * SiteOEM s_oem = SiteOEM.getSOEM(); if (null == s_oem) s_oem = new SiteOEM(request, response);
	 * //TODO: s_oem...
	 * 
	 * */
	
	public static SiteOEM getSOEM(){
		HttpSession session = ContextHolderUtils.getSession();
		SiteOEM sOEM = (SiteOEM)session.getAttribute(_SF_KEY);
//		if (sOEM == null)
//			sOEM = new SiteOEM(null, null);
		
		return sOEM;
	}
	
	public SiteOEM(HttpServletRequest request, HttpServletResponse response){
		if (request != null){
			String strWebName = request.getServerName().toLowerCase();
			setSite(strWebName);

			setMode(request.getHeader( "USER-AGENT" ));//mobile pc pad
			
			setRequest(request);

			setData();
		}
		HttpSession session = ContextHolderUtils.getSession();			
		session.setAttribute(_SF_KEY, this);
		
	}
	
	public void setMobileOrPC(boolean isMobile){
		if (isMobile){
			_isMobile = true;
			_MobileForce = 2;
		}else{
			_isMobile = false;
			_MobileForce = 1;
		}
	}
	
	/*
	 * 设置PC Pad Mobile
	 * */
	private void setMode(String strUserAgent){
		if(null == _UAP){
			String keys[]={"android", "iphone", "ipod", "windows phone", "mqqbrowser", "ucbrowser", "micromessenger" };
			if (strUserAgent != null) {
				strUserAgent = strUserAgent.toLowerCase();
				if ( strUserAgent.indexOf("windows nt") < 0 && strUserAgent.indexOf("macintosh") < 0 ){
					for(int i=0;i<keys.length;i++)	{	
						if (strUserAgent.indexOf(keys[i]) >-1) {
							_isMobile = true;
							return;
						}
					} 
				}
			}
			_isMobile = false;
			return;
		}
		_isMobile = true;
	}
	

	
	/*
	 * 设置OEM Information Data
	 * */
	private void setData(){
		_isChanged  =false;
		switch(_Type){
		case 4:
			if (_lg.equals("en")){//english
				_Name = "APF Town";
				_Slogan = "Asia Pacific Finance Town SANYA CHINA";
			}else{
				_Name = "亚太金融小镇";
				_Slogan = "亚太金融小镇 中国·三亚";				
			}
			_IconPath = "/apftown.ico";
			_LogoPath = "/images/apftown.png";
			_NameEn = "APFTown";// KuangYeQuan | GoldenLend
			_Website = "http://www.apftown.com";
			_EMail = "info@apftown.com";
			break;
		case 3:
			_Name = "清蓝教育";
			_Slogan = "清蓝教育";				
			_IconPath = "/qedu.ico";
			_LogoPath = "/images/qedu.png";
			_NameEn = "qedu";// KuangYeQuan | GoldenLend
			_Website = "http://www.qedu.cn";
			_EMail = "info@qedu.cn";
			break;
		case 2:
			_Name = "亚太金融研究院";
			_Slogan = "亚太金融研究院-中国·三亚";				
			_IconPath = "/apecfinance.ico";
			_LogoPath = "/images/apecfinance.png";
			_NameEn = "ApecFinance";// KuangYeQuan | GoldenLend
			_Website = "http://www.apecfinance.com";
			_EMail = "info@apecfinance.com";
			break;
		case 1:
			if (_lg.equals("en")){//english
				_Name = "Golden lend";
				_Slogan = "Gold and silver natural non currency, money and natural non gold and silver";
			}else{
				_Name = "黄金贷";
				_Slogan = "金银天然非货币，货币天然非金银";				
			}
			_IconPath = "/gl_favicon.ico";
			_LogoPath = "/images/goldenlend.png";
			_NameEn = "GoldenLend";// KuangYeQuan | GoldenLend
			_Website = "http://www.goldenlend.com";
			_EMail = "info@goldenlend.com";
			break;
		default:
			if ("en".equals(_lg)){//english
				_Name = "apftown";
				_Slogan = _Name + "=Internet+apftown";
				_Seo_Name = "MiningCircle";
			}else{
				_lg = "cn";
				_Name = "亚太金融（基金）小镇";
				_Slogan = _Name + "=互联网+基金";
				_Seo_Name = "亚太金融（基金）小镇-apftown";
			}
			_IconPath = "/favicon.ico";
			_LogoPath = "/images/24.png";
			_NameEn = "apftown";// KuangYeQuan | GoldenLend
			_Website = "http://www.apftown.com";
			_EMail = "info@apftown.com";
			break;
		}
		//写入cookie
//		Cookie cookieWeb = new Cookie(_SF_KEY, _Type+"."+_lg);//strWebName = goldenlend.com | miningcircle.com(default)
//		cookieWeb.setPath("/");
//		response.addCookie(cookieWeb);
		HttpSession session = ContextHolderUtils.getSession();			
//		HttpSession session = request.getSession();
		session.setAttribute(_SF_KEY, this);
	}
	
	/*
	 * 
	 * */
	private void setRequest(HttpServletRequest request){
		String strWebName = request.getServerName().toLowerCase();
		if(strWebName.startsWith("cn.")){
			_lg = "cn";
		}else if(strWebName.startsWith("es.")){
			_lg = "es";
		}else if(strWebName.startsWith("en.")){
			_lg = "en";
		}else{
			String strLgTmp = request.getLocale().getLanguage().toLowerCase();

			if (strLgTmp.startsWith("zh") || strLgTmp.startsWith("cn") || strLgTmp.startsWith("hk") || strLgTmp.startsWith("tw")){
				_lg="cn";
			}else if (strLgTmp.startsWith("es")){
				_lg="es";
			}else{
				_lg="en";
			}
		}
		setParameter(request);
	}

	

	/*
	 * 设置网站域名类型
	 * */
	public void setSite(String strWebName){

		short typeTmp = _SF_TYPE_MC;//0:mc.com 1:
		if (strWebName.indexOf("goldenlend.com")>=0){
			typeTmp=_SF_TYPE_GL;
		}else if (strWebName.indexOf("apecfinance.com")>=0){
			typeTmp=_SF_TYPE_AF;
		}else if (strWebName.indexOf("qedu.cn")>=0){
			typeTmp=_SF_TYPE_QE;
		}else if(strWebName.indexOf("apftown.com")>=0){
			typeTmp=_SF_TYPE_AT;
			
			if("m.apftown.com".equalsIgnoreCase(strWebName))
				setMobileOrPC(true);
			else
				setMobileOrPC(false);
		}
		if (typeTmp!=_Type){
			_Type = typeTmp;
			_isChanged = true;
		}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////	

/////////////////////////////////////// LG
	/*
	 * 切换语言
	 * lg = cn|en|es| 。。。
	 * */
	public void setLG(String lg){
		if (_lg.equals(lg))
			return;
		_lg = lg;
		setData();
	}


	public boolean isLgEn(){
		return _lg.equals("en");
	}

/////////////////////////////////////////////////////////////////////////////////
	
	public boolean isMobileNoApp(){
		if (isMobile() && !isUAP())
			return true;
		return false;
	}
	
	
	public String getLg(){
//		if (null == _lg || _lg.length()==0) _lg="cn";
		return _lg;
	}
	
	public String getLgJSP(String strJSP){
		SiteOEM s_oem = SiteOEM.getSOEM(); 
		return s_oem._lg+strJSP;
	}
	
	public void setParameter(HttpServletRequest request){
		setUAP(request.getParameter("uap"));
		String strLgTmp = request.getParameter("lg");
		if(!StringUtil.isNull(strLgTmp)){
			if (!strLgTmp.equals(_lg)){
				_lg = strLgTmp;
				_isChanged  = true;
				setData();
			}
		}
	}



////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 取路径
	 * */
	public String lg(){
		if(isLgEn()){
			return "en";
		}else{
			return "v3";
		}
	}
	


	
/////////////////////////////////// IS 	
	/*
	 * 设置UAP(User Application Product)
	 * */
	private void setUAP(String strUAP){
		if (null == strUAP) return;
		boolean is = true;
		
		if (strUAP.length()==0){
			is = false;
		}
		
		if (is != isUAP()){
			_UAP = strUAP;
			if (is){
				_MobileForce=0;
				_isMobile = true;
			}else{
//				_isMobile = false;
			}
		}
	}

	public String getUAP(){
		return _UAP;
	}
	
	public Boolean isUAP(){
		if (null != _UAP && _UAP.length()>0)
			return true;
		return false;
	}
	
	
	
	public Boolean isMobile(){
		if (_MobileForce==0)
			return _isMobile;
		else if (_MobileForce==2)
			return true;
		if (isUAP())
			return true;
		
		return _isMobile;
	}
	

	
////////////////////////OEM other webite
	public Boolean isSx(){//山西站
		return _Website.indexOf("sx.miningcircle.com")>=0;
	}
	
	public Boolean isApfTown(){
		return _Website.indexOf("apftown.com")>=0;
	}

	/*
	 * 是否是亚太金融研究院
	 * */
	public Boolean isApecFinance(){
		return _Website.indexOf("apecfinance.com")>=0;
	}	

	/*
	 * 是否是清蓝教育
	 * */
	public Boolean isQedu(){
		return _Website.indexOf("qedu.cn")>=0;
	}	
	
	public Boolean isGoldenLend(){
		return _Website.indexOf("goldenlend.com")>=0;
	}	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean __DEBUG__(){
		try{
			if ("1".equals(ZLConfigure.getInstance().getInstance().getValue("sms_debug"))){
				return true;
			}
		}catch(Exception e){}
		return false;
	}	
	
}
