<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sc.crmsys.bean.StockBean" %>

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
	<link rel="stylesheet" type="text/css" href="css/manhuaDate.1.0.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/manhuaDate.1.0.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	$(function (){
  	$("input.mh_date").manhuaDate({
    Event : "click",//可选               
    Left : 0,//弹出时间停靠的左边位置
    Top : -16,//弹出时间停靠的顶部边位置
    fuhao : "-",//日期连接符默认为-
    isTime : false,//是否开启时间值默认为false
    beginY : 1949,//年份的开始默认为1949
    endY :2100//年份的结束默认为2049
  });
});
</script>
      
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
			<form action="stock/add" method="post"> 
			
				<div class="wishShow">
					<table border rules=none cellspacing=0 align=center>
						<tr>
							<td>商品名称</td>
							<td>
								<input type="text" name="commodityName">
							</td>
						</tr>
						<tr>
							<td>商品类型</td>
							<td><input type="text" name="commodityType"></td>
						</tr>
						<tr>
							<td>规格说明</td>
							<td><input type="text" name="description"></td>
						</tr>
						<tr>
							<td>单位</td>
							<td><input type="text" name="unit"></td>
						</tr>
						<tr>
							<td>仓库编号</td>
							<td>
								<select class="textBox" name="warehouseNumber">
								<c:forEach items="${selectWarehouse }" var="classbean">
								 	<option value="${classbean.warehouseNumber}">${classbean.warehouseName}</option>
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
							<td><input type="text" name="postscript"></td>
						</tr>
						<tr>
							<td>公司编号</td>
							<td><input type="text" name="companyId"></td>
						</tr>
						
						
						<tr>
							<td>最后修改时间</td>
							<td>
							<!-- 	<input type="text" name="stockLastTime"> -->
								<input class="vinput mh_date" type="text" readonly="true" />
							</td>
						</tr>
					</table>
				<div class="bbD">
					<p class="bbDP">
						<!-- <button class="btn_ok btn_yes" href="#">提交</button> -->
						<input type="submit" class="btn_ok btn_yes" value="提交">
						<a class="btn_ok btn_no" href="#">取消</a>
					</p>
				</div>
			</form>
					<div class="paging">此处是分页</div>
				</div>
				<!-- wish 表格 显示 end-->
			</div>
			<!-- wish页面样式end -->
		</div>

	</div>
 
 </body>
</html>