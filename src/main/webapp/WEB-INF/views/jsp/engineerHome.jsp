<%--
  Created by IntelliJ IDEA.
  User: lvjinke
  Date: 2018/6/20
  Time: 下午10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglib.jsp"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>实验室管理</title>
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div style="width: 100%">
        <!-- 左侧菜单栏 -->
        <div id="main-container">
            <div id="sidebar" class="col-md-2 column">
                <!-- 创建菜单树 -->
                <div class="col-md-12">

                    <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">

                        <li><a href="#"><i class="glyphicon glyphicon-user"></i>我的信息</a></li>

                        <li><a href="order/queryOrdersInWeek?token=${token}"><i class="glyphicon glyphicon-search"></i>预约管理</a></li>

                        <li><a href="instrument/update?token=${token}"><i class="glyphicon glyphicon-cog"></i>设备维护</a></li>

                    </ul>

                </div>
            </div>

        </div><!-- /.main-container -->
    </div>




    <a href="javascript:exportExcel();">导出为Excel</a>
    <script type="text/javascript">
        function exportExcel(){
            window.open('testExcel.jsp?exportToExcel=YES');
        }

    </script>
    <script src="${ctx}/resources/js/jquery-1.8.3.js"></script>
    <script src="${ctx}/resources/bootstrap/js/bootstrap.js"></script>
</body>
</html>
