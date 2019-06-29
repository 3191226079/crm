<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>显示用户</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="javascript:;">用户管理</a>&nbsp;-&nbsp;</span>&nbsp;显示用户
			</div>
		</div>

		<div class="page">
			<div class="connoisseur">
				
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">序号</td>
							<td width="100px" class="tdColor">头像</td>
							<td width="100px" class="tdColor">姓名</td>
							<td width="140px" class="tdColor">性别</td>
							<td width="140px" class="tdColor">职位</td>
							<td width="145px" class="tdColor">工资</td>
							<td width="150px" class="tdColor">学历</td>
							<td width="165px" class="tdColor">联系电话</td>
							<td width="160px" class="tdColor">入职时间</td>
							<td width="130px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${requestScope.pageInfo.list }" var="employBean" varStatus="ss">
							<tr>
								<td>${(ss.index+1)+(pageInfo.pageNum-1)*(pageInfo.pageSize) }</td>
								<td><div style="margin: 5px 0px;">
										<img src="${employBean.employImg }" width="75px" height="75px">
									</div></td>
								<td>${employBean.employName }</td>
								<td>
									<c:if test="${employBean.employSex eq '1' }">男</c:if>
									<c:if test="${employBean.employSex ne '1' }">女</c:if>
								</td>
								<td>${employBean.jobBean.jobName }</td>
								<td>${employBean.employSalary }</td>
								<td>${employBean.employEducation }</td>
								<td>${employBean.employPhone }</td>
								<td><fmt:formatDate value="${employBean.userBean.userRegisterTime }" pattern="yyyy-MM-dd"/></td>
								<td><a href="employ/jumpToUpdateEmploy?employId=${employBean.employId }"><img class="operation"
										src="img/update.png"></a> <img class="operation delban"
									src="img/delete.png" onclick="mydelete('${employBean.employId}')"></td>
							</tr>
						</c:forEach>
						
					</table>
					<div class="paging">
						<a href="employ/showEmployll?pn=1">首页</a>&nbsp;
						<c:if test="${pageInfo.pageNum gt 1 }"><a href="employ/showEmployll?pn=${pageInfo.pageNum-1 }">上一页</a></c:if>
						<c:if test="${pageInfo.pageNum le 1 }">上一页</c:if>
						&nbsp;
						
						<c:if test="${pageInfo.pageNum lt pageInfo.pages }"><a href="employ/showEmployll?pn=${pageInfo.pageNum+1 }">下一页</a></c:if>
						<c:if test="${pageInfo.pageNum ge pageInfo.pages }">下一页</c:if>
						&nbsp;<a href="employ/showEmployll?pn=${pageInfo.pages }">尾页</a>
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
				<a id="mylla23" href="javascript:;" class="ok yes">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
</body>

<script type="text/javascript">
function mydelete(obj)
{
	document.getElementById('mylla23').href = 'employ/deleteEmploy?employId=' + obj;
}
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