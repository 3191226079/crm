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
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body>
	<div id="pageAll">
		
		<div class="page">
			<!-- opinion 页面样式 -->
			<div class="opinion">
				
				<!-- opinion 表格 显示 -->
				
				<div class="opShow">
					<div class="butrr">
						<div class="buttopr">
							<a href="jsp/addsaleout.jsp" >添加</a>
						</div>	
					</div>
					<table border="0" cellspacing="0" cellpadding="0">
						
						<tr>
							<td width="186px" class="tdColor tdC">销售单编号</td>
							<td width="330px" class="tdColor">客户编号</td>
							<td width="330px" class="tdColor">公司编号</td>
							<td width="330px" class="tdColor">制单日期</td>
							<td width="230px" class="tdColor">发票号码</td>
							<td width="330px" class="tdColor">销售金额</td>
							<td width="280px" class="tdColor">出库状态</td>
							<td width="160px" class="tdColor">订单状态</td>
							<td width="180px" class="tdColor">备注</td>
							<td width="330px" class="tdColor">最后修改时间</td>
							<td width="230px" class="tdColor">操作</td>
							
						</tr>
						<c:forEach items="${getsaleout }" var="p">
						<tr height="40px">
							<td>${p.saleoutId }</td>
							<td>${p.customerId }</td>
							<td>${p.companyId }</td>
							
							
							<td>
				 			<fmt:formatDate value="${p.saleoutTime }" pattern="yyyy-MM-dd HH:mm:ss" />
				 		   </td>
					
							<td>${p.saleoutInvoce}</td>
							<td>${p.saleoutPrice}</td>
							<td>${p.saleoutState}</td>
							<td>${p.saleState }</td>
							<td>${p.saleoutRemarks }</td>
							
							<td>
				 			<fmt:formatDate value="${p.saleoutLastTime }" pattern="yyyy-MM-dd HH:mm:ss" />
				 		   </td>
							
							
							<td><a href="saleout/get1?saleoutId=${p.saleoutId }">
									<img class="operation" src="img/update.png">
								</a> 
								<img class="operation delban" src="img/delete.png" onclick="deleteSa('${p.saleoutId}')">
							</td>
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

	function deleteSa(saleoutId) 
	{
		console.log(saleoutId);
		document.getElementById("sure").href = 'saleout/del?saleoutId=' + saleoutId;	
	}
</script>
</html>