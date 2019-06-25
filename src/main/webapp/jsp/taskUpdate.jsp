<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.sc.crmsys.bean.TaskBean"%>
<%@page import="com.sc.crmsys.bean.TaskDetailBean" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href="<%=basePath%>"> 
	<title>任务管理</title>
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
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;任务发布管理
			</div>
		</div>
		<form action="task/updateTask" method="post">
			<input type="hidden" name="taskId" value="${taskDetailBean.taskId }">
			<input type="hidden" name="taskDetailId" value="${taskDetailBean.taskDetailId }">
			<div class="page ">
				<!-- 上传广告页面样式 -->
				<div class="bor" style="margin-top:10px;">
					<div class="baTopNo">
						<span>任务发布管理</span>
					</div>
					<div class="baBody">
						<div class="bbD">
							任务标题：<input type="text" name="taskTitle" value="${taskDetailBean.taskBean.taskTitle }" class="input3" />
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;接收者：<input type="text" name="employName" readonly  value="${taskDetailBean.employBean.employName}" class="input3" />
						</div>
						<div class="bbD">
							考核指标：
							<select class="input3" name="checkPointId" id="test">
								<c:forEach items="${CheckPointBean }" var="checkPointBean">
									<option value="${checkPointBean.checkPointId }" ${checkPointBean.checkPointId ==  taskDetailBean.taskBean.checkPointBean.checkPointId?checkPointId:''}  >${checkPointBean.checkPointTarget }</option>
								</c:forEach>
							</select>
						</div>
						<%
							TaskDetailBean taskDetailBean = (TaskDetailBean)request.getAttribute("taskDetailBean");
							Date StartTime = taskDetailBean.getTaskBean().getTaskStartTime();
							SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String dateStart = simpleDateFormat1.format(StartTime);
						%>
						<%
							TaskDetailBean taskDetailBean1 = (TaskDetailBean)request.getAttribute("taskDetailBean");
							Date EndTime = taskDetailBean1.getTaskBean().getTaskEndTime();
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String dateEnd = simpleDateFormat1.format(EndTime);
						%> 
						<div class="bbD">
							生效时间：<input  name="taskStartTime" value="<%=dateStart %>" type="text" readonly style="width: 260px;height: 40px;border: 1px solid #ccc;text-indent: 15px;margin-left: 10px;"/>
						</div>
						<div class="bbD">
							失效时间：<input  name="taskEndTime" value="<%=dateEnd %>" type="text" readonly style="width: 260px;height: 40px;border: 1px solid #ccc;text-indent: 15px;margin-left: 10px;"/>
						</div> 
						<div class="bbD">
							任务内容：
							<div class="btext">
								<textarea class="text2" name="taskContent">${taskDetailBean.taskBean.taskContent }</textarea>
							</div>
						</div>
						<div class="bbD">
							<p class="bbDP">
								<input class="btn_ok btn_yes" type="submit" value="提交">
								<a class="btn_ok btn_no" href="task/selectTask">取消</a>
							</p>
						</div>
					</div>
				</div>
				<!-- 上传广告页面样式end -->
			</div>
		</form>
	</div>
</body>
</html> 