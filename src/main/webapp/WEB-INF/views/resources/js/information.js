// 查询个人资料
myInfo();
function myInfo() {
	$.ajax({
		url: 'user/showInfo',
		type: 'get',
		data: {},
		dataType: "JSON",
		success: function (resp) {
			if (resp.code === 200) {
				getPersonInfoArr(resp.data[0][0]);
				getFamilyInfoArr(resp.data[1], resp.data[0][0]);
			}
		},
	});
}

// 文件选择
function subFile(up, div) {
    $(div).siblings().change(function () {
        var formData = new FormData();
        var path = $(div).siblings()[0].value;
        var name = path.slice(path.lastIndexOf("\\") + 1);
        if (name == '') {
            $(div).html('上传');
        } else {
            $(div).html(name);
        }
        var file = $(up)[0].files[0];
        formData.append("file", file);
        $.ajax({
            url: "file/upload",
            type: "post",
            processData: false,
            contentType: false,
            data: formData,
            dataType: "JSON",
            success: function (resp) {
                console.log(resp);
            }
        })
    })
}

// 家庭成员身份证上传
// 家庭成员户口本上传
// 上传毕业证上传
function upload(_this) {
    var div = '#' + _this.id;
    var up = $(div).siblings();
    $(div).siblings().click();
    subFile(up, div);
}

// 家庭成员添加
var countId = 0;
var familySum = 0;  // 家庭人数
$('#fams').click(function () {
    $('.show-sen').attr('style', 'display:block!important');
    countId++;
    familySum++;
    $('#people').val(familySum);
    $('#family>table').append(`<tbody id='${countId}'>
								<tr>
									<td>
										<select id="relation${countId}" style="width: 80px">
											<option value="父子" selected>父子</option>
											<option value="母子">母子</option>
											<option value="兄弟">兄弟</option>
											<option value="姐弟">姐弟</option>
											<option value="兄妹">兄妹</option>
											<option value="姐妹">姐妹</option>
										</select>
									</td>
									<td>
										<input type="text" id="famName${countId}">
									</td>
									<td>
										<input type="text" id="famCard${countId}">
									</td>
									<td>
										<select id="work${countId}" style="width: 80px">
											<option value="退休" selected>退休</option>
											<option value="在职">在职</option>
											<option value="失业">失业</option>
											<option value="其他">其他</option>
										</select>
									</td>
									<td>
										<input type="date" style="width: 180px;" id="famBirth${countId}"/>
									</td>
									<td>
										<input type="text" id="famPhone${countId}"/>
									</td>
									<td>
										<div class="upload" onclick="upload(this)" id="uploadCardFont${countId}" style="width: 100px">上传</div>
										<input type="file" value="上传" id="cardFontImg${countId}" style="display: none;" />
									</td>
									<td>
										<div class="upload" onclick="upload(this)" id="uploadBookFont${countId}" style="width: 100px">上传</div>
										<input type="file" value="上传" id="bookFontImg${countId}" style="display: none;" />
									</td>
									<td>
										<button class="btns" id="del${countId}">删除</button>
									</td>
								</tr>
							</tbody>`)
});
// 删除
$(document).on('click', '#family .btns', function () {
    if (familySum > 0){
        familySum--;
        $('#people').val(familySum);
    }
    if ($('#family tbody').length == 1) {
        $('.show-sen').attr('style', 'display:none!important');
    }
    $(this).parents('tbody').remove();
});

// 获取个人信息
function getPersonInfo() {
    var username = $('#username').val();
    var idCard = $('#idCard').val();
    var birth = $('#birth').val();
    var phone = $('#phone').val();
    var entype = $('#entype').val();
    var apply = $('#selected').text().slice($('#selected').text().lastIndexOf("-") + 1);
    if (apply == '选择区域'){
        apply = '';
    }
    var income = $('#income').val();
    var areasize = $('#areasize').val();
    var people = $('#people').val();
    var cardName = $('#uploadCard').text();
    var bookName = $('#uploadBook').text();
    var cerName = $('#uploadCer').text();
    if (cardName == '上传') {
        cardName = 'null';
    }
    if (bookName == '上传') {
        bookName = 'null';
    }
    if (cerName == '上传') {
        cerName = 'null';
    }
    var info = $('#info').val();
    var obj = {
        "applyId": 0,
        "renterId": 0,
        "areaName": apply,
        "birthday": birth,
        "idCard": idCard,
        "idCardImg": cardName,
        "rebookPerImg": bookName,
        "familyIncome": income,
        "enType": entype,
        "houseArea": areasize,
        "graBookImg": cerName,
        "remarks": info,
        "applyState": '保存',
        "phone": phone,
        "applyName": username,
        "familySum": people,
    };
    return obj;
}

// 获取申请区域信息
$('#saveArea').click(function () {
    var pro = $('#selectProvince').find("option:selected").text();
    if (pro != '请选择省份'){
        $('#selected').text(pro);
    }else {
        $('#selected').text('选择区域');
    }
    var city = $('#selectCity').find("option:selected").text();
    if (city != '请选择城市'){
        $('#selected').text( pro + "-" + city);
    }
    var town = $('#selectArea').find("option:selected").text();
    if (town != '请选择区县') {
        $('#selected').text(pro + "-"  + city + "-"  + town);
    }
    if (pro == '请选择省份'){
        $('#selected').text('选择区域');
    }
});

// 获取家庭成员信息
function getFamilyInfo(i) {
    var relation = $('#relation' + i).val();
    var famName = $('#famName' + i).val();
    var famCard = $('#famCard' + i).val();
    var work = $('#work' + i).val();
    var famBirth = $('#famBirth' + i).val();
    var famPhone = $('#famPhone' + i).val();
    var famCardFont = $('#uploadCardFont' + i).text();
    var famBook = $('#uploadBookFont' + i).text();
    if (famCardFont == '上传'){
        famCardFont = null;
    }
    if (famBook == '上传'){
        famBook = null;
    }
    var obj = {
        "familyId": 0,
        "relation": relation,
        "familyName": famName,
        "familyIdCard": famCard,
        "work": work,
        "familyBirthday": famBirth,
        "familyTel": famPhone,
        "familyCardImg": famCardFont,
        "familyReBookImg": famBook
    };
    return obj;
}

// 获取表格信息  并存放到预览表
$('#check').click(function () {
    var obj = getPersonInfo();
    $('#selfName').text(obj.applyName);
    $('#selfIdCard').text(obj.idCard);
    $('#selfBirth').text(obj.birthday);
    $('#selfPhone').text(obj.phone);
    $('#selfEnType').text(obj.enType);
    $('#selfApply').text(obj.applyName);
    $('#selfIncome').text(obj.familyIncome);
    $('#selfAreaSize').text(obj.houseArea);
    $('#selfPeople').text(obj.familySum);
    $('#selfInfo').text(obj.remarks);
    if ($('#selected').text() != '选择区域'){
        $('#selectProvinces').text($('#selected').text());
    }
    if (obj.idCardImg != '上传' && obj.idCardImg != null) {
        $('#selfCardName').addClass("uploadImg");
        $('#selfCardName').attr('style', 'opacity:1');
        $('#selfCardName').attr('src', 'resources/imgs/' + obj.idCardImg);
    } else {
        $('#selfCardName').attr('style', 'opacity:0');
    }
    if (obj.rebookPerImg != '上传' && obj.rebookPerImg != null) {
        $('#selfBook').addClass("uploadImg");
        $('#selfBook').attr('style', 'opacity:1');
        $('#selfBook').attr('src', 'resources/imgs/' + obj.rebookPerImg);
    } else {
        $('#selfBook').attr('style', 'opacity:0');
    }
    if (obj.graBookImg != '上传' && obj.graBookImg != null) {
        $('#selfCer').addClass("uploadImg");
        $('#selfCer').attr('style', 'opacity:1');
        $('#selfCer').attr('src', 'resources/imgs/' + obj.graBookImg);
    } else {
        $('#selfCer').attr('style', 'opacity:0');
    }

    // 家庭成员信息
    $('#readFamily>table>tbody').html('');
    for (var i = 1; i <= countId; i++) {
        $('#read').attr('style', 'display:block!important');
        if ($('#' + i).html() != null) {
            $('#readFamily>table').append(`<tbody>
				        					<tr>
				        						<td>
				        							<span id="selfFamRela${i}"></span>
				        						</td>
				        						<td>
				        							<span id="selfFamName${i}"></span>
				        						</td>
				        						<td>
				        							<span id="selfFamCard${i}" style="width: 200px;"></span>
				        						</td>
				        						<td>
				        							<span id="selfFameWork${i}"></span>
				        						</td>
				        						<td>
				        							<span id="selfFamBirth${i}"></span>
				        						</td>
				        						<td>
				        							<span id="selfFamPhone${i}"></span>
				        						</td>
				        						<td>
				        							<img alt="" id="selfFamCardFont${i}">
				        						</td>
				        						<td>
				        							<img alt="" id="selfFameBookFont${i}">
				        						</td>
				        					</tr>
				        				</tbody>`);
            var familyInfo = getFamilyInfo(i);

            $('#selfFamRela' + i).text(familyInfo.relation);
            $('#selfFamName' + i).text(familyInfo.familyName);
            $('#selfFamCard' + i).text(familyInfo.familyIdCard);
            $('#selfFameWork' + i).text(familyInfo.work);
            $('#selfFamBirth' + i).text(familyInfo.familyBirthday);
            $('#selfFamPhone' + i).text(familyInfo.familyTel);
            if (familyInfo.familyCardImg != '上传' && familyInfo.familyCardImg != null) {
                $('#selfFamCardFont' + i).addClass("uploadImg");
                $('#selfFamCardFont' + i).attr('style', 'opacity:1');
                $('#selfFamCardFont' + i).attr('src', 'resources/imgs/' + familyInfo.familyCardImg);
            } else {
                $('#selfFamCardFont' + i).attr('style', 'opacity:0');
            }
            if (familyInfo.familyReBookImg != '上传' && familyInfo.familyReBookImg != null) {
                $('#selfFameBookFont' + i).addClass("uploadImg");
                $('#selfFameBookFont' + i).attr('style', 'opacity:1');
                $('#selfFameBookFont' + i).attr('src', 'resources/imgs/' + familyInfo.familyReBookImg);
            } else {
                $('#selfFameBookFont' + i).attr('style', 'opacity:0');
            }
        }
    }
});

function checkInfo() {
    var flag = true;
    var person = getPersonInfo();
    console.log(person.applyName);
    if (!new RegExp(/^.{2,20}$/).test(person.applyName)){
        alert("申请人姓名不合法！");
        flag = false;
        return;
    }
    if (!new RegExp(/^([0-9]){17,18}(x|X)?$/).test(person.idCard)){
        alert("申请人身份证号不合法！");
        flag = false;
        return;
    }
    if (!new RegExp(/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/).test(person.phone)){
        alert("手机号不合法！");
        flag = false;
        return;
    }
    console.log(person.familyIncome);
    if (person.familyIncome == null || person.familyIncome == ''){
        alert("家庭年收入不能为空！");
        flag = false;
        return;
    }
    if (person.houseArea == null || person.houseArea == ''){
        alert("住房面积不能为空！");
        flag = false;
        return;
    }
    if (person.idCardImg == '上传'){
        alert("请上传身份证！");
        flag = false;
        return;
    }
    if (person.rebookPerImg == '上传'){
        alert("请上传户口本！");
        flag = false;
        return;
    }

    for (var i = 1; i <= countId; i++) {
        if ($('#' + i).html() != null) {
            if (!new RegExp(/^.{2,20}$/).test(getFamilyInfo(i).familyName)){
                alert("第" + i + "个家庭成员的姓名不能为空！");
                flag = false;
                return;
            }
            if (!new RegExp(/^([0-9]){17,18}(x|X)?$/).test(getFamilyInfo(i).familyIdCard)){
                alert("第" + i + "个家庭成员的身份证号不合法！");
                flag = false;
                return;
            }
            if (!new RegExp(/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/).test(getFamilyInfo(i).familyTel)){
                alert("第" + i + "个家庭成员的手机号不合法！");
                flag = false;
                return;
            }
            if (getFamilyInfo(i).familyCardImg == null){
                alert("第" + i + "个家庭成员的身份证不能为空！");
                flag = false;
                return;
            }
            if (getFamilyInfo(i).familyReBookImg == null){
                alert("第" + i + "个家庭成员的户口本不能为空！");
                flag = false;
                return;
            }
        }
    }

    return flag;
}

function savePersonInfo(){
    if (confirm('确定保存信息吗？')){
        var person = [];
        person.push(getPersonInfo());
        var family = [];
        for (var i = 1; i <= countId; i++) {
            if ($('#' + i).html() != null) {
                family.push(getFamilyInfo(i));
            }
        }
        $.ajax({
            url: "user/save",
            type: 'post',
            data: {
                "person": JSON.stringify(person[0]),
                "family": JSON.stringify(family)
            },
            dataType: 'json',
            success: function (resp) {
                alert(resp.message);
            }
        })
    }
}
// 保存信息
$('#save').click(function () {
    savePersonInfo();
});
// 预览信息时 保存
$('#checkSave').click(function () {
    savePersonInfo();
});

// 提交信息
$('#submit').click(function () {
	if (confirm('确定提交审核吗？')){
        if (!checkInfo()){
            return;
        }
		$.ajax({
			url: "user/submit",
			type: 'post',
			data: {
			    "applyState":'提交'
            },
			dataType: 'json',
			success: function (resp) {
				alert(resp.message);
			}
		})
	}
});

// 点击预览
$(function () {
    $('#check').click(function () {
        $('#closeReading').removeAttr("disabled !important");
    })
});
// 展示数据
function getPersonInfoArr(applyArr) {
    if(applyArr.applyState == '提交'){
        $("input,textarea").attr("readonly","readonly");
        $("#selected").attr('data-toggle', '');
        $("#selected").attr('onclick', '');
        $('div').attr("onclick", "");
        $("select").attr("disabled","disabled");
        $('button').attr("disabled","disabled");
        $("#closeRead").removeAttr("disabled");
    }
    $('#username').val(applyArr.applyName);
    $('#idCard').val(applyArr.idCard);
    var time = stampToDate(applyArr.birthday);	// 将时间戳转为标准时间
    if (time === '1970-01-01'){
        time = null;
    }
    $('#birth').val(time);
    $('#phone').val(applyArr.phone);
    $('#entype').val(applyArr.enType);
    $('#selected').text(applyArr.areaName);
    // $('#apply').val(applyArr.areaName);
    $('#people').val(applyArr.familySum);
    familySum = applyArr.familySum;
    if (applyArr.familyIncome === 0) {
        $('#income').val();
    } else {
        $('#income').val(applyArr.familyIncome);
    }
    if (applyArr.houseArea === 0) {
        $('#areasize').val();
    } else {
        $('#areasize').val(applyArr.houseArea);
    }
    if (applyArr.idCardImg == null || applyArr.idCardImg === '') {
        $('#uploadCard').text('上传');
    } else {
        $('#uploadCard').text(applyArr.idCardImg);
    }
    if (applyArr.rebookPerImg == null || applyArr.rebookPerImg === '') {
        $('#uploadBook').text('上传');
    } else {
        $('#uploadBook').text(applyArr.rebookPerImg);
    }
    if (applyArr.grabookImg == null || applyArr.grabookImg === '') {
        $('#uploadCer').text('上传')
    } else {
        $('#uploadCer').text(applyArr.grabookImg)
    }
}

function getFamilyInfoArr(familyArr, applyArr) {
    $('.show-sen').attr('style', 'display:block!important');
	$('#family>table tbody').remove();
	countId = 0;
    for (var i = 1; i <= familyArr.length; i++) {
        var time = stampToDate(familyArr[i-1].familyBirthday);	// 将时间戳转为标准时间
        if (time == '1970-01-01'){
            time = null;
        }
		countId++;
        $('#family>table').append(`<tbody id='${countId}'>
								<tr>
									<td>
										<select id="relation${countId}" style="width: 80px">
											<option value="父子">父子</option>
											<option value="母子">母子</option>
											<option value="兄弟">兄弟</option>
											<option value="姐弟">姐弟</option>
											<option value="兄妹">兄妹</option>
											<option value="姐妹">姐妹</option>
										</select>
									</td>
									<td>
										<input type="text" id="famName${countId}" value="${familyArr[i-1].familyName}">
									</td>
									<td>
										<input type="text" id="famCard${countId}" value="${familyArr[i-1].familyIdCard}">
									</td>
									<td>
										<select id="work${countId}" style="width: 80px">
											<option value="退休" selected>退休</option>
											<option value="在职">在职</option>
											<option value="失业">失业</option>
										</select>
									</td>
									<td>
										<input type="date" style="width: 180px;" id="famBirth${countId}"  value="${time}"/>
									</td>
									<td>
										<input type="text" id="famPhone${countId}" value="${familyArr[i-1].familyTel}"/>
									</td>
									<td>
										<div class="upload" onclick="upload(this)" id="uploadCardFont${countId}" style="width: 100px">上传</div>
										<input type="file" value="上传" id="cardFontImg${countId}" style="display: none;" />
									</td>
									<td>
										<div class="upload" onclick="upload(this)" id="uploadBookFont${countId}" style="width: 100px">上传</div>
										<input type="file" value="上传" id="bookFontImg${countId}" style="display: none;" />
									</td>
									<td>
										<button class="btns" id="del${countId}">删除</button>
									</td>
								</tr>
							</tbody>`);

        $('#relation' + countId).val(familyArr[i - 1].relation);
        $('#work' + countId).val(familyArr[i - 1].work);
        var familyCardImg = familyArr[i - 1].familyCardImg;
        if (familyCardImg == null) {
            $('#uploadCardFont' + i).text("上传");
        } else {
			$('#uploadCardFont' + i).text(familyCardImg);
        }
        var familyReBookImg = familyArr[i - 1].familyReBookImg;
        if (familyReBookImg == null) {
			$('#uploadBookFont' + i).text("上传");
        } else {
			$('#uploadBookFont' + i).text(familyReBookImg);
        }
    }
    if(applyArr.applyState == '提交'){
        $("input").attr("readonly","readonly");
        $("button").attr("disabled","disabled");
        $('div').attr("onclick", "");
        $("select").attr("disabled","disabled");
        $("#check").removeAttr("disabled");
    }
}

/**
 * 将时间戳转为标准时间
 */
function stampToDate(time) {
	var date = new Date(Number(time));
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}
