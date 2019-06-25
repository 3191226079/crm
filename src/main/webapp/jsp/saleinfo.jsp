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
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;意见管理
			</div>
		</div>
		<div class="page">
			<!-- opinion 页面样式 -->
			<div class="opinion">
				
				<!-- opinion 表格 显示 -->
				
				<div class="opShow">
					<div class="butrr">
						<div class="buttopr">
							<a href="jsp/addsaleinfo.jsp" >添加</a>
						</div>	
					</div>
					<table border="0" cellspacing="0" cellpadding="0">
						
						<tr>
							<td width="186px" class="tdColor tdC">销售详情编号</td>
							<td width="330px" class="tdColor">公司编号</td>
							<td width="330px" class="tdColor">销售单编号</td>
							<td width="230px" class="tdColor">商品编号</td>
							<td width="330px" class="tdColor">商品数量</td>
							<td width="280px" class="tdColor">商品价格</td>
							<td width="250px" class="tdColor">备注说明</td>
							<td width="330px" class="tdColor">最后修改时间</td>
							<td width="230px" class="tdColor">操作</td>
							
						</tr>
						<c:forEach items="${getsaleinfo}" var="p">
						<tr height="40px">
							<td>${p.saleinfoId }</td>
							<td>${p.companyId }</td>
							
							<td>${p.saleoutId }</td>
							<td>${p.goodsId }</td>
							
					
							<td>${p.goodsNum}</td>
							<td>${p.goodsPrice}</td>
							<td>${p.saleinfoRemarks}</td>
							
							<td>
				 			<fmt:formatDate value="${p.saleinfoLastTime }" pattern="yyyy-MM-dd HH:mm:ss" />
				 		   </td>
							
				
							<td><a href="saleinfo/get1?saleinfoId=${p.saleinfoId }"><img class="operation"
									src="img/update.png"></a>
									<img class="operation delban" src="img/delete.png" onclick="deleteSa('${p.saleinfoId}')">
									
									<%--  <a href="saleinfo/del?saleinfoId=${p.saleinfoId }"><img class="operation delban" --%>
								<!-- src="img/delete.png"></a> --></td>
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

	function deleteSa(saleinfoId) 
	{
	
		document.getElementById("sure").href = 'saleinfo/del?saleinfoId=' + saleinfoId;	
	}
</script>
</html>