<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"> 
	<title>需补货信息添加</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/rafaelcss.css">
<script type="text/javascript"  src=""></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="bor">
				<div class="baTop">
					
				</div>
				<form action="purchase/add" method="get">
				<div class="baBody">
					<div class="bbD">
						<span class="nar">产品编号：</span><input type="text" class="input1" readonly="readonly" id="productId" name="productId" value=""/>
					</div>
					<div class="bbD">
						<span class="nar">产品名称：</span>
						<select class="input1" id="slr">
							<option>请选择</option>
							<c:forEach items="${stockes }" var="s">
							<option value="${s.commodityNumber}">${s.commodityName }</option>
							</c:forEach>
						</select>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">数量：</span><input type="text" class="input1" name="companyId" />
					</div>
					<div class="bbD">
						<span class="blankr"></span><span>备注：</span>
						<div class="btextr">
							<textarea class="text2" name="purchaseInfo"></textarea>
						</div>
					</div>
					<div class="bbD">
						<span class="nar">录入人员：</span><input type="text" class="input1" name="purchasePerson"/>
					</div>
					<div class="bbD">
						<span class="nar">添加时间：</span><input type="text" class="input1" name="purchaseUpdateTime" readonly="readonly"/>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<input type="submit" class="btn_ok btn_yes" value="提交">
							<a class="btn_ok btn_no" href="purchase/select">取消</a>
						</p>
					</div>
				</div>
				</form>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
	<script type="text/javascript">
		$("#slr").change(function(){
			var commodityNumber =  $(this).val();
			
			$("#productId").val(commodityNumber);
		});
	
	
	</script>

</html>