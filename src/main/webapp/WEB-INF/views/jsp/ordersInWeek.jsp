<%--
  Created by IntelliJ IDEA.
  User: lvjinke
  Date: 2018/6/21
  Time: 上午8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>

<body>
<table class="table table-bordered table-hover" style="margin-top:30px;">
    <thead>
    <tr class="info">
        <td colspan="8" align="center" valign="middle">预约管理</td>
    </tr>
    </thead>
    <tbody>
    <tr class="success">

        <td align="center" valign="middle">预约人</td>
        <td align="center" valign="middle">仪器名称</td>
        <td align="center" valign="middle">开始时间</td>
        <td align="center" valign="middle">结束时间</td>
        <td align="center" valign="middle">价格</td>
        <td align="center" valign="middle">预约状态</td>
        <td align="center" valign="middle">删除</td>
        <td align="center" valign="middle">审核</td>
    </tr>
    <c:forEach var="order" items="${viewsList}">
    <tr class="success">
        <td align="center" valign="middle">${order.studentName}</td>
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
        <c:if test="${order.status == 0}">
            <td align="center" valign="middle">
                    <span style="background-color: red">
                        <a href="/order/pass?token=${token}&orderID=${order.orderID}">
                            通过
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
<span id="order_total" style="float: left"></span>
<nav style="float: right" aria-labe="Page navigation">   <!-- 翻页按钮的代码  -->
    <ul class="pagination" id="page">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
<script type="text/javascript" src="${ctx}/resources/js/jquery-1.8.3.js"></script>

</body>
</html>
