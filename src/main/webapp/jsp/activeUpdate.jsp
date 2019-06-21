<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="com.sc.crmsys.bean.ActiveBean"%>
<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="java.text.SimpleDateFormat"%>

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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href="<%=basePath%>">  
	<title>修改日程</title>
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
		    Top : -10,//弹出时间停靠的顶部边位置
		    fuhao : "-",//日期连接符默认为-
		    isTime : false,//是否开启时间值默认为false
		    beginY : 1949,//年份的开始默认为1949
		    endY :2100//年份的结束默认为2049
		  });
		});
		function myfunc()
		{
			 var child = document.getElementById("myselectll").childNodes;
			 for(var i = 0; i < child.length;i++)
			 {
			 	if(child[i].value == '${activeBean1.activeType }')
			 	{
			 		child[i].selected = true;
			 	}
			 }
		}
	</script>
</head>
<body onload="myfunc()">
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">日程管理</a>&nbsp;-</span>&nbsp;日程修改
			</div>
		</div> 
		 <div class="page">
		    <form action="active/update" method="post">
		    <input type="hidden" name="activeId" value="${activeBean1.activeId }">
			<!-- 上传广告页面样式 -->
			<div class="bor" style="margin-top:10px;">
				<div class="baTopNo">
					<span>日程修改</span>
				</div>
				<div class="baBody">
					<div class="bbD">
						日程主题：<input type="text" name="activeTitle" value="${activeBean1.activeTitle }" class="input3" />
					</div>
					<div class="bbD">
						日程类别：
							<select class="input3" name="activeType" id="myselectll">
								<option value="0" disabled selected hidden>请选择</option>
								<option value="1">会议</option>
								<option value="2">聚会</option>
								<option value="3">工作</option>
							</select>
					</div>
					<%
						ActiveBean activeBean = (ActiveBean)request.getAttribute("activeBean1");
						Date activeStartTime = activeBean.getActiveStartTime();
						SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
						String date = simpleDateFormat1.format(activeStartTime);
					%>
					<div class="bbD">
						修改时间：
							<input name="activeStartTime" autocomplete="off" value="<%=date %>" class="vinput mh_date" type="text" style="width: 260px;height: 40px;border: 1px solid #ccc;text-indent: 15px;margin-left: 10px;" />
					</div> 
					<div class="bbD">
						日程描述：
						<div class="btext">
							<textarea class="text2" name="acitveDescribe">${activeBean1.acitveDescribe }</textarea>
						</div>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<input class="btn_ok btn_yes" type="submit" value="提交">
							<a class="btn_ok btn_no" href="active/selectActive">取消</a>
						</p>
					</div>
				</div> 
				</form>
			</div>
			<!-- 上传广告页面样式end -->
		</div> 

	</div>
</body>
</html>