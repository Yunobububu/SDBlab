<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="taglib.jsp"%>
<html>
<head>

    <title>用户注册</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <head/>
<body>

<div class="container">
    <form id="registerForm" method="post" action="" class="form-horizontal">
        <fieldset>
            <legend><label><span class="glyphicon glyphicon-user">&nbsp;用户注册</span></label></legend>

            <div class="form-group" id="roleDiv">
                <label class="col-md-3 control-label" >我是:</label>
                <div class="col-md-5">
                    <label class="radio-inline">
                        <input type="radio" id="inlineCheckbox1" name="role" value="3"> 学生
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="inlineCheckbox2" name="role" value="2"> 工程师
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="inlineCheckbox3" name="role" value="1"> 指导老师
                    </label>
                </div>
                <div class="col-md-4" id="roleSpan"></div>
            </div>
            <div class="form-group" id="IDDiv">
                <label class="col-md-3 control-label" for="ID">学号/工号:</label>
                <div class="col-md-5">
                    <input id="ID" name="ID" class="from-control" type="text" placeholder="请输入学号/工号"><span id="IDSpan"></span>
                </div>
                <div class="col-md-4" />
            </div>
            <div class="form-group" id="nameDiv">
                <label class="col-md-3 control-label" for="name">姓名:</label>
                <div class="col-md-5">
                    <input id="name" name="name" class="from-control" type="text" placeholder="请输入姓名"><span id="nameSpan"></span>
                </div>
                <div class="col-md-4"></div>
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

            <div class="form-group" id="buttonDiv">
                <div class="col-md-5 col-md-offset-3">
                    <button type="button" id="subBut" class="btn btn-xs btn-primary" onclick="return false">注册</button>
                    <button type="reset" id="rstBut" class="btn btn-xs btn-warning">重置</button>
                </div>
                <div class="col-md-4" id="butSpan"></div>
            </div>
        </fieldset>

    </form>
</div>
<script type="text/javascript" src="${ctx}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/md5.js"></script>
<script type="text/javascript">
    <!--用户注册时使用ajax进行验证-->
    //检测ID是否已经被注册
    var flagOne = false;
    var flagTwo = false;
    var flagThree = false;
    var flagFour = false;
    var flagFive = false;
    $("#ID").blur(
        function () {
            var userID = $("#ID").val();
            var reg = new RegExp("^[0-9]*$");
            if($.trim(userID) == "" || !reg.test($("#ID").val())){
                alert("用户名不能为空且只能是工号或学号");
                return false;
            }
            var role = $('input[name="role"]:checked').val();
            var jsonData = {userID:userID,role:role};
            $.ajax({
                type:"POST",
                url:"registerIDCheck",
                dataType:"json",
                data:JSON.stringify(jsonData),
                contentType:"application/json;charset=UTF-8",
                success:function (data) {
                    if(data.code == -1){
                        //回传的是json对象,可以直接用data.field 获取属性的值
                        $("#IDSpan").html("<em style='font-family: color:red'>用户ID已经存在</em>");
                    }else{
                        flagOne = true;
                        $("#IDSpan").html("<em style='font-family: color:green'>用户名可用</em>");
                    }
                }
            });
        }
    )
    <!--校验用户名是否已被注册-->
    $("#name").blur(
        function () {
            var userName = $("#name").val();
            if($.trim(userName) == "" ){
                alert("用户名不能为空");
                return false;
            }
            var role = $('input[name="role"]:checked').val();
            var jsonData = {userName:userName,role:role};
            $.ajax({
                type:"POST",
                url:"registerUserNameCheck",
                dataType:"json",
                data:JSON.stringify(jsonData),
                contentType:"application/json;charset=UTF-8",
                success:function (data) {
                    if(data.code == -1){
                        //回传的是json对象,可以直接用data.field 获取属性的值
                        $("#nameSpan").html("<em style='font-family: color:red'>用户名已经存在</em>");
                    }else{
                        flagTwo = true;
                        $("#nameSpan").html("<em style='font-family: color:green'>用户名可用</em>");
                    }
                }
            });
        }
    );
    <!--密码要大于6位且不为空-->
    $("#password").blur(
        function () {
            var psw = $("#password").val();
            if($.trim(psw) == ""){
                alert("密码不能为空");
                return false;
            }
            if(psw.length < 6 ){
                alert("密码要大于6位");
                return false;
            }
            flagThree = true;
        }
    );
    <!--校验密码输入是否一致-->
    $("#conpsw").blur(
        function () {
            var conpsw = $("#conpsw").val();
            var psw = $("#password").val();
            if(conpsw != psw){
                alert("两次密码不一致,请重新输入");
                return false;
            }
            flagFour = true;
        }

    );
    <!--校验邮箱-->
    $("#email").blur(
        function () {
            var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*" +
                "@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
            var email = $("#email").val();
            if($.trim(email) == ""){
                alert("请输入邮箱");
                return false;
            }
            if(!reg.test(email)){
                alert("非法邮箱");
                return false;
            }
            flagFive=true;
        }
    );
    <!--监听提交按钮-->
    $(function () {
        $("#subBut").click(
            function () {
                var role = $('input[name="role"]:checked').val();
                var userName = $("#name").val();
                var psw = $("#password").val();
                var email = $("#email").val();
                var md5Psw = $.md5(psw);
                var userID = $("#ID").val();
                var uri = "http://localhost:8080/"
                var JSONdata = {
                    userName:userName,
                    role:role,
                    userID:userID,
                    password:md5Psw,
                    email:email
                };
                var url ="http://localhost:8080/registerUpdate";
                if(!(flagOne && flagTwo && flagThree && flagFive && flagFive)){
                    alert("输入有误");
                    return false;
                }
                $.ajax({
                    type:"POST",
                    url:uri + "registerUpdate",
                    data:JSON.stringify(JSONdata),
                    dataType:"json",
                    contentType:"application/json;charset=UTF-8",
                    success:function (data) {
                        alert(data.message);
                        if(data.code == 200){
                            window.location.href = uri + "home";
                        }
                    }
                })
            }
        );
    })

</script>
<script type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
