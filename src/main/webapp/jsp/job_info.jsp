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
				<img src="img/coin02.png" /><span><a href="inc/mainll.jsp">首页</a>&nbsp;&nbsp;&nbsp;-</span>&nbsp;部门/职务信息
			</div>
		</div>

		<div class="page">
			<!-- answer页面样式 -->
			<div class="wish">
				<div class="conform">
				</div>
				<!-- wish 表格 显示 -->
				<div class="wishShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="200px" class="tdColor" style="color:black;">所属部门</td>
							<td width="200px" class="tdColor" style="color:black;">删除部门</td>
							<td width="200px" class="tdColor" style="color:black;">添加职务</td>
							<td width="100px" class="tdColor" style="color:black;">职务</td>
							<td width="100px" class="tdColor" style="color:black;">修改职务</td>
							<td width="100px" class="tdColor" style="color:black;">删除职务</td>
						</tr>
						<c:forEach items="${jobAndDept}" var="jpt">
							<tr>
								<td width="200px" rowspan="${fn:length(jpt.jobList)}" class="tdColor">${jpt.deptName}</td>
								<td class="tdColor" rowspan="${fn:length(jpt.jobList)}">
									<img class="operation delban" src="img/shanchu.png" onclick="del_dept('${jpt.deptNumber}')">
								</td>
								<td class="tdColor" rowspan="${fn:length(jpt.jobList)}">
										<img class="operation delban" src="img/update.png" onclick="add('${jpt.deptNumber}')">
								</td>
								<c:forEach items="${jpt.jobList}" var="jobList">
									<td width="200px" class="tdColor">${jobList.jobName}</td>
									<td class="tdColor">
									<img class="operation delban" src="img/update.png" onclick="update('${jobList.jobId}')">
									</td>
									<td class="tdColor">
										<img class="operation delban" src="img/delete.png" onclick="delet('${jobList.jobId}')">
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
					<input type="button" value="提 交"  class="mit" id="sub_job"><input type="button" value="点击添加部门"  id="open_dept" style="width:332px;height:40px; color: #438eb9;">
				</div>
				<div class="addDept">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="180px" class="tdColor" colspan="4">添加新的部门信息</td>
						</tr>
						<tr>
							<td width="150px" class="tdColor">部门名称</td>
							<td width="180px"><input type="text" style="width: 150px" name="deptName" id="u_deptName" >
							</td>
							<td width="150px" class="tdColor">备注说明</td>
							<td width="180px"><input type="text" style="width: 150px" name="deptRemarks" id="u_deptRemarks"></td>
						</tr>
					</table>
					<input type="button" value="提 交"  id="dept_smt" style="width:664px;height:40px; color: #438eb9;" >
				</div>
				
				<div class="updateJob">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="180px" class="tdColor" colspan="4">修改职务信息</td>
						</tr>
						<tr>
							<td width="150px" class="tdColor">更改名称</td>
							<td width="180px"><input type="text" style="width: 150px" name="jobName" id="updateName"></td>
							<td width="150px" class="tdColor">更改所属部门</td>
							<td width="180px"><input type="text" style="width: 150px" name="deptName" id="updeptName"></td>
						</tr>
					</table>
					<input type="button" value="提 交" id="update_job" style="width:664px;height:40px; color: #438eb9;">
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

	$("#open_dept").click(function(){
		$(".addDept").css("display","block");
	});
		

function send(pn)
{
	location.href = 'question/answer?pn='+(pn-1);	
}

//点击传入部门编号
var deptNumber = "";
function add(departNum)
{
	deptNumber = departNum
	$(".addJob").css("display","block");
}
	//提交添加的职务信息
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
	
	//点击传入职务编号好
	var jobId="";
	function update(job_id)
	{
		jobId = job_id;
		$(".updateJob").css("display","block");//改变 隐藏的div为显示  
	}
	//修改职务信息
	$("#update_job").click(function(){
		var jobName = $("#updateName").val();
		var deptName = $("#updeptName").val();
		$.ajax({
	        type:'post',
	        url:'job/updateJob',
	        data:{jobId:jobId,jobName:jobName,deptName:deptName},
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
	})
	
	//添加部门信息
	$("#dept_smt").click(function()
	 {
		var deptRemarks = $("#u_deptRemarks").val();
		var deptName = $("#u_deptName").val();
		
		var jobName = $("#jobName").val();
		var jobRemarks = $("#jobRemarks").val();
		$.ajax({
	        type:'post',
	        url:'job/addDepartment',
	        data:{deptRemarks:deptRemarks,deptName:deptName,jobName:jobName,jobRemarks:jobRemarks},
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
	
	//删除职务
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
	
	//删除部门信息
	function del_dept(dpt_id)
	{
		var deptNumber  = dpt_id;
		$.ajax({
	        type:'post',
	        url:'job/del_dept',
	        data:{deptNumber:deptNumber},
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