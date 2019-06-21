<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<script type="text/javascript" src="qqjs/vue.min.js"></script>
</head>
<body > 

	<!-- 咨询部分 -->
	<div class="container"  >
		<img src="images/qq_left.png" alt="" style="z-index: 0">
			<div class="qq_left">
				<input type="text" placeholder="输入要查找的内容..." class="info" id="content" name="content"><input type="button" onclick="sub()" value="搜索" class="select"> 
				<div class="questions" >
					<c:forEach items="${questionList}" var="question">
						<div id="oneque">
							<div class="quetime">
								<fmt:formatDate value="${question.questionTime}" pattern="yyyy年MM月dd日  HH时MM分ss秒"/>
							</div>
						    <div class="que">问：${question.questionContent}</div>
						    <div class="anstime" margin="right">
						    	<fmt:formatDate value="${question.answerTime}" pattern="yyyy年MM月dd日  HH时MM分ss秒s"/>
						    </div>
							<div class="ans">答：${question.answerContent}</div>
						</div>
					</c:forEach>
				</div>
				<form action="question/add" method="post" >
					<input type="text"  placeholder="请输入您的问题....." class="put" name="questionContent"><input type="submit" value="提 交" class="submit" >
				</form>
			</div>
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
		
		function sub() {
			
			var content = $('#content').val();
			location.href = 'question/info?content='+content;
			
			//let val = document.querySelector('.info').value;
			/* var data = $('.info').val();
			$.ajax({
                type:'post',
                URL:'question/select',
                data:{content:data},
                dataType:'json',
                success:function(result)
                {
                	for(var i = 0;i<result.length;i++)
                		{
                		  result.questionContent;
                		  result.questionTime;
                		  result.answerContent;
                		  result.answerTime;
                		}
                },
                error:function()
                {
                    alert('系统繁忙');
                }
					
			     
                });
			 */
		} 
	
	
	
	
	</script>
</body>
</html>