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
<link rel="stylesheet" type="text/css" href="css/rafaelcss.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;意见管理
			</div>
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					
				</div>
				<c:forEach items="${purchaseList}" var="p">
				<div class="baBody">
					<div class="bbD">
						<span class="nar">产品编号：</span><div class="input1">${p.productId }</div>
					</div>
					<div class="bbD">
						<span class="nar">产品名称：</span><div class="input1">${p.stockBean.commodityName }</div>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">数量：</span><div class="input1">${p.detailPurchaseBean.productNum }</div>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">单位：</span><div class="input1">${p.stockBean.unit }</div>
					</div>
					<div class="bbD">
						<span class="nar">交货时间：</span><div class="input1">${p.detailPurchaseBean.orderPurchaseBean.orderPurchaseBusinessTime }</div>
					</div>
					<div class="bbD">
						<span class="nar">采购人员：</span><div class="input1">${p.detailPurchaseBean.orderPurchaseBean.orderPurchasePerson }</div>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">状态：</span><div class="input1">${p.purchase_state }</div>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span>备注：</span>
						<div class="btextr">
							<div class="text2">${p.purchaseInfo }</div>
						</div>
					</div>
					<div class="bbD">
						<span class="nar">录入人员：</span><div class="input1">${p.purchasePerson }</div>
					</div>
					<div class="bbD">
						<span class="nar">添加时间：</span><div class="input1">${p.purchaseUpdateTime }</div>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<a class="btn_ok btn_no" href="jsp/banner.jsp">返回</a>
						</p>
					</div>
				</div>
				</c:forEach>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>