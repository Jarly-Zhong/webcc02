$(document).ready(function(){

    $("#submit").click(function(){
        var msg = $("#courFrom").serialize();
        var href  = "/teacher/courOpen.do";
        alert("msg is "  + msg);
        alert("href is "  + href);
        $.ajax({
            url: href,
            data:msg,
            type:"post",
            success: function(data){
                if(data=="success") {
                    alert("申请开课成功!");
                    location.reload();
                }else{
                    alert("请检查输入格式!");
                }
            }
        });
    });

});