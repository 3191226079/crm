<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <link rel="stylesheet" type="text/css" href="css/css.css" />   
    <title>添加</title>        
 </head>
 <body>
 	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;产品信息及库存信息
			</div>
		</div>

		<div class="page">
			<!-- wish页面样式 -->
			<div class="wish">
				<div class="conform">
					<form>
						<div class="cfD">
							<!--时间： <input class="vinput" type="text" />&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="vinput" type="text" /> --> <input class="addUser"
								type="text" placeholder="请输入产品信息" />
							<button class="button">搜索</button>
						</div>
					</form>
				</div>
				<!-- wish 表格 显示 -->
				<div class="wishShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">产品编号</td>
							<td width="200px" class="tdColor">产品名称</td>
							<td width="175px" class="tdColor">产品类型</td>
							<td width="185px" class="tdColor">单位</td>
							<td width="180px" class="tdColor">仓库编号</td>
							<td width="175px" class="tdColor">仓库数量</td>
							<td width="155px" class="tdColor">成本价</td>
							<td width="175px" class="tdColor">零售价</td>
							<td width="230px" class="tdColor">经销价</td>
							<td width="130px" class="tdColor">备注信息</td>
							<td width="130px" class="tdColor">公司编号</td>
							<td width="130px" class="tdColor">最后修改时间</td>
						</tr>
						<!-- <tr>
							<td>A001</td>
							<td><div class="onsImg wishImgv">
									<img src="img/userPICS.png">
								</div></td>
							<td>冰箱</td>
							<td>家电</td>
							<td>75L</td>
							<td>京东襄阳店</td>
							<td><div class="onsImg">
									<img src="img/userPICS.png">
								</div>
									
								襄阳F001</td>
							<td>35台</td>
							<td>1200元</td>
							<td>1750元</td>
							<td>1550元</td>
							<td>备注信息</td>
							<td>jdA01</td>
							<td>2019-03-02</td>
							<td><img class="operation delban" src="img/delete.png"></td>
						</tr> -->
					</table>
					<div class="paging">此处是分页</div>
				</div>
				<!-- wish 表格 显示 end-->
			</div>
			<!-- wish页面样式end -->
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