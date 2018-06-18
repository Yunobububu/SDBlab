$(function () {
    $("#subBut").click(
        function(){
            var userID = $("#ID").val();
            var psw = $("#password").val();
            <!--取password中的值进行md5加密-->
            var md5Psw = $.md5(psw);
            var role = $('input[name="role"]:checked').val();
            alert(role);
            var jsonData = {ID:userID,password:md5Psw,role:role};
            var url = "http://localhost:8080/loginWithJson";
            $.ajax({
                type:"POST",
                data:JSON.stringify(jsonData),
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                url:"loginWithJson",
                async: false,
                success:function(data){
                    if(data == null){
                        alert("密码错误");
                    }
                    alert("登录成功");
                    window.location.href="http://localhost:8080/home";
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(errorThrown);
                    alert(XMLHttpRequest.readyState);
                }
            })
        }
    )

});