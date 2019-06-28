<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<link rel="stylesheet" type="text/css" href="css/rafaelcss.css">
<script type="text/javascript" src="js/jquery.min.js"></script>

</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;行家添加
			</div>
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					
				</div>
				<form action="supplier/add" method="post">
				<div class="baBody_r">
					<div class="bbD">
						<span class="blankr3"></span><span class="nar">供应商名称：</span><input type="text" class="input1" name="supplierName"/>
					</div>
					<div class="bbD">
						<span class="blankr2"></span><span class="nar">联系人：</span><input type="text" class="input1" name="supplierContact" />
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">电话：</span><input type="text" class="input1" name="supplierPhone"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">传真：</span><input type="text" class="input1" name="supplierFax"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">邮箱：</span><input type="text" class="input1" name="supplierEmail"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span>备注：</span>
						<div class="btextr">
							<textarea class="text2" name="supplierInfo"></textarea>
						</div>
					</div>
					<div class="bbD">
						<span class="nar">录入人员：</span><input type="text" class="input1" name="supplierPerson" readonly="readonly"/>
					</div>
					<div class="bbD">
						<span class="nar">添加时间：</span><input type="text" class="input1" name="supplierUpdateTime" readonly="readonly"/>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes">提交</button>
							<a class="btn_ok btn_no" href="supplieradd.jsp">取消</a>
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