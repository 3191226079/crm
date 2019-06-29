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
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="inc/mainll.jsp"></a></span>&nbsp;&nbsp;&nbsp;&nbsp;咨询回复
			</div>
		</div>

		<div class="page">
			<!-- answer页面样式 -->
			<div class="wish">
				<div class="conform">
				</div>
				<!-- wish 表格 显示 -->
				<div class="wishShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="200px" class="tdColor" style="color:black;">时间</td>
							<td width="200px" class="tdColor" style="color:black;">用户姓名</td>
							<td width="200px" class="tdColor" style="color:black;">操作内容</td>
						</tr>
						<c:forEach items="${pageJournal.list}" var="pageJournal">
							<tr>
								<td width="200px" class="tdColor tdC">
									<fmt:formatDate value="${pageJournal.visitTime}" pattern="yyyy-MM-dd  HH:MM:ss"/>
								</td>
								<td width="200px" class="tdColor">${pageJournal.userBean.userName}</td>
								<td width="200px" class="tdColor">${pageJournal.permission}</td>
							</tr>
						</c:forEach>
					</table>
					<div class="page" style="height: 50px; margin-top: 30px;line-height: 50px;border-bottom:1px solid grey;">
				        <a href="journal/info" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	首页
				        </a>
				     	<a href="javascript:send(${pageJournal.pageNum })" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	上一页
				       	</a>
				        <a href="journal/info?pn=${pageJournal.nextPage}" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	下一页
				        </a>
				        <a href="journal/info?pn=${pageJournal.pages }" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	尾页
				        </a>
				    </div>
				</div>
				<!-- wish 表格 显示 end-->
			</div>
			<!-- wish页面样式end -->
		</div>
	</div>
	<!-- 回复框 -->
	<!-- 回复框  end-->
</body>

<script type="text/javascript">

function send(pn)
{
	location.href = 'journal/info?pn='+(pn-1);	
}




// 广告弹出框 end
</script>
</html>