<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"> 
	<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/rafaelcss.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/rafael.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="page">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					
				</div>
				
				
				
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>