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
	<link rel="stylesheet" href="css/qiandao_style.css">
	<script type="text/javascript" src="qqjs/vue.min.js"></script>
</head>

<body>
	
	<div class="pageTop">
		<div class="page">
			<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
			href="#">人事管理</a>&nbsp;-</span>&nbsp;工资核算
		</div>
	</div>

    <div class="qiandao-warp">
        <div class="qiandap-box">
            <!-- <div class="qiandao-banner">
                <img src="images/qiandao_banner.jpg" height="551" width="1120" alt="">
            </div> -->
            <div class="qiandao-con clear">
                <div class="qiandao-left">
                    <div class="qiandao-left-top clear">
                        <div class="current-date">2016年1月6日</div>
                        <div class="qiandao-history qiandao-tran qiandao-radius" id="js-qiandao-history">我的签到</div>
                    </div>
                    <div class="qiandao-main" id="js-qiandao-main">
                        <ul class="qiandao-list" id="js-qiandao-list">
                        </ul>
                    </div>
                </div>
                <div class="qiandao-right">
                    <div class="qiandao-top">
                        <div class="just-qiandao qiandao-sprits" id="js-just-qiandao">
                        </div>
                    </div>
                    
                    <div class="qiandao-bottom">
                        <div class="qiandao-rule-list">
                            <h4>签到规则</h4>
                            <p>每天上班前按时签到</p>
                            <p>每月每天按时签到，不迟到不早退，按制度分发全勤奖</p>
                            <p>请假手续不记录在签到日期内，仍按缺勤处理</p>
                        </div>
                        <div class="qiandao-rule-list">
                            <h4>其他说明</h4>
                            <p>对月末全勤奖以及工资有异议，可到财务部或人事部咨询</p>
                        </div>
                        <a class="qiandao-notic" href="" style="margin-left:100px">点击返回主页</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 我的签到 layer start -->
    <div class="qiandao-layer qiandao-history-layer" >
        <div class="qiandao-layer-con qiandao-radius" >
            <a href="javascript:;" class="close-qiandao-layer qiandao-sprits"></a>
            <ul class="qiandao-history-inf clear">
                <li>
                    <p>连续签到</p>
                    <h4>${conutInfo.signCounts}</h4>
                    <input type="hidden" value="${state}" id="sign_state">       	
                </li>
                <li>
                    <p>本月签到</p>
                    <h4 id="signNum1"></h4>
                </li>
               
            </ul>
            <div>
	            <c:forEach items="${signInfo}" var="sign">
	                 <input type="hidden" value="${sign.signDays}" class="signDays">       	
	            </c:forEach>
            </div>
            <div class="qiandao-history-table" style="overflow-y:auto;height:300px;">
                <table>
                    <thead>
                        <tr>
                            <th>签到日期</th>
                            <th>说明</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${signInfo}" var="sign">
                        	<tr class="signss">
                        		<td>
                        		<fmt:formatDate value="${sign.signTime}" pattern="yyyy年MM月dd日  HH:MM:ss"/>
                        		</td>
                        		<td>签到成功</td>
                        	</tr>
                        </c:forEach>
                    </table>
                </tbody>
            </div>
        </div>
        <div class="qiandao-layer-bg"></div>
    </div>
    <!-- 我的签到 layer end -->
    <!-- 签到 layer start -->
    <div class="qiandao-layer qiandao-active">
        <div class="qiandao-layer-con qiandao-radius">
            <a href="javascript:;" class="close-qiandao-layer qiandao-sprits"></a>
            <div class="yiqiandao clear">
                <div class="yiqiandao-icon qiandao-sprits"></div>您本月已签到
                <span id="sign_num"></span>天
            </div>
            
            <a href="sign/info" class="qiandao-share qiandao-tran">确定</a>
        </div>
        <div class="qiandao-layer-bg"></div>
    </div>
    <!-- 签到 layer end -->
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/qiandao_js.js"></script>
</body>

</html>
