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
<script type="text/javascript" src="js/verify.js" ></script>
<script type="text/javascript" src="js/vue.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<style type="text/css">
.lgD
{
	position:relative;
}
.lgD span
{
	position:absolute;
	bottom: -19px;
	left:2px;
	color:red;
	font-size: 14px;
}
</style>
</head>
<body>

	<!-- 登录页面头部 -->
	<div class="logHead">
		<img src="img/logLOGO.png" />
	</div>
	<!-- 登录页面头部结束 -->

	<!-- 登录body -->
	<div class="logDiv" id="myvuell">
		<img class="logBanner" src="img/logBanner.png" />
		<div class="logGet" style="top:5%;right:16%;height:448px;">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1" style="display: block;text-align:center;">登录</p>
				
			</div>
			<div class="lgD">
				<img class="img1" src="img/coin02.png" /><input type="text" v-model="companyCode"
					placeholder="输入公司代码" @blur="sp1"/><span>{{spll1}}</span>
			</div>
			<!-- 输入框 -->
			<div class="lgD">
				<img class="img1" src="img/logName.png" /><input type="text" v-model="userName"
					placeholder="输入用户名" @blur="sp2"/><span>{{spll2}}</span>
			</div>
			<div class="lgD">
				<img class="img1" src="img/logPwd.png" /><input type="text"  v-model="userPassword"
					placeholder="输入用户密码" @blur="sp3"/><span>{{spll3}}</span>
			</div>
			<div class="lgD">
				<div id="mpanel2"></div><span>{{spll4}}</span>
				 <!-- <button type="button" id="check-btn" class="verify-btn">确定</button>  -->
			</div>
			<div class="logC">
				<button id="check-btn" v-on:click="juge">登 录</button>
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
<script type="text/javascript">
	var v = new Vue({
		el:'#myvuell',
		data:
		{
			companyCode:'',
			userName:'',
			userPassword:'',
			spll1:'',
			spll2:'',
			spll3:'',
			spll4:''
		},
		methods:
		{
			juge:function()
			{
				if(this.companyCode == '')
				{
					this.spll1 = '* 公司代码不能为空';
				}
				else if(!/^[a-zA-Z][A-Za-z0-9]{3,10}$/.test(this.companyCode))
				{
					this.spll1 = '* 公司代码格式不正确';
				}
				else
				{
					this.spll1 = '';
				}
				
				if(this.userName == '')
				{
					this.spll2 = '* 用户名不能为空';
				}
				else if(!/^[A-Za-z0-9]{3,10}$/.test(this.userName))
				{
					this.spll2 = '* 用户名必须在3到10个之间，字母加数字';
				}
				else
				{
					this.spll2 = '';
				}
				
				if(this.userPassword == '')
				{
					this.spll3 = '* 用户密码不能为空';
				}
				else if(!/^[A-Za-z0-9]{6,15}$/.test(this.userPassword))
				{
					this.spll3 = '* 密码必须在6到15个之间，字母加数字';
				}
				else
				{
					this.spll3 = '';
				}
			},
			sp1()
			{
				if(this.companyCode == '')
				{
					this.spll1 = '* 公司代码不能为空';
				}
				else if(!/^[a-zA-Z][A-Za-z0-9]{3,10}$/.test(this.companyCode))
				{
					this.spll1 = '* 公司代码格式不正确';
				}
				else
				{
					this.spll1 = '';
				}
			},
			sp2()
			{
				if(this.userName == '')
				{
					this.spll2 = '* 用户名不能为空';
				}
				else if(!/^[A-Za-z0-9]{3,10}$/.test(this.userName))
				{
					this.spll2 = '* 用户名必须在3到10个之间，字母加数字';
				}
				else
				{
					this.spll2 = '';
				}
			},
			sp3()
			{
				if(this.userPassword == '')
				{
					this.spll3 = '* 用户密码不能为空';
				}
				else if(!/^[A-Za-z0-9]{6,15}$/.test(this.userPassword))
				{
					this.spll3 = '* 密码必须在6到15个之间，字母加数字';
				}
				else
				{
					this.spll3 = '';
				}
			}
		}
		
	});
	function sp4()
	{
		$('#check-btn').click();
	}
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
			v.spll4 = '验证成功';
		},
		error : function() {
			if($('#yanzhenll').val() == '')
			{
				v.spll4 = '* 输入验证码';
			}
			else
			{
				v.spll4 = '* 验证码不匹配';
			}
		}
	});
</script>
</body>
</html>