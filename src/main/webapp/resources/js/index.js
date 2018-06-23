$(function () {
    $("#subBut").click(
        function(){
            var userID = $("#ID").val();
            var psw = $("#password").val();
            <!--取password中的值进行md5加密-->
            var md5Psw = $.md5(psw);
            var role = $('input[name="role"]:checked').val();
            var jsonData = {userID:userID,password:md5Psw,role:role};
            var url = "http://localhost:8080/login";
            $.ajax({
                type:"POST",
                data:JSON.stringify(jsonData),
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                url:url,
                async: false,
                success:function(data){
                    if(data.code == 200){
                        var token = data.data.token;
                        var redUrl = "http://localhost:8080/home?userID="+ userID+"&token="+ token;
                        window.location.href= redUrl;

                    }else{
                        alert("密码错误");
                        alert(data.data);
                    }
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