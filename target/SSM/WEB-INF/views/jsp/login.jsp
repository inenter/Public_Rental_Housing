<%--
  Created by IntelliJ IDEA.
  User: LQB
  Date: 2022/11/26
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <title>用户登录</title>
    <meta name="keywords" content="Apps Login Form Responsive widget, Flat Web Templates, Android Compatible web template,
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<div class="agile-login">
    <h1>公租房租赁平台</h1>
    <div class="wrapper">
        <h2>欢迎登录</h2>
        <div class="w3ls-form">
            <form action="" method="post">
                <label>账号</label>
                <input type="text" name="name" placeholder="用户账号" id="userAcc" required/>
                <label>密码</label>
                <input type="text" name="password" placeholder="用户密码" id="password" required/>
                <label>验证码</label>
                <div style="display: flex">
                    <input type="text" name="code" placeholder="验证码" id="code" style="width: 70%; margin-right: 10px" required/>
                    <img src="checkCode" onclick="changePic()" id="prcode">
                </div>
                <input type="button" value="登录" id="login"/>
                <a href="<%=request.getContextPath()%>/register" class="pass">前往注册</a>
            </form>
        </div>
    </div>
</div>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script src="resources/js/login.js"></script>
</body>
</html>
