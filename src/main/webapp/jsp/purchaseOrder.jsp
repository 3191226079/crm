<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"> 
	<title>采购单</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/rafaelcss.css">

<script type="text/javascript" src="js/vue.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/rafael.js"></script>

<!-- <script type="text/javascript" src="js/page.js" ></script> -->
<style type="text/css">
.banDel .delete .delP2 .ok 
{
	width:100px;
	display: inline-block;
	height: 40px;
	line-height: 40px;
	background-color: #3695cc;
	color: #fff;
	margin-top: 65px;
	margin-left: 25px;
	margin-right: 25px;
	font-size: 16px;
	cursor: pointer;
	margin-bottom: 65px;
}

</style>
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
			<!-- topic页面样式 -->
			<div class="topic">
				<div class="conform">
						<div class="butrr">
							<div class="buttopr">
								<a href="purchaseOrder/getSuppliers" >添加</a>
							</div>	
						</div>
				</div>
				<!-- topic表格 显示 -->
				<div class="conShow">
					
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="100px" class="tdColor tdC">序号</td>
							<td width="366px" class="tdColor tdC">编号</td>
							<td width="300px" class="tdColor">采购内容</td>
							<td width="150px" class="tdColor">采购日期</td>
							<td width="150px" class="tdColor">供应商</td>
							<td width="155px" class="tdColor">交货方式</td>
							<td width="150px" class="tdColor">交货时间</td>
							<td width="100px" class="tdColor">付款状态</td>
							<td width="80px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${purchaseOrderList }" var="po" varStatus="c">
						
						<tr>
							<td>${c.count }</td>
							<td>${po.orderPurchaseId }
								<input type="hidden" id="opId" name="orderPurchaseId" value="${po.orderPurchaseId }">
							</td>
							<td>${po.orderPurchaseTitle }</td>
							<td>
								<fmt:formatDate value="${po.orderPurchaseTime }" pattern="yyyy-MM-dd  HH:MM:ss"/>
							</td>
							<td>${po.supplierBean.supplierName }</td>
							<td>${po.orderPurchaseBusinessType }</td>
							<td>
								<fmt:formatDate value="${po.orderPurchaseBusinessTime }" pattern="yyyy-MM-dd  HH:MM:ss"/>
							</td>
							<c:if test="${po.orderPurchaseState !=2 }">
								<td>未付款</td>
							</c:if>
							
							<td><a href="purchaseOrder/find?orderPurchaseId=${po.orderPurchaseId  }"><img class="operation"
									src="img/update.png"></a> <img class="operation delban"
								src="img/delete.png" onclick="delban('${po.orderPurchaseId  }')" ></td>
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
				<input type="hidden" id="id" value="">
				<button class="ok yes" id="yes_ra">确定</button><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
</body>

<script type="text/javascript">
// 广告弹出框
function delban(delid)
{
	
	$(".banDel").show();
	$("#id").val(delid);
}

$(".close").click(function(){
  $(".banDel").hide();
});
$(".no").click(function(){
  $(".banDel").hide();
});
// 广告弹出框 end
</script>
</html>