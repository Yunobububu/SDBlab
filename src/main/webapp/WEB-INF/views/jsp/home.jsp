<%--
  Created by IntelliJ IDEA.
  User: lvjinke
  Date: 2018/6/12
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglib.jsp"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>sbd平台导航</title>
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home/myOrder?token=${param.token}">我的预约</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home/CVD?token=${param.token}&instrumentID=001">CVD</a></li>
                <li><a href="/home/Polisher?token=${param.token}&instrumentID=002">抛光机</a></li>
            </ul>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout?token=${param.token}">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<table class="table table-bordered table-hover" style="margin-top:30px;">
    <thead>
    <tr class="info">
        <td colspan="6" align="center" valign="middle">我的预约</td>
    </tr>
    </thead>
    <tbody>
    <tr class="success">

        <td align="center" valign="middle">仪器名称</td>
        <td align="center" valign="middle">开始时间</td>
        <td align="center" valign="middle">结束时间</td>
        <td align="center" valign="middle">价格</td>
        <td align="center" valign="middle">预约状态</td>
        <td align="center" valign="middle">删除</td>
    </tr>
    <c:forEach var="order" items="${ViewsList}">
        <tr class="success">
            <td align="center" valign="middle">${order.instrumentName}</td>
            <td align="center" valign="middle">${order.startTime}</td>
            <td align="center" valign="middle">${order.endTime}</td>
            <td align="center" valign="middle">${order.price}</td>
            <c:if test="${order.status == 0}">
                <td align="center" valign="middle" style="background-color: #ec971f">待审核</td>
            </c:if>
            <c:if test="${order.status == 1}">
                <td align="center" valign="middle" style="background-color: green">已通过</td>
            </c:if>
            <c:if test="${order.status == 0}">
                <td align="center" valign="middle">
                    <span style="background-color: red">
                        <a href="/order/delete?token=${token}&orderID=${order.orderID}">
                            删除
                        </a>
                    </span>
                </td>
            </c:if>
            <c:if test="${order.status == 1}">
                <td align="center" valign="middle" style="background-color: green">已通过</td>
            </c:if>
        </c:forEach>
    </tr>
    </tbody>
</table>
<script type="text/javascript" src="${ctx}/resources/js/jquery-1.8.3.js"></script>
</body>
</html>
