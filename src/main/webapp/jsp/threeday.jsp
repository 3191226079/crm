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
				 		
				 		</tr>
				 		</c:forEach>
						
						
						
						<!-- <tr>
							<td>1</td>
							<td><div class="bsImg">
									<img src="img/banimg.png">
								</div></td>
							<td>双十一连天购</td>
							<td><a class="bsA" href="#">http://www.sdfsdfsdfds.com</a></td>
							<td>是</td>
							<td>1</td>
							<td><a href="banneradd.html"><img class="operation"
									src="img/update.png"></a> <img class="operation delban"
								src="img/delete.png"></td>
						</tr>
						<tr>
							<td>1</td>
							<td><div class="bsImg">
									<img src="img/banimg.png">
								</div></td>
							<td>双十一连天购</td>
							<td><a class="bsA" href="#">http://www.sdfsdfsdfds.com</a></td>
							<td>是</td>
							<td>1</td>
							<td><a href="banneradd.html"><img class="operation"
									src="img/update.png"></a> <img class="operation delban"
								src="img/delete.png"></td>
						</tr> -->
					</table>
					<div class="paging">此处是分页</div>
				</div>
				<!-- banner 表格 显示 end-->
			</div>
			<!-- banner页面样式end -->
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
				<a href="#" class="ok yes" onclick="del()">确定</a><a class="ok no">取消</a>
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
// 广告弹出框 end

function del(){
    var input=document.getElementsByName("check[]");
    for(var i=input.length-1; i>=0;i--){
       if(input[i].checked==true){
           //获取td节点
           var td=input[i].parentNode;
          //获取tr节点
          var tr=td.parentNode;
          //获取table
          var table=tr.parentNode;
          //移除子节点
          table.removeChild(tr);
        }
    }     
}
</script>
</html>