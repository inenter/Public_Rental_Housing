// 生成验证码
function changePic() {
    console.log($('#prcode'));
    $('#prcode').attr('src', 'checkCode?' + new Date());
}

/**
 * 登录事件
 */
$(function () {
   $('#login').click(function () {
       var code = $('#code').val();
       $.ajax({
           url: 'user/check',
           type: 'get',
           data: {
               code:code
           },
           dataType:"JSON",
           success:function (resp) {
               if (resp.code == 200){
                   var userAcc = $('#userAcc').val();
                   var password = $('#password').val();
                   $.ajax({
                       url:'user/login',
                       type:'get',
                       data: {
                           userAcc: userAcc,
                           password: password
                       },
                       dataType: "JSON",
                       success: function (resp) {
                           if (resp.code == 200){
                               alert("登录成功!");
                               location.href = 'index';
                           }else {
                               alert("账户名或密码错误!");
                           }
                       }
                   });
               }else {
                   alert("验证码错误!");
                   changePic();
               }
           },
           error:function (err) {
                alert("网络出错......")
           }
       });
   })
});






