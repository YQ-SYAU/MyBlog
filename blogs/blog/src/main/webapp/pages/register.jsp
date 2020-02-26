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

    <title>注册</title>


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dmaku.css" />
    <style type="text/css">
        .error{
            color: red;
            font-size: 15px;
        }
        .msg{
            color: red;
            font-size: 20px;
            font-weight:bold;
            text-align: center;
        }
    </style>
</head>

<body>

<header id="header">
    <a href="javascript:;" class="logo"></a>

</header><!-- /header -->

<!-- 页面主体START -->

<input type="hidden" value = "false" id = "isVisiable_request_form_verifyCode" />
<input type="hidden" value = "true" id = "is_must_show_verify_code" />

<section id="main" style="background: rgba(255,255,255,0.3)">
    <h1>注册帐号</h1>
    <form  id="registerForm" action="${pageContext.request.contextPath}/user/register" accept-charset="utf-8" data-view="phoneRegister" method="post">


        <div class="username" data-propertyname="namea" data-controltype="Name">
            <input onblur="checkUsername()"  value="${userInfo.username}" type="text" id="username" name="username" placeholder="用户名（最多20字符）" data-required="required" autocomplete="off" >
            <span id="s_username"></span>
        </div>



        <div class="clearfix" data-propertyname="password" data-controltype="Password">
            <input onblur="checkPassword()"  type="password" id="password" name="password" placeholder="请输入密码（3~20位）" data-required="required" autocomplete="off" >
            <span id="s_password"></span>
        </div>
        <div class="clearfix" data-propertyname="password" data-controltype="Password">
            <input onblur="checkRepassword()" type="password" id="repassword" name="" placeholder="请确认密码" data-required="required" autocomplete="off" >
            <span id="s_repassword"></span>
        </div>

        <div class="phone_prefix clearfix" data-propertyname="phone" data-controltype="Phone">
            <div>qq</div>
            <input onblur="checkQQ()" value="${userInfo.qq}" type="text" id="qq" name="qq" placeholder="输入qq号码绑定邮箱获取验证码" data-required="required" autocomplete="off" >
            <span id="s_qq"></span>
        </div>


        <div data-propertyname="phoneVerificationCode" data-controltype="PhoneVerificationCode">
            <div class="input_group clearfix">
                <input onblur="checkCode()" type="text" class="first_child" id="code" name="random" placeholder="输入邮箱验证码" data-required="required" autocomplete="off" >
                <input onclick="sendEmail()" type="button" class="last_child" value="获取验证码" data-required="required">
                <span id="s_code"></span>
            </div>
        </div>

        <div class="msg clearfix box_checkbox" data-propertyname="protocol" data-controltype="CheckBox">
            <%--<label for="checkbox">--%>
                <%--&lt;%&ndash;<input type="checkbox" value="" id="checkbox" class="checkbox" data-myvalue="agred" data-text="我已阅读并同意" >&ndash;%&gt;--%>

            <%--</label>--%>
                ${msg}
        </div>

        <div class="clearfix btn_login" data-propertyname="submit" data-controltype="Botton">
            <input type="submit" value="注册">
        </div>

        <div class="clearfix goregister">
            <span class="reg_now">已有帐号？</span>
            <a href="${pageContext.request.contextPath}/pages/login.jsp">登录</a>
        </div>

    </form>
</section>

<!-- 页面主体END -->

<footer id="footer">

    <%--<div>联系客服：829654759 <span>（周一至周五10:00-19:00）</span> </div>--%>
    <p>Copyright ? 2019 </p>
</footer><!-- jquery lib -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>

    /**
     * 校验表单
        1.给表单绑定onsubmit事件。监听器中判断每一个方法校验的结果。
            如果都为true,则监听器方法放回true
            有一个为false,则返回false
        2.定义一些方法分别校验表单项
        3.给各个表单绑定onblur事件。（离焦事件）
     */


    //1.给表单绑定事件
    $("#registerForm").submit(function () {
        return checkUsername()&&checkQQ()&&checkCode()&&checkPassword()&&checkRepassword();
    });

    //校验用户名
    function checkUsername() {
        var username = $("#username").val();

        if(username.trim().length==0 ||username.length>20){
            $("#s_username").html("用户名格式有误");
            $("#s_username").addClass("error");
            return false;
        }else{
            //* 语法：$.post(url, [data], [callback], [type])
            $.post(
                "${pageContext.request.contextPath}/user/checkUsername",
                "username="+username,
                function (data) {
                    if(data=="false"){

                        $("#s_username").html("此用户名太受欢迎啦，请换一个");
                        $("#s_username").addClass("error");
                    }else{
                        $("#s_username").html("<img width='35' height='25' src='${pageContext.request.contextPath}/images/gou.png'/>");
                        return true;
                    }
                }
           );
        }

    }

    //校验qq
    function checkQQ() {
        var QQ = $("#qq").val();
        //定义正则 8-10位的数字
        var reg = /^\d{8,10}$/;
        //判断是否否和正则表达式
        var flag = reg.test(QQ);
        if(flag){
            $("#s_qq").html("<img width='35' height='25' src='${pageContext.request.contextPath}/images/gou.png'/>");
            return true;
        }else{
            $("#s_qq").html("QQ格式不正确");
            $("#s_qq").addClass("error");
            return false;
        }
    }

    //校验验证码
    function checkCode() {
        var code = $("#code").val();
        var reg = /^\d{5,6}$/;
        //判断是否否和正则表达式
        var flag = reg.test(code);
        if(flag){
            $("#s_code").html("");
            return true;
        }else{
            $("#s_code").html("验证码由6位数字组成");
            $("#s_code").addClass("error");
            return false;
        }
    }

    //校验密码
    function checkPassword() {
        var password = $("#password").val();
        if(password.length<3 ||password.length>20){
            $("#s_password").html("密码由3-20位字符组成");
            $("#s_password").addClass("error");
            return false;
        }else{
            $("#s_password").html("<img width='35' height='25' src='${pageContext.request.contextPath}/images/gou.png'/>");
            return true;
        }
    }
    //校验确认密码
    function checkRepassword() {
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        if(password.length!=0&&password!=null){
            //判断密码是否相等
            if(password==repassword){
                $("#s_repassword").html("<img width='35' height='25' src='${pageContext.request.contextPath}/images/gou.png'/>");
                return true;
            }
        }
        $("#s_repassword").html("两次密码不一致");
        $("#s_repassword").addClass("error");
    }


    //发送邮件
    function sendEmail() {
        //获取qq号
        var QQ = $("#qq").val();
        if(QQ.length==0){
            alert("请先填写QQ号");
        }else{
            //发送ajax请求
            alert("正在发送，请稍等...")
            $.post(
                "${pageContext.request.contextPath}/user/getRegistrationCode",
                "qq="+QQ,
                function (data) {
                    alert(data);
                }
                ,"text");
        }
    }
</script>
</body>
</html>

