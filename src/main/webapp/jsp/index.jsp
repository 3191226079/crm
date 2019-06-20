<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"> 
	<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>客户联系首页</title>
	<link href="qqcss/style.css" rel="stylesheet" media="screen" type="text/css" />
	<script type="text/javascript" src="qqjs/jquery-1.10.2.min.js"></script>
</head>
<body onload="submit()"> 
	<!-- 咨询部分-->
	<div class="container"  >
		<img src="images/qq_left.png" alt="" style="z-index: 0">
		<form  name="form" action="question/info" method="post">
			<div class="qq_left">
				<textarea name="customerInfo" placeholder="输入您要咨询的问题" style="width: 99%;height: 20%;background-color: rgb(87,36,68)"></textarea>
				<input type="submit" value="提 交" style=" background-color: rgb(125,50,78); border-bottom: 1px rgba(0,0,0,0.6) solid;color: white;font-size: 17px;">
			</div>
		</form>
	</div>
	
	<!-- 客服部分 -->
	<div style="right:-230px;" class="contactusdiyou">
		<div class="hoverbtn">
			<span>联</span><span>系</span><span>我</span><span>们</span>
			<img class="hoverimg" src="images/hoverbtnbg.gif" height="9" width="13">
		</div>
		<div class="conter">
			<div class="con1"> 
				<dl class="fn_cle">
					<dt><img src="images/tel.png" height="31" width="31"></dt>
					<dd class="f1">咨询热线：</dd>
					<dd class="f2"><span class="ph_num">188-9999-8888</span></dd>
				</dl>
			</div> 
			<div class="blank0"></div>
			<div class="qqcall"> 
				<dl class="fn_cle">
					<dt><img src="images/zxkfqq.png" height="31" width="31"></dt>
					<dd class="f1 f_s14">在线客服：</dd>
					<dd class="f2 kefuQQ">
						<span>客服一</span>
						<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=1720508324&amp;site=qq&amp;menu=yes"></a><br>
						<span>客服二</span>
						<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=1479180564&amp;site=qq&amp;menu=yes"></a>
					</dd>
				</dl>
				<div class="blank0"></div>           
			</div> 
			<div class="blank0"></div>
			<div class="weixincall"> 
				<dl class="fn_cle">
					<dt><img src="images/weixin.png" height="31" width="31"></dt>
					<dd class="f1">官方微信站：</dd>
					<dd class="f3"><img src="images/wechat_code.png" height="73" width="73"></dd>
				</dl>
			</div> 
			<div class="blank0"></div>
			<div class="dytimer">
				<span style="font-weight: bold;">公司官网：</span>
				<span><a href="">sc.chinaz.com</a></span>
			</div>
		</div>
	</div>
	
	<div class="diyoumask" ></div>
	
	<script type="text/javascript">
	$(function() {
		$(".contactusdiyou").hover(function() {
			$(".hoverimg").attr("src","images/hoverbtnbg1.gif");
			$('.diyoumask').fadeIn();
			$('.contactusdiyou').animate({right:'0'},300); 
		}, function() {
			$(".hoverimg").attr("src","images/hoverbtnbg.gif");
			$('.contactusdiyou').animate({right:'-230px'},300,function(){});
			$('.diyoumask').fadeOut();
		});
	});
	$(document).ready(function){
		$()
		
	}
	
	
	</script>
</body>
</html>