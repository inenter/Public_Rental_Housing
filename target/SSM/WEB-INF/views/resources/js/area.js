// 查询省份
findProvinces(1);
function findProvinces(pid) {
    $.ajax({
        url:"user/findArea",
        type:"post",
        data:{
            "pid":pid
        },
        dataType:"JSON",
        success:function (resp) {
            if(resp.code == 200){
                showProvinces(resp.data);
            }
        }
    });
}
// 选择省份
function showProvinces(provincesArr) {
    $("#selectProvince").html("");
    var str = "<option value='0'>请选择省份</option>";
    for (var i = 0; i < provincesArr.length; i++) {
        str += `<option value='${provincesArr[i].areaId}' id="${provincesArr[i].areaName}">${provincesArr[i].areaName}</option>`
    }
    $("#selectProvince").html(str);
}
// 查询城市
function findCity(_this) {
    if ($('#selectProvince').val() === 0){
        $("#selectCity").html("");
        var str = "<option value='0'>请选择城市</option>";
        $("#selectCity").html(str);
    }else {
        $.ajax({
            url:"user/findArea",
            type:"post",
            data:{
                "pid":_this.value
            },
            dataType:"JSON",
            success:function (resp) {
                if(resp.code == 200){
                    showCity(resp.data);
                }
            }
        });
    }
}
// 选择城市
function showCity(cityArr) {
    $("#selectCity").html("");
    var str = "<option value='0'>请选择城市</option>";
    for (var i = 0; i < cityArr.length; i++) {
        str += `<option value="${cityArr[i].areaId}" id="${cityArr[i].areaName}">${cityArr[i].areaName}</option>`
    }
    $("#selectCity").html(str);
}
// 查询区
function findArea(_this) {
    if ($("#selectCity").val() == 0){
        $("#selectArea").html('');
        var str = "<option value='0'>请选择区县</option>";
        $("#selectArea").html(str);
    }else {
        $.ajax({
            url:"user/findArea",
            type:"post",
            data:{
                "pid":_this.value
            },
            dataType:"JSON",
            success:function (resp) {
                if(resp.code == 200){
                    showArea(resp.data);
                }
            }
        });
    }
}
// 选择区
function showArea(areaArr) {
    $("#selectArea").html('');
    $('#area').html('');
    var str = "<option>请选择区县</option>";
    for (var i = 0; i < areaArr.length; i++) {
        str += `<option value="${areaArr[i].areaId}" id="${areaArr[i].areaName}">${areaArr[i].areaName}</option>`

        // 房源  区域
        $('#area').append(`<span class="houseArea" value="${areaArr[i].areaName}" id="${areaArr[i].areaId}">${areaArr[i].areaName}</span>`)
    }
    $("#selectArea").html(str);
}

// 选择区域
$(document).on('click', '#area .houseArea', function () {
    $(this).toggleClass("active").siblings().removeClass("active");
    $.ajax({
        url:'user/findTown',
        type:'post',
        data:{
            "areaId": $('#area .active').attr("id")
        },
        dataType:'json',
        success: function (resp) {
            $('#town').html('');    // 小区
            for (var i = 0; i < resp.data.length; i++) {
                $('#town').append(`<span class="houseArea" id="${resp.data[i].communityId}">${resp.data[i].communityName}</span>`);
            }
        }
    })
});

$(document).on('click', '#town .houseArea', function () {
    $(this).toggleClass("active").siblings().removeClass("active");
});