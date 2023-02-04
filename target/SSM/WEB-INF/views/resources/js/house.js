$(function () {
    $('#houseType span').click(function () {
        $(this).toggleClass("active").siblings().removeClass("active");
    });
    $('#housePrice span').click(function () {
        $(this).toggleClass("active").siblings().removeClass("active");
    });
});

findHouse(1);
// 点击搜索
$('#search').click({paramName:'1'}, function (e) {
    findHouse(e);
});
// 上一页
$('#pre').click(function () {
    var currPage = $('#currPage').text();
    if (currPage <= 1){
        return;
    }
    currPage--;
    $('#currPage').text(currPage);
    findHouse(currPage);
});
// 下一页
$('#next').click(function () {
    var currPage = $('#currPage').text();
    var pageSize = $('#pageSize').text();
    if (currPage >= pageSize){
        return;
    }
    currPage++;
    $('#currPage').text(currPage);
    findHouse(currPage);
});

function findHouse(e) {
    var currPage = e;
    if (typeof currPage != "number"){
        currPage = e.data.paramName;
    }
    var prov = $('#selectProvince').val();
    if (prov == '请选择省份' || prov == null){
        prov = 0;
    }
    var cityId =  $('#selectCity').val();
    if (cityId == '请选择城市' || cityId == null){
        cityId = 0;
    }
    var areaId =  $('#area .active').attr('id');
    if (areaId == null){
        areaId = 0;
    }
    var townId = $('#town .active').attr('id');
    if (townId == null){
        townId = 0;
    }
    var searchContent = $('#search-content').val();
    if (searchContent != ""){
        townId = 0;
        $('#town span').removeClass('active');
    }
    var houseType = $('#houseType .active').attr('id');
    if (houseType == null){
        houseType = 'no'
    }
    var houseRent = $('#housePrice .active').text();
    if (houseRent == ""){
        houseRent = 'no';
    }
    $.ajax({
        url:'house_source/findHouse',
        type:'post',
        data:{
            "provId": prov,
            "cityId": cityId,
            "search": searchContent,
            "areaId": areaId,
            "townId": townId,
            "houseType": houseType,
            "houseRent": houseRent,
            "currPage": currPage
        },
        dataType:'json',
        success:function (resp) {
            $('#pageSize').text(resp.data[1]);
            showHouseSource(resp.data[0]);
        }
    })
}
function showHouseSource(arr) {
    $('#showHouse').html('');
    if (arr.length > 0){
        for(var i = 0; i < arr.length; i++){
            var house = `<div class="col-lg-4 col-md-4 col-sm-6 source" data-toggle="modal" data-target="#exampleModal">
                    <figure class="effect-service">
                        <img id="houseImg" src="http://localhost:8888/Manager_PublishHouse/${arr[i].images}" alt="" style="width: 343px; height: 326px"/>
                        <figcaption>
                            <h2 class="maxText">${arr[i].communityName}/${arr[i].buildingNum}楼/${arr[i].houseNum}</h2>
                            <p>
                                <span>所属区域：</span>
                                <span class="comName">${arr[i].communityName}</span><br/>
                                <span>所属户型：</span>
                                <span class="houseT">${arr[i].houseType}</span><br/>
                                <span>楼层编号：</span>
                                <span class="building">${arr[i].buildingNum}楼</span><br/>
                                <span>房号：</span>
                                <span class="houseNum">${arr[i].houseNum}号</span><br/>
                                <span>建筑面积：</span>
                                <span class="houseS">${arr[i].houseArea}平方米</span><br/>
                                <span>租金：</span><span class="money">${arr[i].money}</span><span>元/月</span><br/>
                            </p>
                            <a href="#">View more</a>
                        </figcaption>
                    </figure>
                </div>`;
            $('#showHouse').append(house);
        }
        $('.source').on('click', function (e) {
            var showInfo = $(this).children().children();
            $('.sourceInfo img').attr('src', $(showInfo[0]).attr('src')); // 图片
            $('.sourceInfo .rent').text($($(showInfo[1]).children()[1]).children('.money').text()); // 租金
            $('.sourceInfo .houseType').text($($(showInfo[1]).children()[1]).children('.houseT').text());   // 户型
            $('.sourceInfo .houseSize').text($($(showInfo[1]).children()[1]).children('.houseS').text()); // 面积
            $('.sourceInfo .roomNum').text($($(showInfo[1]).children()[1]).children('.houseNum').text()); // 房号
            $('.sourceInfo .buildingNUm').text($($(showInfo[1]).children()[1]).children('.building').text()); // 楼层
            $('.sourceInfo .address').text($($(showInfo[1]).children()[1]).children('.comName').text()); // 小区名字
            $('.sourceInfo .address-info').text($($(showInfo[1]).children()[0]).text()) // 详细地址
        });
    }else {
        var house = `<div class="col-lg-4 col-md-4 col-sm-6">
                    <p style="width: 1136px; text-align: center; font-size: 18px; margin-top: 20px">暂无数据</p>
                </div>`;
        $('#showHouse').append(house);
    }
    var pageSize = $('#pageSize').text();
    if (pageSize == 0){
        $('#currPage').text(0);
    }
}
