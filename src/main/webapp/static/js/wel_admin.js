$(function(){
    $("#btn_stu").on("click",function(){
        alert(1);
        $.ajax({
            type: "POST",
            url: "admin/adminstu.do",
            dataType:"html",
            success:function(msg){

            }
        });
    });
});

function openItem(root,url){
    var href = "/" + root + "/" + url;
    msg


}