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
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;意见管理
			</div>
		</div>
		<div class="page">
			<!-- opinion 页面样式 -->
			<div class="opinion">
				
				<!-- opinion 表格 显示 -->
				
				<div class="opShow">
					<div class="butrr">
						<div class="buttopr">
							<a href="jsp/banneradd.jsp" >添加</a>
						</div>	
					</div>
					<table border="0" cellspacing="0" cellpadding="0">
						
						<tr>
							<td width="186px" class="tdColor tdC">补货编号</td>
							<td width="330px" class="tdColor">产品编号</td>
							<td width="330px" class="tdColor">产品类别</td>
							<td width="330px" class="tdColor">产品名称</td>
							<td width="230px" class="tdColor">规格</td>
							<td width="330px" class="tdColor">所属仓库</td>
							<td width="280px" class="tdColor">补货数量</td>
							<td width="160px" class="tdColor">补货状态</td>
							<td width="180px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${purchaseList }" var="p">
						<tr height="40px">
							<td>${p.purchaseId }</td>
							<td>${p.productId }</td>
							<td>${p.stockBean.commodityType }</td>
							<td>${p.stockBean.commodityName }</td>
							<td>${p.stockBean.description }</td>
							<td>${p.stockBean.warehouseBean.warehouseName }</td>
							<td>${p.detailPurchaseBean.productNum }</td>
							<td>${p.purchaseState }</td>
							<td><a href="purchase/find?purchaseId=${p.purchaseId }"><img class="operation"
									src="img/update.png"></a> <a href="purchase/del?purchaseId=${p.purchaseId }"><img class="operation delban"
								src="img/delete.png"></a></td>
						</tr>
						</c:forEach>
						
					</table>
					<div class="paging">第一页共1页</div>
				</div>
				<!-- opinion 表格 显示 end-->
			</div>
			<!-- 页面样式end -->
		</div>
	</div>
</body>
</html>