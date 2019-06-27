<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>3天内需要联系</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
	
		<div class="page">
			<!-- banner页面样式 -->
			<div class="banner">
		
				<!-- banner 表格 显示 -->
				<div class="banShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor">客户编号</td>
					
							<td width="200px" class="tdColor">客户姓名</td>
							<td width="200px" class="tdColor">上级单位</td>
							<td width="200px" class="tdColor">负责人</td>
							<td width="200px" class="tdColor">客户状态</td>
							<td width="200px" class="tdColor">客户地址</td>
							<td width="200px" class="tdColor">客户电话</td>
							<td width="300px" class="tdColor">客户传真</td>
							<td width="300px" class="tdColor">客户邮箱</td>
							<td width="300px" class="tdColor">联系时间</td>
							<td width="300px" class="tdColor">备注信息</td>
							<td width="300px" class="tdColor">公司编号</td>
							<td width="300px" class="tdColor">修改时间</td>
							<td width="300px" class="tdColor">修改</td>
						</tr>
						<c:forEach items="${getthreeday}" var="today1">		
				 		<tr>
				 		<td>${today1.customerId}</td>
				 		<td>${today1.customerName}</td>
				 		<td>${today1.customerUpDepartment}</td>
				 		<td>${today1.customerContactPerson}</td>
				 		<td>${today1.customerState}</td>
				 		<td>${today1.customerAddress}</td>
				 		<td>${today1.customerPhone}</td>
				 		<td>${today1.customerFax}</td>
				 		<td>${today1.customerEmail}</td>
				 		<td>
				 			<fmt:formatDate value="${today1.customerContactTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				 		</td>
				 		<td>${today1.customerInfo}</td>
				 		<td>${today1.companyId}</td>
				 		<td>
				 			<fmt:formatDate value="${today1.customerUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				 		</td>
				 		<td> <img class="operation delban" src="img/delete.png" onclick="deleteSa('${today1.customerId}')"></td>
				 		</tr>
				 		</c:forEach>
						
		
	
					</table>
					<div class="paging">此处是分页</div>
				
				</div>
				<!-- user 表格 显示 end-->
			</div>
			<!-- user页面样式end -->
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
				<a href="javascript:;" class="ok yes" id="sure">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
</body>

<script type="text/javascript">
// 广告弹出框
$(document).ready(function(){
	$(".delban").click(function(){
		  $(".banDel").show();
		});
		$(".close").click(function(){
		  $(".banDel").hide();
		});
		$(".no").click(function(){
		  $(".banDel").hide();
		});
});
	
// 广告弹出框 end

	function deleteSa(customerId) 
	{
		console.log(customerId);
		document.getElementById("sure").href = 'today/delthreeday?customerId=' + customerId;	
	}
</script>
</html>