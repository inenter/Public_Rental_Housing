
// 生成验证码
function changePic() {
    console.log($('#prcode'));
    $('#prcode').attr('src', 'checkCode?' + new Date());
}
/**
 * 注册事件
 */
var flag = false;
$(function () {
    $('#register').click(function () {
        var code = $('#recode').val();
        $.ajax({
            url: 'user/check',
            type: 'get',
            data: {
                code: code
            },
            dataType: "JSON",
            success: function (resp) {
                if (resp.code == 200) {
                    var userAcc = $('#userAcc').val();
                    var password = $('#password').val();
                    var nickname = $('#nickname').val();
                    var phone = $('#phone').val();
                    var idCard = $('#idCard').val();
                    var address = $('#address').val();
                    // 验证字段
                    flag = checkColumn(userAcc, nickname, password, phone, idCard);
                    if (flag == false){
                        return;
                    }
                    var obj = {
                        "renterId": 0,
                        "renterAcc": userAcc,
                        "renterPwd": password,
                        "renterName": nickname,
                        "renterTel": phone,
                        "renterIdNum": idCard,
                        "contactAddr": address
                    };
                    $.ajax({
                        url: 'user/register',
                        type: 'get',
                        data: {
                            "obj": JSON.stringify(obj)
                        },
                        dataType: "JSON",
                        success: function (resp) {
                            alert(resp.message);
                            if (resp.code === 200) {
                                location.href = 'login'
                            }
                        }
                    });
                } else {
                    alert("验证码错误!");
                    changePic();
                }
            },
            error: function (err) {
                alert("网络出错......")
            }
        });
    })
});

// 验证字段是否合法
function checkColumn(userAcc, nickname, password, phone, idCard) {
// 验证账号、用户名
    console.log(userAcc);
    var regex1 = new RegExp(/^[A-Za-z0-9]{4,10}$/);
    if (regex1.test(userAcc) == false) {
        alert("账号不合法！");
        return false;
    }
    // 验证密码
    var regex2 = new RegExp(/^[A-Za-z0-9]{6,10}$/);
    if (regex2.test(password) == false) {
        alert("密码不合法！");
        return false;
    }
    // 验证手机号
    var regex3 = new RegExp(/^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/);
    if (regex3.test(phone) == false) {
        alert("手机号错误！");
        return false;
    }
    // 验证身份证
    var regex4 = new RegExp(/^\d{8,18}|[0-9x]{8,18}|[0-9X]{8,18}?$/);
    if (regex4.test(idCard) == false) {
        alert("证件号错误！");
        return false;
    }
}

// 返回首页
$(function () {
    $('#toIndex').click(function () {
        location.href = 'index';
    })
});