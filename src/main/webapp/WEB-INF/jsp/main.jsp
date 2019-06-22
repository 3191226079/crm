<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CRM系统</title>
</head>
	<frameset rows="100,*" cols="*" scrolling="No" framespacing="0" frameborder="no" border="0"> 
		<frame src="user/head" name="headmenu" id="mainFrame" title="mainFrame">
	<!-- 引用头部 -->
	<!-- 引用左边和主体部分 --> 
		<frameset rows="100*" cols="220,*" scrolling="No" framespacing="0" frameborder="no" border="0"> 
			<frame src="inc/left.jsp" name="leftmenu" id="mainFrame" title="mainFrame">
			<frame src="inc/mainll.jsp" name="main" scrolling="yes" noresize="noresize" id="rightFrame" title="rightFrame">
		</frameset>
	</frameset>
</html>