<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
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
<link rel="stylesheet" type="text/css" href="css/rafaelcss.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/rafael.js"></script>
<style type="text/css">
.bbD .bbDP .backr
{
	width: 100px;
	height: 40px;
	line-height: 40px;
	background-color: #3695cc;
	color: #fff;
	margin-top: 50px;
	margin-right: 25px;
	font-size: 16px;
	cursor: pointer;
	text-align: center;
	margin-bottom: 160px;
	border: none;
	display:block;
}
</style>

</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;行家添加
			</div>
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					
				</div>
				<form action="supplier/update" method="post">
				<div class="baBody_r">
					<div class="bbD">
						<input type="hidden" name="supplierId" value="${supplierBean.supplierId }">
						<span class="blankr3"></span><span class="nar">供应商名称：</span><input type="text" class="input1" id="supplierName" name="supplierName" readonly="readonly" value="${supplierBean.supplierName }"/>
					</div>
					<div class="bbD">
						<span class="blankr2"></span><span class="nar">联系人：</span><input type="text" class="input1" id="supplierContact" name="supplierContact" readonly="readonly" value="${supplierBean.supplierContact }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">电话：</span><input type="text" class="input1" id="supplierPhone" name="supplierPhone" readonly="readonly" value="${supplierBean.supplierPhone }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">传真：</span><input type="text" class="input1" id="supplierFax" name="supplierFax" readonly="readonly" value="${supplierBean.supplierFax }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span class="nar">邮箱：</span><input type="text" class="input1" id="supplierEmail" name="supplierEmail" readonly="readonly" value="${supplierBean.supplierEmail }"/>
					</div>
					<div class="bbD">
						<span class="blankr"></span><span>备注：</span>
						<div class="btextr">
							<textarea class="text2" id="supplierInfo" name="supplierInfo" readonly="readonly">${supplierBean.supplierInfo }</textarea>
						</div>
					</div>
					<div class="bbD">
						<span class="nar">录入人员：</span><input type="text" class="input1" name="supplierPerson" readonly="readonly" value="${supplierBean.supplierPerson }"/>
					</div>
					<div class="bbD">
						<span class="nar">添加时间：</span><input type="text" class="input1" name="supplierUpdateTime" readonly="readonly" value="<fmt:formatDate value="${supplierBean.supplierUpdateTime }" pattern="yyyy-MM-dd  HH:MM:ss"/>"/>
					</div>
					<div class="bbD">
						<p class="bbDP" id="updater">
							<input type="button" class="btn_ok btn_yes" value="修改" id="but" >
							<a class="btn_ok btn_no" href="supplier/select">返回</a>
						</p>
						<p id="backr" class="bbDP">
							<button class="backr">保存并返回</button>
						</p>
					</div>
				</div>
				</form>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
	<script type="text/javascript">
	 	$("#but").click(function(){
		console.log($("#updater"));
		$("#updater").css("display","none");
		$("#backr").css("display","block");
		$("#supplierName").removeAttr("readonly");
		$("#supplierContact").removeAttr("readonly");
		$("#supplierPhone").removeAttr("readonly");
		$("#supplierFax").removeAttr("readonly");
		$("#supplierEmail").removeAttr("readonly");
		$("#supplierInfo").removeAttr("readonly");	
		});
	 
	</script>
</body>
</html>