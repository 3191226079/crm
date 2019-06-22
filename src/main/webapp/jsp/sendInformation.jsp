<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>   
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href="<%=basePath%>">  
	<title>发送短信</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;发送短信
			</div>
		</div>
		<form action="info/insertInfo">
			<div class="page">
				<!-- 上传广告页面样式 -->
				<div class="bor"  style="margin-top:10px;">
					<div class="baTopNo">
						<span>发送短信</span>
					</div>
					<div class="baBody">
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发送主题：
							<input type="text" name="infoTitle" class="input3" />
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;接收用户：
							<select class="input3" name="employId">
								<c:forEach items="${employList }" var="employBean">
									<option value="1" disabled selected hidden>请选择</option>
									<option value="${employBean.employId }">${employBean.employName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发送内容：
							<div class="btext2">
								<textarea class="text2" name="infoContent"></textarea>
							</div>
						</div>
						<div class="bbD">
							<p class="bbDP">
								<input class="btn_ok btn_yes" type="submit" value="提交">
								<a class="btn_ok btn_no" href="info/selectInfo">取消</a>
							</p>
						</div>
					</div>
				</div>
			</form>
			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>

