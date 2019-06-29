<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <link rel="stylesheet" type="text/css" href="css/css.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <title>销售详情表</title>        
 </head>
 <body>
 	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;销售详情表
			</div>
		</div>

		<div class="page">
			<!-- wish页面样式 -->
			<div class="wish">
				<!-- wish 表格 显示 -->
			<form action="stock/outStock" method="post">
				<div class="wishShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<%-- <tr>
							<td width="150px" class="tdColor tdC" name="saleinfoId">销售单详情编号</td>
							<td>
								<input style="height:40px;width:160px;" type="text" name="goodsId">
								<select style="width:150px; height:40px;" class="textBox" name="warehouseNumber">
									<c:forEach items="${sss }" var="ff">
									 	<option value="${ff.stockBeanss.warehouseNumber}">${ff.stockBeanss.warehouseName}</option>
									</c:forEach> 
							    </select> 
							</td>
						</tr> --%>
						 <tr>
							<td width="175px" class="tdColor" name="companyId">公司编号</td>
							<td>
								<select name="companyId" style="width:160px; height:40px;">
									<c:forEach items="${getsaleout}" var="getstock">
										<option  value="${getstock.companyId}">${getstock.companyId}</option>
									</c:forEach>
								</select>
							</td>
						</tr> 
						<tr>
							<td width="200px" class="tdColor" name="saleoutId">销售单编号</td>
							<td>
								
							    <select name="saleoutId" style="width:160px; height:40px;">
									<c:forEach items="${getsaleout}" var="getstock">
										<option  value="${getstock.saleoutInvoce}">${getstock.saleoutInvoce}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td width="175px" class="tdColor" name="goodsId">商品编号***</td>
							<td>
								<select name="goodsId"  style="width:160px; height:40px;" onchange="aa()" id="mytt">
									<c:forEach items="${getStock}" var="getstock">
										<option  value="${getstock.commodityNumber}">${getstock.commodityName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<td width="185px" class="tdColor" name="goodsPrice">商品价格***</td>
							<td>
								<input id="myprice" type="text" name="cc" readonly style="height:40px;width:160px;">
							</td>
						</tr>
						<tr>
							<td width="185px" class="tdColor" >库存数量</td>
							<td>
								<input id="mynum" type="text" name="cc" readonly style="height:40px;width:160px;">
							</td>
						</tr>
						<tr>
							<td width="185px" class="tdColor" name="goodsNum">出库数量</td>
							<td>
								<input style="height:40px;width:160px;" type="text" name="goodsNum">
							</td>
						</tr>
						<tr>
							<td width="180px" class="tdColor" name="saleinfoRemarks">备注信息</td>
							<td>
								<input style="height:40px;width:160px;" type="text" name="saleinfoRemarks">
							</td>
						</tr>
				
					 	<!-- <tr>
							<td width="155px" class="tdColor" name="saleinfoLastTime">最后修改时间</td>
							<td>
								
							</td>
						</tr> -->
				
					</table>
					<div class="bbD">
						<p class="bbDP">
							
							<input type="submit" value="出库" class="btn_ok btn_yes">
							<a class="btn_ok btn_no" href="#">取消</a>
						</p>
					</div>
					<div class="paging">此处是分页</div>
				</div>
			</form>	
				<!-- wish 表格 显示 end-->
			</div>
			<!-- wish页面样式end -->
			${fail }
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
				<a href="javascipt:;" id="del" class="ok yes">确定</a><a class="ok no">取消</a>
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
		
		function setPath(id)
		{
			console.log(id);
			var path = 'stock/deleteId?commodityNumber='+id;
			document.getElementById('del').href = path;
		}
		/* 
		function aa()
		{
			
		} */
		var num1 = $('#mytt').val();
		$.ajax({
			type:'POST',//请求方式为post
			url:'stock/selectPrice',//请求地址
			data:{'num':num1},//参数
			success:function (result)
			//success指的是请求成功并返回信息
			//result是返回的内容
			{
				//从后台获取价格
				var price = result.se.retailPrice;
				$('#myprice').val(price);//将值放到页面
				$('#mynum').val(result.se.stockNumber);//将值放到页面
				
			},
			error:function()
			{
				alert('系统繁忙');
			}
		});
		
		$(document).ready(function (){
			$('#mytt').change(function(){
				var num = $('#mytt').val();
				$.ajax({
					type:'POST',//请求方式为post
					url:'stock/selectPrice',//请求地址
					data:{'num':num},//参数
					success:function (result)
					//success指的是请求成功并返回信息
					//result是返回的内容
					{
						var price = result.se.retailPrice;
						$('#myprice').val(price);
						$('#mynum').val(result.se.stockNumber);//将值放到页面
					},
					error:function()
					{
						alert('系统繁忙');
					}
				});
			});
			
			 $('.btn').click(function (){
				var saleinfoId=$('#saleinfoId').val();
				var companyId=$('#companyId').val();
				var saleoutId=$('#saleoutId').val();
				var goodsId=$('#goodsId').val();
				var goodsNum=$('#goodsNum').val();
				var goodsPrice=$('#goodsPrice').val();
				var saleinfoRemarks=$('#saleinfoRemarks').val();
				var saleinfoLastTime=$('#saleinfoLastTime').val();
				/*$.data() 函数用于在指定的元素上存取数据，返回设置值。*/
				/*data是json对象*/
				var data={
					name:name,
					startStation:startStation,
					endStation:endStation,
					startTime:startTime,
					endTime:endTime,
					ticketNum:ticketNum,
					ticketPrice:ticketPrice
				};/*传入之后就是Java类*/

				$.ajax({
					type:'POST',//请求方式为post
					url:'///',//请求地址
					data:data,//参数
					success:function (result)
					//success指的是请求成功并返回信息
					//result是返回的内容
					{
						if (result.state==200) 
						{
							$('#dialog').css('display','block');
							$('#dialog').html(result.msg);
							/*定时器，时间为3秒*/
							setTimeout(hide,3000);

						}
					},
					error:function()
					{
						alert('系统繁忙');
					}
				});
			}); 

		}); 
// 广告弹出框 end
</script>
</html>