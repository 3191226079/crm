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
<base  href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>销售联系人</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body onload="page()">
	<div id="pageAll">
		<div >
			
		</div>

		<div class="page">
			<!-- topic页面样式 -->
			<div class="topic">
				<div class="conform">
					<form>
						
						
					</form>
				</div>
				<!-- topic表格 显示 -->
				<div class="conShow">
				<div class="butrr">
						<!-- <div class="buttopr">
							<a href="jsp/addcontacts.jsp" >添加</a>
						</div>	 -->
					</div>
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							
							
							<td width="150px" class="tdColor">联系人姓名</td>
							
							<td width="150px" class="tdColor">联系人职务</td>
							
							<td width="150px" class="tdColor">联系人部门</td>
							<td width="150px" class="tdColor">联系人手机</td>
							<td width="150px" class="tdColor">联系人办公电话</td>
							<td width="150px" class="tdColor">联系人电子邮件</td>
							<td width="150px" class="tdColor">联系人地址</td>
							<td width="150px" class="tdColor">备注</td>
							
							<td width="150px" class="tdColor">最后修改时间</td>
							<td width="150px" class="tdColor">操作</td>
							
						</tr>
						<c:forEach items="${selectAll.list}" var="customerlose">
						<tr>
						
						<td>${customerlose.contactsName }</td>
						<td>${customerlose.contactsPost }</td>
						<td>${customerlose.contactsDepartment }</td>
						<td>${customerlose.contactsPhone }</td>
						<td>${customerlose.contactsOficePhone }</td>
						<td>${customerlose.contactsEmail }</td>
						<td>${customerlose.contactsAddress }</td>
						<td>${customerlose.contactsRemarks }</td>
					
						
						<td>
				 			<fmt:formatDate value="${customerlose.contactsTime }" pattern="yyyy-MM-dd HH:mm:ss" />
				 		</td>
				 		
						<td>
							<a href="contacts/get2?contactsId=${customerlose.contactsId }">
								<img class="operation" src="img/update.png">
							</a>
						</td>
						</tr>
						
						
						
						</c:forEach>
						
						
						<!-- <tr>
							<td>1</td>
							<td>
								<div class="onsImg">
									<img src="img/banimg.png">
								</div>
								<p class="topicP">
									某某话题<img class="topicImg" src="img/topic.png">
								</p>
							</td>
							<td>山下就只</td>
							<td>CEO</td>
							<td>南京设疑网络科技公司哈哈哈</td>
							<td>110W</td>
							<td>总监</td>
							<td>2015-12-12 12.12</td>
							<td>未审核</td>
							<td>否</td>
							<td><a href="connoisseuradd.html"><img class="operation"
									src="img/update.png"></a> <img class="operation delban"
								src="img/delete.png"></td>
						</tr> -->
					</table>
					<div class="paging" id="div" style="float:right"></div>
				</div>
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


function page()
	{
        var td = document.getElementById('div');
        if(${selectAll.pageNum} != 1)
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '首页';
        	a.href = 'contacts/get?pn=1';
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
        
        if(${selectAll.pageNum} <= 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(i+1 <= ${selectAll.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = i + 1;
					a.href = 'contacts/get?pn=' + (i + 1);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${selectAll.pageNum} == i+1)
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
				
			}
        }
        if(${selectAll.pageNum} > 6)
        {
        	for (var i = 0; i < 10; i++) 
        	{
				if(${selectAll.pageNum}+i-5 <= ${selectAll.pages})
				{
					var a = document.createElement('a');
					a.innerHTML = ${selectAll.pageNum}+i-5;
					a.href = 'contacts/get?pn=' + (${selectAll.pageNum}+i-5);
					td.appendChild(a);
					a.style = 'display = block ;width: 50px; text-align: center; font-size: 20px; height: 40px; line-height: 40px;';
					a.style.float = 'left';
					
					if(${selectAll.pageNum} == (${selectAll.pageNum}+i-5))
					{
						a.style.color = 'red';
						a.href = 'javascript:;'
						a.style.textDecoration = 'none';
					}
				}
			}
        }
        
        if(${selectAll.pageNum } != ${selectAll.pages})
       	{
        	var a = document.createElement('a');
        	a.innerHTML = '尾页';
        	a.href = 'contacts/get?pn=' + ${selectAll.pages};
        	td.appendChild(a);
        	a.style = 'display = block; border-style: solid; width: 60px; text-align: center; height: 40px; font-size: 15px; line-height: 40px;';
        	a.style.float = 'left';
       	}
	}
	</script>
</html>
