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
	<title>添加采购单</title>
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
	.addr
	{
		width:90px;
		height: 20px;
		border: 1px solid #47a4e1;
		text-align: center;
		line-height: 20px;
		margin-top: 50px;
		margin-left:100px;
		font-size:15px;
		color:white;
		cursor:pointer;
		background-color: #47a4e1;
	
	}
	.box_r
	{
		
		width: 100%;
		height: 710px;
		background-color: rgba(0, 0, 0, 0.29);
		padding-top: 50px;
		display: none;
		position: relative;
		bottom: 0px;
	}
	.barBody
	{
		
		width:800px;
		height:650px;
		border:1px solid rgba(0, 0, 0, 0.29);
		margin: 0 auto;
		padding-left: 200px;
		background-color: white;
	}
	
	</style>
</head>
<body>
	<div id="pageAll">
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
								<span class="bls">采购主题：</span><input type="text" class="input1" id="orderPurchaseTitle" name="orderPurchaseTitle">
							</td>
							<td>
								<span class="bls">采购日期：</span><input type="text" class="input1" id="orderPurchaseTime" name="orderPurchaseTime">
							</td>
						</tr>
						<tr>
							<td>
								<span class="blankr4"></span><span class="bls_g">供应商：</span>
								<select class="input1" id="sel" name="supplierId">
								<option>请选择</option>
								<c:forEach items="${supplierList }" var="s">
										
										<option value="${s.supplierId }">${s.supplierName }</option>
								</c:forEach>
								</select>
							</td>
							<td>
								<span class="blankr"></span><span class="bls">电话：</span><input type="text" class="input1" id="supplierPhone"  name="supplierPhone">
							</td>
						</tr>
						<tr>
							<td>
								<span class="blankr2"></span><span class="bls">联系人：</span><input type="text" class="input1" id="supplierContact"  name="supplierContact">
							</td>
							<td>
									<span class="blankr"></span><span class="bls">传真：</span><input type="text" class="input1" id="supplierFax" name="supplierFax">
								</td>
							</tr>
						<tr>
							<td>
								<span class="blankr"></span><span class="bls">邮箱：</span><input type="text" class="input1" id="supplierEmail"  name="supplierEmail">
							</td>
							<td>
								<span class="blankr"></span><span class="bls">金额：</span><input type="text" class="input1" id="orderPurchaseMoney" name="orderPurchaseMoney" readonly="readonly">
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">付款状况：</span><input type="text" class="input1" id="orderPurchaseState" name="orderPurchaseState" readonly="readonly" >
							</td>
							<td>
								<span class="bls">采购进展：</span><input type="text" class="input1" id="orderPurchaseInfo" name="orderPurchaseInfo">
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">采购状态：</span><input type="text" class="input1" name="orderPurchaseState" readonly="readonly" value="待采购">
							</td>
							<td>
								<span class="bls">交货时间：</span><input type="text" class="input1" id="orderPurchaseBusinessTime" name="orderPurchaseBusinessTime" >
							</td>
						</tr>
						<tr>
							<td>
								<span class="bls">交货方式：</span><input type="text" class="input1" id="orderPurchaseBusinessType" name="orderPurchaseBusinessType">
							</td>
							<td>
								<span class="bls">交货地点：</span><input type="text" class="input1" id="rderPurchaseBusinessAddress" name="rderPurchaseBusinessAddress">
							</td>
						</tr>
						<tr>
							<td>
								<span class="blankr2"></span><span class="bls">操作员：</span><input type="text" class="input1" id="orderPurchasePerson"  name="orderPurchasePerson">
							</td>
							<td>
							</td>
						</tr>
					</table>				
					
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" id="opb">保存</button>
							<a class="btn_ok btn_no" href="purchaseOrder/select">取消</a>
						</p>
					</div>
				</div>
				<div class="conShowr">
					<input type="hidden" id="opid" value="">
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
							<td>
							</td>
							<td>
							</td>
							<td>
							</td>
							<td>
							</td>
							<td>
							</td>
							<td>	
							</td>
							<td></td>
							
							
							<td><a href="#"><img class="operation"
									src="img/update.png"></a> <img class="operation delban"
								src="img/delete.png"></td>
						</tr>
						
					</table>
					<div class="addr" id="addr">添加</div>
					<div class="paging"><span class="pagerr">上一页</span><span class="pagerr">共1页</span><span class="pagerr">下一页</span></div>
				</div>
			</div>
			
		</div>
		<div class="box_r"  id="box_r">
					<div class="barBody">
						<div class="bbD">
							<span class="nar">产品名称：</span>
							<select class="input1" id="sed" name="commodityNumber">
									<option>请选择</option>
									<c:forEach items="${stockList }" var="s">
											<option value="${s.commodityNumber }">${s.commodityName }</option>
									</c:forEach>
							</select>
						</div>
						<div class="bbD">
							<span class="blankr"></span><span class="nar">数量：</span><input type="text" class="input1" id="productNum" name="productNum" />
						</div>
						<div class="bbD">
							<span class="blankr"></span><span class="nar">单价：</span><input type="text" class="input1" id="productPrice" readonly="readonly" name="productPrice" />
						</div>
						<div class="bbD">
							<span class="blankr"></span><span class="nar">单位：</span><input type="text" class="input1" id="unit" readonly="readonly" name="unit" />
						</div>
						<div class="bbD">
							<span class="blankr"></span><span>备注：</span>
							<div class="btextr">
								<textarea class="text2" id="detailPurchaseInfo" name="detailPurchaseInfo"></textarea>
							</div>
						</div>
						<div class="bbD">
							<span class="nar">录入人员：</span><input type="text" class="input1" id="detailPurchasePerson" name="detailPurchasePerson"/>
						</div>
						<div class="bbD">
							<span class="nar">添加时间：</span><input type="text" class="input1" id="detailPurchaseUpdateTime" name="detailPurchaseUpdateTime" readonly="readonly"/>
						</div>
						<div class="bbD">
							<p class="bbDP">
								<input type="button" class="btn_ok btn_yes" id="detailb" value="保存">
								<input type="button" class="btn_ok btn_yes" id="undetailb" value="取消">
							</p>
						</div>
				   </div>
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
	
	$("#addr").click(function(){
		$("#box_r").css("display","block");
		$("#box_r").css("position","fixed"); 
	});
	
	$("#undetailb").click(function(){
		$("#box_r").css("display","none");
		$("#box_r").css("position","relative");
		
	});
	
	$("#detailb").click(function(){
		$("sed").val();
	});

	sed
	productNum
	productPrice
	unit
	detailPurchaseInfo
	detailPurchasePerson
	detailPurchaseUpdateTime

</script>
</html>