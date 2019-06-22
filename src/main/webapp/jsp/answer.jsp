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
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;咨询回复
			</div>
		</div>

		<div class="page">
			<!-- answer页面样式 -->
			<div class="wish">
				<div class="conform">
					<form action="question/answer" method="post">
						<div class="cfD">
							&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="addUser" type="text" placeholder="请输入要查找的咨询...." name="content"/>
							<button class="button" type="submit">搜索</button>
						</div>
					</form>
				</div>
				<!-- wish 表格 显示 -->
				<div class="wishShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="200px" class="tdColor" style="color:black;">咨询时间</td>
							<td width="250px" class="tdColor" style="color:black;">咨询内容</td>
							<td width="100px" class="tdColor" style="color:black;">是否回复</td>
							<td width="250px" class="tdColor" style="color:black;">回复内容</td>
							<td width="200px" class="tdColor" style="color:black;">回复时间</td>
							<td width="130px" class="tdColor" style="color:black;">回复</td>
						</tr>
						<c:forEach items="${questionList.list}" var="question">
							<tr>
								<td width="66px" class="tdColor tdC">
									<fmt:formatDate value="${question.questionTime}" pattern="yyyy-MM-dd  HH:MM:ss"/>
								</td>
								<td width="200px" class="tdColor">${question.questionContent}</td>
								<c:if test="${question.questionState == 1}">
									<td width="175px" class="tdColor">已回复</td>
								</c:if>
								<c:if test="${question.questionState == 0}">
									<td width="175px" class="tdColor">未回复</td>
								</c:if>
								<c:if test="${empty question.questionState }">
									<td width="175px" class="tdColor"></td>
								</c:if>
								<td width="185px" class="tdColor">${question.answerContent}</td>
								<td width="180px" class="tdColor">
									<fmt:formatDate value="${question.answerTime}" pattern="yyyy-MM-dd  HH:MM:ss"/>
								</td>
								<td>
									<img class="operation delban" src="img/update.png" onclick="abcdd('${question.questionId}')">
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="page" style="height: 50px; margin-top: 30px;line-height: 50px;border-bottom:1px solid grey;">
				        <a href="question/answer" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	首页
				        </a>
				     	<a href="javascript:send(${questionList.pageNum })" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	上一页
				       	</a>
				        <a href="question/answer?pn=${questionList.nextPage}" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	下一页
				        </a>
				        <a href="question/answer?pn=${questionList.pages }" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	尾页
				        </a>
				    </div>
				</div>
				<!-- wish 表格 显示 end-->
			</div>
			<!-- wish页面样式end -->
		</div>
	</div>
	<!-- 回复框 -->
	<div class="banDel">
		<div class="delete">
			<div class="close">
				<a><img src="img/shanchu.png" /></a>
			</div>
				<input class="delP1" id="answer_content" type="text" name="answerContent" placeholder="输入回复内容..." style="with:300px!important;height:50px;">
				<p class="delP2">
					<input type="button" id="smt" class="ok yes" value="确定"  style="text-align:center;">
					<a class="ok no">取消</a>
				</p>
		</div>
	</div>
	<!-- 回复框  end-->
</body>

<script type="text/javascript">

function send(pn)
{
	location.href = 'question/answer?pn='+(pn-1);	
}

var myid = '';
function abcdd(id)
{
	myid = id;
}
// 广告弹出框
$(".delban").click(function(){
	
  $(".banDel").show();
  
});
$(".close").click(function(){
  $(".banDel").hide();
});
$(".no").click(function(){
  $(".banDel").hide();
});

$("#smt").click(function(){
	var questionId = myid;
	var answerContent = $("#answer_content").val();
	$.ajax({
        type:'post',
        url:'question/addanswer',
        data:{questionId:questionId,answerContent:answerContent},
        dataType:'json',
        success:function(e)
        {
        	
        	console.dir(e);
        	location.href="question/answer";
        },
        error:function()
        {
            alert('系统繁忙');
        }
			
        });
	 
  });


// 广告弹出框 end
</script>
</html>