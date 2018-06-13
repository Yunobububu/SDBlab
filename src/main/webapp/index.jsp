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
    <a href="register">注册</a>
    <form action="query" method="post">
        <input type="text" name="ID" id="queryID" placeholder="查询ID">
        <input type="submit" value="查询">
    </form>
    <script type="text/javascript">
        //请求json，输出是json
        $(function(){
            //1k67u85916.51mypc.cn:33579
            var prefixUrl="localhost:8080";
            $("#subBut").click(function(){
                alert('sjfldjls');
                $.ajax({
                    type:"post",
                    data:$("#loginForm").serialize(),
                    url:"http://"+prefixUrl+"/loginWithJson",
                    dataType:"json",
                    cache:false,
                    success:function(data){
                        alert(data);
                    }
                })
            })
        })
    </script>
    <script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"/>
    <script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"/>
    <script type="text/javascript" src="resources/js/md5.js"/>
</body>
</html>
