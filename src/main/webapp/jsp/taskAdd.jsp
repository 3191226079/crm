<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<form action="task/insertTask" method="post">
			<div class="page ">
				<!-- 上传广告页面样式 -->
				<div class="bor" style="margin-top:10px;">
					<div class="baTopNo">
						<span>任务发布管理</span>
					</div>
					<div class="baBody">
						<div class="bbD">
							任务标题：<input type="text" autocomplete="off"
							 name="taskTitle" class="input3" />
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;接收者：
							<select class="input3" name="employId">
								<c:forEach items="${EmployBean }" var="employBean">
									<option value="1" disabled selected hidden="true">请选择</option>
									<option value="${employBean.employId }">${employBean.employName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="bbD">
							考核指标：
							<select class="input3" name="checkPointId">
								<c:forEach items="${CheckPointBean }" var="checkPointBean">
									<option value="1" disabled selected hidden="true">请选择</option>
									<option value="${checkPointBean.checkPointId }">${checkPointBean.checkPointTarget }</option>
								</c:forEach>
							</select>
						</div>
						<div class="bbD">
							生效时间：<input autocomplete="off" class="vinput mh_date" name="taskStartTime" type="text"  style="width: 260px;height: 40px;border: 1px solid #ccc;text-indent: 15px;margin-left: 10px;"/>
						</div>
						<div class="bbD">
							失效时间：<input autocomplete="off" class="vinput mh_date" name="taskEndTime" type="text" style="width: 260px;height: 40px;border: 1px solid #ccc;text-indent: 15px;margin-left: 10px;"/>
						</div>
						<div class="bbD">
							任务内容：
							<div class="btext">
								<textarea class="text2" name="taskContent"></textarea>
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