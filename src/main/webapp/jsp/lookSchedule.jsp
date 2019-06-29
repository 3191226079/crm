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
	<title>查看日程</title>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body onload="addNode()">
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;查看日程
			</div>
	</div>

		<div class="page">
			<!-- topic页面样式 -->
			<div class="topic">
				<div class="conform">
					<form action="active/selectActive" method="post" id="myll">
						<div class="cfD" style="margin-left:0px">
							<input class="addUser" id="input1"  autocomplete="off" value="${title }"  name="activeTitle" type="text" placeholder="日程主题" />
							<!-- <button class="button" onclick="javascript:function(){document.getElementById('myll').submit()};" >搜索</button> -->
							<input class="button" type="submit" value="搜索">
							<a class="addA addA1" href="jsp/addSchedule.jsp">添加日程</a>
						</div>
					</form>
				</div>
				<!-- topic表格 显示 -->
				<form action="active/selectActive" method="post">
					<div class="conShow">
						<table border="1" cellspacing="0" cellpadding="0">
							<tr>
								<td width="66px" class="tdColor tdC">序号</td>
								<td width="125px" class="tdColor">安排主题</td>
								<td width="155px" class="tdColor">安排类别</td>
								<td width="300px" class="tdColor">日程描述</td>
								<td width="160px" class="tdColor">发布时间</td>
								<td width="145px" class="tdColor">修改时间</td>
								<td width="130px" class="tdColor">操作</td>
							</tr>
							<c:forEach items="${activeBean1.list}" var="activeBean" varStatus="s">
								<tr>
									<td>${s.index+1 }</td>
									<td>${activeBean.activeTitle }</td>
									<td>
										<c:if test="${activeBean.activeType eq 1 }">会议</c:if>
										<c:if test="${activeBean.activeType eq 2 }">聚餐</c:if>
										<c:if test="${activeBean.activeType eq 3 }">工作</c:if>
										<c:if test="${activeBean.activeType eq 4 }">商务</c:if>
										<c:if test="${activeBean.activeType eq 5 }">投简</c:if>
										<c:if test="${activeBean.activeType eq 6 }">公关</c:if>
										<c:if test="${activeBean.activeType eq 7 }">销售</c:if> 
									</td>
									<td>${activeBean.acitveDescribe }</td>
									<td>
										<fmt:formatDate value="${activeBean.activeStartTime }" pattern="yyyy-MM-dd"/>
									</td>
									<td>
										<fmt:formatDate value="${activeBean.activeUpdateTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
										<a href="active/jumpToUpdate?activeId=${activeBean.activeId }">
											<img class="operation" src="img/update.png">
										</a> 
											<img class="operation delban" src="img/delete.png" onclick="jumptodelete('${activeBean.activeId }')">
									</td>
								</tr>
							</c:forEach>
						</table>
						<div class="paging" id="addtd"></div>
					</div>
				</form>
				<!-- topic 表格 显示 end-->
			</div>
			<!-- topic页面样式end -->
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
				<a href="javascript:;" id="jumpall" class="ok yes">确定</a><a href="active/selectActive" class="ok no">取消</a>
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
		function jumptodelete(idstr)
		{
			document.getElementById('jumpall').href = 'active/deleteActive?activeId=' + idstr;
		}
		
		function addNode()
		{
            var td = document.getElementById('addtd');
            if(${activeBean1.pageNum} != 1)
           	{
            	var title = document.getElementById('input1').value;
            	
            	var a = document.createElement('a');
            	a.innerHTML = '首页';
            	a.href = 'active/selectActive?pn=1' + '&activeTitle' + title;
            	td.appendChild(a);
            	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
            	a.style.float = 'left';
           	}
            
            if(${activeBean1.pageNum} <= 6)
            {
            	for (var i = 0; i < 10; i++) 
            	{
					if(i+1 <= ${activeBean1.pages})
					{
						var title = document.getElementById('input1').value;
						
						var a = document.createElement('a');
						a.innerHTML = i + 1;
						a.href = 'active/selectActive?pn=' + (i + 1) + '&activeTitle' + title;
						td.appendChild(a);
						a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
						a.style.float = 'left';
						
						if(${activeBean1.pageNum} == i+1)
						{
							a.style.color = 'red';
							a.href = 'javascript:;'
							a.style.textDecoration = 'none';
						}
					}
					
				}
            }
            if(${activeBean1.pageNum} > 6)
            {
            	for (var i = 0; i < 10; i++) 
            	{
					if(${activeBean1.pageNum}+i-5 <= ${activeBean1.pages})
					{
						var title = document.getElementById('input1').value;
						
						var a = document.createElement('a');
						a.innerHTML = ${activeBean1.pageNum}+i-5;
						a.href = 'active/selectActive?pn=' + (${activeBean1.pageNum}+i-5) + '&activeTitle' + title;
						td.appendChild(a);
						a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
						a.style.float = 'left';
						
						if(${activeBean1.pageNum} == (${activeBean1.pageNum}+i-5))
						{
							a.style.color = 'red';
							a.href = 'javascript:;'
							a.style.textDecoration = 'none';
						}
					}
				}
            }
            
            if(${activeBean1.pageNum } != ${activeBean1.pages})
           	{
            	var title = document.getElementById('input1').value;
            	
            	var a = document.createElement('a');
            	a.innerHTML = '尾页';
            	a.href = 'active/selectActive?pn=' + ${activeBean1.pages} + '&activeTitle' + title;
            	td.appendChild(a);
            	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
            	a.style.float = 'left';
           	}
		}
	</script>
</html>