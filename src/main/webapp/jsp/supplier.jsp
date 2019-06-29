<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"> 
	<title>供应商信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/rafaelcss.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/rafael.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
			
			</div>
		</div>

		<div class="page">
			<!-- topic页面样式 -->
			<div class="topic">
				<div class="conform">
					<div class="buttopr">
							<a href="jsp/supplieradd.jsp" >添加</a>
						</div>	
				</div>
				<!-- topic表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="56px" class="tdColor tdC">编号</td>
							<td width="200px" class="tdColor">供应商名称</td>
							<td width="120px" class="tdColor">联系人</td>
							<td width="200px" class="tdColor">电话</td>
							<td width="255px" class="tdColor">传真</td>
							<td width="250px" class="tdColor">邮箱</td>
							<td width="220px" class="tdColor">备注</td>
							<td width="180px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${supplierList }" var="s" varStatus="c">
						<tr>
							
							<td>${c.count }<input type="hidden" name="supplierId" id="sid" value="${s.supplierId }"></td>
							<td>${s.supplierName }</td>
							<td>${s.supplierContact }</td>
							<td>${s.supplierPhone }</td>
							<td>${s.supplierFax }</td>
							<td>${s.supplierEmail }</td>
							<td>${s.supplierInfo }</td>
							<td><a href="supplier/find?supplierId=${s.supplierId }"><img class="operation"
									src="img/update.png"></a> <img class="operation delban"
								src="img/delete.png"></td>
						</tr>
						</c:forEach>
					</table>
					<div class="paging"><span class="pagerr">上一页</span><span class="pagerr">共1页</span><span class="pagerr">下一页</span></div>
				</div>
				<!-- topic 表格 显示 end-->
			</div>
			<!-- topic页面样式end -->
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
				<button class="ok yes" id="yesr">确定</button><a class="ok no">取消</a>
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