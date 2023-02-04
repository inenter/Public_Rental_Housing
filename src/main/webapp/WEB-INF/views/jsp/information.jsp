<%--
  Created by IntelliJ IDEA.
  User: LQB
  Date: 2022/11/29
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Real Estate Builders Free Responsive Website Templates - icon">
    <meta name="author" content="webThemez.com">
    <title>公租房租赁平台-资料上传</title>
    <link rel="favicon" href="resources/images/favicon.png">
    <link rel="stylesheet" href="resources/css2/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css2/font-awesome.min.css">
    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="resources/css2/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" href="resources/css2/style.css">
<%--    <link rel="stylesheet" href="resources/css2/about.css" />--%>
    <link rel="stylesheet" href="resources/css2/information.css" />
</head>

<body>
<!-- Fixed navbar -->
<div class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span
                    class="icon-bar"></span></button>
            <a class="navbar-brand" href="index.html">
                <img src="resources/images/logo.png" alt="Techro HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right mainNav" id="tar">
                <li><a href="<%=request.getContextPath()%>/index">首页</a></li>
                <li><a href="<%=request.getContextPath()%>/house">房源</a></li>
                <c:if test="${acc == null}">
                    <li><a href="<%=request.getContextPath()%>/login">登录</a></li>
                    <li><a href="<%=request.getContextPath()%>/register">注册</a></li>
                </c:if>
                <c:if test="${acc != null }">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${acc}<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li id="cancel"><a href="#">注销</a></li>
                        </ul>
                    </li>
                </c:if>
                <li class="active"><a onclick="myInfo()" href="#">我的资料</a></li>
            </ul>
        </div>
    </div>
</div>

<header id="head" class="secondary">
    <div class="container">
        <div class="row">
            <div class="col-sm-8">
                <h1>房源</h1>
            </div>
        </div>
    </div>
</header>

<!-- 申请资料上传 -->
<section class="container de">
    <div class="row detail">
        <section class="col-sm-8 maincontent detail-con">
            <h4 class="title">申请人基本信息</h4>
            <div class="show">
                <table cellpadding="1" cellspacing="1" border="1">
                    <tr>
                        <td>申请人姓名*:</td>
                        <td>
                            <input placeholder="长度为(2~20)" value="" id="username" />
                        </td>
                        <td>身份证号*:</td>
                        <td>
                            <input value="" id="idCard" />
                        </td>
                        <td>出生年月:</td>
                        <td>
                            <input type="date" value="" id="birth" />
                        </td>
                    </tr>
                    <tr>
                        <td>手机*:</td>
                        <td>
                            <input value="" id="phone" />
                        </td>
                        <td>保障类型:</td>
                        <td>
                            <select id="entype">
                                <option value="A类" selected>A类</option>
                                <option value="B类">B类</option>
                                <option value="C类">C类</option>
                                <option value="D类">D类</option>
                            </select>
                        </td>
                        <td>申请的区域*:</td>
                        <td>
                            <button type="button" style="width: 180px" data-toggle="modal" onclick="findProvinces()" id="selected"
                                    data-target="#staticBackdrop" style="background-color: white !important;">选择区域</button>
                            <!-- Modal -->
                            <div class="modal fade" id="staticBackdrop" data-backdrop="static"
                                 data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 style="font-size: 25px;" class="modal-title" id="staticBackdropLabel">选择区域</h5>
                                        </div>
                                        <div class="modal-body">
                                            <select id="selectProvince" onchange="findCity(this)"></select>
                                            <select id="selectCity" onchange="findArea(this)"></select>
                                            <select id="selectArea"></select>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal" id="closeRead">关闭</button>
                                            <button type="button" class="btn btn-primary"  data-dismiss="modal" id="saveArea">保存</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>家庭年收入*:</td>
                        <td>
                            <input id="income" />
                        </td>
                        <td>住房面积*:</td>
                        <td>
                            <input id="areasize" />
                        </td>
                        <td>家庭人数*:</td>
                        <td>
                            <input id="people" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>身份证上传*:</td>
                        <td>
                            <div onclick="upload(this)" id="uploadCard">上传</div>
                            <input type="file" value="上传" id="cardImg" style="display: none;" />
                        </td>
                        <td>户口本上传*:</td>
                        <td>
                            <div onclick="upload(this)" id="uploadBook">上传</div>
                            <input type="file" value="上传" id="bookImg" style="display: none;" />
                        </td>
                        <td>毕业证上传:</td>
                        <td>
                            <div onclick="upload(this)" id="uploadCer">上传</div>
                            <input type="file" value="上传" id="cerImg" style="display: none;" />
                        </td>
                    </tr>
                    <tr>
                        <td>备注</td>
                        <td colspan="5">
                            <textarea id="info" placeholder="文字字数为0~50" rows="2" cols="20" maxlength="50"></textarea>
                        </td>
                    </tr>
                </table>
            </div>
        </section>
        <section class="detail-con">
            <button class="fam" id="fams">家庭成员添加</button>
            <div class="show show-sen" id="family" style="display: none !important;">
                <table border="1">
                    <thead>
                    <tr>
                        <td>与本人关系</td>
                        <td>姓名*</td>
                        <td>身份证号*</td>
                        <td>职业</td>
                        <td>出生年月</td>
                        <td>手机号*</td>
                        <td>身份证上传*</td>
                        <td>户口本上传*</td>
                        <td>操作</td>
                    </tr>
                    </thead>
                </table>
            </div>
        </section>

        <section class="col-sm-8 maincontent detail-con">
            <div class="save show">
                <button id="save">保存</button>
                <button type="button" data-toggle="modal" data-target="#exampleModal" id="check">预览</button>
                <button id="submit">提交</button>
            </div>
        </section>
    </div>
</section>

<!-- 预览 -->
<div>
    <div style="z-index: 99999;" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 1300px;">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel" style="font-size: 22px;">预览</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <section class="col-sm-8 maincontent" style="width: 1260px;">
                            <h4 class="title" style="margin-left: 20px">申请人基本信息</h4>
                            <div class="showData">
                                <table cellpadding="1" cellspacing="1" border="1">
                                    <tr>
                                        <td>申请人姓名:</td>
                                        <td>
                                            <span id="selfName"></span>
                                        </td>
                                        <td>身份证号:</td>
                                        <td>
                                            <span id="selfIdCard"></span>
                                        </td>
                                        <td>出生年月:</td>
                                        <td>
                                            <span id="selfBirth"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>手机:</td>
                                        <td>
                                            <span id="selfPhone"></span>
                                        </td>
                                        <td>保障类型:</td>
                                        <td>
                                            <span id="selfEnType"></span>
                                        </td>
                                        <td>申请的区域:</td>
                                        <td>
                                            <span id="selectProvinces"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>家庭年收入:</td>
                                        <td>
                                            <span id="selfIncome"></span>
                                        </td>
                                        <td>住房面积:</td>
                                        <td>
                                            <span id="selfAreaSize"></span>
                                        </td>
                                        <td>家庭人数:</td>
                                        <td>
                                            <span id="selfPeople"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>身份证上传</td>
                                        <td>
                                            <img alt="" id="selfCardName">
                                        </td>
                                        <td>户口本上传</td>
                                        <td>
                                            <img alt="" id="selfBook">
                                        </td>
                                        <td>毕业证上传</td>
                                        <td>
                                            <img alt="" id="selfCer">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>备注</td>
                                        <td colspan="5">
                                            <span id="selfInfo"></span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </section>
                        <section class="col-sm-8 maincontent detail-con" style="margin-top: 20px">
                            <h4 class="title" id="read" style="display: none;">家庭成员信息</h4>
                            <div class="showData show-sen" id="readFamily">
                                <table border="1">
                                    <thead>
                                    <tr>
                                        <td>与本人关系</td>
                                        <td>姓名</td>
                                        <td>身份证</td>
                                        <td>职业</td>
                                        <td>出生年月</td>
                                        <td>手机号</td>
                                        <td>身份证上传</td>
                                        <td>户口本上传</td>
                                    </tr>
                                    </thead>
                                </table>
                            </div>
                        </section>
                    </div>
                </div>
                <div class="modal-footer">
                    <button style="outline: none; background-color: rgb(40,167,69);" type="button" class="btn btn-secondary" data-dismiss="modal" id="closeReading">关闭</button>
                    <button style="outline: none; background-color: rgb(11,196,223);" type="button" class="btn btn-primary" data-dismiss="modal" id="checkSave">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script type='text/javascript' src='resources/js/jquery.min.js'></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jq.js"></script>
<script src="resources/js/information.js"></script>
<script src="resources/js/area.js"></script>
<script src="resources/js/cancel.js"></script>
</body>
</html>

