/*js文件*/

/*根据id删除用户并给出警告提示*/
function deleteById( deleteurl) {
    $("#warnModal").modal("show");
    var result;
    // 绑定删除事件
    $("#btnModalOk").bind("click", function () {
        $.ajax({
            "url": deleteurl,
            "type": "GET",
            "dataType": "JSON",
            "success": function (data) {
                $("#btnModalOk").unbind("click");
            }
        });
        $("#warnModal").modal("hide");
        window.location.reload();
    });

}

/*全选复选框*/
function  check() {
    var flag=document.getElementById("big_box").checked;
    var minimals=document.getElementsByClassName("minimal");
    if(flag){
        for(var i=0;i<minimals.length;i++){
            minimals[i].checked=true;
        }
    }else{
        for(var i=0;i<minimals.length;i++ ){
            minimals[i].checked=false;
        }

    }
}





