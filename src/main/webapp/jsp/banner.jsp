<%@page import="com.sc.crmsys.utils.DateFormatUtils"%>
<%@page import="java.util.Date"%>
<%@page import="com.sc.crmsys.bean.PurchaseBean"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript"  src="js/rafael.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					
				</div>
				<form action="purchase/select" method="post">
				<c:forEach items="${purchaseList}" var="p">
				<%
						List<PurchaseBean> purchaseList = (List<PurchaseBean>)request.getAttribute("purchaseList");
						String uTime = "";
						String bTime = "";
						for (int i = 0; i < purchaseList.size(); i++) {
							PurchaseBean purchaseBean = purchaseList.get(i);
							Date purchaseUpdateTime = purchaseBean.getPurchaseUpdateTime();
							Date orderPurchaseBusinessTime = purchaseBean.getDetailPurchaseBean().getOrderPurchaseBean().getOrderPurchaseBusinessTime();
							uTime = DateFormatUtils.getDate(purchaseUpdateTime);
							bTime = DateFormatUtils.getDate(orderPurchaseBusinessTime);
						}
				%>
				
				<div class="baBody">
					<div class="bbD">
						<input type="hidden" class="input1" id="pid" name="purchaseId" value="${p.purchaseId }"/>
					</div>
					<div class="bbD">
						<span class="nar">产品编号：</span><input type="text" class="input1" id="CN" name="commodityNumber" readonly="readonly" value="${p.stockBean.commodityNumber }"/>
					</div>
					<div class="bbD">
						<span class="nar">产品名称：</span><input type="text" class="input1" id="PN" readonly="readonly" value="${p.stockBean.commodityName }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">数量：</span><input type="text" class="input1" id="PC" name="productNum" readonly="readonly" value="${p.detailPurchaseBean.productNum }"/>
					</div>
					<div class="bbD">
						<span class="nar">交货时间：</span><input type="text" class="input1" id="BT" name="orderPurchaseBusinessTime" readonly="readonly" value="<%=bTime %>"/>
					</div>
					<div class="bbD">
						<span class="nar">采购人员：</span><input type="text" class="input1" id="OPP" name="orderPurchasePerson" readonly="readonly" value="${p.detailPurchaseBean.orderPurchaseBean.orderPurchasePerson }"/>
					</div>
					<div class="bbD">
								<span class="blankr"></span><span class="nar">状态：</span>
								<c:choose>
									<c:when test="${p.purchaseState==1 }">
										<span class="blankr"></span><span>采购中</span>
									</c:when>
									<c:when test="${p.purchaseState==0 }">
										<span class="blankr"></span><span>代采购</span>
									</c:when>
								</c:choose>
								<input type="hidden" class="input1" name="purchaseState" value="${p.purchaseState }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span>备注：</span>
						<div class="btextr">
							<textarea class="text2" id="PI" readonly="readonly" name="purchaseInfo">${p.purchaseInfo }</textarea>
						</div>
					</div>
					<div class="bbD">
						<span class="nar">录入人员：</span><input type="text" class="input1" id="PP" readonly="readonly" name="purchasePerson" value="${p.purchasePerson }"/>
					</div>
					<div class="bbD">
						<span class="nar">添加时间：</span><input type="text" class="input1" id="UT"  name="purchaseUpdateTime" value="<%=uTime %>" readonly="readonly"/>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<input type="button" class="btn_ok btn_yes" id="button"  value="修改">
							<input type="button" class="btn_ok btn_yes" id="ubutton" style="display:none" value="保存">
							<input type="submit" class="btn_ok btn_no"  value="返回">
					
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