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
	<title>指标添加</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;添加指标
			</div>
		</div>
		<form action="checkPoint/insertTask" method="post">
			<div class="page">
				<!-- 上传广告页面样式 -->
				<div class="bor" style="margin-top:10px;">
					<div class="baTopNo">
						<span>添加指标</span>
					</div>
					<div class="baBody">
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考核指标名称：
							 <input type="text" name="checkPointTarget" autocomplete="off" class="input3" autocomplete="off"/>
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考核指标描述：
							<div class="btext2">
								<textarea class="text2" name="checkPointInfo" style="margin-left: 25px"></textarea>
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