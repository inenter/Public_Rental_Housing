<%--
  Created by IntelliJ IDEA.
  User: LQB
  Date: 2022/11/27
  Time: 14:25
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
    <title>公租房租赁平台-房源</title>
    <link rel="favicon" href="resources/images/favicon.png">
    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="resources/css2/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css2/font-awesome.min.css">
    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="resources/css2/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" href="resources/css2/style.css">
    <link rel="stylesheet" href="resources/css2/house.css"/>
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
            <ul class="nav navbar-nav pull-right mainNav">
                <li><a href="<%=request.getContextPath()%>/index">首页</a></li>
                <li class="active"><a href="#">房源</a></li>
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
                    <li><a href="<%=request.getContextPath()%>/information">我的资料</a></li>
                </c:if>
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

<!-- container -->
<section class="container">
    <div class="row about">
        <!-- main content -->
        <section style="display: flex; justify-content: space-between; padding: 15px">
            <div style="display: flex; border: 0; outline: none; font-size: 20px">
                <select id="selectProvince" onchange="findCity(this)" style="margin-right: 15px; "></select>
                <select id="selectCity" onchange="findArea(this)"></select>
            </div>
            <div style="display: flex;  border: 0;">
                <input id="search-content" type="text" maxlength="10" placeholder="请输入小区关键字(10字以内)">
                <button id="search">搜索</button>
            </div>
        </section>
        <!-- /main -->
        <section class="col-sm-8 maincontent about-main">
            <div class="rowes">
                <h4 class="title">区域：</h4>
                <div class="selected" id="area">
                    <span class="houseArea" value="思明区" id="587">思明区</span>
                    <span class="houseArea" value="海沧区" id="588">海沧区</span>
                    <span class="houseArea" value="海沧区" id="589">湖里区</span>
                    <span class="houseArea" value="集美区" id="590">集美区</span>
                    <span class="houseArea" value="同安区" id="591">同安区</span>
                    <span class="houseArea" value="翔安区" id="592">翔安区</span>
                </div>
            </div>
            <div class="rowes">
                <h4 class="title">小区：</h4>
                <div class="selected" id="town">
                    <span class="houseArea" id="1">福样花园</span>
                    <span class="houseArea" id="2">东方威尼斯</span>
                    <span class="houseArea" id="3">水岸豪景</span>
                    <span class="houseArea" id="4">桃源大厦</span>
                </div>
            </div>
            <div class="rowes">
                <h4 class="title">户型：</h4>
                <div class="selected" id="houseType">
                    <span id="1-0">一室</span>
                    <span id="1-1">一室一厅</span>
                    <span id="2-0">两室</span>
                    <span id="2-1">两室一厅</span>
                    <span id="3-0">三室</span>
                    <span id="3-1">三室一厅</span>
                    <span id="4-0">四室</span>
                    <span id="4-1">四室一厅</span>
                </div>
            </div>
            <div class="rowes">
                <h4 class="title">租金：</h4>
                <div class="selected" id="housePrice">
                    <span>0-1000</span>
                    <span>1000-1999</span>
                    <span>2000-2999</span>
                    <span>3000-3999</span>
                    <span>4000-4999</span>
                    <span>5000-5999</span>
                    <span>6000-6999</span>
                    <span>7000-10000</span>
                </div>
            </div>
        </section>
    </div>

</section>

<!-- 房屋查询 -->
<section class="news-box">
    <div id="services" class="services-box main-timeline-box">
        <div class="container result">
            <div class="row resulted">
                <div class="col-lg-12">
                    <div class="title-box">
                        <h2>房源展示</h2>
                        <p style="font-size: 20px;">共有36个房源:</p>
                    </div>
                </div>
            </div>
            <div class="row" id="showHouse">

            </div>
            <div class="search">
                <button id="pre">上一页</button>
                <span id="currPage">1</span>
                <span>/</span>
                <span id="pageSize"></span>
                <button id="next">下一页</button>
            </div>
        </div>
    </div>
</section>

<%--修改密码--%>
<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3 class="modal-title">修改密码</h3>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label class="control-label">旧密码:</label>
                        <input type="password" class="form-control" id="oldPwd" placeholder="请输入旧密码">
                    </div>
                    <div class="form-group">
                        <label class="control-label">新密码:</label>
                        <input type="password" class="form-control" id="pwd" placeholder="请输入新密码">
                    </div>
                    <div class="form-group">
                        <label class="control-label">确认密码:</label>
                        <input type="password" class="form-control" id="repwd" placeholder="再输入新密码">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="hidePanel">取消</button>
                <button type="button" class="btn btn-primary" id="ensure">确认</button>
            </div>
        </div>
    </div>
</div>

<!-- 房源详情 -->
<div>
    <div style="z-index: 99999;" class="modal fade" id="exampleModal" tabindex="-1"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 900px;">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel" style="font-size: 25px;">房源详情</h5>
                </div>
                <div class="modal-body">
                    <h1>杨辉路996弄祥云/11号/01楼/102</h1>
                    <div class="sourceInfo">
                        <img src="" alt="">
                        <div style="margin-left: 20px">
                            <h4>房源情况</h4>
                            <span class="rent"></span><span>元/月</span><br>
                            <span>户型：</span><span class="houseType"></span><br>
                            <span>面积：</span><span class="houseSize"></span><br>
                            <span>房号：</span><span class="roomNUm"></span><br>
                            <span>起租日期：2022-12-04</span><br>
                            <span>楼层：</span><span class="buildingNUm"></span><br>
                            <span>小区：</span><span class="address"></span><br>
                            <span>地址：</span><span class="address-info"></span>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button style="outline: none; background-color: rgb(40,167,69);" type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</div>


<footer id="footer">
    <div class="footer2">
        <div class="container">
            <div class="row">
                <div class="col-md-6 panel">
                    <div class="panel-body">
                        <p class="simplenav">
                            <a href="index.html">Home</a> |
                            <a href="about.html">About</a> |
                            <a href="services.html">Services</a> |
                            <a href="price.html">Price</a> |
                            <a href="projects.html">Projects</a> |
                            <a href="contact.html">Contact</a>
                        </p>
                    </div>
                </div>

                <div class="col-md-6 panel">
                    <div class="panel-body">
                        <p class="text-right">
                            Copyright &copy; 2019. Aerosky is one of the <a
                                href="https://webthemez.com/tag/free" target="_blank">free templates</a> by
                            WebThemez.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>

<script type='text/javascript' src='resources/js/jquery.min.js'></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jq.js"></script>
<script src="resources/js/area.js"></script>
<script src="resources/js/house.js"></script>
<script src="resources/js/cancel.js"></script>
</body>
</html>

