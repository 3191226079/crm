<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<script type="text/javascript" src="js/rafael.js"></script>
	<style type="text/css">
	.baTopNor .button_r1 
	{
		height:30px;
		width:200px;
		border-right:3px solid #438eb9;
		border-bottom:3px solid #438eb9;
		border-top:3px solid #438eb9;
		padding-left:50px;
		padding-right:50px;
		background-color:#438eb9;
		line-height: 30px;
		font-size: 18px;
		color: white;
		cursor: pointer;
		
	}
	.baTopNor .button_r2
	{
		height: 30px;
		width:200px;
		padding-left:50px;
		padding-right:50px;
		line-height: 30px;
		font-size: 18px;
		color: #438eb9;
		cursor: pointer;
	
	}
	.baTopNor
	{
		width:100%;
		border-bottom:1px solid #438eb9;
	}

	.banneradd_bor {
		border: 1px solid #ccc;
		margin-bottom: 160px;
		margin-top: 10px;
		
	}
	
	</style>
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
			<div class="banneradd_bor">
					<div class="baTopNor">
						<span class="button_r1" id="butG">基本信息</span>
						<span class="button_r2" id="butM">采购明细</span>
					</div>
				<div class="baBody_r">
					<table class="table_r">
						<tr>
							<td>
								<span class="bls">采购主题：</span><input type="text" class="input1" id="OPT" name="orderPurchaseTitle" readonly="readonly" value="${orderPurchaseBean.orderPurchaseTitle }">
							</td>
							<td>
								<span class="bls">采购日期：</span><input type="text" class="input1" id="OPTime" name="orderPurchaseTime" readonly="readonly"  value="<fmt:formatDate value="${orderPurchaseBean.orderPurchaseTime }" pattern="yyyy-MM-dd  HH:MM:ss"/>">
							</td>
						</tr>
						<tr>
							<td>
								<span class="blankr4"></span><span class="bls_g">供应商：</span>
								<input  class="input1" id="OPS" name="supplierName" value="${orderPurchaseBean.supplierBean.supplierName }" readonly="readonly" >
							</td>
							<td>
								<span class="blankr"></span><span class="bls">电话：</span><input type="text" class="input1" id="SP"  name="supplierPhone" value="${orderPurchaseBean.supplierBean.supplierPhone }" readonly="readonly" >
							</td>
						</tr>
						<tr>
							<td>
								<span class="blankr2"></span><span class="bls">联系人：</span><input type="text" class="input1" id="SC"  name="supplierContact" readonly="readonly"  value="${orderPurchaseBean.supplierBean.supplierContact }">
							</td>
							<td>
									<span class="blankr"></span><span class="bls">传真：</span><input type="text" class="input1" id="SF" name="supplierFax" readonly="readonly"  value="${orderPurchaseBean.supplierBean.supplierFax }">
								</td>
							</tr>
						<tr>
							<td>
								<span class="blankr"></span><span class="bls">邮箱：</span><input type="text" class="input1" id="SE"  name="supplierEmail" readonly="readonly"  value="${orderPurchaseBean.supplierBean.supplierEmail }">
							</td>
							<td>
								<span class="blankr"></span><span class="bls">金额：</span><input type="text" class="input1" id="OPM" name="orderPurchaseMoney" readonly="readonly" value="${orderPurchaseBean.orderPurchaseMoney }">
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">付款状况：</span><input type="text" class="input1" id="OPS" name="orderPurchaseState" readonly="readonly" >
							</td>
							<td>
								<span class="bls">采购进展：</span><input type="text" class="input1" id="OPI" readonly="readonly"  name="orderPurchaseInfo" value="${orderPurchaseBean.orderPurchaseInfo }">
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">采购状态：</span><input type="text" class="input1" name="OPS" readonly="readonly" value="待采购">
							</td>
							<td>
								<span class="bls">交货时间：</span><input type="text" class="input1" id="OPBT" name="orderPurchaseBusinessTime" readonly="readonly"  value="<fmt:formatDate value="${orderPurchaseBean.orderPurchaseBusinessTime }" pattern="yyyy-MM-dd  HH:MM:ss"/>">
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">交货方式：</span><input type="text" class="input1" id="OPBType" name="orderPurchaseBusinessType" readonly="readonly"  value="${orderPurchaseBean.orderPurchaseBusinessType }">
							</td>
							<td>
								<span class="bls">交货地点：</span><input type="text" class="input1" id="OPBA" name="orderPurchaseBusinessAddress" readonly="readonly"  value="${orderPurchaseBean.orderPurchaseBusinessAddress }">
							</td>
						</tr>
						<tr>
							<td>
								<span class="blankr2"></span><span class="bls">操作员：</span><input type="text" class="input1" id="orderPurchasePerson"  name="orderPurchasePerson" readonly="readonly"  value="${orderPurchaseBean.orderPurchasePerson }">
							</td>
							<td>
								
							</td>
						</tr>
					</table>	
					<div class="bbD">
						<p class="bbDP">
							<input type="button" class="btn_ok btn_yes" id="buttono"  value="修改">
							<input type="button" class="btn_ok btn_yes" id="ubuttono" style="display:none" value="保存">
							<input type="submit" class="btn_ok btn_no"  value="返回">
						</p>
					</div>
				</div>
				<div class="conShowr">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="100px" class="tdColor tdC">序号</td>
							<td width="200px" class="tdColor">产品名称</td>
							<td width="400px" class="tdColor">产品编号</td>
							<td width="150px" class="tdColor">数量</td>
							<td width="150px" class="tdColor">单价</td>
							<td width="155px" class="tdColor">单位</td>
							<td width="150px" class="tdColor">金额</td>
							<td width="100px" class="tdColor">是否入库</td>
							<td width="150px" class="tdColor">操作</td>
						</tr>
						
						
						<tr>
							<td>${po.orderPurchaseId }</td>
							<td>${po.orderPurchaseTitle }</td>
							<td>
								
							</td>
							<td>${po.supplierBean.supplierName }</td>
							<td>${po.orderPurchaseBusinessType }</td>
							<td>
							</td>

							<td><a href="#"><img class="operation"
									src="img/update.png"></a> <img class="operation delban"
								src="img/delete.png"></td>
						</tr>
						
					</table>
					<div class="paging"><span class="pagerr">上一页</span><span class="pagerr">共1页</span><span class="pagerr">下一页</span></div>
				</div>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#butM").click(function(){
		$("#butG").css("background-color","white");
		$("#butG").css("border-right","3px solid white");
		$("#butG").css("border-bottom","3px solid white");
		$("#butG").css("border-top","1px solid white");
		$("#butG").css("color","#438eb9");
		$(".conShowr").css("display","block");
		$(".baBody_r").css("display","none");
		
		$(this).css("background-color","#438eb9");
		$(this).css("border-right","3px solid #438eb9");
		$(this).css("border-bottom","3px solid #438eb9");
		$(this).css("border-top","3px solid #438eb9");
		$(this).css("color","white");
		
	});
	
	$("#butG").click(function(){
		$("#butM").css("background-color","white");
		$("#butM").css("border-right","3px solid white");
		$("#butM").css("border-bottom","3px solid white");
		$("#butM").css("border-top","1px solid white");
		$("#butM").css("color","#438eb9");
		$(".conShowr").css("display","none");
		$(".baBody_r").css("display","block");
		
		$(this).css("background-color","#438eb9");
		$(this).css("border-right","3px solid #438eb9");
		$(this).css("border-bottom","3px solid #438eb9");
		$(this).css("border-top","3px solid #438eb9");
		$(this).css("color","white");
		
	});
	
	
	


</script>
</html>