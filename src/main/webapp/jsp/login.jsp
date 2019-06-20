<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CRM系统登陆</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/page.css" />
<link rel="stylesheet" type="text/css" href="css/verify.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>
<body>

	<!-- 登录页面头部 -->
	<div class="logHead">
		<img src="img/logLOGO.png" />
	</div>
	<!-- 登录页面头部结束 -->

	<!-- 登录body -->
	<div class="logDiv">
		<img class="logBanner" src="img/logBanner.png" />
		<div class="logGet" style="top:5%;right:16%;height:448px;">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1" style="display: block;text-align:center;">登录</p>
				
			</div>
			<div class="lgD">
				<img class="img1" src="img/coin02.png" /><input type="text"
					placeholder="输入公司代码" />
			</div>
			<!-- 输入框 -->
			<div class="lgD">
				<img class="img1" src="img/logName.png" /><input type="text"
					placeholder="输入用户名" />
			</div>
			<div class="lgD">
				<img class="img1" src="img/logPwd.png" /><input type="text"
					placeholder="输入用户密码" />
			</div>
			<div class="lgD">
				<div id="mpanel2"></div>
				 <!-- <button type="button" id="check-btn" class="verify-btn">确定</button>  -->
			</div>
			<div class="logC">
				<button>登 录</button>
			</div>
		</div>
	</div>
	<!-- 登录body  end -->

	<!-- 登录页面底部 -->
	<div class="logFoot">
		<p class="p1">版权所有：湖北襄阳思创科技SC1803组</p>
		<p class="p2">湖北襄阳思创科技有限公司 登记序号：鄂ICP备11003578号-2</p>
	</div>
	<!-- 登录页面底部end -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/verify.js" ></script>
<script type="text/javascript">
	$('#mpanel2').codeVerify({
		type : 1,
		width : '150px',
		height : '44px',
		fontSize : '30px',
		codeLength : 6,
		btnId : 'check-btn',
		ready : function() {
		},
		success : function() {
			alert('验证匹配！');
		},
		error : function() {
			alert('验证码不匹配！');
		}
	});
</script>
</body>
</html>