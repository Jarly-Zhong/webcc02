$(document).ready(function(){
    $(".setCour").click(function () {
        var courF =  $(this).siblings(".courF");
        var msg = courF.serialize();
        var href = "/student/courSet.do"
        $.ajax({
            url: href,
            data:msg,
            type:"post",
            success: function(data){
                if(data=="success") {
                    alert("选课成功!");
                    location.reload();
                }else if(data=="reSet"){
                    alert("重复选课");
                }else if(data=="reTime"){
                    alert("上课时间冲突");
                }
            }
        });
    });
});