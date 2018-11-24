 /*function  dropDown() {
    var tus=document.getElementsByClassName("tu");
    var flag=0;
    for(var i=0;i<tus.length;i++){
        tus[i].className="glyphicon glyphicon-chevron-down";
        flag=i;

    }
};*/


 $(function(){
     $("button").click(function(e){
         /*切换折叠指示图标*/
         $(this).find("span").toggleClass("glyphicon-chevron-down");
     });
 });
