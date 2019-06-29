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
    <title>添加</title>        
 </head>
 <body>
 	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;产品信息及库存信息
			</div>
		</div>

		<div class="page">
			<!-- wish页面样式 -->
			<div class="wish">
				<div class="conform">
					<form>
						<div class="cfD">
							<!--时间： <input class="vinput" type="text" />&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="vinput" type="text" /> --> <input class="addUser"
								type="text" placeholder="请输入产品信息" />
							<button class="button">搜索</button>
							<a class="addA addA1" href="addgd/selectAll">添加商品</a>
						</div>
					</form>
				</div>
				<!-- wish 表格 显示 -->
			
				<div class="wishShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">产品编号</td>
							<td width="200px" class="tdColor">产品名称</td>
							<td width="175px" class="tdColor">产品类型</td>
							<td width="185px" class="tdColor">规格说明</td>
							<td width="185px" class="tdColor">单位</td>
							<td width="180px" class="tdColor">仓库编号</td>
							<td width="175px" class="tdColor">仓库数量</td>
							<td width="155px" class="tdColor">成本价</td>
							<td width="175px" class="tdColor">零售价</td>
							<td width="230px" class="tdColor">经销价</td>
							<td width="130px" class="tdColor">备注信息</td>
							<td width="130px" class="tdColor">公司编号</td>
							<td width="130px" class="tdColor">最后修改时间</td>
							<td width="130px" class="tdColor">删除</td>
							<td width="130px" class="tdColor">修改</td>
						</tr>
					<c:forEach items="${selectStock}" var="stock"> 
						<tr>
							<td>${stock.commodityNumber}</td>
							<td>${stock.commodityName}</td>
							<td>${stock.commodityType}</td>
							<td>${stock.description}</td>
							<td>${stock.unit}</td>
							<td>${stock.warehouseNumber}</td>
							<td>${stock.stockNumber}</td>
							<td>${stock.costPrice}</td>
							<td>${stock.retailPrice}</td>
							<td>${stock.salePrice}</td>
							<td>${stock.postscript}</td>
							<td>${stock.companyId}</td>
							<td>
								<!--jsp中 修改时间格式 -->
								<fmt:formatDate value="${stock.stockLastTime}" pattern="yyyy-MM-dd"/>
							</td>
							<td>
								<!-- 删除 -->
									<img class="operation delban" src="img/delete.png" onclick="setPath('${stock.commodityNumber }')">
							</td>
							<td>
								<!-- 修改 -->
								<a href="stock/selectId?id=${stock.commodityNumber }">
									<img class="operation" src="img/update.png">
								</a>
							</td>
						</tr>
					</c:forEach>
						
						
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
		//确认删除
		function setPath(id)
		{
			console.log(id);
			var path = 'stock/deleteId?commodityNumber='+id;
			document.getElementById('del').href = path;
		}
// 广告弹出框 end
</script>
</html>