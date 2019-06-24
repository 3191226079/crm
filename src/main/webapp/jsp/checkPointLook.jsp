<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>"> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>任务考核</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>
<body onload="addNode()">
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;查看考核指标
			</div>
		</div>

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<form action="checkPoint/selectCheckPoint" method="post" id="myForm">
						<div class="cfD">
							<input class="addUser" autocomplete="off" name="checkPointTarget" type="text" placeholder="考核名称" />
							<button class="button" onclick="javascript:function(){document.getElementById('myForm').submit()};">搜索</button>
							<a class="addA addA1" href="jsp/checkPointAdd.jsp">添加指标</a>
						</div>
					</form>
				</div>
				<form action="checkPoint/selectCheckPoint" method="post">
				<!-- banner 表格 显示 -->
					<div class="conShow">
						<table border="1" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150px" class="tdColor tdC">序号</td>
								<td width="300px" class="tdColor">考核名称</td>
								<td width="600px" class="tdColor">考核描述</td>
								<td width="600px" class="tdColor">发布时间</td>
								<td width="200px" class="tdColor">操作</td>
							</tr>
							<c:forEach items="${selectAllList.list}" var="CheckPointBean" varStatus="s">
								<tr>
									<td>${s.index+1 }</td>
									<td>${CheckPointBean.checkPointTarget }</td>
									<td>${CheckPointBean.checkPointInfo }</td>
									<td>
										<fmt:formatDate value="${CheckPointBean.checkPointUpdateTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
										<a href="checkPoint/jumpToUpdate?checkPointId=${CheckPointBean.checkPointId }">
											<img class="operation" src="img/update.png">
										</a>
											<img class="operation delban" src="img/delete.png" onclick="jumptodelete('${CheckPointBean.checkPointId }')">
									</td>
								</tr>
							</c:forEach>
						</table>
						<div class="paging" id="addtd"></div>
					</div>
				<!-- banner 表格 显示 end-->
				</form>
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
				<a href="javascript:;" id="sure" class="ok yes">确定</a><a href="checkPoint/selectCheckPoint" class="ok no">取消</a>
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
	
	function jumptodelete(checkId) 
	{
		document.getElementById('sure').href = 'checkPoint/delete?checkPointId=' + checkId;
	}
	function addNode()
		{
            var td = document.getElementById('addtd');
            if(${selectAllList.pageNum} != 1)
           	{
            	var a = document.createElement('a');
            	a.innerHTML = '首页';
            	a.href = 'checkPoint/selectCheckPoint?pn=1';
            	td.appendChild(a);
            	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
            	a.style.float = 'left';
           	}
            
            if(${selectAllList.pageNum} <= 6)
            {
            	for (var i = 0; i < 10; i++) 
            	{
					if(i+1 <= ${selectAllList.pages})
					{
						var a = document.createElement('a');
						a.innerHTML = i + 1;
						a.href = 'checkPoint/selectCheckPoint?pn=' + (i + 1);
						td.appendChild(a);
						a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
						a.style.float = 'left';
						
						if(${selectAllList.pageNum} == i+1)
						{
							a.style.color = 'red';
							a.href = 'javascript:;'
							a.style.textDecoration = 'none';
						}
					}
					
				}
            }
            if(${selectAllList.pageNum} > 6)
            {
            	for (var i = 0; i < 10; i++) 
            	{
					if(${selectAllList.pageNum}+i-5 <= ${selectAllList.pages})
					{
						var a = document.createElement('a');
						a.innerHTML = ${selectAllList.pageNum}+i-5;
						a.href = 'checkPoint/selectCheckPoint?pn=' + (${selectAllList.pageNum}+i-5);
						td.appendChild(a);
						a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
						a.style.float = 'left';
						
						if(${selectAllList.pageNum} == (${selectAllList.pageNum}+i-5))
						{
							a.style.color = 'red';
							a.href = 'javascript:;'
							a.style.textDecoration = 'none';
						}
					}
				}
            }
            
            if(${selectAllList.pageNum } != ${selectAllList.pages})
           	{
            	var a = document.createElement('a');
            	a.innerHTML = '尾页';
            	a.href = 'checkPoint/selectCheckPoint?pn=' + ${selectAllList.pages};
            	td.appendChild(a);
            	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
            	a.style.float = 'left';
           	}
		}
	</script>
</html>
