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
<title></title>
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
				<form action="customerlose/update1" method="post">
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
						</tr>
						<tr>
							
							<td width="135px" class="tdColor" colspan="4">更改流失客户信息</td>
						</tr>
						<tr>
							<td width="135px" class="tdColor">流失客户编码</td>
							<td width="370px"><input type="text" style="width: 210px" name="customerLoseId" readonly value="${selectcustomerlose.customerLoseId }" >
							</td>
							<td width="135px" class="tdColor"  >客户编码</td>
							<td width="370px"><input type="text" style="width: 210px" name="customerId" value="${selectcustomerlose.customerId }"></td>
						</tr>
						<tr>
							<td width="110px" class="tdColor">操作人员编号</td>
							<td width="300px"><input type="text" style="width: 210px"  name="customerLoseOperation" value="${selectcustomerlose.customerLoseOperation }"></td>
							<td width="110px" class="tdColor">处理方式</td>
							<td width="300px"><input type="text" style="width: 210px" name="customerLosePromethods" value="${selectcustomerlose.customerLosePromethods}" ></td>
						</tr>
						<tr>
							
							<td width="110px" class="tdColor">流失状态</td>
							<td width="30px"><input type="text" style="width: 210px" name="customerLoseSate" value="${selectcustomerlose.customerLoseSate }"></td>
							<td width="110px" class="tdColor">公司编号</td>
							<td width="300px"><input type="text" style="width: 210px"  name="companyId" value="${selectcustomerlose.companyId }"></td>
						</tr>
						<tr>
							<td width="110px" class="tdColor">最后更改时间</td>
							<td width="300px"><input type="text" class="vinput mh_date" readonly="true" style="width: 210px"  name="customerLoseLastTime" value="${selectcustomerlose.customerLoseLastTime}"></td>
						
						</tr>
				
					</table>
					<input type="submit" value="确认" style="width: 
				     200px;height:40px; color: #438eb9; margin-left: 410px"  >

					<div class="paging">此处是分页</div>
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