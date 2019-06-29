<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href="<%=basePath%>"> 
	<title>查询任务</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<link rel="stylesheet" type="text/css" href="css/manhuaDate.1.0.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/manhuaDate.1.0.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	$(function (){
	  $("input.mh_date").manhuaDate({
	    Event : "click",//可选               
	    Left : 0,//弹出时间停靠的左边位置
	    Top : -16,//弹出时间停靠的顶部边位置
	    fuhao : "-",//日期连接符默认为-
	    isTime : false,//是否开启时间值默认为false
	    beginY : 1949,//年份的开始默认为1949
	    endY :2100//年份的结束默认为2049
	  });
	});
</script>
</head>

<body onload="page()">
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;查询任务
			</div>
		</div>

		<div class="page">
			<!-- vip页面样式 -->
			<div class="vip" id="dis">
				<div class="conform">
					<form id="forms" action="task/selectTask" method="post">
						<div class="cfD" style="margin-left:0px">
							时间：
							<input type="text" name="taskStartTime" id="input1" class="vinput mh_date" value="${startTime }" autocomplete="off"/>&nbsp;-&nbsp;
							<input type="text" name="taskEndTime" id="input2" class="vinput mh_date" value="${endTime }" autocomplete="off" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="addUser" autocomplete="off" id="input3" name="taskTitle" value="${title }" type="text"  placeholder="任务标题/任务指标" />
							<!-- <button class="button" onclick="javascript:function(){document.getElementById('forms').submit()};">搜索</button> -->
							<input class="button" type="submit" value="搜索">
							<a class="addA addA1 addA2" href="task/jumpToAdd">添加任务</a>
							<!-- <a class="addA addA1 addA2" href="task/selectTask">查询任务</a>
 -->						</div>
					</form>
				</div>
				<form action="task/selectTask?state=1" method="post">
				<!-- vip 表格 显示 -->
					<div class="conShow">
						<table border="1" cellspacing="0" cellpadding="0">
							<tr>
								<td width="66px" class="tdColor tdC">序号</td>
								<td width="120px" class="tdColor">发布人</td>
								<td width="120px" class="tdColor">接收人</td>
								<td width="150px" class="tdColor">任务标题</td>
								<td width="300px" class="tdColor">任务内容</td>
								<td width="120px" class="tdColor">任务指标</td>
								<td width="150px" class="tdColor">开始时间</td>
								<td width="150px" class="tdColor">结束时间</td>
								<td width="150px" class="tdColor">发布时间</td>
								<td width="100px" class="tdColor">完成状态</td>
								<td width="130px" class="tdColor">操作</td>
							</tr>
							<c:forEach items="${TaskDetailBean.list }" var="taskDetailBean" varStatus="s">
								<tr>
									<td>${s.index + 1}</td>
									<td>${taskDetailBean.taskBean.taskPerson}</td>
									<td>${taskDetailBean.employBean.employName}</td>
									<td>${taskDetailBean.taskBean.taskTitle}</td>
									<td>${taskDetailBean.taskBean.taskContent}</td>
									<td>${taskDetailBean.taskBean.checkPointBean.checkPointTarget}</td>
									<td>
										<fmt:formatDate value="${taskDetailBean.taskBean.taskStartTime}" pattern="yyyy-MM-dd"/>
									</td>
									<td>
										<fmt:formatDate value="${taskDetailBean.taskBean.taskEndTime}" pattern="yyyy-MM-dd"/>
									</td>
									<td>
										<fmt:formatDate value="${taskDetailBean.taskBean.taskUpdateTime}" pattern="yyyy-MM-dd"/>
									</td>
									<td>
										<c:if test="${taskDetailBean.taskDetailState eq 1}">已读</c:if>
										<c:if test="${taskDetailBean.taskDetailState eq 0}">未读</c:if>
									</td>
									<td>
										<a href="task/jumpToUpdate?taskDetailId=${taskDetailBean.taskDetailId}&taskId=${taskDetailBean.taskId}&employId=${taskDetailBean.employId}&checkPointId=${taskDetailBean.taskBean.checkPointId}">
											<img class="operation" src="img/update.png">
										</a> 
											<img class="operation delban" src="img/delete.png" onclick="deleteTask('${taskDetailBean.taskId}','${taskDetailBean.taskDetailId}') "> 
									</td>
								</tr>
							</c:forEach>
						</table>
						<div class="paging" id="div"></div>
					</div>
				</form>
				<!-- vip 表格 显示 end-->
			</div>
			<!-- vip页面样式end -->
		</div>

	</div>


	<!-- 删除弹出框 -->
	<div class="banDel">
		<div class="delete">
			<div class="close">
				<a><img src="img/shanchu.png" /></a>
			</div>
			<p class="delP1">你确定要删除此条记录吗？</p>
			<p class="delP2">
				<a href="javascript:;" id="read" class="ok yes">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
</body>
	<script type="text/javascript" src="js/vue.min.js"></script>
	<script type="text/javascript">
	// 广告弹出框
	$(document).ready(function(){
		$(".delban").click(function(){
		  $(".banDel").show();
		});
		$(".close").click(function(){
		  $(".banDel").hide();
		});
		$(".no").click(function(){
		  $(".banDel").hide();
		});
	});
	// 广告弹出框 end
/* 	new Vue({
		el:"#dis",
		data:
		{
			myresult:''
		}
	}); */
	function deleteTask(taskId,taskDetailId) 
	{
		document.getElementById('read').href = "task/delete?taskId=" + taskId + "&taskDetailId=" + taskDetailId;
	}
	function page()
	{
        var td = document.getElementById('div');
        if(${TaskDetailBean.pageNum} != 1)
       	{
        	var startTime = document.getElementById('input1').value;
			var endTime = document.getElementById('input2').value;
			var title = document.getElementById('input3').value;
			
        	var a = document.createElement('a');
        	a.innerHTML = '首页';
        	a.href = 'task/selectTask?pn=1' + '&taskStartTime=' + startTime + '&taskEndTime=' + endTime + '&taskTitle' + title;
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
        
        if(${TaskDetailBean.pageNum} <= 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(i+1 <= ${TaskDetailBean.pages})
				{
					var startTime = document.getElementById('input1').value;
					var endTime = document.getElementById('input2').value;
					var title = document.getElementById('input3').value;
					
					var a = document.createElement('a');
					a.innerHTML = i + 1;
					a.href = 'task/selectTask?pn=' + (i + 1) + '&taskStartTime=' + startTime + '&taskEndTime=' + endTime + '&taskTitle' + title;
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${TaskDetailBean.pageNum} == i+1)
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
				
			}
        }
        if(${TaskDetailBean.pageNum} > 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(${TaskDetailBean.pageNum}+i-5 <= ${TaskDetailBean.pages})
				{
					var startTime = document.getElementById('input1').value;
					var endTime = document.getElementById('input2').value;
					var title = document.getElementById('input3').value;
					
					var a = document.createElement('a');
					a.innerHTML = ${activeBean1.pageNum}+i-5;
					a.href = 'task/selectTask?pn=' + (${TaskDetailBean.pageNum}+i-5 + '&taskStartTime=' + startTime + '&taskEndTime=' + endTime + '&taskTitle' + title);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${TaskDetailBean.pageNum} == (${TaskDetailBean.pageNum}+i-5))
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
			}
        }
        
        if(${TaskDetailBean.pageNum } != ${TaskDetailBean.pages})
       	{
        	var startTime = document.getElementById('input1').value;
			var endTime = document.getElementById('input2').value;
			var title = document.getElementById('input3').value;
			
        	var a = document.createElement('a');
        	a.innerHTML = '尾页';
        	a.href = 'task/selectTask?pn=' + ${TaskDetailBean.pages} + '&taskStartTime=' + startTime + '&taskEndTime=' + endTime + '&taskTitle' + title;
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
	}
	</script>
	
</html>