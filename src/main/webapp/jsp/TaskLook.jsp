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
	<title>任务发布管理</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body onload="page()">
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;任务发布管理
			</div>
		</div>

		<div class="page">
			<!-- vip页面样式 -->
			<div class="vip" id="dis">
				<div class="conform">
					<form id="forms" action="task/selectTask" method="post">
						<div class="cfD">
							<input autocomplete="off" name="taskTitle"  type="hidden" v-model="myresult">
							<input class="addUser" autocomplete="off" name="checkPointBean.checkPointTarget" type="text" v-model="myresult" placeholder="任务标题/任务指标" />
							<button class="button" onclick="javascript:function(){document.getElementById('forms').submit()};">搜索</button>
							<a class="addA addA1 addA2" href="task/jumpToAdd">添加任务</a>
						</div>
					</form>
				</div>
				<!-- vip 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">序号</td>
							<td width="150px" class="tdColor">发布人</td>
							<td width="290px" class="tdColor">接收人</td>
							<td width="188px" class="tdColor">任务标题</td>
							<td width="235px" class="tdColor">任务内容</td>
							<td width="220px" class="tdColor">任务指标</td>
							<td width="290px" class="tdColor">开始时间</td>
							<td width="282px" class="tdColor">结束时间</td>
							<td width="130px" class="tdColor">完成状态</td>
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
	new Vue({
		el:"#dis",
		data:
		{
			myresult:''
		}
	});
	function deleteTask(taskId,taskDetailId) 
	{
		console.log(taskDetailId);
		document.getElementById('read').href = "task/delete?taskId=" + taskId + "&taskDetailId=" + taskDetailId;
	}
	function page()
	{
        var td = document.getElementById('div');
        if(${TaskDetailBean.pageNum} != 1)
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '首页';
        	a.href = 'task/selectTask?pn=1';
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
					var a = document.createElement('a');
					a.innerHTML = i + 1;
					a.href = 'task/selectTask?pn=' + (i + 1);
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
					var a = document.createElement('a');
					a.innerHTML = ${activeBean1.pageNum}+i-5;
					a.href = 'task/selectTask?pn=' + (${TaskDetailBean.pageNum}+i-5);
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
        	var a = document.createElement('a');
        	a.innerHTML = '尾页';
        	a.href = 'task/selectTask?pn=' + ${TaskDetailBean.pages};
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
	}
	</script>
	
</html>