<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>今天需要联系</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;-</span>&nbsp;管理员管理
			</div>
		</div>

		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					
				</div>
				<!-- user 表格 显示 -->
				<div class="conShow">
			
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor">客户编号</td>
					
							<td width="200px" class="tdColor">客户姓名</td>
							<td width="200px" class="tdColor">上级单位</td>
							<td width="200px" class="tdColor">负责人</td>
							<td width="200px" class="tdColor">客户状态</td>
							<td width="200px" class="tdColor">客户地址</td>
							<td width="200px" class="tdColor">客户电话</td>
							<td width="300px" class="tdColor">客户传真</td>
							<td width="300px" class="tdColor">客户邮箱</td>
							<td width="300px" class="tdColor">联系时间</td>
							<td width="300px" class="tdColor">备注信息</td>
							<td width="300px" class="tdColor">公司编号</td>
							<td width="300px" class="tdColor">修改时间</td>
							
						</tr>
				 		<c:forEach items="${selectToday}" var="today">		
				 		<tr>
				 		<td>${today.customerId}</td>
				 		<td>${today.customerName}</td>
				 		<td>${today.customerUpDepartment}</td>
				 		<td>${today.customerContactPerson}</td>
				 		<td>${today.customerState}</td>
				 		<td>${today.customerAddress}</td>
				 		<td>${today.customerPhone}</td>
				 		<td>${today.customerFax}</td>
				 		<td>${today.customerEmail}</td>
				 		<td>
				 			<fmt:formatDate value="${today.customerContactTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				 		</td>
				 		<td>${today.customerInfo}</td>
				 		<td>${today.companyId}</td>
				 		<td>
				 			<fmt:formatDate value="${today.customerUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				 		</td>
				 		
				 		</tr>
				 		</c:forEach>
				 		
				 		
				 		
				 		
				 		
						<!-- <tr height="40px">
							<td>1</td>
							
							<td>2015-25-36 12:12</td>
							<td><a href="connoisseuradd.html"><img class="operation"
									src="img/update.png"></a> <img class="operation delban"
								src="img/delete.png"></td>
						</tr> -->
					</table>
					<div class="paging">此处是分页</div>
				
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