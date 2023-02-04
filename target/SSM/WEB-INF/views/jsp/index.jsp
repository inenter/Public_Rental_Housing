<%--
  Created by IntelliJ IDEA.
  User: LQB
  Date: 2022/11/27
  Time: 14:23
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
    <title>公租房租赁平台-首页</title>
    <link rel="favicon" href="resources/images/favicon.png">
    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="resources/css2/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css2/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css2/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" href="resources/css2/style.css">
    <link rel='stylesheet' id='camera-css' href='resources/css2/camera.css' type='text/css' media='all'>
    <link rel="stylesheet" href="resources/css2/index.css">
    <link rel="stylesheet" href="resources/js/layui-v2.6.8/layui/css/layui.css">
</head>
<body>
<!-- 头部导航栏 -->
<div class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span
                    class="icon-bar"></span></button>
            <a class="navbar-brand" href="#">
                <img src="resources/images/logo.png" alt="Techro HTML5 template">
            </a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right mainNav" id="tar">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="<%=request.getContextPath()%>/house">房源</a></li>
                <c:if test="${acc == null}">
                    <li><a href="<%=request.getContextPath()%>/login">登录</a></li>
                    <li><a href="<%=request.getContextPath()%>/register">注册</a></li>
                </c:if>
                <c:if test="${acc != null }">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${acc}<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li data-toggle="modal" data-target="#exampleModal" data-whatever="@fat"><a href="#">修改密码</a></li>
                            <li id="cancel"><a href="#">注销</a></li>
                        </ul>
                    </li>
                    <li><a href="<%=request.getContextPath()%>/information">我的资料</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</div>

<!-- 轮播图 -->
<header id="head">
    <div class="container">
        <div class="fluid_container">
            <div class="camera_wrap camera_emboss pattern_1" id="camera_wrap_4">
                <div data-thumb="resources/images/slides/thumbs/slide1.jpg"
                     data-src="resources/images/slides/slide1.jpg">
                </div>
                <div data-thumb="resources/images/slides/thumbs/slide2.jpg"
                     data-src="resources/images/slides/slide2.jpg">
                </div>
                <div data-thumb="resources/images/slides/thumbs/slide3.jpg"
                     data-src="resources/images/slides/slide3.jpg">
                </div>
            </div>
        </div>
    </div>
</header>

<section class="secpadding">
    <div class="container">
        <div class="row">
            <div class="col-md-12 remark" id="msg">
                <div class="title-box clearfix ">
                    <h2 class="title-box_primary ">我的消息</h2>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="packages" class="secpadding">
    <div class="container commend">
        <h2><span>房源推荐</span></h2>

        <div class="row commend">
            <div class="col-md-3 col-sm-6">
                <div class="cuadro_intro_hover " style="background-color:#cccccc;">
                    <p style="text-align:center;">
                        <img src="resources/images/pic/pic-5.jpg" class="img-responsive" alt="">
                    </p>
                    <div class="caption">
                        <div class="blur"></div>
                        <div class="caption-text">
                            <h3>汤臣一品</h3>
                            <a class=" btn btn-default" href="#"><i>$4600</i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="cuadro_intro_hover " style="background-color:#cccccc;">
                    <p style="text-align:center;">
                        <img src="resources/images/pic/pic-5.jpg" class="img-responsive" alt="">
                    </p>
                    <div class="caption">
                        <div class="blur"></div>
                        <div class="caption-text">
                            <h3>汤臣一品</h3>
                            <a class=" btn btn-default" href="#"><i>$4600</i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="cuadro_intro_hover " style="background-color:#cccccc;">
                    <p style="text-align:center;">
                        <img src="resources/images/pic/pic-5.jpg" class="img-responsive" alt="">
                    </p>
                    <div class="caption">
                        <div class="blur"></div>
                        <div class="caption-text">
                            <h3>汤臣一品</h3>
                            <a class=" btn btn-default" href="#"><i>$4600</i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="cuadro_intro_hover " style="background-color:#cccccc;">
                    <p style="text-align:center;">
                        <img src="resources/images/pic/pic-5.jpg" class="img-responsive" alt="">
                    </p>
                    <div class="caption">
                        <div class="blur"></div>
                        <div class="caption-text">
                            <h3>汤臣一品</h3>
                            <a class=" btn btn-default" href="#"><i>$4600</i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%--修改密码--%>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3 class="modal-title" id="exampleModalLabel">修改密码</h3>
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
            </div>
        </div>
    </div>
</footer>

<script type='text/javascript' src='resources/js/jquery.min.js'></script>
<script type='text/javascript' src='resources/js/jquery.easing.1.3.js'></script>
<script type='text/javascript' src='resources/js/camera.min.js'></script>
<script src="resources/js/bootstrap.min.js"></script>

<script>
    jQuery(function() {
        jQuery('#camera_wrap_4').camera({
            height: '750',
            loader: 'bar',
            pagination: false,
            thumbnails: false,
            hover: false,
            opacityOnGrid: false,
            imagePath: 'resources/images/'
        });
    });
</script>
<script src="resources/js/index.js"></script>
<script src="resources/js/cancel.js"></script>
<script src="resources/js/layui-v2.6.8/layui/layui.js"></script>

</body>
</html>

