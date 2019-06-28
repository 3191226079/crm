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
			
				<div class="wishShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="150px" class="tdColor tdC" name="saleinfoId">销售单详情编号</td>
							<td>
								<select class="textBox" name="warehouseNumber">
									<c:forEach items="${selectWarehouse }" var="classbean">
									 	<option value="${classbean.warehouseNumber}">${classbean.warehouseName}</option>
									</c:forEach> 
							    </select>
							</td>
						</tr>
						<tr>
							<td width="200px" class="tdColor" name="companyId">销售单编号</td>
							<td>
								<select class="textBox" name="warehouseNumber" width="200px" class="tdColor">
									
							    </select>
							</td>
						</tr>
						<tr>
							<td width="175px" class="tdColor" name="saleoutId">商品编号</td>
							<td>
								<select>
									<c:forEach items="${getStock}" var="getstock">
										<option  value="${getstock.commodityNumber}">${getstock.commodityName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td width="185px" class="tdColor" name="goodsId">商品数量</td>
							<td>
								
							</td>
						</tr>
						<tr>
							<td width="185px" class="tdColor" name="goodsNum">商品价格</td>
							<td>
								<select>
									<c:forEach items="${getStock}" var="getstock">
										<option  value="${getstock.retailPrice}">${getstock.retailPrice}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td width="180px" class="tdColor" name="goodsPrice">备注信息</td>
							<td></td>
						</tr>
						<tr>
							<td width="175px" class="tdColor" name="saleinfoRemarks">公司编号</td>
							<td></td>
						</tr>
						<tr>
							<td width="155px" class="tdColor" name="saleinfoLastTime">最后修改时间</td>
							<td></td>
						</tr>
					
						
						
						
						
						
						
						
						
						
					</table>
					<div class="paging">此处是分页</div>
				</div>
				
				<!-- wish 表格 显示 end-->
			</div>
			<!-- wish页面样式end -->
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
		
		
		$(document).ready(function (){
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