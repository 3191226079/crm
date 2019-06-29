<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工添加</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<style type="text/css">
table
{
	border: 0px;
	border-collapse: collapse;
}
tr{
	height: 60px;
}
td{
	border:0px;
}
.myri{
	text-align: right;
}
.myle{
	text-align: left;
}
</style>
<script type="text/javascript">
function show(obj)
{
	var f = obj.files[0];
	var reader = new FileReader();
	reader.readAsDataURL(f);
	reader.onload = function(){
		var r = this.result;
		document.getElementById("myimg134").src = r;
	}
}
</script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="javascript:;">用户管理</a>&nbsp;-&nbsp;</span>&nbsp;添加用户
			</div>
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="bor">
				<div class="baTopNo">
					<span>员工注册</span>
				</div>
				<form action="employ/addEmploy" method="post" id="myform143" enctype="multipart/form-data">
					<div class="baBody">
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;头像：
							<div class="vipHead" style="position: relative;">
								<input type="file" onchange="show(this)" name="uploadImg" style="width: 100px;height: 97px;opacity:0;position: absolute;" > 
								<img id="myimg134" alt="" src="img/personhead.png" style="width: 100px;height: 97px">
							</div>
							
						</div>
						<table>
							<tr class="bbD">
								<td class="myri">用户名：</td>
								<td class="myle"><input type="text" name="userName" class="input3" /></td>
							</tr>
							<tr class="bbD">
								<td class="myri">员工姓名：</td>
								<td class="myle"><input type="text" name="employName" class="input3" /></td>
							</tr>
							<tr class="bbD">
								<td class="myri">性别：</td>
								<td class="myle"><input type="radio" name="employSex" checked value="1" style="width:18px;height:18px;margin-left: 10px;"/>&nbsp;男
							<input type="radio" name="employSex" value="0" style="width:18px;height:18px;" />&nbsp;女</td>
							</tr>
							<tr class="bbD">
								<td class="myri">身份证：</td>
								<td class="myle"><input type="text" name="employIdentify" class="input3" /></td>
							</tr>
							<tr class="bbD">
								<td class="myri">员工地址：</td>
								<td class="myle"><input type="text" name="employAddress" class="input3" /></td>
							</tr>
							<tr class="bbD">
								<td class="myri">学历：</td>
								<td class="myle">
									<select name="employEducation"  class="input3">
										<option value="专科">专科
										<option value="本科">本科
										<option value="硕士">硕士
										<option value="博士">博士
									</select>
								</td>
							</tr>
							<tr class="bbD">
								<td class="myri">政治面貌：</td>
								<td class="myle">
									<select name="employPolitic"  class="input3">
										<option value="群众">群众
										<option value="团员">团员
										<option value="党员">党员
									</select>
								</td>
							</tr>
							<tr class="bbD">
								<td class="myri">毕业学校：</td>
								<td class="myle"><input type="text" name="employSchool" class="input3" /></td>
							</tr>
							<tr class="bbD">
								<td class="myri">联系电话：</td>
								<td class="myle"><input type="text" name="employPhone" class="input3" /></td>
							</tr>
							<tr class="bbD">
								<td class="myri">职位：</td>
								<td class="myle">
									<select name="jobId"  class="input3">
										<c:forEach items="${requestScope.jobList }" var="jobBean">
											<option value="${jobBean.jobId }">${jobBean.jobName }
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="bbD">
								<td class="myri" style="color:red;">选择角色：</td>
								<td class="myle">
									<select name="roleNumber"  class="input3">
										<c:forEach items="${requestScope.roleList }" var="roleBean">
											<option value="${roleBean.roleNumber }">${roleBean.roleName }
										</c:forEach>
									</select>
								</td>
							</tr>
						</table>
						
						
						<div class="bbD">
							<p class="bbDP">
								<button class="btn_ok btn_yes" onclik="javascript:function(){document.getElementById('myform143').submit();};">提交</button>
								<a class="btn_ok btn_no" href="inc/mainll.jsp">取消</a>
							</p>
						</div>
					</div>
				</form>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>