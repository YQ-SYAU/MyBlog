<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/9 0009
  Time: 10:49
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
    <title>修改密码</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dmaku2.css" />
    <style>
        .error{
            color: red;
            font-size: 15px;
        }
        #s_msg{
            color: green;
            font-size: 20px;
        }
    </style>
</head>

<body>

<header id="header">
    <a href="javascript:;" class="logo"></a>

</header><!-- /header -->

<!-- 页面主体START -->
<section id="main">
    <h1>修改密码</h1>
    <form action="javascript:;" accept-charset="utf-8" data-view="loginView">

        <div class="clearfix" data-propertyname="username" data-controltype="Phone">
            <input onblur="checkOldPassword()" type="password" placeholder="输入旧密码" id="oldPassword" name="" placeholder="" data-required="required" autocomplete="off" >
            <span id="o_password"></span>
        </div>

        <div class="clearfix" data-propertyname="password" data-controltype="Password">
            <input onblur="checkPassword2()"   type="password" id="nowPassword" name="" placeholder="输入新密码(3-20位字符组成)" data-required="required" autocomplete="off" >
            <span id="s_password"></span>
        </div>
        <div class="clearfix" data-propertyname="password" data-controltype="Password">
            <input onblur="checkRepassword()" type="password" id="reNowPassword" name="" placeholder="确认新密码" data-required="required" autocomplete="off" >
            <span id="s_repassword"></span>
        </div>
        <div class="clearfix" data-propertyname="password" data-controltype="Password" style="text-align: center">
            <span id="s_msg"></span>
        </div>
        <div class="clearfix btn_login" data-propertyname="submit" data-controltype="Botton">
            <input id="updatePassword" type="submit" value="确认修改">
        </div>

    </form>
</section>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>

    //检查密码格式
    var a=0,b=0,c=0;
    function checkPassword2() {
        var password = $("#nowPassword").val();
        if(password.length<3 ||password.length>20){
            $("#s_password").html("密码由3-20位字符组成");
            $("#s_password").addClass("error");
        }else{
            $("#s_password").html("");
            a=1;
        }

    }

    //检查旧密码是否正确
    function checkOldPassword() {

        var oldPassword = $("#oldPassword").val();
        $.post("${pageContext.request.contextPath}/mySpace/checkOldPassword","oldPassword="+oldPassword,
        function (data) {
            console.log("a");
            if("false"==data){
                $("#o_password").html("密码不正确");
                $("#o_password").addClass("error");
            }else{
                $("#o_password").html("");
                b=1;
            }
        })
    }

    //检查确认密码
    function checkRepassword(obj) {
        var password = $("#reNowPassword").val();
        var repassword = $("#reNowPassword").val();
        if(password.length!=0&&password!=null){
            //判断密码是否相等
            if(password==repassword){
                $("#s_repassword").html("");
                //return true;
                c=1;
            }else{
                $("#s_repassword").html("两次密码不一致");
                $("#s_repassword").addClass("error");
            }
        }

        //return false
    }

    //点击修改密码
    $("#updatePassword").click(function () {
        var password = $("#nowPassword").val();
        console.log(a+" "+b+" "+c);
        if(a==1&&b==1&&c==1)

            $.post("${pageContext.request.contextPath}/mySpace/updatePassword","newPassword="+password,
                function (data) {
                    if("true"==data){
                        $("#s_msg").html("修改成功");
                    }else{
                        $("#s_msg").html("修改失败");
                    }
                })
    })

</script>
</html>

