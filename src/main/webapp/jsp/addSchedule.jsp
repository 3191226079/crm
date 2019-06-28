<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>   
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href="<%=basePath%>">  
	<title>日程管理</title>
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
	</script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">日程管理</a>&nbsp;-</span>&nbsp;日程添加
			</div>
		</div> 
		 <div class="page">
		    <form action="active/insertActive" method="post">
			<!-- 上传广告页面样式 -->
			<div class="bor" style="margin-top:10px;">
				<div class="baTopNo">
					<span>日程添加</span>
				</div>
				<div class="baBody">
					<div class="bbD">
						日程主题：<input type="text" autocomplete="off"
						 name="activeTitle" class="input3" />
					</div>
					<div class="bbD">
						日程类别：
							<select class="input3" name="activeType">
								<option value="1" disabled selected hidden="true">请选择</option>
								<option value="1">开会</option>
								<option value="2">聚会</option>
								<option value="3">工作</option>
								<option value="4">商务</option>
								<option value="5">投简</option>
								<option value="6">公关</option>
								<option value="7">销售</option>
							</select>
					</div>
					<div class="bbD">
						开始时间：<input name="activeStartTime" class="vinput mh_date" type="text" autocomplete="off"
						 style="width: 260px;height: 40px;border: 1px solid #ccc;text-indent: 15px;margin-left: 10px;" />
					</div>
					<div class="bbD">
						日程描述：
						<div class="btext">
							<textarea class="text2" name="acitveDescribe"></textarea>
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

</body>
</html>