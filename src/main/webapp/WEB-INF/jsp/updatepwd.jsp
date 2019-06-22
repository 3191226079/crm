<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<style type="text/css">
.myclassd
{
	position: relative;
}
.myclassd span
{
	position: absolute;
	bottom: 15px;
	right: -50px;
	color:red;
}
</style>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="inc/mainll.jsp">首页</a>&nbsp;-&nbsp;</span>&nbsp;修改密码
			</div>
		</div>
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.userBean.userName }</div>
				<div class="bbD">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				注册时间：&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${requestScope.userBean.userRegisterTime }" pattern="yyyy年MM月dd日"/></div>
				<form action="user/updatepass" method="post" id="myformll792">
					<div class="bbD myclassd">
						&nbsp;&nbsp;&nbsp;&nbsp;输入旧密码：<input type="password" name="oldPass" class="input3"
							onblur="checkpwd1()" onfocus="myxiaochu()" id="pwd1" /> <img class="imga"
							src="img/ok.png" /><img class="imgb" src="img/no.png" />
							<span id="myspan12">${requestScope.fail }</span>
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;输入新密码：<input type="password" name="newPass" class="input3"
							onblur="checkpwd2()" id="pwd2" /> <img class="imga"
							src="img/ok.png" /><img class="imgb" src="img/no.png" />
					</div>
					<div class="bbD">
						&nbsp;再次确认密码：<input type="password" class="input3" onblur="checkpwd3()"
							id="pwd3" /> <img class="imga" src="img/ok.png" /><img
							class="imgb" src="img/no.png" />
					</div>
				</form>
				<div class="bbD">
					<p class="bbDP">
						<button class="btn_ok btn_yes" id="mysubmit09">提交</button>
						<a class="btn_ok btn_no" href="inc/mainll.jsp">取消</a>
					</p>
				</div>
			</div>

			<!-- 修改密码页面样式end -->
		</div>
	</div>
</body>
<script type="text/javascript">
function myxiaochu(){
	document.getElementById('myspan12').innerHTML='';
}
var temps = 0;
	document.getElementById('mysubmit09').onclick = function(){
		temps = 0;
		checkpwd1();
		checkpwd2();
		checkpwd3();
		if(temps == 3)
		{
			document.getElementById('myformll792').submit();
		}
	};
function checkpwd1(){
	myxiaochu();
var user = document.getElementById('pwd1').value.trim();
 if (user.length >= 6 && user.length <= 12) {
	 temps++;
  $("#pwd1").parent().find(".imga").show();
  $("#pwd1").parent().find(".imgb").hide();
 }else{
  $("#pwd1").parent().find(".imgb").show();
  $("#pwd1").parent().find(".imga").hide();
 };
}
function checkpwd2(){
var user = document.getElementById('pwd2').value.trim();
 if (user.length >= 6 && user.length <= 12) {
	 temps++;
  $("#pwd2").parent().find(".imga").show();
  $("#pwd2").parent().find(".imgb").hide();
 }else{
  $("#pwd2").parent().find(".imgb").show();
  $("#pwd2").parent().find(".imga").hide();
 };
}
function checkpwd3(){
var user = document.getElementById('pwd3').value.trim();
var pwd = document.getElementById('pwd2').value.trim();
 if (user.length >= 6 && user.length <= 12 && user == pwd) {
	 temps++;
  $("#pwd3").parent().find(".imga").show();
  $("#pwd3").parent().find(".imgb").hide();
 }else{
   $("#pwd3").parent().find(".imgb").show();
  $("#pwd3").parent().find(".imga").hide();
 };
}
</script>
</html>