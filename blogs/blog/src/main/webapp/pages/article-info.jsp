<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4 0004
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>文章详情</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/icon.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sandalstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/nprogress.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.lazyload.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/html5shiv.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/respond.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/selectivizr-min.js" type="text/javascript"></script>

    <style type="text/css">
        /*文章图片  352  240*/
        .picture-img{
            width: 352px;
            height: 240px;
        }

        /*点赞*/
        .support {
            text-align: center;
            font-size: 20px;
            vertical-align: middle;
        }
        .support img{
            display: inline-block;

        }
    </style>

</head>
<body class="user-select single">
<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="header-topbar hidden-xs link-border">
                <ul class="site-nav topmenu">
                    <%--<li><a href="login.html" >登录</a></li>--%>
                    <%--<li><a href="register.html" >注册</a></li>--%>

                </ul>
                勤记录 懂分享</div>
            <div class="navbar-header">

            </div>
            <div class="collapse navbar-collapse" id="header-navbar">

                <ul class="nav navbar-nav navbar-right">
                    <li> <a style="font-size: 20px;color: #0f74a8" href="${pageContext.request.contextPath}/index/showIndex" title="首页" >首页</a></li>
                    <c:forEach items="${categoryList}" var="category">
                        <li>   <a style="font-size: 20px;color: #0f74a8" href="${pageContext.request.contextPath}/index/findByCid?cid=${category.id}&pageNum=1" title="${category.cname}" >${category.cname}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </nav>
</header>
<section class="container">
    <div class="content-wrap">
        <div class="content">
            <header class="article-header">
                <h1 class="article-title"><a href="javascript:void(0);" title="题目" >${article.title}</a></h1>
                <div class="article-meta"> <span class="item article-meta-time">
	  <time class="time" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="发表时间：${article.publishTime}">
	  	<img src="${pageContext.request.contextPath}/images/time.png"> <a href="javascript:void(0);" title="发表时间" >${article.publishTime}</a></time>
	  </span>
                    <span class="item article-meta-source" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="来源：${article.user.username}">
	  	<img src="${pageContext.request.contextPath}/images/username.png"> <a href="javascript:void(0);" title="用户名" >${article.user.username}</a> </span>
                    <span class="item article-meta-category" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="MZ-NetBlog主题">
	  		<img src="${pageContext.request.contextPath}/images/category.png">
	  		<a href="javascript:void(0);" title="分类名称" >${article.category.cname}</a></span>
                    <span class="item article-meta-views" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="浏览量：${article.browse}">
                        <img  title="浏览量" src="${pageContext.request.contextPath}/images/browse.png"> <a href="javascript:void(0);" title="浏览量" >${article.browse}</a></span>
                    <span class="item article-meta-comment" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="评论量"><img src="${pageContext.request.contextPath}/images/comment.png"> <a href="javascript:void(0);" title="评论量" >${commentCount}</a></span> </div>
            </header>
            <article class="article-content">
                <p><img src="${article.picture}" alt="" /></p>
                <p>${article.content}</p>
                <div>
                    <img class="picture-img" src="${pageContext.request.contextPath}/picture/${article.picture}">
                </div>

               <!-- 点赞-->
                <div class="support">
                    <c:choose>
                       <c:when test="${flag==0}">
                           <img id="support" src="${pageContext.request.contextPath}/images/nonsupport32.png">&nbsp;&nbsp;${article.support}
                       </c:when>
                        <c:otherwise>
                            <img id="support" src="${pageContext.request.contextPath}/images/support32.png">&nbsp;&nbsp;${article.support}
                        </c:otherwise>
                    </c:choose>


                </div>

                <div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_tieba" data-cmd="tieba" title="分享到百度贴吧"></a><a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a></div>
                <script>                  window._bd_share_config = { "common": { "bdSnsKey": {}, "bdText": "", "bdMini": "2", "bdMiniList": false, "bdPic": "", "bdStyle": "1", "bdSize": "32" }, "share": {} }; with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=0.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
            </article>


            <div class="title" id="comment">
                <h3>评论(登录后才可评论哦...)</h3>
            </div>
            <sec:authorize access="isFullyAuthenticated()" var="isFullyAuthenticated">
                <div id="respond">
                    <form id="comment-form" name="comment-form" action="${pageContext.request.contextPath}/comment/save" method="POST">
                        <div class="comment">
                            <div class="comment-box">
                                <textarea maxlength="600" placeholder="您的评论(最多600字)" name="content" id="comment-textarea" cols="100%" rows="3" tabindex="3"></textarea>
                                <input type="hidden" id="aId" name="aId" value="${article.id}">
                                <input type="hidden" id="uId" name="userInfo.id" value="${userInfo.id}">
                                <div class="comment-ctrl">
                                    <div class="comment-prompt" style="display: none;"> <i class="fa fa-spin fa-circle-o-notch"></i> <span class="comment-prompt-text">评论正在提交中...请稍后</span> </div>
                                    <div class="comment-success" style="display: none;"> <i class="fa fa-check"></i> <span class="comment-prompt-text">评论提交成功...</span> </div>
                                    <button type="submit" name="comment-submit" id="comment-submit" tabindex="4">评论</button>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </sec:authorize>

            <div id="postcomments">
                <ol id="comment_list" class="commentlist">
                   <c:forEach items="${commentsList}" var="comment" varStatus="status">
                       <li class="comment-content"><span class="comment-f">#${status.index+1}</span><div class="comment-main"><p><a class="address" href="#" rel="nofollow" target="_blank">${comment.userInfo.username}</a><span class="time">(${comment.cTime})</span><br>${comment.content}</p></div></li>
                       </c:forEach>
                </ol>
            </div>
        </div>
    </div>
    <aside class="sidebar">
        <div class="fixed">


        </div>
        <div class="widget widget_hot">
            <!--  <div id="page" class="hfeed site"> -->



            <div id="sidebar" class="widget-area all-sidebar">





                <aside id="about-2" class="widget about wow fadeInUp" data-wow-delay="0.3s">
                    <h3 class="widget-title">
					<span class="title-i">
						<span class="title-i-t"></span>
						<span class="title-i-b"></span>
						<span class="title-i-b"></span>
						<span class="title-i-t"></span>
					</span>关于作者</h3><div id="feed_widget">
                    <div class="feed-about">



                        <div class="about-main">
                            <div class="about-img" style="text-align: center"><!-- 头像文件 -->
                                <a href="${pageContext.request.contextPath}/index/otherPublish?uId=${article.user.id}"><img style="width: 180px;height: 150px" src="${pageContext.request.contextPath}/picture/${article.user.picture}" alt="name" /></a>
                            </div>
                            <div class="profile-intro d-flex">
                                <div class="about-name">${article.user.username}</div><!-- 用户名 -->

                                <div class="opt-box d-flex justify-content-center flex-column"  id="guanzhu">
                                    <span  class="csdn-tracking-statistics tracking-click" data-mod="popu_379">
                                        <input type="hidden" id="other_uId" value="${article.user.id}">
                                         <c:choose>
                                             <c:when test="${aflag==0}">
                                                 <a href="javascript:void(0);"  class="btn btn-sm btn-red-hollow attention" id="btnAttent">关注</a><!-- 关注 -->
                                             </c:when>
                                             <c:otherwise>
                                                 <a href="javascript:void(0);"  class="btn btn-sm btn-red-hollow attention" id="btnAttent">取消关注</a><!-- 关注 -->
                                             </c:otherwise>
                                         </c:choose>
                                    <%--<a   class="btn btn-sm btn-red-hollow attention" id="btnAttent">关注</a><!-- 关注 -->--%>
                                </span>
                                </div>
                            </div>
                            <div class="about-the">${article.user.description}</div>
                        </div>
                        <hr>




                        <div class="data-info d-flex item-tiling">
                            <div id="asideProfile" class="aside-box">
                                <dl class="text-center" title="23">
                                    <dt><!-- <a href="https://blog.csdn.net/qq_24334403?t=1"> -->原创<!-- </a> --></dt>
                                    <dd><!-- <a href="https://blog.csdn.net/qq_24334403?t=1"> --><span class="count">${count}</span><!-- </a> --></dd>
                                </dl>
                                <hr>
                                <dl class="text-center" id="fanBox" title="3">
                                    <dt>粉丝</dt>
                                    <dd><span class="count" id="fan">${article.user.fans}</span></dd>
                                </dl>
                                <hr>
                                <dl class="text-center" title="4">
                                    <dt>QQ邮箱</dt>
                                    <dd><span class="count">${article.user.qq}@qq.com</span></dd>
                                </dl>
                                <hr>
                                <dl class="text-center" title="1">
                                    <dt>性别</dt>
                                    <dd><span class="count">${article.user.gender}</span></dd>
                                </dl>

                            </div>
                        </div>
                        <!-- <div class="about-inf">
                            <span class="about-pn">文章 396</span>
                            <span class="about-cn">留言 24</span>
                        </div> -->
                    </div>
                </div>

                    <div class="clear"></div></aside>
            </div>


            </div>


    </aside>
</section>
<footer class="footer">

    <div id="gotop"><a class="gotop"></a></div>
</footer>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ias.js"></script>
<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</body>
<script>

    $("#comment-form").submit(function () {
        //获取评论内容
        var content = $("#comment-textarea").val();
        if(content.trim().length==0){
            alert("评论内容不能为空");
            return false;
        }else{
            return true;
        }
    });


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

    //点赞
    $("#support").click(function () {

        //判断图片是否已经点亮
        var iconPath = $("#support").prop("src");
        var icoName = iconPath.substring(iconPath.lastIndexOf("/")+1);
        //获取文章id
        var aId = $("#aId").val();
        //获取用户id
        var uId = $("#uId").val();

        if(typeof uId=="undefined"){
            //未登录
            location.href ="${pageContext.request.contextPath}/pages/login.jsp";
        }else{

            //登录

            if(icoName=="nonsupport32.png"){//图片未点亮
                //发送ajax请求
                $.post("${pageContext.request.contextPath}/supAndAtt/saveSupport",
                    "aId="+aId+"&uId="+uId,
                    function (data) {
                        location.reload(true);
                    }
                )
            }else{
                //发送ajax请求
                $.post("${pageContext.request.contextPath}/supAndAtt/delSupport",
                    "aId="+aId+"&uId="+uId,
                    function (data) {
                        location.reload(true);
                    }
                )
            }}
    });

</script>

</html>

