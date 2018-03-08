<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.apft.utils.SiteOEM"%>
<%@page import="com.apft.core.ApplicationContextUtil"%>
<%@page import="com.apft.utils.ZToken"%>
<%@page import="com.apft.mvc.model.TbUserEntity"%>
<%@page import="com.apft.utils.SessionUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
/*String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


String basePath1 = request.getScheme()+"://"+request.getServerName()+path+"/";
*/


String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName();
if (request.getServerPort() != 80){
	basePath += ":"+request.getServerPort(); 
}
basePath += path +"/";


SiteOEM s_oem = SiteOEM.getSOEM();
if (null == s_oem) 
	s_oem = new SiteOEM(request, response);
s_oem.setParameter(request);

String menuType = "";
%>

