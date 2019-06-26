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
			
		</div>

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				
				<!-- banner 表格 显示 -->
				<form action="feedback/update" method="post">
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						
						<tr>
							
							<td width="135px" class="tdColor" colspan="4">添加客户反馈信息</td>
						</tr>
						<tr>
							<td width="135px" class="tdColor">反馈编号</td>
							<td width="370px"><input type="text" style="width: 210px" readonly name="feedbackId" value="${get1feedback.feedbackId }" >
							</td>
							<td width="135px" class="tdColor"  >客户编号</td>
							<td width="370px"><input type="text" style="width: 210px" name="customerId" value="${get1feedback.customerId }"></td>
						</tr>
						<tr>
							<td width="110px" class="tdColor">公司编号</td>
							<td width="300px"><input type="text" style="width: 210px"  name="companyId" value="${get1feedback.companyId }"></td>
							<td width="110px" class="tdColor">反馈状态</td>
							<td width="300px"><input type="text" style="width: 210px" name="feedbackState" value="${get1feedback.feedbackState }" ></td>
						</tr>
						<tr>
							
							<td width="110px" class="tdColor">反馈类型</td>
							<td width="30px"><input type="text" style="width: 210px" name="feedbackType" value="${get1feedback.feedbackType }"></td>
							<td width="110px" class="tdColor">反馈时间</td>
							<td width="300px"><input type="text" class="vinput mh_date" readonly="true" style="width: 210px"  name="feedbackTime" value="${get1feedback.feedbackTime }"></td>
						</tr>
						
						<tr>
							<td width="110px" class="tdColor">反馈内容</td>
							<td width="300px" ><input type="text" style="width: 210px;border: 1px solid none;padding-left: 5px;" name="feedbackContent" value="${get1feedback.feedbackContent }"></td>
						
			
							<td width="110px" class="tdColor">反馈原因</td>
							<td width="300px" ><input type="text" style="width: 210px;border: 1px solid none;padding-left: 5px;" name="feedbackReason" value="${get1feedback.feedbackReason }"></td>
						
						</tr>

						<tr>
							<td width="110px" class="tdColor">负责人</td>
							<td width="300px"><input type="text" style="width: 210px" name="feedbackCharge" value="${get1feedback.feedbackCharge }"></td>
							<td width="110px" class="tdColor">反馈主题</td>
							<td width="300px"><input type="text" style="width: 210px" name="feedbackTitle" value="${get1feedback.feedbackTitle }"></td>
						</tr>
						<tr>
							
							<td width="110px" class="tdColor">最后修改时间</td>
							<td width="300px"><input type="text" class="vinput mh_date" readonly="true" style="width: 210px"  name="feedbackLastTime" value="${get1feedback.feedbackLastTime }"></td>
							<td width="110px" class="tdColor">分析</td>
							<td width="300px"><input type="text" style="width: 210px" name="feedbackAnalyse" value="${get1feedback.feedbackAnalyse }"></td>
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