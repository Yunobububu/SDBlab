<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>用户注册</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

    <head/>
<body>

<div class="container">
    <form id="registerForm" method="post" action="registerSub" class="form-horizontal">
        <fieldset>
            <legend><label><span class="glyphicon glyphicon-user">&nbsp;用户注册</span></label></legend>
            <div class="form-group" id="midDiv">
                <label class="col-md-3 control-label" for="ID">学号/工号:</label>
                <div class="col-md-5">
                    <input id="ID" name="ID" class="from-control" type="text" placeholder="请输入学号/工号">
                </div>
                <div class="col-md-4" id="midSpan"></div>
            </div>
            <div class="form-group" id="nameDiv">
                <label class="col-md-3 control-label" for="ID">姓名:</label>
                <div class="col-md-5">
                    <input id="name" name="name" class="from-control" type="text" placeholder="请输入姓名">
                </div>
                <div class="col-md-4" id="nameSpan"></div>
            </div>
            <div class="form-group" id="passwordDiv">
                <label class="col-md-3 control-label" for="password">密码:</label>
                <div class="col-md-5">
                    <input id="password" name="password" class="from-control" type="password" placeholder="请输入密码">
                </div>
                <div class="col-md-4" id="passwordSpan"></div>
            </div>
            <div class="form-group" id="conpswDiv">
                <label class="col-md-3 control-label" for="conpsw">再次输入密码:</label>
                <div class="col-md-5">
                    <input id="conpsw" name="conpsw" class="from-control" type="password" placeholder="请再次输入密码">
                </div>
                <div class="col-md-4" id="conpswSpan"></div>
            </div>
            <div class="form-group" id="emailDiv">
                <label class="col-md-3 control-label" for="email">邮箱:</label>
                <div class="col-md-5">
                    <input id="email" name="email" class="from-control" type="text" placeholder="请输入邮箱">
                </div>
                <div class="col-md-4" id="emailSpan"></div>
            </div>
            <div class="form-group" id="roleDiv">
                <label class="col-md-3 control-label" >我是:</label>
                    <div class="col-md-5">
                        <label class="radio-inline">
                            <input type="radio" id="inlineCheckbox1" name="role" value="0"> 学生
                        </label>
                        <label class="radio-inline">
                            <input type="radio" id="inlineCheckbox2" name="role" value="1"> 工程师
                        </label>
                        <label class="radio-inline">
                            <input type="radio" id="inlineCheckbox3" name="role" value="2"> 指导老师
                        </label>
                    </div>
                <div class="col-md-4" id="roleSpan"></div>
            </div>
          
            <div class="form-group" id="buttonDiv">
                <div class="col-md-5 col-md-offset-3">
                    <button type="submit" id="subBut" class="btn btn-xs btn-primary">提交</button>
                </div>
                <div class="col-md-4" id="butSpan"></div>
            </div>


        </fieldset>

    </form>
</div>
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"/>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"/>
<script type="text/javascript">

</script>
</body>
</html>
