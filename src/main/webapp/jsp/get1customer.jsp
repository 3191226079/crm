<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sc.crmsys.bean.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>潜在客户</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />

<link rel="stylesheet" type="text/css" href="css/manhuaDate.1.0.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/manhuaDate.1.0.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
	<script type="text/javascript">
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
<script type="text/javascript">
$(function (){
  $("input.mh_date").manhuaDate({
    Event : "click",//可选               
    Left : 0,//弹出时间停靠的左边位置
    Top : -16,//弹出时间停靠的顶部边位置
    fuhao : "/",//日期连接符默认为-
    isTime : false,//是否开启时间值默认为false
    beginY : 1949,//年份的开始默认为1949
    endY :2100//年份的结束默认为2049
  });
});
</script>

</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;意见管理
			</div>
		</div>

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				
				<!-- banner 表格 显示 -->
				<form action="add1/update1" method="post">
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<!-- <tr>
							<td width="66px" class="tdColor tdC">序号</td>
							<td width="170px" class="tdColor">头像</td>
							<td width="135px" class="tdColor">姓名</td>
							<td width="145px" class="tdColor">手机号码</td>
							<td width="140px" class="tdColor">所在城市</td>
							<td width="140px" class="tdColor">任职机构</td>
							<td width="145px" class="tdColor">行家头衔</td>
							<td width="150px" class="tdColor">本周预约次数</td>
							<td width="140px" class="tdColor">可约时段</td>
							<td width="140px" class="tdColor">审核状态</td>
							<td width="150px" class="tdColor">是否推荐</td>
							<td width="130px" class="tdColor">操作</td>
						</tr> -->
						<tr>
							
							<td width="135px" class="tdColor" colspan="4">修改客户信息</td>
						</tr>
						
						
						<tr>
						
							<td width="300px"><input type="hidden"  style="width: 210px" autocomplete="off" name="customerId" value="${get1.customerId }"></td>
							
							
							
							
						</tr>
						<tr>
						
							<td width="110px" class="tdColor">上级单位</td>
							<td width="300px"><input type="text" style="width: 210px" autocomplete="off" name="customerUpDepartment" value="${get1.customerUpDepartment }"></td>
							<td width="110px" class="tdColor">负责人</td>
							<td width="300px"><input type="text" style="width: 210px" autocomplete="off"  name="customerContactPerson" value="${get1.customerContactPerson }" ></td>
						</tr>
						<tr>
							
							<td width="110px" class="tdColor">客户状态</td>
							<td width="30px"><input type="text" style="width: 210px" name="customerState" value="${get1.customerState }"></td>
							<td width="110px" class="tdColor">客户电话</td>
							<td width="300px"><input type="text" style="width: 210px" autocomplete="off" name="customerPhone" id="phone" onblur="checkPhone()" value="${get1.customerPhone }"></td>
						</tr>
						<tr>
							<td width="110px" class="tdColor">客户地址</td>
							<td width="250px" colspan="3"><input type="text" autocomplete="off" style="width: 650px;border: 1px solid none;padding-left: 5px;" name="customerAddress" value="${get1.customerAddress }"></td>
						
						</tr>

						<tr>
							<td width="110px" class="tdColor">客户传真</td>
							<td width="300px"><input type="text" style="width: 210px" autocomplete="off" name="customerFax" id="fax" onblur="checkfax()" value="${get1.customerFax }"></td>
							<td width="110px" class="tdColor">客户邮箱</td>
							<td width="300px"><input type="text" style="width: 210px" name="customerEmail" autocomplete="off" id="email"  onblur="checkemail()" value="${get1.customerEmail }"></td>
						</tr>
						<tr>
						
						
						<%
						CustomerBean activeBean = (CustomerBean)request.getAttribute("get1");
						Date activeStartTime = activeBean.getCustomerContactTime();
						SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
						String date = simpleDateFormat1.format(activeStartTime);
						%>
							
							<td width="110px" class="tdColor">联系时间</td>
							<td width="300px"> <input type="text" class="vinput mh_date"  readonly="true" style="width: 210px"  name="customerContactTime" value="${get1.customerContactTime }"> </td>
							<td width="110px" class="tdColor">备注信息</td>
							<td width="300px"><input type="text" style="width: 210px" name="customerInfo" value="${get1.customerInfo }"></td>
						</tr>
						<tr>
							<td width="135px" class="tdColor"  >客户名字</td>
							<td width="370px"><input type="text" style="width: 210px" name="customerName" autocomplete="off" value="${get1.customerName }"></td>
							<td width="110px" class="tdColor">修改时间</td>
							<td width="300px"> <input type="text" class="vinput mh_date" readonly="true" style="width: 210px" name="customerUpdateTime" value="${get1.customerUpdateTime }"> </td>
						</tr>
					
					</table>
					<input type="submit" value="确认" style="width: 
				     200px;height:40px; color: #438eb9; margin-left: 410px"  >

					
				</div>
			</form>

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
				<a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div>
	<!-- 删除弹出框  end-->
</body>

<script type="text/javascript">

function checkPhone(){ 
    var phone = document.getElementById('phone').value;
    if(!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(phone))){ 
        alert("手机号码有误，请重填");  
        return false; 
    } 
}


function checkfax(){ 
    var fax = document.getElementById('fax').value;
    if(!/^(\d{3,4}-)?\d{7,8}$/.test(fax)){ 
        alert("传真有误，请重填");  
        return false; 
    } 
}


function checkemail(){ 
    var email1 = document.getElementById('email').value;
    if(!/^\w+([-\.]\w+)*@\w+([\.-]\w+)*\.\w{2,4}$/.test(email1)){ 
        alert("邮箱有误，请重填");  
        return false; 
    } 
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
// 广告弹出框 end
</script>
</html>