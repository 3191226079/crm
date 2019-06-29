<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>   

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href="<%=basePath%>">  
	<title>查看短信</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>
<body onload="page()">
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;消息管理
			</div>
		</div>
		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				<div class="conform" id="myll12138">
					<form action="info/selectInfo" id="forms" method="post">
						<div class="cfD">
							<input type="hidden" name="employBean.employPhone" v-model="myresult">
							<input type="hidden" name="employBean.employName" v-model="myresult">
							<input class="addUser" name="infoBean.infoTitle"  autocomplete="off" v-model="myresult" type="text" placeholder="输入接收者/主题/联系电话" />
							<!-- <button class="button" onclick="javascript:function(){document.getElementById('forms').submit()};">搜索</button> -->
							<input class="button" value="搜索" type="submit">
							<a class="addA addA1" href="info/jumptosend">发送短信</a>
						</div>
					</form>
				</div>
				<!-- banner 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="100px" class="tdColor tdC">序号</td>
							<td width="170px" class="tdColor">主题</td>
							<td width="170px" class="tdColor">接收人</td>
							<td width="200px" class="tdColor">联系电话</td>
							<td width="250px" class="tdColor">发送时间</td>
							<td width="170px" class="tdColor">信息状态</td>
							<td width="170px" class="tdColor">用户操作</td>
						</tr>
						<c:forEach items="${InfoDetail.list}" var="InfoDetailBean" varStatus="s">
							<tr>
								<td>${s.index+1}</td>
								<td>${InfoDetailBean.infoBean.infoTitle}</td>
								<td>${InfoDetailBean.employBean.employName}</td>
								<td>${InfoDetailBean.employBean.employPhone}</td>
								<td>
									<fmt:formatDate value="${InfoDetailBean.infoDetailUpdateTime}" pattern="yyyy-MM-dd   HH:mm:ss"/>
								</td>
								<td>
									<c:if test="${InfoDetailBean.infoDetailState eq 1}">未读</c:if>
									<c:if test="${InfoDetailBean.infoDetailState eq 0}">已读</c:if>
								</td>
								<td>
									<c:if test="${InfoDetailBean.infoDetailState eq 0}">
										<img class="operation delban" src="img/delete.png" onclick="deleteInfo('${InfoDetailBean.infoDetailId}','${InfoDetailBean.infoId }')">
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="paging" id="div" style="float:right"></div>
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
				<a href="javascript:;" id="read" class="ok yes">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
</body>
	<script type="text/javascript" src="js/vue.min.js"></script>
	<script type="text/javascript">
	new Vue({
		el:'#myll12138',
		data:
		{
			myresult:''
		}
	});
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
	function deleteInfo(infoDetailId,infoId)
	{
		document.getElementById("read").href = "info/deleteInfo?infoDetailId=" + infoDetailId + "&infoId=" + infoId;
	}
	function page()
	{
        var td = document.getElementById('div');
        if(${InfoDetail.pageNum} != 1)
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '首页';
        	a.href = 'info/selectInfo?pn=1';
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
        
        if(${InfoDetail.pageNum} <= 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(i+1 <= ${InfoDetail.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = i + 1;
					a.href = 'info/selectInfo?pn=' + (i + 1);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${InfoDetail.pageNum} == i+1)
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
				
			}
        }
        if(${InfoDetail.pageNum} > 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(${InfoDetail.pageNum}+i-5 <= ${InfoDetail.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = ${activeBean1.pageNum}+i-5;
					a.href = 'info/selectInfo?pn=' + (${InfoDetail.pageNum}+i-5);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${InfoDetail.pageNum} == (${InfoDetail.pageNum}+i-5))
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
			}
        }
        
        if(${InfoDetail.pageNum } != ${InfoDetail.pages})
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '尾页';
        	a.href = 'info/selectInfo?pn=' + ${InfoDetail.pages};
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
	}
</script>
</html>