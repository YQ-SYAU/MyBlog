<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4 0004
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <title>精英博客——404</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dmaku.main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-migrate-1.1.1.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,800|Sarina' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.spritely-0.6.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-animate-css-rotate-scale.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
</head>
<body >
<div class="wrapper">
    <div id="sky">
        <div id="moon" ></div>
        <div id="stars"></div>
        <div id="clouds" ></div>
    </div>
    <div id="middle-content">
        <div id="spaceship" class="swing ">
            <div id="light"></div>
        </div>
        <div class="err-text swing-text" >
            <h1>服务器 404</h1>
        </div>
    </div>
    <div id="ground">
        <div id="mountain1" ></div>
        <div id="mountain2"></div>
        <div id="mountain3" ></div>
    </div>
</div>
</body>
</html>
