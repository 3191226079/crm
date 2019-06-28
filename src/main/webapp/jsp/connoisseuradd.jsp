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
	<title>行家添加-有点</title>
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
					<span>基本信息</span>
					<span>采购明细</span>
				</div>
				<div class="baBody_r">
					<table class="table_r">
						<tr>
							<td>
								<span class="blankr"></span><span class="bls">编号：</span><input type="text" class="input1" name="">
							</td>
							<td>
								<span class="bls">采购主题：</span><input type="text" class="input1" name="">
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">采购日期：</span><input type="text" class="input1" name="">
							</td>
							<td>
								<span class="blankr2"></span><span class="bls">供应商：</span><input type="text" class="input1" name="">
							</td>
						</tr>
						<tr>
							<td>
								<span class="blankr"></span><span class="bls">电话：</span><input type="text" class="input1" name="">
							</td>
							<td>
								<span class="blankr2"></span><span class="bls">联系人：</span><input type="text" class="input1" name="">
							</td>
						</tr>
						<tr>
							<td>
								<span class="blankr"></span><span class="bls">传真：</span><input type="text" class="input1" name="">
							</td>
							<td>
								<span class="blankr"></span><span class="bls">邮箱：</span><input type="text" class="input1" name="">
							</td>
						</tr>
						<tr>
							<td>
								<span class="blankr"></span><span class="bls">金额：</span><input type="text" class="input1" name="">
							</td>
							<td>
								<span class="bls">付款状况：</span><input type="text" class="input1" name="">
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">采购进展：</span><input type="text" class="input1" name="">
							</td>
							<td>
								<span class="bls">采购状态：</span><input type="text" class="input1" name="">
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">交货时间：</span><input type="text" class="input1" name="">
							</td>
							<td>
								<span class="bls">交货方式：</span><input type="text" class="input1" name="">
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">交货地点：</span><input type="text" class="input1" name="">
							</td>
							<td>
								
							</td>
						</tr>
					</table>				
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核状态：<label><input
							type="radio" checked="checked" name="styleshoice1" />&nbsp;未审核</label> <label><input
							type="radio" name="styleshoice1" />&nbsp;已通过</label> <label class="lar"><input
							type="radio" name="styleshoice1" />&nbsp;不通过</label>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" href="#">提交</button>
							<a class="btn_ok btn_no" href="#">取消</a>
						</p>
					</div>
				</div>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>