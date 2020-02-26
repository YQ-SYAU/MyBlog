<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10 0010
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <link rel="canonical" href="https://blog.csdn.net/qq_31792281"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="https://csdnimg.cn/public/favicon.ico" rel="SHORTCUT ICON">
    <title>精英博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/alcsdn1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/alcsdn2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/alcsdn3.css">
    <script type="text/javascript">
        var username = "qq_31792281";
        var blog_address = "https://blog.csdn.net/qq_31792281";
        var static_host = "https://csdnimg.cn/release/phoenix/";
        var currentUserName = "";
        var isShowAds = true;
        var isOwner = false;
        var loginUrl = "http://passport.csdn.net/account/login?from=https://blog.csdn.net/qq_31792281"
        var blogUrl = "https://blog.csdn.net/";

        var curSkin = "skin-yellow";
        // 第四范式所需数据
        var articleTitles = "【Mr_Literature的博客】分享一些学习的知识和经验，以及学习历程！";

        var nickName = "Mr_Literature";
        var isCorporate = false;
        var subDomainBlogUrl = "https://blog.csdn.net/"
        var digg_base_url = "https://blog.csdn.net/qq_31792281/phoenix/comment";
        var articleDetailUrl = "";
    </script>
    <script src="https://csdnimg.cn/public/common/libs/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="https://csdnimg.cn/rabbit/exposure-click/main-1.0.6.js"></script>
    <script src="//g.csdnimg.cn/??fixed-sidebar/1.1.3/fixed-sidebar.js,track/1.2.6/track.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://csdnimg.cn/public/sandalstrap/1.4/css/sandalstrap.min.css">
    <style>
        .MathJax, .MathJax_Message, .MathJax_Preview{
            display: none
        }
    </style>
</head>
<body class="nodata " >
<!--   <link rel="stylesheet" href="https://csdnimg.cn/public/common/toolbar/content_toolbar_css/content_toolbar.css"> -->
<!--  <script id="toolbar-tpl-scriptId" src="https://csdnimg.cn/public/common/toolbar/js/content_toolbar.js"
 type="text/javascript" domain="https://blog.csdn.net/"></script> -->
<link rel="stylesheet" href="https://csdnimg.cn/release/phoenix/vendor/pagination/paging.css">
<header>
    <div class="container d-flex clearfix">
        <div class="title-box">
            <h1 class="title-blog">
                <a href="https://blog.csdn.net/qq_31792281">${userInfo.username}的博客</a>
            </h1>
            <p class="description ">${userInfo.description}</p>
        </div>
        <div class="opt-box d-flex justify-content-end">
        </div>
    </div>
</header>
<!-- <script src="https://dup.baidustatic.com/js/ds.js"></script> -->
<div class="container clearfix pt0" id="mainBox">
    <main>



        <div class="article-list">

            <div class="article-list">
                <c:forEach items="${articleList}" var="article">
                    <div class="article-item-box csdn-tracking-statistics" data-articleid="80161032">
                        <h4 class="">
                            <a href="${pageContext.request.contextPath}/index/findById?id=${article.id}" target="_blank">
                                <span class="article-type type-1 float-none">原</span>${article.title}</a>
                        </h4>
                        <p class="content">
                            <a href="${pageContext.request.contextPath}/index/findById?id=${article.id}" target="_blank">
                                <c:choose>
                                    <c:when test="${article.content.length()>80}">
                                        ${fn:substring(article.content,0 , 80)}......
                                    </c:when>
                                    <c:otherwise>${article.content}</c:otherwise>
                                </c:choose>
                            </a>
                        </p>
                        <div class="info-box d-flex align-content-center">
                            <p>
                                <span class="date">${article.publishTime}</span>
                            </p>
                            <p class="point"></p>
                            <p>
                                <span class="read-num">阅读数 <span class="num">${article.browse}</span> </span>
                            </p>
                            <p class="point"></p>
                            <p>
                                <span class="read-num">评论数 <span class="num">${article.commentNum}</span> </span>
                            </p>
                            <p class="point"></p>
                            <p>
                                <span class="read-num">点赞数 <span class="num">${article.support}</span> </span>
                            </p>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </main>
    <aside>
        <div id="asideProfile" class="aside-box">
            <!-- <h3 class="aside-title">个人资料</h3> -->
            <div class="profile-intro d-flex">
                <div class="avatar-box d-flex justify-content-center flex-column">
                    <a href="javascript:void(0)">
                        <img src="${pageContext.request.contextPath}/picture/${userInfo.picture}" class="avatar_pic">

                    </a>

                </div>
                <div class="user-info d-flex justify-content-center flex-column">
                    <p class="name csdn-tracking-statistics tracking-click" data-mod="popu_379">
                        <a href="https://me.csdn.net/qq_31792281" target="_blank" class="" >${userInfo.username}</a>
                    </p>
                </div>
                <div class="opt-box d-flex justify-content-center flex-column">
            <span  class="csdn-tracking-statistics tracking-click" data-mod="popu_379">
                                     <c:choose>
                                         <c:when test="${aflag==0}">
                                             <a href="javascript:void(0);"  class="btn btn-sm btn-red-hollow attention" id="btnAttent">关注</a><!-- 关注 -->
                                         </c:when>
                                         <c:otherwise>
                                             <a href="javascript:void(0);"  class="btn btn-sm btn-red-hollow attention" id="btnAttent">取关</a><!-- 取消关注 -->
                                         </c:otherwise>
                                     </c:choose>
                            </span>
                </div>
            </div>
            <div class="data-info d-flex item-tiling">


                <dl class="text-center" title="21">
                    <dt><a href="#">原创</a></dt>
                    <dd><a href="https://blog.csdn.net/qq_31792281?t=1"><span class="count">${userArticleNum}</span></a></dd>
                </dl>


                <dl class="text-center" id="fanBox" title="${userInfo.fans}">
                    <dt>粉丝</dt>
                    <dd><span class="count" id="fan">${userInfo.fans}</span></dd>
                </dl>


                <dl class="text-center" title="56">
                    <dt>喜欢</dt>
                    <dd><span class="count">${supportNum}</span></dd>
                </dl>


                <dl class="text-center" title="7">
                    <dt>评论</dt>
                    <dd><span class="count">${userCommentNum}</span></dd>
                </dl>
            </div>

        </div>

    </aside>

    <script>
        $("a.flexible-btn").click(function(){
            $(this).parents('div.aside-box').removeClass('flexible-box');
            $(this).remove();
        })
    </script>
</div>

<%-- 发布文章用户id--%>
<input type="hidden" value="${userInfo.id}" id="other_uId">
<%--查看的用户的id--%>
<input type="hidden" value="${oUser.id}" id="uId">


<script>
    var currentPage = 1;
    var baseUrl = 'https://blog.csdn.net/qq_31792281/article/list' ;
    var pageSize = 20 ;
    var listTotal = 21 ;
    var pageQueryStr = '?t=1&';
    function getAllUrl(page) {
        return baseUrl + "/" + page + pageQueryStr;
    }
</script>


<script src="https://csdnimg.cn/release/phoenix/vendor/pagination/paging.js"></script>

<script src="https://csdnimg.cn/release/phoenix/template/js/list-7c51275791.min.js"></script>


<script>
    //关注
    $("#btnAttent").click(function () {

        //判断内容是关注还是取消关注
        var content = $("#btnAttent").text();

        //获取发布文章用户id
        var oId = $("#other_uId").val();
        //获取用户id
        var uId = $("#uId").val();
        if(typeof uId=="undefined" || uId==null || uId.length==0){
            //未登录
            location.href ="${pageContext.request.contextPath}/pages/login.jsp";
        }else{

            //登录

            if(content=="关注"){//未关注
                //发送ajax请求
                $.post("${pageContext.request.contextPath}/supAndAtt/saveAttention",
                    "other.id="+oId+"&myself.id="+uId,
                    function (data) {
                        location.reload(true);
                    }
                )
            }else{//关注
                //发送ajax请求
                $.post("${pageContext.request.contextPath}/supAndAtt/delAttention",
                    "other.id="+oId+"&myself.id="+uId,
                    function (data) {
                        location.reload(true);
                    }
                )
            }}
    });

</script>
</body>
</html>

