function get_data(arg){  // 获取会议时长的方法
    var page = 1;
    var request = new Object();
    request = GetRequest();
    var token = request['token'];
    var userID = request['userID'];
    var url = "http://localhost:8080/order/tutorView?token=" + token;
    var jsonData = {
        token:token,
        page:page,
        userID:userID
    };
    $.ajax({
        url:url,
        type:'post',
        dataType:'json',
        contentType:"application/json;charset=UTF-8",
        data:JSON.stringify(jsonData),
        success: function(callback){
            if(callback.code == 200){
                show_order_detail(callback)
            }
        },
        error: function(){
            alert('error');
        }
    })
}

function show_order_detail(callback) {  // 显示会议状况的详情和做翻页按钮
    $("#order_detail").show();
    $("#order_total").html('<em>共 '+ callback.data.pages +' 页 第 ' + callback.data.currentPage+' 页</em>');  //  显示总数据量
    $("#order_detail_table tr:first").siblings('tr').remove()  // 清空之前的数据
    var orders = callback.data.orderViews;
    for(var i in orders){
        var per_record = orders[i];
        var html_code = '<tr id="record_'+ i +'">' +
            '<td>'+per_record.studentName+'</td>' +
            '<td>'+per_record.instrumentName +'</td>' +
            '<td>'+ per_record.startTime.year +'-'+per_record.startTime.monthValue +'-'+ per_record.startTime.dayOfMonth
             +"  "+ per_record.startTime.hour+':00:00'+ '</td>' +
            '<td>'+ per_record.endTime.year +'-'+per_record.endTime.monthValue +'-'+ per_record.endTime.dayOfMonth
            +"  "+ per_record.endTime.hour+':00:00'+ '</td>' +
            '<td>'+ per_record.price;
        $('#order_detail_table tr:last').after(html_code)
    }

    $("#page li:first").siblings('li').children('.delete_mark').remove();  // 先删除之前的换页的html代码
    for(var i=Number(callback.data.pages);i>0;i--){
        var page_num = Number(i);
        var page_range = Math.abs(page_num - Number(callback.data.currentPage))
        if( page_range <= 2 ){  // 这一步的目的在于页面显示的时候是共5页的分页按钮
            if(Number(callback.data.currentPage) == page_num){   // 说明是当前页，那么进行高亮显示，把class设置为active
                $("#page li:first").after('<li class="active" ><a href="#" class="delete_mark"    ' + 'onclick="go_to_page(this)" current_page_num="' + page_num + '">' + page_num + '</a></li>')
                // 下面的代码是实现返回第一页的功能
                $("#page li:first a").attr("onclick","go_to_page(this)");
                $("#page li:first a").attr("current_page_num",1);   // 设置跳转到第一页

                // 下面的代码是实现跳转到末页
                $("#page li:last a").attr("onclick","go_to_page(this)");
                alert('当前页'+page_num);
            }else {    // 说明不是当前页，那么不进行高亮显示
                alert(i);
            }
        }
    }

}

function go_to_page(arg){   // 获取指定页的内容
    var page = $(arg).attr('current_page_num');
    var request = new Object();
    request = GetRequest();
    var token = request['token'];
    var userID = request['userID'];
    var url = "http://localhost:8080/order/tutorView?token=" + token;
    var jsonData = {
        token:token,
        page:page,
        userID:userID
    };
    $.ajax({
        url:url,
        type:'post',
        dataType:'json',
        contentType:"application/json;charset=UTF-8",
        data:JSON.stringify(jsonData),
        success: function(callback){
            console.log(callback);
            show_order_detail(callback)
        },
        error: function(){
        }
    })
}
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=decodeURI(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}