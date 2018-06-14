<%--
  Created by IntelliJ IDEA.
  User: lvjinke
  Date: 2018/6/14
  Time: 上午9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglib.jsp"%>
<html>
<head>
    <script type="text/javascript" src="${ctx}/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
            function sendJson() {
                alert(0);
                $.ajax({
                    type:"post",
                    url:"${ctx}/Json",
                    data:'{"id":"1","name":"电冰箱","price":"1999"}',
                    contentType:"application/json;charset=utf-8",
                    success:function(data) {
                        alert(data);
                    }
                });
            }
    </script>
    <title>JqueryTest</title>
</head>
<body>
        <h1 id="h1">hello</h1>
        <button onclick="sendJson()">json数据交互测试</button>


</body>
</html>


