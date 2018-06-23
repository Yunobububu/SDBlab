<%--
  Created by IntelliJ IDEA.
  User: lvjinke
  Date: 2018/6/21
  Time: 下午2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglib.jsp"%>

<html>
<head>
    <title>指导老师页面</title>
    <meta charset="UTF-8">
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/resources/bootstrap/css/toastr.css" type="text/css" rel="stylesheet">
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
                <li><a href="/home/Polisher?token=${param.token}&instrumentID=002">
                    抛光机
                </a></li>
            </ul>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout"><i class="glyphicon glyphicon-log-out">退出</i></a></li>
            </ul>
        </div>
    </div>
</nav>
<div>
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#order" aria-controls="order" role="tab" data-toggle="tab">我的预约</a></li>
        <li role="presentation"><a href="#people_minute" aria-controls="people_minute" role="tab" data-toggle="tab">CVD预约</a></li>
        <li role="presentation" ><a href="#total_chart" aria-controls="total_chart" role="tab" data-toggle="tab">抛光机预约</a></li>
        <li role="presentation" ><a href="#realtime_chart" aria-controls="realtime_chart" role="tab" data-toggle="tab">光刻机预约</a></li>
        <li role="presentation"><a href="/order/exportExcel?token=${token}&tutorID=20120000">导出excel</a>
        </li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="order">
            <br>
            <p>
                请选择订单日期: <input type="text" id="datepicker" class="datepicker"> &nbsp;
                <button  class="btn btn-info" type="button" onclick="get_data(this)">确定查询</button>
            </p>
            <div id="order_detail" style="display: none">   <!-- 只在这个div内的table里更新数据 -->
                <table id="order_detail_table" class="display table  table-hover" >
                    <thead >
                    <tr id="order_first_tr">
                        <th data-field="ordered_by" >预约人</th>
                        <th data-field="instrument_name" >预约仪器</th>
                        <th data-field="order_start_time" >开始时间</th>
                        <th data-field="order_end_time" >结束时间</th>
                        <th data-field="order_price" >价格</th>
                    </tr>
                    </thead>
                </table>
                <span id="order_total" style="float: left"></span>
                <nav style="float: right" aria-label="Page navigation">   <!-- 翻页按钮的代码  -->
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
            </div>
        </div>
        <div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/resources/js/jquery-1.8.3.js"></script>
<script  type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/toastr.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/tutorOrder.js?v=${v}">

</script>
</html>
