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
    <style>
        .container
        {
            width: 60%;
            margin: 0 auto;
            height: 900px;
            
        }
        .head
        {
            width: 100%;
            font-size: 30px;
            font-weight: 900;
            padding-bottom: 10px;
            border-bottom:1px solid grey;
        }

        .body
        {
            margin-top: 50px;
        }
        .item
        {
            clear: both;
            margin-top: 30px;
        }
        .question
        {
            overflow: hidden;
        }
        .title
        {
            width:80%;
            font-size: 16px;
            font-weight: 600;
            float: left;
        }
        .time
        {
            width: 30%;
            font-size: 15px;
            color: grey;
            float: right;
            text-align: right;
        }
        .answer
        {
            clear: both;
            font-size: 14px;
            font-weight: 400;
            line-height: 24px;
            color: #333;
            padding: 10px 0;
        }

        .page
        {
            height: 50px;
            margin-top: 30px;
            line-height: 50px;
            border-bottom:1px solid grey;
        }

        .page a
        {
            display: inline-block;
            margin-right: 5px;
            width: 80px;
            height: 30px;
            text-align: center;
            line-height: 30px;
            text-decoration: none;
            background-color: white;
            border:1px solid rgb(4,129,255);

        }
        .page a:hover
        {
            background-color: rgb(4,129,255);
            color: white;
        }

        .send-question
        {
           
            margin-top:50px;
        }

        .quetitle
        {
            font-size: 20px;
            font-weight: 900;
        }

        .quescontent
        {
            width: 70%;
            height: 100px;
            margin-top: 10px;
            outline: none;
        }

        .send
        {
            width: 220px;
            height: 100px;
            color: white;
            text-align: center;
            background-color: rgb(4,129,255);
            border:none;
            font-size: 25px;
            letter-spacing: 5px;
            cursor: pointer;
            position: absolute;
            margin-left: 580px;
            margin-top: -105px;
            
        }

        .send:hover
        {
            border-radius: 5px;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="head">
        问题反馈
        <a href="login.jsp" style="font-size: 15px;margin-left: 530px;">管理员登陆</a>
        <input type="text" placeholder="输入要查找的内容..." class="info" id="content" name="content">
        <input type="button" onclick="sub()" value="搜 索" class="select"> 
    </div>
    <div class="body">
        <div class="item">
        <c:forEach items="${questionList.list}" var="question">
            <div class="question">
                <div class="title">问：${question.questionContent}</div>
                <div class="time">
                	<fmt:formatDate value="${question.questionTime}" pattern="yyyy-MM-dd  HH:MM:ss"/>
                </div>
            </div>
            <div class="answer">
                 	 答：${question.answerContent}
            </div>
       </c:forEach>
       </div>
    </div>
    <div class="page">
        <a href="question/info">首页</a>
        <a href="javascript:send(${questionList.pageNum })">上一页</a>
        <a href="question/info?pn=${questionList.nextPage}">下一页</a>
        <a href="question/info?pn=${questionList.pages }">尾页</a>
    </div>
    <form action="question/add" method="post" >
	    <div class="send-question">
	        <div class="quetitle">问题咨询</div>
	        <div>
	            <textarea name="questionContent" class="quescontent"  ></textarea>
	        </div>
	        <div>
	            <input type="submit" class="send"  value="提交">
	        </div>
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
	function send(pn)
	{
		location.href = 'question/info?pn='+(pn-1);	
	}
	
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
