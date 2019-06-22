<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>头部</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>

<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL">
			<img class="headLogo" src="img/headLogo.png" />
		</div>
		<div class="headR">
			<p class="p1">
				欢迎，<c:if test="${not empty requestScope.username }">${requestScope.username }</c:if>
			</p>
			<p class="p2">
				<a href="#" class="resetPWD">重置密码</a>&nbsp;&nbsp;<a
					href="{:U('Admin/Index/exit')}" class="goOut">退出</a>
			</p>
		</div>
		<!-- onclick="{if(confirm(&quot;确定退出吗&quot;)){return true;}return false;}" -->
	</div>

	<div class="closeOut">
		<div class="coDiv">
			<p class="p1">
				<span>X</span>
			</p>
			<p class="p2">确定退出当前用户？</p>
			<P class="p3">
				<a class="ok yes" href="#">确定</a><a class="ok no" href="#">取消</a>
			</p>
		</div>
	</div>



</body>
</html>