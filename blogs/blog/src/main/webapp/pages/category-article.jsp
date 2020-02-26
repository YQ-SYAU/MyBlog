<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4 0004
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>分类展示</title>
    <meta name="keywords" content="软件项目课程设计">
    <meta name="description" content="软件项目课程设计">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/icon.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/nprogress.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.lazyload.min.js"></script>
    <style type="text/css">
        .content{
            margin:0 auto;
            width:80%;
        }
        .fenye{
            text-align: center;
        }
        .fenye .more{
            margin-left: 105px;
        }
    </style>

</head>
<body class="user-select">
<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="header-topbar hidden-xs link-border">
                <ul class="site-nav topmenu">
                    <security:authorize access="hasRole('ADMIN')">
                        <li><a href="${pageContext.request.contextPath}/pages/admin-index.jsp" >后台管理</a></li>
                    </security:authorize>
                    <!-- 只有登录的才可以看见-->
                    <sec:authorize access="isFullyAuthenticated()" var="isFullyAuthenticated">
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
            <div id="focusslide" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#focusslide" data-slide-to="0" class="active"></li>
                    <li data-target="#focusslide" data-slide-to="1"></li>
                </ol>

                <div class="title">
                    <h3>最新发布</h3>
                    <div class="more">
                        <a style="font-size: 20px;color: #0f74a8" href="${pageContext.request.contextPath}/index/showIndex" title="首页" >首页</a>
                        <c:forEach items="${categoryList}" var="category">
                            <a style="font-size: 20px;color: #0f74a8" href="${pageContext.request.contextPath}/index/findByCid?cid=${category.id}" title="${category.cname}" >${category.cname}</a>
                        </c:forEach>
                    </div>
                </div>
                <c:forEach items="${pageInfo.list}" var="article">
                    <article class="excerpt excerpt-1" style="">
                        <a class="focus" href="${pageContext.request.contextPath}/index/findById?id=${article.id}"  target="_blank" ><img class="thumb"  src="${pageContext.request.contextPath}/picture/${article.picture}"  style="display: inline;"></a>
                        <header><a class="cat" href="#" >${article.user.username}<i></i>
                        </a>
                            <h2>
                                <a href="${pageContext.request.contextPath}/index/findById?id=${article.id}" target="_blank" >${article.title}</a>
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
                                <c:when test="${article.content.length()>144}">
                                    ${fn:substring(article.content,0 , 144)}......
                                </c:when>
                                <c:otherwise>${article.content}</c:otherwise>
                            </c:choose>
                        </p>
                    </article>
                </c:forEach>
            </div>
        </div>
        <div class="fenye">
            <div class="more">

                <a href="${pageContext.request.contextPath}/index/findByCid?cid=${param.cid}&pageNum=${pageInfo.prePage}" ><span style="font-size: 20px;color: #0c0c0c">上一页</span></a>
                <c:forEach begin="1" end="${pageInfo.pages}" varStatus="status">
                    <a href="${pageContext.request.contextPath}/index/findByCid?cid=${param.cid}&pageNum=${status.index}" ><span style="font-size: 20px;color: #0c0c0c">${status.index}</span></a>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/index/findByCid?cid=${param.cid}&pageNum=${pageInfo.nextPage}" ><span style="font-size: 20px;color: #0c0c0c">下一页</span></a>
            </div>
        </div>
    </div>>

</section>

<hr>
<footer class="footer">

    <div id="gotop"><a class="gotop"></a></div>
</footer>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ias.js"></script>
<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>
</html>

