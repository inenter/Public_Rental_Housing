// 退出登录
jQuery('#cancel').click(function () {
    if (confirm('确定退出吗？')){
        jQuery.ajax({
            url: 'user/logout',
            type: 'get',
            data: {},
            dataType: "json",
            success: function (resp) {
                if (resp.code == 200){
                    location.href = 'index';
                }
            }
        });
    }
});

// 修改密码
jQuery('#ensure').click(function () {
    if (jQuery('#pwd').val() != jQuery('#repwd').val()){
        alert("两次密码不一致");
        clearText();
    }else {
        if (confirm('确定修改吗？')){
            jQuery.ajax({
                url: 'user/selectPwd',
                type: 'get',
                data: {
                    "oldPwd": jQuery('#oldPwd').val()
                },
                dataType: "json",
                success: function (resp) {
                    if (resp.code == 200){
                        jQuery.ajax({
                            url:'user/updatePwd',
                            type:'get',
                            data: {
                                "pwd": jQuery('#pwd').val()
                            },
                            dataType: 'json',
                            success: function (resp) {
                                if (resp.code == 200){
                                    jQuery('#hidePanel').click();
                                    alert(resp.message);
                                }
                                clearText();
                            }
                        })
                    }else {
                        alert("原密码错误！");
                        clearText();
                    }
                }
            });
        }
    }
});

function clearText() {
    jQuery('#oldPwd').val('');
    jQuery('#pwd').val('');
    jQuery('#repwd').val('')
}
