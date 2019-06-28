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
	<title>查看信息</title>
	<base href="<%=basePath%>">  
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;-</span>&nbsp;查看信息
			</div>
		</div>
		
		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				<!-- user 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">序号</td>
							<td width="435px" class="tdColor">发送人</td>
							<td width="400px" class="tdColor">发送主题</td>
							<td width="630px" class="tdColor">发送内容</td>
							<td width="630px" class="tdColor">发送时间</td>
							<td width="130px" class="tdColor">信息状态</td>
							<td width="130px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${selectInfo.infoDetailBeanList }" var="infoDetailBean" varStatus="s">
							<tr height="40px">
								<td>${s.index+1 }</td>
								<td>${infoDetailBean.infoBean.infoPerson }</td>
								<td>${infoDetailBean.infoBean.infoTitle }</td>
								<td>${infoDetailBean.infoBean.infoContent }</td>
								<td>
									<fmt:formatDate value="${infoDetailBean.infoBean.infoUpdateTime }" pattern="yyyy-MM-dd  HH:mm:ss"/>
								</td>
								<td>
									已读
								</td>
								<td>
									<img class="operation delban" src="img/delete.png" onclick="deleteEmploy('${infoDetailBean.employId}')">
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="paging"></div>
				</div>
				<!-- user 表格 显示 end-->
			</div>
			<!-- user页面样式end -->
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
	
	function deleteEmploy(employId)
	{
		document.getElementById('read').href = "employ/delete?employId=" + employId;
	}
	</script>
</html>