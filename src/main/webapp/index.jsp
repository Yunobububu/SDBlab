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
        <form id="loginForm" method="post" action="" class="form-horizontal">
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
                <div class="form-group" id="roleDiv">
                    <label class="col-md-3 control-label" for="password">我是:</label>
                        <div class="col-md-5">
                            <label class="radio-inline">
                                <input type="radio"  id="stuRadio" name="role" value="3" checked="checked">学生
                            </label>
                            <label class="radio-inline">
                                <input type="radio"  id="tutorRadio" name="role" value="2">工程师
                            </label>
                            <label class="radio-inline">
                                <input type="radio"  id="engRadio" name="role" value="1">指导老师
                            </label>
                            <label class="radio-inline">
                                <input type="radio"  id="sysRadio" name="role" value="0">管理员
                            </label>
                        <div class="col-md-4" id="roleSpan"></div>
                </div>

                <div class="form-group" id="buttonDiv">
                    <div class="col-md-5 col-md-offset-3">
                        <button type="button" id="subBut"  class="btn btn-xs btn-primary" onclick="return false">登录</button>
                        <button type="reset" id="rstBut" class="btn btn-xs btn-warning">重置</button>
                    </div>
                    <div class="col-md-4" id="butSpan"></div>
                </div>
            </fieldset>
        </form>
    </div>
    <a href="register">注册</a><br>
    <a href="queryStudent?ID=33520141152417">查询学生</a><br>

    <a href="testJquery">jqueryTest</a><br>

    <div class="col-md-5 col-md-offset-3">
        <button type="button" id="quesBut"  class="btn btn-xs btn-primary" onclick="return false">登录</button>
    </div>


    <form action="query" method="post">
        <input type="text" name="ID" id="queryID" placeholder="查询ID">
        <input type="submit" value="查询" onclick="query()">
    </form>
    <script type="text/javascript" src="${ctx}/resources/js/jquery-1.8.3.js"></script>

    <script  type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script  type="text/javascript" src="${ctx}/resources/js/md5.js"></script>

    <!--禁止表单重复提交,对提交按钮进行监听,验证通过后跳到home页,否则弹出密码错误-->
    <script type="text/javascript" src="${ctx}/resources/js/index.js?v=${v}"></script>
    <script type="text/javascript" src="${ctx}/resources/js/answer.js?v=${v}"></script>

    <!--答题测试-->
    <script type="text/javascript">

    </script>
</body>
</html>
