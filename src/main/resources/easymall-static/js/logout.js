function logout(){
    $.ajax({
       url:"http://127.0.0.1/user/logout",
       dataType:"json",
       type:"GET",
        async: false,
       success:function (data) {
           console.log(data)
           window.location.href="../index.html";
       },
        error:function (data) {
           console.log(data)
           // alert("登出请求发送失败");
       }
    });
}