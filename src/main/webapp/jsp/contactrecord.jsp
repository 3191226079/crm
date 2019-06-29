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
<title>联系记录表</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body onload="page()">
	
		<div class="page">
			<!-- banner页面样式 -->
			<div class="banner">
		
				<!-- banner 表格 显示 -->
				
				
				<div class="banShow">
				<div class="butrr">
				<div></div>
				<div></div>
				<div></div>
						<div class="buttopr">
							<a href="jsp/addcontactrecord.jsp" >添加</a>
						</div>	
					</div>
					<form>
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">联系记录ID</td>
							<td width="200px" class="tdColor">联系标题</td>
							<td width="235px" class="tdColor">联系时间</td>
							<td width="200px" class="tdColor">客户编号</td>
							<td width="200px" class="tdColor">联系内容</td>
							<td width="200px" class="tdColor">公司编号</td>
							<td width="200px" class="tdColor">最后修改时间</td>
							<td width="200px" class="tdColor">操作</td>
							
						</tr>
						<c:forEach items="${getcontactrecord.list}" var="getcontactrecord">
						<tr>
						<td>${getcontactrecord.contactLogsId}</td>
						<td>${getcontactrecord.contactLogsTitle}</td>
						<td>
				 			<fmt:formatDate value="${getcontactrecord.contactLogsTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				 		</td>
						
						<td>${getcontactrecord.customerId}</td>
						<td>${getcontactrecord.contactLogsContent}</td>
						<td>${getcontactrecord.companyId}</td>
						<td>
				 			<fmt:formatDate value="${getcontactrecord.contactLogsLastTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				 		</td>
				 		<td>
						<a href="getcontactrecord/get1?contactLogsId=${getcontactrecord.contactLogsId }">
									<img class="operation" src="img/update.png"></a> 
						<img class="operation delban" src="img/delete.png" onclick="deleteSa('${getcontactrecord.contactLogsId}')">
						</td>
						
						</tr>
						</c:forEach>				
					</table>
					<div class="paging" id="div" style="float:right"></div>
				
				</div>
				<!-- user 表格 显示 end-->
			</div>
			<!-- user页面样式end -->
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
				<a href="javascript:;" class="ok yes" id="sure">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
</body>

<script type="text/javascript">
// 广告弹出框
$(document).ready(function(){
	$(".delban").click(function(){
		  $(".banDel").show();
		});
		$(".close").click(function(){
		  $(".banDel").hide();
		});
		$(".no").click(function(){
		  $(".banDel").hide();
		});
});
	
// 广告弹出框 end

	function deleteSa(contactLogsId) 
	{
	
		document.getElementById("sure").href = 'getcontactrecord/del?contactLogsId=' + contactLogsId;	
	}
	function page()
	{
        var td = document.getElementById('div');
        if(${getcontactrecord.pageNum} != 1)
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '首页';
        	a.href = 'getcontactrecord/get?pn=1';
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
        
        if(${getcontactrecord.pageNum} <= 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(i+1 <= ${getcontactrecord.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = i + 1;
					a.href = 'getcontactrecord/get?pn=' + (i + 1);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${getcontactrecord.pageNum} == i+1)
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
				
			}
        }
        if(${getcontactrecord.pageNum} > 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(${getcontactrecord.pageNum}+i-5 <= ${getcontactrecord.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = ${getcontactrecord.pageNum}+i-5;
					a.href = 'getcontactrecord/get?pn=' + (${getcontactrecord.pageNum}+i-5);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${getcontactrecord.pageNum} == (${getcontactrecord.pageNum}+i-5))
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
			}
        }
        
        if(${getcontactrecord.pageNum } != ${getcontactrecord.pages})
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '尾页';
        	a.href = 'getcontactrecord/get?pn=' + ${getcontactrecord.pages};
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
	}
	</script>
</html>