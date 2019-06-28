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
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="inc/mainll.jsp">首页</a>&nbsp;&nbsp;&nbsp;-</span>&nbsp;人事管理
			</div>
		</div>

		<div class="page">
			<!-- answer页面样式 -->
			<div class="wish">
				<div class="conform">
					<form action="mangePerson/info" method="post">
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
							<td width="100px" class="tdColor" style="color:black;">员工性别</td>
							<td width="200px" class="tdColor" style="color:black;">身份证号</td>
							<td width="100px" class="tdColor" style="color:black;">学历</td>
							<td width="200px" class="tdColor" style="color:black;">联系电话</td>
							<td width="100px" class="tdColor" style="color:black;">所在部门</td>
							<td width="100px" class="tdColor" style="color:black;">职务</td>
							<td width="130px" class="tdColor" style="color:black;">职务调整</td>
						</tr>
						<c:forEach items="${employ.list}" var="employ">
							<tr>
								<td width="120px" class="tdColor tdC">${employ.employName}</td>
								<td width="100px" class="tdColor">${employ.employSex}</td>
								<td width="200px" class="tdColor">${employ.employIdentify}</td>
								<td width="100px" class="tdColor">${employ.employEducation}</td>
								<td width="200px" class="tdColor">${employ.employPhone}</td>
								<td width="100px" class="tdColor">${employ.jobBean.deparmentBean.deptName}</td>
								<td width="100px" class="tdColor">${employ.jobBean.jobName}</td>
								<td width="130px" class="tdColor" style="color:black;">
									<img class="operation delban" src="img/update.png" onclick="change_job()">
								</td>
								
							</tr>
						</c:forEach>
					</table>
					<div class="page" style="height: 50px; margin-top: 30px;line-height: 50px;border-bottom:1px solid grey;">
				        <a href="mangePerson/info" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	首页
				        </a>
				     	<a href="javascript:send(${employ.pageNum })" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	上一页
				       	</a>
				        <a href="mangePerson/info?pn=${employ.nextPage}" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
				        	下一页
				        </a>
				        <a href="mangePerson/info?pn=${employ.pages }" style="display: inline-block;margin-right: 5px;width: 80px;height: 30px;text-align: center;line-height: 30px;text-decoration: none;background-color: white;border:1px solid rgb(4,129,255);">
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
				<select id="first" name="deptName" class="job_change" onchange="setSecond(this.value)" style="with:120px;height: 30px;margin-left:-50px;margin-top: 20px">
					<option>部门选择</option>
				</select>
				<select id="second" name="jobName" style="with:120px;height: 30px;"></select>
				<p class="delP2">
					<input type="button" id="smt" class="ok yes" value="确定"  style="text-align:center;width: 100px;">
					<a class="ok no" style="text-align:center;width: 100px;">取消</a>
				</p>
		</div>
	</div>
	<!-- 回复框  end-->
</body>

<script type="text/javascript">
 
/* function setSecond(value){
	  var val = value;
	  if(val == "主管部门"){
	    var sec = document.getElementById('second');
	    sec.options.length=0; //清空二级菜单项
	    sec.options[0] = new Option("总经理","总经理");
	    sec.options[1] = new Option("秘书长","秘书长");
	    sec.options[2] = new Option("秘书","秘书");
	  }
	  else if(val == "开发部门")
	  {
	    var sec = document.getElementById('second');
	    sec.options.length=0; //清空二级菜单项
	    sec.options[0] = new Option("项目总监","项目总监");
	    sec.options[1] = new Option("开发组长","开发组长");
	    sec.options[2] = new Option("开发组员","开发组员");
	  }
	  else{
		  var sec = document.getElementById('second');
		    sec.options.length=0; //清空二级菜单项
	  }
	} */

function send(pn)
{
	location.href = 'mangePerson/info?pn='+(pn-1);	
}

var deptdata = null;
function change_job()
{
	//查询职务与部门信息
	$.ajax({
        type:'post',
        url:'job/selectJobAndDept',
        data:{},
        dataType:'json',
        success:function(result)
        {
        	showDept(result);
        	deptdata = result;
        },
        error:function()
        {
            alert('系统繁忙');
        }
			
        });
}

function showDept(depts)
{
	var first = $('#first');
	for (var i = 0; i < depts.length; i++) {
		var dept = depts[i];
		var op = $('<option value='+dept.deptNumber+' >'+dept.deptName+'</option>');
		first.append(op);	
	}
}

function setSecond(value)
{
	for (var i = 0; i < deptdata.length; i++) {
		var dept = deptdata[i];
		if(dept.deptNumber == value)
		{
			var jobs = dept.jobList;
			var second = $('#second');
			second.html('');
			for (var j = 0; j < jobs.length; j++) {
				var job = jobs[j];
				var op = $('<option value='+job.jobId+' >'+job.jobName+'</option>');
				second.append(op);	
			} 
		}
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

$("#smt").click(function(){
	var employId = $('#first').val();
	var jobId = $("#second").val();
	
   var data = {
		   jobId:jobId,
		   employId:employId
   };
	console.log(data.jobName);

	 $.ajax({
        type:'post',
        url:'mangePerson/updateJob',
        data:{jobId:jobId,employId:employId},
        dataType:'json',
        success:function()
        {
        	location.href="mangePerson/info";
        	
        },
        error:function()
        {
            alert('系统繁忙');
        }
			
        });
	 
  }); 


// 广告弹出框 end
</script>
</html>