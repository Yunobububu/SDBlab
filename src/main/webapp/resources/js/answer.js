$(function () {
    $("#quesBut").click(
        function(){
            var jsonData = {
                '1':{'questionID':'1','submit':'C'},
                '3':{'questionID':'3','submit':'A'},
                '5':{'questionID':'5','submit':'C'},
                '6':{'questionID':'6','submit':'D'},
                '10':{'questionID':'10','submit':'B'},
                '15':{'questionID':'15','submit':'C'},
                '20':{'questionID':'20','submit':'B'},
                '23':{'questionID':'23','submit':'C'},
                '29':{'questionID':'29','submit':'A'},
                '30':{'questionID':'30','submit':'D'},
                '45':{'questionID':'45','submit':'C'},
                '48':{'questionID':'48','submit':'D'},
                '49':{'questionID':'49','submit':'A'},
                '53':{'questionID':'53','submit':'C'},
                '55':{'questionID':'55','submit':'B'},
                '58':{'questionID':'58','submit':'C'},
                '60':{'questionID':'60','submit':'D'},
                '63':{'questionID':'63','submit':'C'},
                '70':{'questionID':'70','submit':'A'}
            };
            var url = "http://localhost:8080/answer";
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
                        var redUrl = "http://localhost:8080/index.jsp";
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