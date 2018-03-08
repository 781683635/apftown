$(document).ready(function () {  
    //注册按钮的点击事件  
    $("#idBtnupload").click(btnUpLoad_onclick);  
    CreateFrame();  
    Init();  
})  
///创建iframe  
function CreateFrame() {  
    var FrameName = "uploadFrame_" + Math.floor(Math.random() * 1000);  
    var oframe = $('<iframe name=' + FrameName + '>');  
    //修改样式是css，修改属性是attr  
    oframe.css("display", "none");  
    //在内部的前面加节点  
    $('body').prepend(oframe);  
    //设置form属性，关键是target要指向iframe  
    $("#uploadForm").attr("target", FrameName);  
    $("#uploadForm").attr("method", "post");  
    //注意ie的form没有enctype属性，要用encoding  
    $("#uploadForm").attr("encoding", "multipart/form-data");  
}  
///上传  
function btnUpLoad_onclick() {  
    $("#uploadForm").submit();  
}  
///初始化时新建一个file类型文本框  
function Init() {  
    var fileJquery = $("<input type='file'>").attr("name", "Test").attr("title", "Jquery");  
    //这是运用js的onchange属性赋值的(不知道用Jquery怎么实现，用Jquery绑定方法没能实现)  
    fileJquery[0].onchange = function () { return OperateAndNew(fileJquery[0]); };  
    fileJquery.appendTo("#idFile");  
}  
///每当添加一个附件时执行  
function OperateAndNew(o) {  
    if (o.value != "") {  
        o.style.display = "none"  
        Init();  
    }  
}  
///上传完成后提示消息  
function Finish(msg) {  
    alert(msg);  
}  