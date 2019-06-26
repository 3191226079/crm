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
	<style type="text/css">
		.tdColor{
			height: 40px;
			background-color: #f2f2f2;
			color: #438eb9;
		}
	</style>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">人事管理</a>&nbsp;-</span>&nbsp;工资核算
			</div>
		</div>

		<div class="page">
			<!-- answer页面样式 -->
			<div class="wish">
				<div class="conform">
					<form action="mangePerson/salary" method="post">
						<div class="cfD" style="margin-left: 100px;">
							&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="addUser" type="text" placeholder="请输入员工姓名" name="content"/>
							<button class="button" type="submit">搜索</button>
						</div>
					</form>
				</div>
				<!-- wish 表格 显示 -->
				<div class="wishShow" style="margin-left: 100px;">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120px" class="tdColor" style="color:black;">员工姓名</td>
							<td width="80px" class="tdColor"  style="color:black;">员工性别</td>
							<td width="150px" class="tdColor" style="color:black;">身份证号</td>
							<td width="150px" class="tdColor" style="color:black;">联系电话</td>
							<td width="100px" class="tdColor" style="color:black;">签到/天</td>
							<td width="100px" class="tdColor" style="color:black;">缺勤/天</td>
							<td width="100px" class="tdColor" style="color:black;">全勤奖/元</td>
							<td width="100px" class="tdColor" style="color:black;">应发工资/元</td>
							<td width="130px" class="tdColor" style="color:black;">实发工资/元</td>
							<td width="100px" class="tdColor" style="color:black;">加/降薪</td>
						</tr>
						<c:forEach items="${employ.list}" var="employ">
							<tr>
								<td width="120px" class="tdColor tdC">${employ.employName}</td>
								<td width="80px" class="tdColor">${employ.employSex}</td>
								<td width="150px" class="tdColor">${employ.employIdentify}</td>
								<td width="150px" class="tdColor">${employ.employPhone}</td>
								<td width="100px" class="tdColor">${employ.signCount }</td>
								<td width="100px" class="tdColor">${employ.littleCount }</td>
								<c:if test="${employ.littleCount ==0}">
									<td width="100px" class="tdColor_a" style="background-color: rgb(242,242,242);color: #438eb9;">200</td>
								</c:if>
								<c:if test="${employ.littleCount !=0}">
									<td width="175px" class="tdColor_a" style="background-color: rgb(242,242,242);color: #438eb9;">0</td>
								</c:if>
								
								<td width="100px" class="tdColor_b" style="background-color: rgb(242,242,242);color: #438eb9;">${employ.employSalary}</td>
								<td width="130px" class="tdColor_r"  style="background-color: rgb(242,242,242);color: #438eb9;"></td><!-- 实发工资 -->
								<td width="100px" class="tdColor">
									<img class="operation delban" src="img/update.png" onclick="change_job(${employ.employId})">
							    </td>
							</tr>
						</c:forEach>
					</table>
					<div class="page" style="height:50px; margin-top: 30px;line-height: 50px;border-bottom:1px solid grey;">
				        <a href="mangePerson/salary" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	首页
				        </a>
				     	<a href="javascript:send(${employ.pageNum })" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	上一页
				       	</a>
				        <a href="mangePerson/salary?pn=${employ.nextPage}" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	下一页
				        </a>
				        <a href="mangePerson/salary?pn=${employ.pages }" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
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
	<div class="banDel">
		<div class="delete">
			<div class="close">
				<a><img src="img/shanchu.png" /></a>
			</div>
				<input type="text" name="salary" placeholder="输入员工工资" id="salary_int" class="delP1">
				<p class="delP2">
					<input type="button" id="smt" class="ok yes" value="确定"  style="text-align:center;width: 100px;">
					<a class="ok no" style="width: 100px;">取消</a>
				</p>
		</div>
	</div>
	<!-- 回复框  end-->
</body>

<script type="text/javascript">


function send(pn)
{
	location.href = 'mangePerson/salary?pn='+(pn-1);	
}

var employId = '';
function change_job(employ_id)
{
	employId = employ_id;
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

$("#smt").click(function(){
	var employSalary = $("#salary_int").val();
	 $.ajax({
        type:'post',
        url:'mangePerson/updateJob',
        data:{employSalary:employSalary,employId:employId},
        dataType:'json',
        success:function()
        {
        	location.href="mangePerson/salary";
        	
        },
        error:function()
        {
            alert('系统繁忙');
        }
			
        });
	 
  }); 

// 广告弹出框 end
	$(document).ready(function(){
		var begin_salary = $(".tdColor_b");
		var add_salary = $(".tdColor_a");
		var real_salary = $(".tdColor_r");
		for (var i = 0; i < begin_salary.length; i++) {
			var sum = parseInt($(begin_salary[i]).html()) + parseInt($(add_salary[i]).html());
			$(real_salary[i]).html(sum);
		}
	});
		

</script>
</html>