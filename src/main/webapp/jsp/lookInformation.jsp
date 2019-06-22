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
	<title>查看短信</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;消息管理
			</div>
		</div>
		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<form action="info/selectInfo" id="forms" method="post">
						<div class="cfD">
							<input class="addUser" type="text" placeholder="输入用户名/主题/联系电话" />
							<button class="button" onclick="javascript:function(){document.getElementById(forms).submit()};">搜索</button>
							<a class="addA addA1" href="info/jumptosend">发送短信</a>
						</div>
					</form>
				</div>
				<!-- banner 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="100px" class="tdColor tdC">序号</td>
							<td width="170px" class="tdColor">主题</td>
							<td width="170px" class="tdColor">发送者</td>
							<td width="200px" class="tdColor">联系电话</td>
							<td width="250px" class="tdColor">发送时间</td>
							<td width="170px" class="tdColor">信息状态</td>
							<td width="170px" class="tdColor">用户操作</td>
						</tr>
						<c:forEach items="${InfoDetail}" var="InfoDetailBean" varStatus="s">
							<tr>
								<td>${s.index+1}</td>
								<td>${InfoDetailBean.infoBean.infoTitle}</td>
								<td>${InfoDetailBean.employBean.employName}</td>
								<td>${InfoDetailBean.employBean.employPhone}</td>
								<td>${InfoDetailBean.infoDetailUpdateTime}</td>
								<td>
									<c:if test="${InfoDetailBean.infoDetailState eq 1}">未读</c:if>
									<c:if test="${InfoDetailBean.infoDetailState eq 0}">已读</c:if>
								</td>
								<td><a href="jsp/sendInformation.jsp">
										<img class="operation" src="img/update.png">
									</a> 
										<img class="operation delban" src="img/delete.png"></td>
							</tr>
						</c:forEach>
					</table>
					<div class="paging">此处是分页</div>
				</div>
				<!-- banner 表格 显示 end-->
			</div>
			<!-- banner页面样式end -->
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
				<a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
</body>

	<script type="text/javascript">
	// 广告弹出框
	$(".delban").click(function(){
	  $(".banDel").show();
	});
	$(".close").click(function(){
	  $(".banDel").hide();
	});
	$(".no").click(function(){
	  $(".banDel").hide();
	});
	// 广告弹出框 end
</script>
</html>