<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10 0010
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>个人主页</title>


    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <meta charset="utf-8">
    <meta name="referrer"content="always">
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>

    <script>
        var CFG={

        }
    </script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/csdn1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/csdn2.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/csdn3.css">
    <link href="${pageContext.request.contextPath}/css/csdn4.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/csdn5.css" type="text/css" rel="stylesheet">
    <style>

        .error{
            color: red;
            font-size: 15px;
        }
        .ok{
            color: green;
            font-size: 15px;
        }
    </style>
</head>
<body>



<div class="me_wrap clearfix">
    <div class="me_wrap_l my_tab_page clearfix">
        <div class="me_wrap_lt clearfix">
            <div class="lt_avatar">
                <img src="${pageContext.request.contextPath}/picture/${userInfo.picture}" alt="用户头像">
            </div>
            <div class="lt_main clearfix">
                <p class="lt_title">

                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#csdnc-years-rectangle"></use>
                    </svg>
                    ${userInfo.username}        </p>

                <div class="description clearfix">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#csdnc-m-namecar"></use>
                    </svg>
                    <h3>邮箱：${userInfo.qq}@qq.com</h3>
                </div>
                <div class="job clearfix">
                    <svg class="icon _blank" aria-hidden="true">
                        <use xlink:href="#csdnc-m-namecar"></use>
                    </svg>
                    <h3>粉丝数目：${userInfo.fans}</h3>
                </div>

                <div class="job clearfix">
                    <svg class="icon _blank" aria-hidden="true">
                        <use xlink:href="#csdnc-m-namecar"></use>
                    </svg>
                    <h3>性别：${userInfo.gender}</h3>
                </div>

                <div class="description clearfix">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#csdnc-m-namecar"></use>
                    </svg>
                    <p class="description_detail">
                        个人描述：${userInfo.description}
                    </p>
                </div>
            </div>

        </div>        <div class="me_chanel_bar clearfix">
        <ul class="me_chanel_list clearfix">
            <li>
                <a class="tab_item tab_item_click" href="/blog/qq_31792281">
                    <label>
                        <span>个人信息</span>

                    </label>
                </a>
            </li>
            <li>
                <a target="_blank" class="tab_item " href="${pageContext.request.contextPath}/mySpace/findAllCategory">
                    <label>
                        <span id="publish">发布文章</span>
                    </label>
                </a>
            </li>
            <li>
                <a target="_blank" class="tab_item " href="${pageContext.request.contextPath}/mySpace/myArticle">
                    <label>
                        <span>我的发布</span>
                        <span class="count">
                            ${userArticleNum}                   </span>
                    </label>
                </a>
            </li>
            <li>
                <a target="_blank" class="tab_item " href="${pageContext.request.contextPath}/mySpace/attention">
                    <label>
                        <span>我的关注</span>
                        <span class="count">
                            ${attentionNum}                    </span>
                    </label>
                </a>
            </li>
        </ul>
    </div>


        <div>
            <h3>更换昵称：
                <input  onblur="checkUsername()" id="username" type="text" value="${userInfo.username}" maxlength="20">
                <span id="s_username"></span>
            </h3>
        </div>
        <div>
            <tr>
                <td style="font-size: 100px">性别: </td>
                <td>
                    <select name="category" id="select" >
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
            </tr>
        </div>

        <div>
            <h3>点击更换头像：
                <input type="file"  id="picture"/>
            </h3>
        </div>
        <div>
            <tr>
                <td>个人描述:</td>
                <td>
                    <textarea id="description" maxlength="300" style="width:100%;height: 100px">${userInfo.description}</textarea>
                </td>
            </tr>
        </div>
        <div>
            <button type="button" id="update">确认修改</button>
        </div>

        <div class="changepassword">
            <h3>修改密码：
                <a target="_blank" href="${pageContext.request.contextPath}/pages/updatePassword.jsp">点击修改</a></h3>

        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>

    var flag=1;
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
                "${pageContext.request.contextPath}/mySpace/checkUpdateUsername",
                "username="+username,
                function (data) {
                    if(data=="false"){

                        $("#s_username").html("此用户名太受欢迎啦，请换一个");
                        $("#s_username").removeClass("ok");
                        $("#s_username").addClass("error");
                        flag=1;
                    }else{
                        $("#s_username").html("用户名可用");
                        $("#s_username").removeClass("error");
                        $("#s_username").addClass("ok");

                    }
                }
            );
        }

    }


    //修改信息
    $("#update").click(function () {
        if(flag==1){
            var formData = new FormData();

            //获取用户名
            var username = $("#username").val();
            //获取性别
            var gender = $("#select").val();
            //获取个人描述
            var description = $("#description").val();
            //获取头像
            var file = $("#picture")[0].files[0]
            if(file==null){
                formData.append("username",username);
                formData.append("gender",gender);
                formData.append("description",description);
                $.ajax({
                    url: "${pageContext.request.contextPath}/mySpace/updateUserInfo2",
                    type: "POST",
                    contentType: "multipart/form-data",
                    data: formData,
                    async: false, //异步
                    processData: false, //很重要，告诉jquery不要对form进行处理
                    contentType: false, //很重要，指定为false才能形成正确的Content-Type
                    success: function(res) {
                        location.reload(true);
                    },
                    error: function() {
                        alert("连接网络错误，请稍后再试");
                    }
                });
            }else{
                formData.append("uploadFile",file);
                formData.append("username",username);
                formData.append("gender",gender);
                formData.append("description",description);
                $.ajax({
                    url: "${pageContext.request.contextPath}/mySpace/updateUserInfo1",
                    type: "POST",
                    contentType: "multipart/form-data",
                    data: formData,
                    async: false, //异步
                    processData: false, //很重要，告诉jquery不要对form进行处理
                    contentType: false, //很重要，指定为false才能形成正确的Content-Type
                    success: function(res) {
                        location.reload(true);
                    },
                    error: function() {
                        alert("连接网络错误，请稍后再试");
                    }
                });
            }
        }
    });




</script>
</html>
