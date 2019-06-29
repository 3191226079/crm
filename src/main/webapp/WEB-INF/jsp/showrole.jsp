<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色列表</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="javascript:;">角色管理</a>&nbsp;-&nbsp;-</span>&nbsp;显示角色
			</div>
		</div>

		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				<!-- user 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">序号</td>
							<td width="235px" class="tdColor">角色名称</td>
							<td width="600px" class="tdColor">角色描述</td>
							<td width="330px" class="tdColor">操作时间</td>
							<td width="130px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${requestScope.pageInfo.list }" var="roleBean" varStatus="ss">
							<tr height="40px">
								<td>${ss.index+1+(pageInfo.pageNum-1)*pageSize }</td>
								<td>${roleBean.roleName }</td>
								<td>${roleBean.roleDescribe }</td>
								<td><fmt:formatDate value="${roleBean.roleLastTime }" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
								<td><a href="role/jumpToUpdateRole?roleNumber=${roleBean.roleNumber }"><img class="operation"
										src="img/update.png"></a></td>
							</tr>
						</c:forEach>
					</table>
					<div class="paging">
						<a href="role/showRole?pn=1">首页</a>&nbsp;
						<c:if test="${pageInfo.pageNum gt 1 }"><a href="role/showRole?pn=${pageInfo.pageNum-1 }">上一页</a></c:if>
						<c:if test="${pageInfo.pageNum le 1 }">上一页</c:if>
						&nbsp;
						
						<c:if test="${pageInfo.pageNum lt pageInfo.pages }"><a href="role/showRole?pn=${pageInfo.pageNum+1 }">下一页</a></c:if>
						<c:if test="${pageInfo.pageNum ge pageInfo.pages }">下一页</c:if>
						&nbsp;<a href="role/showRole?pn=${pageInfo.pages }">尾页</a>
					</div>
				</div>
			</div>
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
				<a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
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
</script>
</html>