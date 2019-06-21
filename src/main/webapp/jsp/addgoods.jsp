<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>title</title>
    <link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>        
 </head>
 <body>
 	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;添加产品信息
			</div>
		</div>

		<div class="page">
			<!-- wish页面样式 -->
			<div class="wish">
				<!-- <div class="conform">
					<form>
						<div class="cfD">
							时间： <input class="vinput" type="text" />&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="vinput" type="text" /> <input class="addUser"
								type="text" placeholder="请输入产品信息" />
							<button class="button">搜索</button>
						</div>
					</form>
				</div> -->
				<!-- wish 表格 显示 -->
				<div class="wishShow">
					<table border rules=none cellspacing=0 align=center>
						<tr>
							<td >商品编号</td>
							<td>
								<input type="text" name="commodityNumber">
							</td>
						</tr>
						<tr>
							<td>商品名称</td>
							<td>
								<input type="text" name="commodityName">
							</td>
						</tr>
						<tr>
							<td>商品数量</td>
							<td><input type="text" name="commodityType"></td>
						</tr>
						<tr>
							<td>规格说明</td>
							<td><input type="text" name="Description"></td>
						</tr>
						<tr>
							<td>单位</td>
							<td><input type="text" name="Unit"></td>
						</tr>
						<tr>
							<td>仓库编号</td>
							<td>
								<select class="textBox" name="warehouseNumber">
								<c:forEach items="${classforication }" var="classbean">
								 	<option value="${classbean.gdclassId }">${classbean.className }</option>
								</c:forEach> 
							    </select>
							</td>
						</tr>
						<tr>
							<td>库存数量</td>
							<td><input type="text" name="stockNumber"></td>
						</tr>
						<tr>
							<td>成本价</td>
							<td><input type="text" name="costPrice"></td>
						</tr>
						<tr>
							<td>零售价</td>
							<td><input type="text" name="retailPrice"></td>
						</tr>
						<tr>
							<td>经销价</td>
							<td><input type="text" name="salePrice"></td>
						</tr>
						<tr>
							<td>备注信息</td>
							<td><input type="text" name="Postscript"></td>
						</tr>
						<tr>
							<td>公司编号</td>
							<td><input type="text" name="companyId"></td>
						</tr>
						<tr>
							<td>最后修改时间</td>
							<td><input type="text" name="stockLastTime"></td>
						</tr>
					</table>
					<div class="paging">此处是分页</div>
				</div>
				<!-- wish 表格 显示 end-->
			</div>
			<!-- wish页面样式end -->
		</div>

	</div>
 
 </body>
</html>