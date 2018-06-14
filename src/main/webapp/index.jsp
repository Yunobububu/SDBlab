<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@include file="WEB-INF/views/jsp/taglib.jsp"%>
<html>
<head>

    <title>萨本栋实验预约平台</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

<head/>
<body>

    <div class="container">
        <form id="loginForm" method="post" action="login" class="form-horizontal">
            <fieldset>
                <legend><label><span class="glyphicon glyphicon-user">&nbsp;用户登录</span></label></legend>
                <div class="form-group" id="IDDiv">
                    <label class="col-md-3 control-label" for="ID">学号/工号:</label>
                    <div class="col-md-5">
                        <input id="ID" class="from-control" name="ID" type="text" placeholder="请输入用户名">
                    </div>
                    <div class="col-md-4" id="IDSpan"></div>
                </div>
                <div class="form-group" id="passwordDiv">
                    <label class="col-md-3 control-label" for="password">密码:</label>
                    <div class="col-md-5">
                        <input id="password" name="password" class="from-control" type="password" placeholder="请输入密码">
                    </div>
                    <div class="col-md-4" id="passwordSpan"></div>
                </div>


                <div class="form-group" id="buttonDiv">
                    <div class="col-md-5 col-md-offset-3">
                        <button type="submit" id="subBut"  class="btn btn-xs btn-primary">登录</button>
                        <button type="reset" id="rstBut" class="btn btn-xs btn-warning">重置</button>
                    </div>
                    <div class="col-md-4" id="butSpan"></div>
                </div>


            </fieldset>

        </form>
    </div>
    <a href="register">注册</a><br>
    <a href="testJquery">jqueryTest</a><br>


    <form action="query" method="post">
        <input type="text" name="ID" id="queryID" placeholder="查询ID">
        <input type="submit" value="查询" onclick="query()">
    </form>
    <script type="text/javascript" src="${ctx}/resources/js/jquery-1.8.3.js"></script>

    <script  type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script  type="text/javascript" src="${ctx}/resources/js/md5.js"></script>

    <!--禁止表单重复提交-->

    <script type="text/javascript">
        var btn = $("#subBut");
        /**
         * 绑定btn按钮的监听事件
         */

        alert(btn);
        var bindBtn = function(){
            btn.click(function(){
                // 需要先禁用按钮（为防止用户重复点击）
                btn.unbind('click');

                $.ajax({
                    // ..
                    type:"post",
                    data:{ID:"23214",password:"03042"},
                    url:"${ctx}/loginWithJson",
                    dataType:"json",
                    contentType:"application/json,charset=UTF-8"
                })
                    .done(function () {
                        alert('提交成功');
                        //成功，跳转
                    })
                    .fail(function () {
                        //失败，弹窗
                        alert('服务器错误');

                        // ** 重要：因为提交失败，所以要恢复提交按钮的监听 **
                        bindBtn();
                    });
            })
        }
    </script>
</body>
</html>
