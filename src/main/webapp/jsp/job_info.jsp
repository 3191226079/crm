<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
				<img src="img/coin02.png" /><span><a href="inc/mainll.jsp">首页</a>&nbsp;&nbsp;&nbsp;-</span>&nbsp;咨询回复
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
							<td width="200px" class="tdColor" style="color:black;">所属部门</td>
							<td width="200px" class="tdColor" style="color:black;">添加职务</td>
							<td width="100px" class="tdColor" style="color:black;">职务</td>
							<td width="100px" class="tdColor" style="color:black;">修改职务</td>
							<td width="100px" class="tdColor" style="color:black;">删除职务</td>
						</tr>
						<c:forEach items="${jobAndDept}" var="jpt">
							<tr>
								<td width="200px" rowspan="${fn:length(jpt.jobList)}" class="tdColor">${jpt.deptName}</td>
								<td class="tdColor" rowspan="${fn:length(jpt.jobList)}">
									<img class="operation delban" src="img/update.png" onclick="add('${jpt.deptNumber}')">
								</td>
								<c:forEach items="${jpt.jobList}" var="jobList">
									<td width="200px" class="tdColor">${jobList.jobName}</td>
									<td class="tdColor">
									<img class="operation delban" src="img/update.png" onclick="abcdd('${jobList.jobId}')">
									</td>
									<td class="tdColor">
										<img class="operation delban" src="img/shanchu.png" onclick="delet('${jobList.jobId}')">
									</td>
									
								
								
							</tr>
							</c:forEach>
						</c:forEach>
					</table>
				</div>
				
				<div class="addJob">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="180px" class="tdColor" colspan="4">添加新的职务信息</td>
						</tr>
						<tr>
							<td width="150px" class="tdColor">职务名称</td>
							<td width="180px"><input type="text" style="width: 150px" name="jobName" id="jobName">
							</td>
							<td width="150px" class="tdColor">备注说明</td>
							<td width="180px"><input type="text" style="width: 150px" name="jobRemarks" id="jobRemarks"></td>
						</tr>
					</table>
					<input type="button" value="提 交"  class="mit" id="sub_job"><input type="button" value="点击添加部门" class="mit"  id="open_dept">
				</div>
				<div class="addDept">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="180px" class="tdColor" colspan="4">添加新的部门信息</td>
						</tr>
						<tr>
							<td width="150px" class="tdColor">部门名称</td>
							<td width="180px"><input type="text" style="width: 150px" name="feedbackId" value="" >
							</td>
							<td width="150px" class="tdColor">备注说明</td>
							<td width="180px"><input type="text" style="width: 150px" name="customerId" value=""></td>
						</tr>
					</table>
					<input type="button" value="提 交" style="width:664px;height:40px; color: #438eb9;" >
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

var deptNumber = "";
function add(departNum)
{
	deptNumber = departNum
	$(".addJob").css("display","block");
}
	
	$("#sub_job").click(function()
	{
		var jobName = $("#jobName").val();
		var jobRemarks = $("#jobRemarks").val();
		$.ajax({
	        type:'post',
	        url:'job/addJob',
	        data:{jobName:jobName,jobRemarks:jobRemarks,deptNumber:deptNumber},
	        dataType:'json',
	        success:function(e)
	        {
	        	
	        	console.log(e);
	        	location.href="job/selectAllInfo";
	        },
	        error:function()
	        {
	            alert('系统繁忙');
	        }
				
	        });
	});
	
	function delet(id)
	{
		var jobId = id;
		$.ajax({
	        type:'post',
	        url:'job/deleteJob',
	        data:{jobId:jobId},
	        dataType:'json',
	        success:function(e)
	        {
	        	
	        	console.log(e);
	        	location.href="job/selectAllInfo";
	        },
	        error:function()
	        {
	            alert('系统繁忙');
	        }
				
	        });
	}
	

// 广告弹出框


/* $(".delban").click(function(){
	
  $(".banDel").show();
  
});
$(".close").click(function(){
  $(".banDel").hide();
});
$(".no").click(function(){
  $(".banDel").hide();
}); */

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