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
<script type="text/javascript"  src=""></script>
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
				<form action="purchase/update" method="post">
				<c:forEach items="${purchaseList}" var="p">
				<div class="baBody">
					<div class="bbD">
						<span class="nar">产品编号：</span><input type="text" class="input1" name="commodityNumber" value="${p.stockBean.commodityNumber }"/>
					</div>
					<div class="bbD">
						<span class="nar">产品名称：</span><input type="text" class="input1" value="${p.stockBean.commodityName }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">数量：</span><input type="text" class="input1" name="productNum" value="${p.detailPurchaseBean.productNum }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">单位：</span><input type="text" class="input1" value="${p.stockBean.unit }"/>
					</div>
					<div class="bbD">
						<span class="nar">交货时间：</span><input type="text" class="input1" name="orderPurchaseBusinessTime" value="${p.detailPurchaseBean.orderPurchaseBean.orderPurchaseBusinessTime }"/>
					</div>
					<div class="bbD">
						<span class="nar">采购人员：</span><input type="text" class="input1" name="orderPurchasePerson" value="${p.detailPurchaseBean.orderPurchaseBean.orderPurchasePerson }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">状态：</span><input type="text" class="input1" name="purchaseState" value="${p.purchaseState }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span>备注：</span>
						<div class="btextr">
							<textarea class="text2" name="purchaseInfo">${p.purchaseInfo }</textarea>
						</div>
					</div>
					<div class="bbD">
						<span class="nar">录入人员：</span><input type="text" class="input1" name="purchasePerson" value="${p.purchasePerson }"/>
					</div>
					<div class="bbD">
						<span class="nar">添加时间：</span><input type="text" class="input1" name="purchaseUpdateTime" value="${p.purchaseUpdateTime }"/>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<input type="submit" class="btn_ok btn_yes" value="保存">
							<a class="btn_ok btn_no" href="purchase/select?companyId=${p.companyId }">返回</a>
						</p>
					</div>
				</div>
				</c:forEach>
				</form>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>