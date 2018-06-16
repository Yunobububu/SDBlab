$(function () {
    $("#ID").blur(
        function () {
            var userID = $("#ID").val();
            var reg = new RegExp("^[0-9]*$");
            if($.trim(userID) == "" || !reg.test($("#ID").val())){
                alert("用户名不能为空且只能是工号或学号");
                return false;
            }
            var role = $('input[name="role"]:checked').val();
            var jsonData = {ID:userID,role:role};
            $.ajax({
                type:"POST",
                url:"registerIDCheck",
                dataType:"json",
                data:JSON.stringify(jsonData),
                contentType:"application/json;charset=UTF-8",
                success:function (data) {
                    if(data != null){
                        //回传的是json对象,可以直接用data.field 获取属性的值
                        $("#IDSpan").html("<em style='font-family: color:red'>用户ID已经存在</em>");
                    }else{
                        flag = true;
                        $("#IDSpan").html("<em style='font-family: color:green'>用户名可用</em>");
                    }
                }
            });
        }
    )
});