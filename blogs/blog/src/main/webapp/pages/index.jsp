<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/14 0014
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>精英博客</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/nprogress.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.lazyload.min.js"></script>


</head>
<body class="user-select">
<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <img  title="精英博客" width="150px" height="60px" style="float: left" src="${pageContext.request.contextPath}/images/logo.png"/>
            <div class="header-topbar hidden-xs link-border">
                <ul class="site-nav topmenu">
                    <security:authorize access="hasRole('ADMIN')">
                        <li><a href="${pageContext.request.contextPath}/syslog/adminIndex" target="_blank">后台管理</a></li>
                    </security:authorize>
                    <!-- 只有登录的才可以看见-->
                    <sec:authorize access="isFullyAuthenticated()" var="isFullyAuthenticated">
                        <li><a href="${pageContext.request.contextPath}/mySpace/showInfo?uId=${userInfo.id}" target="_blank">个人中心</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout" >注销</a></li>
                    </sec:authorize>
                    <c:if test="${isFullyAuthenticated == false}">
                        <li><a href="${pageContext.request.contextPath}/pages/login.jsp" >登录</a></li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/pages/register.jsp" rel="nofollow" >注册</a></li>
                </ul>
            </div>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>

            </div>
            <div class="collapse navbar-collapse" id="header-navbar">


            </div>
        </div>
    </nav>
</header>


<section class="container">
    <div class="content-wrap">
        <div class="content">
            <div id="focusslide" class="carousel slide" data-ride="carousel" >
                <ol class="carousel-indicators">
                    <li data-target="#focusslide" data-slide-to="0" class="active"></li>
                    <li data-target="#focusslide" data-slide-to="1"></li>
                    <li data-target="#focusslide" data-slide-to="2"></li>
                </ol>
                <!-- 轮播图开始 -->
                <div class="carousel-inner" role="listbox"  >
                    <div class="item active" >
                        <a href="#" target="_blank"   title="精英博客，欢迎您">
                            <img width="820px" height="400px" src="${pageContext.request.contextPath}/picture/${slideshow.picture1}" alt="亲，网络不太好哦" class="img-responsive"></a>
                    </div>
                    <div class="item">
                        <a href="#" target="_blank" title="精英博客，欢迎您" >
                            <img width="820px" height="200px" src="${pageContext.request.contextPath}/picture/${slideshow.picture2}" class="img-responsive"></a>
                    </div>
                    <div class="item">
                        <a href="#" target="_blank" title="精英博客，欢迎您" >
                            <img width="820px" height="200px" src="${pageContext.request.contextPath}/picture/${slideshow.picture3}" class="img-responsive"></a>
                    </div>
                </div>
                <!-- 轮播图结束 -->
                <a class="left carousel-control" href="#focusslide" role="button" data-slide="prev" rel="nofollow">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">上一个</span>
                </a>
                <a class="right carousel-control" href="#focusslide" role="button" data-slide="next" rel="nofollow">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">下一个</span>
                </a>
                </div>

            <div class="title">
                <h3 style="color: green">最新发布</h3>
                <div class="more">
                    <a style="font-size: 20px;color: #0f74a8" href="${pageContext.request.contextPath}/index/showIndex" title="首页" >首页</a>
                    <c:forEach items="${categoryList}" var="category">
                        <a style="font-size: 20px;color: #0f74a8" href="${pageContext.request.contextPath}/index/findByCid?cid=${category.id}&pageNum=1" title="${category.cname}" >${category.cname}</a>
                    </c:forEach>
                </div>
            </div>

            <c:forEach items="${newList}" var="article">
            <article class="excerpt excerpt-1" style="">
                    <a class="focus" href="${pageContext.request.contextPath}/index/findById?id=${article.id}"  target="_blank" ><img class="thumb"  src="${pageContext.request.contextPath}/picture/${article.picture}"  style="display: inline;"></a>
                    <header><a class="cat" href="${pageContext.request.contextPath}/index/findById?id=${article.id}" >${article.user.username}<i></i></a>
                        <h2><a href="${pageContext.request.contextPath}/index/findById?id=${article.id}" target="_blank" >${article.title}</a>
                        </h2>
                    </header>
                    <p class="meta">
                        <span>${article.category.cname}&nbsp;&nbsp;</span>
                        <time class="time"><img title="时间" src="${pageContext.request.contextPath}/images/time.png"> ${article.publishTime}</time>
                        <span class="views"><img title="点赞量" src="${pageContext.request.contextPath}/images/support.png">${article.support}</span>
                        <img title="浏览量" src="${pageContext.request.contextPath}/images/browse.png"></i>${article.browse}
                    </p>
                    <p class="note" style="font-size: 15px">
                        <c:choose>
                            <c:when test="${article.content.length()>130}">
                                ${fn:substring(article.content,0 , 130)}......
                            </c:when>
                            <c:otherwise>${article.content}</c:otherwise>
                        </c:choose>
                     </p>
                </article>
            </c:forEach>

        </div>
    </div>

    <!-- 排行榜-->
    <aside class="sidebar">

        <div class="widget widget_hot">
            <h3 style="color: red">热门文章<span style="font-size: 10px">(点赞最多)</span></h3>
            <ul>
                <c:forEach items="${supportList}" var="article">
                    <li>
                        <a  href="${pageContext.request.contextPath}/index/findById?id=${article.id}" >
                        <span class="thumbnail">
				        <img class="thumb"  src="${pageContext.request.contextPath}/picture/${article.picture}" alt="${article.title}"  style="display: block;">
			            </span>
                            <!-- 标题-->
                            <span class="text">${article.title}</span>
                            <span class="muted">
                            <span>${article.category.cname}</span><br/>
                            <span class="muted">
                            <img title="时间" src="${pageContext.request.contextPath}/images/time.png">
				            ${article.publishTime}
			                 </span>
                            <br/>
                            <span title="点赞量" class="muted"><img src="${pageContext.request.contextPath}/images/support.png">
                            ${article.support}
                        </span>
                        </a>
                    </li>
                </c:forEach>

            </ul>
        </div>

        <div class="widget widget_hot">
            <h3 style="color: red">热门文章<span style="font-size: 10px">(浏览最多)</span></h3>
            <ul>
                <c:forEach items="${browseList}" var="article">
                    <li>
                        <a href="${pageContext.request.contextPath}/index/findById?id=${article.id}" >
                        <span class="thumbnail">
				        <img class="thumb"  src="${pageContext.request.contextPath}/picture/${article.picture}" alt="${article.title}"  style="display: block;">
			            </span>
                            <!-- 标题-->
                            <span class="text">${article.title}</span>

                            <span class="muted">
                             <span>${article.category.cname}</span><br/>
                                <span class="muted">
                            <img title="时间" src="${pageContext.request.contextPath}/images/time.png">
				            ${article.publishTime}
			            </span>
                            <br/>
                            <span class="muted"><img title="浏览量" src="${pageContext.request.contextPath}/images/browse.png">
                            ${article.browse}
                        </span>
                            </span>
                        </a>

                    </li>
                </c:forEach>

            </ul>
        </div>

    </aside>
</section>



<footer class="footer">

    <div id="gotop"><a class="gotop"></a></div>
</footer>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ias.js"></script>
<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>
</html>


