<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页左侧导航</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			<a href="inc/mainll.jsp" target="main"><div class="line">
					<img src="img/coin01.png" />&nbsp;&nbsp;首页
				</div></a>
			<c:forEach items="${subfieldList }" var="subfieldBean">
				<dl class="system_log">
					<dt>
						<img class="icon1" src="img/coin05.png" /><img class="icon2"
							src="img/coin06.png" /> ${subfieldBean.subfieldName }<img class="icon3"
							src="img/coin19.png" /><img class="icon4"
							src="img/coin20.png" />
					</dt>
					<c:forEach items="${subfieldBean.permissionSubfieldList }" var="subfieldBean1">
						<dd>
							<img class="coin11" src="img/coin111.png" /><img class="coin22"
								src="img/coin222.png" /><a class="cks" href="${subfieldBean1.permissionInformationBean.informationRemarks }"
								target="main">${subfieldBean1.subfieldName }</a><img class="icon5" src="img/coin21.png" />
						</dd>
					</c:forEach>
				</dl>
			</c:forEach>
			

		</div>

	</div>
</body>
</html>
