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
<title>一个月为联系</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/manhuaDate.1.0.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/manhuaDate.1.0.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
	<script type="text/javascript">
$(function (){
  $("input.mh_date").manhuaDate({
    Event : "click",//可选               
    Left : 0,//弹出时间停靠的左边位置
    Top : -16,//弹出时间停靠的顶部边位置
    fuhao : "-",//日期连接符默认为-
    isTime : false,//是否开启时间值默认为false
    beginY : 1949,//年份的开始默认为1949
    endY :2100//年份的结束默认为2049
  });
});
</script>
</head>

<body onload="page()">
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;意见管理
			</div>
		</div>

		<div class="page">
			<!-- vip页面样式 -->
			<div class="vip">
				
				<!-- vip 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						
						
						<tr>
						
					
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
							
							<td width="300px" class="tdColor">修改时间</td>
							<td width="300px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${getonemonthday.list}" var="today1">		
				 		<tr>
				
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
				 		
				 		<td>
				 			<fmt:formatDate value="${today1.customerUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				 		</td>
				 		
				 		<td> <img class="operation delban" src="img/delete.png" onclick="deleteSa('${today1.customerId}')"></td>
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

	function deleteSa(customerId) 
	{
		
		document.getElementById("sure").href = 'today/delmm?customerId=' + customerId;	
	}
	function page()
	{
        var td = document.getElementById('div');
        if(${getonemonthday.pageNum} != 1)
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '首页';
        	a.href = 'today/getonemonthday?pn=1';
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
        
        if(${getonemonthday.pageNum} <= 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(i+1 <= ${getonemonthday.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = i + 1;
					a.href = 'today/getonemonthday?pn=' + (i + 1);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${getonemonthday.pageNum} == i+1)
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
				
			}
        }
        if(${getonemonthday.pageNum} > 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(${getonemonthday.pageNum}+i-5 <= ${getonemonthday.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = ${getonemonthday.pageNum}+i-5;
					a.href = 'today/getonemonthday?pn=' + (${getonemonthday.pageNum}+i-5);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${getonemonthday.pageNum} == (${getonemonthday.pageNum}+i-5))
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
			}
        }
        
        if(${getonemonthday.pageNum } != ${getonemonthday.pages})
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '尾页';
        	a.href = 'today/getonemonthday?pn=' + ${getonemonthday.pages};
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
	}
	</script>
</html>s