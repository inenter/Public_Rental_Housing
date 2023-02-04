jQuery.ajax({
    url: 'user/findMsg',
    type: 'get',
    data: {},
    dataType: "json",
    success: function (resp) {
        for(var i = 0; i < resp.data.length; i++){
            if (resp.data[i].messageState == '已读'){
                jQuery('#msg').append(`<p class="prow${i}" id="${resp.data[i].messageId}"><span style="font-size: 20px!important; margin-left: 10px">${resp.data[i].messageText}</span></p>`);
            }
            if (resp.data[i].messageState == '未读'){
                jQuery('#msg').append(`<p class="prow${i}" id="${resp.data[i].messageId}"><span class="dialog"></span><span style="font-size: 20px!important; margin-left: 10px">${resp.data[i].messageText}</span></p>`);
                layer.alert(resp.data[i].messageText);
            }
        }
    }
});

jQuery(document).on('click', '#msg p', function () {
    jQuery(this).children('span').removeClass("dialog");
    jQuery.ajax({
        url: 'user/updateMsgState',
        type: 'get',
        data: {
            "messageId": this.id
        },
        dataType: "json",
        success: function (resp) {
            console.log(resp);
        }
    });
});
