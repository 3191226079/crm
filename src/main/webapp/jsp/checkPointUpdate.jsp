<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.sc.crmsys.bean.CheckPointBean" %>
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
	<title>指标更改</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;指标更改
			</div>
		</div>
		<form action="checkPoint/update" method="post">
			<input type="hidden" name="checkPointId" value="${checkPointBean.checkPointId }">
			<div class="page">
				<!-- 上传广告页面样式 -->
				<div class="bor" style="margin-top:10px;">
					<div class="baTopNo">
						<span>修改指标</span>
					</div>
					<div class="baBody">
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考核指标名称：
							 <input type="text" autocomplete="off" name="checkPointTarget" value="${checkPointBean.checkPointTarget }" class="input3" />
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考核指标描述：
						<div class="btext2">
							<textarea class="text2" name="checkPointInfo" style="margin-left: 25px">${checkPointBean.checkPointInfo }</textarea>
						</div>
						<%
							CheckPointBean checkPointBean = (CheckPointBean)request.getAttribute("checkPointBean");
							Date Time = checkPointBean.getCheckPointUpdateTime();
							SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
							String date = simpleDateFormat1.format(Time);
						%>
						<div class="bbD">
							发布时间：<input  name="taskStartTime" value="<%=date %>" type="text" readonly style="width: 260px;height: 40px;border: 1px solid #ccc;text-indent: 15px;margin-left: 10px;"/>
						</div>
						</div>
						<div class="bbD">
							<p class="bbDP">
								<input class="btn_ok btn_yes" type="submit" value="提交">
								<a class="btn_ok btn_no" href="checkPoint/selectCheckPoint">取消</a>
							</p>
						</div>
					</div>
				</div>
			</form>
			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>