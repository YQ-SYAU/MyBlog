<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/22 0022
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- meta -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit">
    <meta property="qc:admins" content="23635710066417756375" />
    <meta name="baidu-site-verification" content="QIQ6KC1oZ6" />
    <meta charset="UTF-8">


    <meta name="viewport" content="width=device-width"/>

    <title>登录</title>







    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dmaku2.css" />
</head>

<body>

<header id="header">
    <a href="javascript:;" class="logo"></a>

</header><!-- /header -->

<!-- 页面主体START -->
<section id="main" style="background: rgba(255,255,255,0.3)">
    <h1>登录</h1>
    <!--<form action="javascript:;" accept-charset="utf-8" data-view="loginView">-->
    <form action="${pageContext.request.contextPath}/login.do" accept-charset="utf-8" data-view="loginView" method="post">
        <div class="clearfix" data-propertyname="username" data-controltype="Phone">
            <input type="text" placeholder="输入用户名" id="user_name" name="username" placeholder="" data-required="required" autocomplete="off" >
        </div>

        <div class="clearfix" data-propertyname="password" data-controltype="Password">
            <input type="password" id="" name="password" placeholder="输入密码" data-required="required" autocomplete="off" >
        </div>

        <div class="verifyCodeInput clearfix"  data-propertyname="request_form_verifyCode" data-controltype="VerifyCode" style="display:none;">
            <div class="code_cont">
                <input type="text" name="" placeholder="请证明你不是机器人" data-required="required" autocomplete="off" >
                <img src="" alt="" class="yzm">
                <a href="javascript:;" class="reflash"></a>
            </div>
        </div>

        <div class="clearfix">
            <!-- <label>
                <input type="checkbox" class="autologin" />
                自动登录
            </label> -->
            <a href="javascript:;" class="forgot_pwd">忘记密码？</a>
        </div>

        <div class="clearfix btn_login" data-propertyname="submit" data-controltype="Botton">
            <input type="submit" value="登录">
        </div>

        <div class="clearfix goregister">
            <span class="reg_now">没有帐号？</span>
            <a href="${pageContext.request.contextPath}/pages/register.jsp">注册</a>
        </div>

        <input type="hidden" value = "" id = "isVisiable_request_form_verifyCode" />

    </form>
</section>
<!-- 页面主体END -->

<footer id="footer">

</footer><!-- jquery lib -->
<!--拉勾UI框架 -->
</body>
</html>

