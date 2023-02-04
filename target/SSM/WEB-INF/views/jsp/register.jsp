<%--
  Created by IntelliJ IDEA.
  User: LQB
  Date: 2022/11/26
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <title>用户注册</title>
    <meta name="keywords" content="Apps Login Form Responsive widget, Flat Web Templates, Android Compatible web template,
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<div class="agile-login" style="padding-top: 0px">
    <h1>公租房租赁平台</h1>
    <div class="wrapper" style="padding: 1% 0px;">
        <h2 style="margin-bottom: 10px;">欢迎注册</h2>
        <div class="w3ls-form">
            <form action="" method="post">
                <label>账号</label>
                <input type="text" name="name" placeholder="用户账号（包含英文和数字，长度在4~10位）" id="userAcc" required/>
                <label>密码</label>
                <input type="text" name="password" placeholder="用户密码（包含英文和数字，长度在6~10位）" id="password" required/>
                <span id="tips"></span>
                <label>姓名</label>
                <input type="text" name="nickname" placeholder="姓名" id="nickname" required/>
                <label>手机</label>
                <input type="text" name="phone" placeholder="手机号" id="phone" required/>
                <label>证件号码</label>
                <input type="text" name="idCard" placeholder="身份证号" id="idCard" required/>
                <label>联系地址</label>
                <input type="text" name="address" placeholder="联系地址" id="address" required/>

                <label>验证码</label>
                <div style="display: flex">
                    <input type="text" name="code" placeholder="验证码" id="recode" style="width: 70%; margin-right: 10px" required/>
                    <img src="checkCode" onclick="changePic()" id="prcode">
                </div>
                <div style="display: flex; justify-content: space-between;">
                    <input type="button" value="注册" id="register" style="width: 40%; padding: 9px 0px;"/>
                    <input type="button" value="返回首页" id="toIndex" style="width: 40%; padding: 9px 0px;"/>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script src="resources/js/register.js"></script>
</body>
</html>
