<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>萨本栋实验预约平台</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

<head/>
<body>

    <div class="container">
        <form id="loginForm" method="post" action="login" class="form-horizontal">
            <fieldset>
                <legend><label><span class="glyphicon glyphicon-user">&nbsp;用户登录</span></label></legend>
                <div class="form-group" id="midDiv">
                    <label class="col-md-3 control-label" for="mid">用户名:</label>
                    <div class="col-md-5">
                        <input id="mid" class="from-control" type="text" placeholder="请输入用户名">
                    </div>
                    <div class="col-md-4" id="midSpan"></div>
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
                        <button type="submit" id="subBut" class="btn btn-xs btn-primary">登录</button>
                        <button type="reset" id="rstBut" class="btn btn-xs btn-warning">重置</button>
                    </div>
                    <div class="col-md-4" id="butSpan"></div>
                </div>


            </fieldset>

        </form>
    </div>
    <a href="register">注册</a>
    <script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"/>
    <script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"/>
</body>
</html>
