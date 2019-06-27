<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>"> 
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>添加角色</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script src="js/vue.js"></script>

<style>
*{
	box-sizing: border-box;
	margin: 0;padding: 0;
}
*:before,*:after{
	box-sizing: border-box;
}
ul,
li {
	list-style: none;
}

.l_tree_container {
	width: 100%;
	height: 100%;
	box-shadow: 0 0 3px #ccc;
	margin: 13px;
	position: relative;
}

.l_tree {
	width: calc(100% - 44px);
	height: 100%;
	padding-left: 42px;
}
.l_tree_branch {
	width: 100%;
	height: 100%;
	display: block;
	padding: 13px;
	position: relative;
}

.l_tree_branch .l_tree_children_btn {
	width: 19px;
	height: 19px;
	background-color: #23b1f0;
	font-size: 14px;
	text-align: center;
	color: #ffffff;
	outline: none;
	border: 0;
	cursor: pointer;
	position: relative;
}

ul.l_tree:before {
	content: '';
	border-left: 1px dashed #999999;
	height: calc(100%);
	position: absolute;
	left: 10px;
	top: 0px;
}

.l_tree .l_tree_branch:last-child::before {
	content: '';
	width: 3px;
	height: calc(100% - 24px);
	display: block;
	background-color: #ffffff;
	position: absolute;
	bottom: 0;
	left: -34px;
}

.l_tree,
.l_tree_branch {
	position: relative;
}

.l_tree_branch::after {
	content: '';
	width: 40px;
	height: 0;
	border-bottom: 1px dashed #000;
	position: absolute;
	right: calc(100% - 9px);
	top: 22px;
}

.l_tree_container>.l_tree::before,
.l_tree_container>.l_tree>.l_tree_branch::after {
	display: none;
}

.myinputs
{
	width: 17px;
	height:17px;
	position: absolute;
	top:1px;
	left:1px;
}
</style>

</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="javascript:;">角色管理</a>&nbsp;-&nbsp;</span>&nbsp;添加角色
			</div>
		</div>
		<div class="page ">
			<div id="demo">
				<div class="l_tree_container">
					<ul class="l_tree">
			            <li class="l_tree_branch" v-for="item in model" :key="item.id">
			                <div class="l_tree_click">
			                    <button type="button" class="l_tree_children_btn" ><input id="totalPMS" onclick="mychangeto()" type="checkbox" name="mypermission" class="myinputs"></button>
			                    <span class="l_folder">系统权限</span>
			                </div>
			                <c:forEach items="${requestScope.permissionList }" var="permission" varStatus="s">
				                <ul class="l_tree">
						            <li class="l_tree_branch" v-for="item in model" :key="item.id">
						                <div class="l_tree_click">
						                    <button type="button" class="l_tree_children_btn" ><input id="PMS${s.index+1 }" onclick="mychange(${s.index+1 })" type="checkbox" name="result" value="${permission.permissionNumber }"  class="myinputs"></button>
						                    <span class="l_folder">${permission.permissionName }</span>
						                </div>
						                <c:forEach items="${permission.pmsInfoBean }" var="permission1" varStatus="s1">
							                <ul class="l_tree">
									            <li class="l_tree_branch" v-for="item in model" :key="item.id">
									                <div class="l_tree_click">
									                    <button type="button" class="l_tree_children_btn" ><input id="PMS${s.index+1 }_${s1.index+1 }"  onclick="mychange2(${s.index+1 },${s1.index+1 })" type="checkbox" name="result" value="${permission1.permissionNumber }"  class="myinputs"></button>
									                    <span class="l_folder">${permission1.permissionName }</span>
									                </div>
									                <c:forEach items="${permission1.pmsInfoBean }" var="permission2" varStatus="s2">
										                <ul class="l_tree">
												            <li class="l_tree_branch" v-for="item in model" :key="item.id">
												                <div class="l_tree_click">
												                    <button type="button" class="l_tree_children_btn" ><input id="PMS${s.index+1 }_${s1.index+1 }_${s2.index+1 }" onclick="mychange3()" type="checkbox" name="result" value="${permission2.permissionNumber }"  class="myinputs"></button>
												                    <span class="l_folder">${permission2.permissionName }</span>
												                </div>
												                
												            </li>
												        </ul>
											        </c:forEach>
									            </li>
									        </ul>
								        </c:forEach>
						            </li>
						        </ul>
					        </c:forEach>
			            </li>
			        </ul>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript">
	function mychange(k)
	{
		var one = document.getElementById('PMS'+k);
		for(var i = 1; i < 100; i++)
		{
			var two = document.getElementById('PMS'+k+'_'+i);
			if(two != null)
			{
				if(one.checked)
				{
					two.checked = true;
				}
				else
				{
					two.checked = false;
				}
				
				for(var j = 1; j < 100; j++)
				{
					var three = document.getElementById('PMS'+k+'_'+i+'_'+j);
					if(three != null)
					{
						if(two.checked)
						{
							three.checked = true;
						}
						else
						{
							three.checked = false;
						}
					}
					else
					{
						break;
					}
				}
			}
			else
			{
				break;
			}
		}
		
		for(var k = 1; k < 100; k++)
		{
			var one = document.getElementById('PMS'+k);
			if(one != null)
			{
				if(one.checked)
				{
					document.getElementById('totalPMS').checked = true;
				}
			}
			else
			{
				break;
			}
		}	
	}
	
	function mychange2(k,i)
	{
		var two = document.getElementById('PMS'+k+'_'+i);
		for(var j = 1; j < 100; j++)
		{
			var three = document.getElementById('PMS'+k+'_'+i+'_'+j);
			if(three != null)
			{
				if(two.checked)
				{
					three.checked = true;
				}
				else
				{
					three.checked = false;
				}
			}
			else
			{
				break;
			}
		}
		
		for(var k = 1; k < 100; k++)
		{
			var one = document.getElementById('PMS'+k);
			if(one != null)
			{
				for(var i = 1; i < 100; i++)
				{
					var two = document.getElementById('PMS'+k+'_'+i);
					if(two != null)
					{
						if(two.checked)
						{
							var one = document.getElementById('PMS'+k);
							one.checked = true;
							document.getElementById('totalPMS').checked = true;
						}
					}
					else
					{
						break;
					}
				}
			}
			else
			{
				break;
			}
		}	
	}
	
	function mychange3()
	{
		for(var k = 1; k < 100; k++)
		{
			var one = document.getElementById('PMS'+k);
			if(one != null)
			{
				for(var i = 1; i < 100; i++)
				{
					var two = document.getElementById('PMS'+k+'_'+i);
					if(two != null)
					{
						for(var j = 1; j < 100; j++)
						{
							var three = document.getElementById('PMS'+k+'_'+i+'_'+j);
							if(three != null)
							{
								if(three.checked)
								{
									var two = document.getElementById('PMS'+k+'_'+i);
									two.checked = true;
									var one = document.getElementById('PMS'+k);
									one.checked = true;
									document.getElementById('totalPMS').checked = true;
								}
							}
							else
							{
								break;
							}
						}
					}
					else
					{
						break;
					}
				}
			}
			else
			{
				break;
			}
		}	
	}
	
	function mychangeto()
	{
		var total = document.getElementById('totalPMS');
		for(var k = 1; k < 100; k++)
		{
			var one = document.getElementById('PMS'+k);
			if(one != null)
			{
				if(total.checked)
				{
					one.checked = true;
				}
				else
				{
					one.checked = false;
				}
				for(var i = 1; i < 100; i++)
				{
					var two = document.getElementById('PMS'+k+'_'+i);
					if(two != null)
					{
						if(total.checked)
						{
							two.checked = true;
						}
						else
						{
							two.checked = false;
						}
						for(var j = 1; j < 100; j++)
						{
							var three = document.getElementById('PMS'+k+'_'+i+'_'+j);
							if(three != null)
							{
								if(total.checked)
								{
									three.checked = true;
								}
								else
								{
									three.checked = false;
								}
							}
							else
							{
								break;
							}
						}
					}
					else
					{
						break;
					}
				}
			}
			else
			{
				break;
			}
		}	
	}
</script>


</body>
</html>