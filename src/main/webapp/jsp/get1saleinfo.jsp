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
<title>添加销售详情表</title>
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
		

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				
				<!-- banner 表格 显示 -->
				<form action="saleinfo/update" method="post">
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						
						<tr>
							
							<td width="135px" class="tdColor" colspan="4">修改销售详情</td>
						</tr>
						<tr>
							<td width="135px" class="tdColor">销售详情编号</td>
							<td width="370px"><input type="text" style="width: 210px" readonly name="saleinfoId" value="${get1saleinfo.saleinfoId}" >
							</td>
							<td width="135px" class="tdColor"  >销售单编号</td>
							<td width="370px"><input type="text" style="width: 210px" name="saleoutId" value="${get1saleinfo.saleoutId }"></td>
						</tr>
						<tr>
							<td width="110px" class="tdColor">商品编号</td>
							<td width="300px"><input type="text" style="width: 210px"  name="goodsId" value="${get1saleinfo.goodsId }"></td>
							<td width="110px" class="tdColor">商品数量</td>
							<td width="30px"><input type="text" style="width: 210px" name="goodsNum" value="${get1saleinfo.goodsNum }"></td>
						</tr>
						
						
						<tr>
							<td width="110px" class="tdColor">商品价格</td>
							<td width="300px" ><input type="text" style="width: 210px;border: 1px solid none;padding-left: 5px;" name="goodsPrice" value="${get1saleinfo.goodsPrice }"></td>
						
			
							<td width="110px" class="tdColor">备注说明</td>
							<td width="300px" ><input type="text" style="width: 210px;border: 1px solid none;padding-left: 5px;" name="saleinfoRemarks" value="${get1saleinfo.saleinfoRemarks }"></td>
						
						</tr>
						<tr>
							
							<td width="110px" class="tdColor">公司编号</td>
							<td width="300px" ><input type="text" style="width: 210px;border: 1px solid none;padding-left: 5px;" name="companyId" value="${get1saleinfo.companyId }"></td>
							<td width="110px" class="tdColor">最后修改时间</td>
							<td width="300px"><input type="text" class="vinput mh_date" readonly="true" style="width: 210px"  name="saleinfoLastTime" value="${get1saleinfo.saleinfoLastTime }"></td>
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