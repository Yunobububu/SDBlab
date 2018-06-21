<%--
  Created by IntelliJ IDEA.
  User: lvjinke
  Date: 2018/6/20
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@include file="taglib.jsp"%>
<html>
<head>
    <title>抛光机预约</title>
    <meta charset="UTF-8" />
    <title>CVD预约</title>
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<table class="table table-bordered table-hover" style="margin-top:30px;">
    <caption>
        <h2 style="margin-top:40px; color:white;" align="center">抛光机预约</h2>
    </caption>
    <thead>
    <tr class="info">
        <td align="center" valign="middle">抛光机预约</td>
        <td colspan="5" align="center" valign="middle">可用时间</td>
        <td colspan="2" align="center" valign="middle">维护</td>
    </tr>
    </thead>
    <tbody>
    <tr class="success">
        <td align="center" valign="middle">星期</td>
        <td align="center" valign="middle">星期一</td>
        <td align="center" valign="middle">星期二</td>
        <td align="center" valign="middle">星期三</td>
        <td align="center" valign="middle">星期四</td>
        <td align="center" valign="middle">星期五</td>
        <td align="center" valign="middle">星期六</td>
        <td align="center" valign="middle">星期天</td>
    </tr>
    <tr class="success">
        <td rowspan="2" align="center" valign="middle">上午</td>
        <td align="center" valign="middle">
            <c:if test="${isPast[0]==true}">
                <span style="background-color: #e7c3c3">09:00-10:00</span>
            </c:if>
            <c:if test="${isOrdered[0]==false && isPast[0] == false}">
                <a href="/order?token=${param.token}&day=1&time=09:00:00&instrumentID=002">9:00-10:00</a>
            </c:if>
            <c:if test="${isPast[0]==false && isOrdered[0] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[4]==true}">
                <span style="background-color: #e7c3c3">09:00-10:00</span>
            </c:if>
            <c:if test="${isOrdered[4]==false && isPast[4] == false}">
                <a href="/order?token=${param.token}&day=2&time=09:00:00&instrumentID=002">9:00-10:00</a>
            </c:if>
            <c:if test="${isPast[4]==false && isOrdered[4] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[8]==true}">
                <span style="background-color: #e7c3c3">09:00-10:00</span>
            </c:if>
            <c:if test="${isOrdered[8]==false && isPast[8] == false}">
                <a href="/order?token=${param.token}&day=3&time=09:00:00&instrumentID=002">9:00-10:00</a>
            </c:if>
            <c:if test="${isPast[8]==false && isOrdered[8] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[12]==true}">
                <span style="background-color: #e7c3c3">09:00-10:00</span>
            </c:if>
            <c:if test="${isOrdered[12]==false && isPast[12] == false}">
                <a href="/order?token=${param.token}&day=4&time=09:00:00&instrumentID=002">9:00-10:00</a>
            </c:if>
            <c:if test="${isPast[12]==false && isOrdered[12] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[16]==true}">
                <span style="background-color: #e7c3c3">09:00-10:00</span>
            </c:if>
            <c:if test="${isOrdered[16]==false && isPast[16] == false}">
                <a href="/order?token=${param.token}&day=5&time=09:00:00&instrumentID=002">9:00-10:00</a>
            </c:if>
            <c:if test="${isPast[16]==false && isOrdered[16] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[20]==true}">
                <span style="background-color: #e7c3c3">09:00-10:00</span>
            </c:if>
            <c:if test="${isOrdered[20]==false && isPast[20] == false}">
                <a href="/order?token=${param.token}&day=6&time=09:00:00&instrumentID=002">9:00-10:00</a>
            </c:if>
            <c:if test="${isPast[20]==false && isOrdered[20] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td rowspan="2" align="center" valign="middle">维护</td>
    </tr>
    <tr class="success">
        <td align="center" valign="middle">
            <c:if test="${isPast[1]==true}">
                <span style="background-color: #e7c3c3">09:00-10:00</span>
            </c:if>
            <c:if test="${isOrdered[1]==false && isPast[1] == false}">
                <a href="/order?token=${param.token}&day=1&time=10:00:00&instrumentID=002">9:00-10:00</a>
            </c:if>
            <c:if test="${isPast[1]==false && isOrdered[1] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[5]==true}">
                <span style="background-color: #e7c3c3">10:00-11:00</span>
            </c:if>
            <c:if test="${isOrdered[5]==false && isPast[5] == false}">
                <a href="/order?token=${param.token}&day=2&time=10:00:00&instrumentID=002">10:00-11:00</a>
            </c:if>
            <c:if test="${isPast[5]==false && isOrdered[5] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[9]==true}">
                <span style="background-color: #e7c3c3">10:00-11:00</span>
            </c:if>
            <c:if test="${isOrdered[9]==false && isPast[9] == false}">
                <a href="/order?token=${param.token}&day=3&time=10:00:00&instrumentID=002">10:00-11:00</a>
            </c:if>
            <c:if test="${isPast[9]==false && isOrdered[9] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[13]==true}">
                <span style="background-color: #e7c3c3">10:00-11:00</span>
            </c:if>
            <c:if test="${isOrdered[13]==false && isPast[13] == false}">
                <a href="/order?token=${param.token}&day=4&time=10:00:00&instrumentID=002">10:00-11:00</a>
            </c:if>
            <c:if test="${isPast[13]==false && isOrdered[13] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[17]==true}">
                <span style="background-color: #e7c3c3">10:00-11:00</span>
            </c:if>
            <c:if test="${isOrdered[17]==false && isPast[17] == false}">
                <a href="/order?token=${param.token}&day=5&time=10:00:00&instrumentID=002">10:00-11:00</a>
            </c:if>
            <c:if test="${isPast[17]==false && isOrdered[17] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[21]==true}">
                <span style="background-color: #e7c3c3">10:00-11:00</span>
            </c:if>
            <c:if test="${isOrdered[21]==false && isPast[21] == false}">
                <a href="/order?token=${param.token}&day=6&time=10:00:00&instrumentID=002">10:00-11:00</a>
            </c:if>
            <c:if test="${isPast[21]==false && isOrdered[21] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
    </tr>
    <tr class="success">
        <td rowspan="2" align="center" valign="middle">下午</td>
        <td align="center" valign="middle">
            <c:if test="${isPast[2]==true}">
                <span style="background-color: #e7c3c3">14:00-15:00</span>
            </c:if>
            <c:if test="${isOrdered[2]==false && isPast[2] == false}">
                <a href="/order?token=${param.token}&day=1&time=14:00:00&instrumentID=002">14:00-15:00</a>
            </c:if>
            <c:if test="${isPast[2]==false && isOrdered[2] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[6]==true}">
                <span style="background-color: #e7c3c3">14:00-15:00</span>
            </c:if>
            <c:if test="${isOrdered[6]==false && isPast[6] == false}">
                <a href="/order?token=${param.token}&day=2&time=14:00:00&instrumentID=002">14:00-15:00</a>
            </c:if>
            <c:if test="${isPast[6]==false && isOrdered[6] == true}">
                <em style="background-color: crimson">已经预约</em>
            </c:if>
        </td><td align="center" valign="middle">
        <c:if test="${isPast[10]==true}">
            <span style="background-color: #e7c3c3">14:00-15:00</span>
        </c:if>
        <c:if test="${isOrdered[10]==false && isPast[10] == false}">
            <a href="/order?token=${param.token}&day=3&time=14:00:00&instrumentID=002">14:00-15:00</a>
        </c:if>
        <c:if test="${isPast[10]==false && isOrdered[10] == true}">
            <em style="background-color: crimson">已经预约</em>
        </c:if>
    </td><td align="center" valign="middle">
        <c:if test="${isPast[14]==true}">
            <span style="background-color: #e7c3c3">14:00-15:00</span>
        </c:if>
        <c:if test="${isOrdered[14]==false && isPast[14] == false}">
            <a href="/order?token=${param.token}&day=4&time=14:00:00&instrumentID=002">14:00-15:00</a>
        </c:if>
        <c:if test="${isPast[14]==false && isOrdered[14] == true}">
            <em style="background-color: crimson">已预约</em>
        </c:if>
    </td><td align="center" valign="middle">
        <c:if test="${isPast[18]==true}">
            <span style="background-color: #e7c3c3">14:00-15:00</span>
        </c:if>
        <c:if test="${isOrdered[18]==false && isPast[18] == false}">
            <a href="/order?token=${param.token}&day=5&time=14:00:00&instrumentID=002">14:00-15:00</a>
        </c:if>
        <c:if test="${isPast[18]==false && isOrdered[18] == true}">
            <em style="background-color: crimson">已预约</em>
        </c:if>
    </td><td align="center" valign="middle">
        <c:if test="${isPast[22]==true}">
        <span style="background-color: #e7c3c3">14:00-15:00</span>
        </c:if>
        <c:if test="${isOrdered[22]==false && isPast[22] == false}">
        <a href="/order?token=${param.token}&day=6&time=14:00:00&instrumentID=002">14:00-15:00</a>
        </c:if>
        <c:if test="${isPast[22]==false && isOrdered[22] == true}">
        <em style="background-color: crimson">已预约</em>
        </c:if>
        <td rowspan="2" align="center" valign="middle">维护</td>
    </tr>
    <tr class="success">
        <td align="center" valign="middle">
            <c:if test="${isPast[3]==true}">
                <span style="background-color: #e7c3c3">15:00-16:00</span>
            </c:if>
            <c:if test="${isOrdered[3]==false && isPast[3] == false}">
                <a href="/order?token=${param.token}&day=1&time=15:00:00&instrumentID=002">15:00-16:00</a>
            </c:if>
            <c:if test="${isPast[3]==false && isOrdered[3] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[7]==true}">
                <span style="background-color: #e7c3c3">15:00-16:00</span>
            </c:if>
            <c:if test="${isOrdered[7]==false && isPast[7] == false}">
                <a href="/order?token=${param.token}&day=2&time=15:00:00&instrumentID=002">15:00-16:00</a>
            </c:if>
            <c:if test="${isPast[7]==false && isOrdered[7] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[11]==true}">
                <span style="background-color: #e7c3c3">15:00-16:00</span>
            </c:if>
            <c:if test="${isOrdered[11]==false && isPast[11] == false}">
                <a href="/order?token=${param.token}&day=3&time=15:00:00&instrumentID=002">15:00-16:00</a>
            </c:if>
            <c:if test="${isPast[11]==false && isOrdered[11] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[15]==true}">
                <span style="background-color: #e7c3c3">15:00-16:00</span>
            </c:if>
            <c:if test="${isOrdered[15]==false && isPast[15] == false}">
                <a href="/order?token=${param.token}&day=4&time=15:00:00&instrumentID=002">15:00-16:00</a>
            </c:if>
            <c:if test="${isPast[15]==false && isOrdered[15] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[19]==true}">
                <span style="background-color: #e7c3c3">15:00-16:00</span>
            </c:if>
            <c:if test="${isOrdered[19]==false && isPast[19] == false}">
                <a href="/order?token=${param.token}&day=5&time=15:00:00&instrumentID=002">15:00-16:00</a>
            </c:if>
            <c:if test="${isPast[19]==false && isOrdered[19] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>
        <td align="center" valign="middle">
            <c:if test="${isPast[23]==true}">
                <span style="background-color: #e7c3c3">15:00-16:00</span>
            </c:if>
            <c:if test="${isOrdered[23]==false && isPast[23] == false}">
                <a href="/order?token=${param.token}&day=6&time=15:00:00&instrumentID=002">15:00-16:00</a>
            </c:if>
            <c:if test="${isPast[23]==false && isOrdered[23] == true}">
                <em style="background-color: crimson">已预约</em>
            </c:if>
        </td>

    </tr>
    </tbody>
</table>
</body>
</html>
