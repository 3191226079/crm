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
                        <p class="qiandao-notic">请每天按时签到</p>
                    </div>
                    <c:forEach items="${signInfo }" var="signInfo">
                    	<input type="hidden" value="${signDays}" class="signDays">
                    </c:forEach>
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
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 我的签到 layer start -->
    <div class="qiandao-layer qiandao-history-layer">
        <div class="qiandao-layer-con qiandao-radius" id="signum">
            <a href="javascript:;" class="close-qiandao-layer qiandao-sprits"></a>
            <ul class="qiandao-history-inf clear">
                <li>
                    <p>连续签到</p>
                    <h4>5</h4>
                </li>
                <li>
                    <p>本月签到</p>
                    <h4>{{number}}</h4>
                </li>
                <li>
                    <p>总共签到数</p>
                    <h4>28</h4>
                </li>
                <li>
                    <p>签到累计奖励</p>
                    <h4>30</h4>
                </li>
            </ul>
            <div class="qiandao-history-table">
                <table>
                    <thead>
                        <tr>
                            <th>签到日期</th>
                            <th>奖励</th>
                            <th>说明</th>
                        </tr>
                    </thead>
                    <table>
                        <tr>
                            <td>2016-1-6 14:23:45</td>
                            <td>0.20</td>
                            <td>连续签到19天奖励</td>
                        </tr>
                        <tr>
                            <td>2016-1-6 14:23:45</td>
                            <td>0.20</td>
                            <td>分享奖励</td>
                        </tr>
                        <tr>
                            <td>2016-1-6 14:23:45</td>
                            <td>0.20</td>
                            <td>连续签到19天奖励</td>
                        </tr>
                        <tr>
                            <td>2016-1-6 14:23:45</td>
                            <td>0.20</td>
                            <td>连续签到19天奖励</td>
                        </tr>
                        <tr>
                            <td>2016-1-6 14:23:45</td>
                            <td>0.20</td>
                            <td>连续签到19天奖励</td>
                        </tr>
                        <tr>
                            <td>2016-1-6 14:23:45</td>
                            <td>0.20</td>
                            <td>连续签到19天奖励</td>
                        </tr>
                        <tr>
                            <td>2016-1-6 14:23:45</td>
                            <td>0.20</td>
                            <td>连续签到19天奖励</td>
                        </tr>
                        <tr>
                            <td>2016-1-6 14:23:45</td>
                            <td>0.20</td>
                            <td>连续签到19天奖励</td>
                        </tr>
                    </table>
                </table>
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
                <div class="yiqiandao-icon qiandao-sprits"></div>您本月已签到<span>2</span>天
            </div>
            
            <a href="#" class="qiandao-share qiandao-tran">分享获取双倍收益</a>
        </div>
        <div class="qiandao-layer-bg"></div>
    </div>
    <!-- 签到 layer end -->
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/qiandao_js.js"></script>
</body>

</html>
