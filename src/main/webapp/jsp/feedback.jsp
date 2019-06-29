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
<title>用户反馈</title>
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
			
		
			<div>
			
			<div class="butrr">
					<!-- 	<div class="buttopr">
							<a href="jsp/addfeedback.jsp" >添加</a>
						</div> -->	
				</div>				
			</div>
		
		<div class="page">
			<!-- vip 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">						
						<tr>
					
							

							 <td width="200px" class="tdColor">客户姓名</td> 
							
							<td width="200px" class="tdColor">反馈状态</td>
			
							<td width="200px" class="tdColor">反馈类型</td>
							
							<td width="200px" class="tdColor">反馈时间</td>
				
							<td width="200px" class="tdColor">反馈原因</td>
							
							<td width="200px" class="tdColor">负责人</td>
							
						
						
							<td width="200px" class="tdColor">反馈主题</td>
							
							<td width="200px" class="tdColor">反馈内容</td>
							
							<td  class="tdColor" width="200px" >分析</td>
							<td width="200px" class="tdColor" >最后修改时间</td>
							<td width="200px" class="tdColor" >操作</td>
							</tr>
							
							<c:forEach items="${getfeedback.list}" var="getfeed">
							<tr>
						
						
							<td>${getfeed.customerBean.customerName}</td>
							<td>${getfeed.feedbackState}</td>
							<td>${getfeed.feedbackType}</td>
							<td>
				 			<fmt:formatDate value="${getfeed.feedbackTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				 			</td>
							
							
							<td>${getfeed.feedbackReason}</td>
							<td>${getfeed.feedbackCharge}</td>
							<td>${getfeed.feedbackTitle}</td>
							<td>${getfeed.feedbackContent}</td>
							<td>${getfeed.feedbackAnalyse}</td>
							<td>
				 			<fmt:formatDate value="${getfeed.feedbackLastTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				 			</td>
						
							<td>
						<a href="feedback/get1?feedbackId=${getfeed.feedbackId }">
						<img class="operation" src="img/update.png"></a> 
						
						
						<img class="operation delban" src="img/delete.png" onclick="deleteSa('${getfeed.feedbackId}')">
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

	function deleteSa(feedbackId) 
	{
		
		document.getElementById("sure").href = 'feedback/del?feedbackId=' + feedbackId;	
	}
	
	function page()
	{
        var td = document.getElementById('div');
        if(${getfeedback.pageNum} != 1)
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '首页';
        	a.href = 'feedback/getfeedback?pn=1';
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
        
        if(${getfeedback.pageNum} <= 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(i+1 <= ${getfeedback.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = i + 1;
					a.href = 'feedback/getfeedback?pn=' + (i + 1);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${getfeedback.pageNum} == i+1)
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
				
			}
        }
        if(${getfeedback.pageNum} > 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(${getfeedback.pageNum}+i-5 <= ${getfeedback.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = ${getfeedback.pageNum}+i-5;
					a.href = 'feedback/getfeedback?pn=' + (${getfeedback.pageNum}+i-5);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${getfeedback.pageNum} == (${getfeedback.pageNum}+i-5))
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
			}
        }
        
        if(${getfeedback.pageNum } != ${getfeedback.pages})
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '尾页';
        	a.href = 'feedback/getfeedback?pn=' + ${getfeedback.pages};
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
	}
	</script>
</html>