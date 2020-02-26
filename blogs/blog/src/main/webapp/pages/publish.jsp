<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/9 0009
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>发布博文</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" href="../css/jquery.wysiwyg.css" type="text/css"/>
    <style>
        .msg{

            display: inline-block;
            color: green;
            font-size: 20px;
        }
        .create{
            display: inline-block;
            width: 80px;
            background-color: orange;
            color: red;
            font-size: 20px;
        }
    </style>
</head>

<body>


<h2 align="center">发布博文</h2>
<form id="form1"  method="post" action="${pageContext.request.contextPath}/mySpace/publish" enctype="multipart/form-data">
    <table id="tab" align="center">
        <tr>
            <td >主题: </td>
            <td>
                <input name="title" type="text" id="title" size="40" placeholder="最多40字符"/>
            </td>
        </tr>

        <tr>
            <td>分类: </td>
            <td>
                <select name="category.id" id="select">

                    <c:forEach items="${categoryList}" var="c">
                        <option value="${c.id}">${c.cname}</option>
                    </c:forEach>
                </select>
            </td>

        </tr>


        <tr>
            <td colspan="2">内容: <br/>
                <textarea name="content" id="wysiwyg" rows="20" cols="80" ></textarea>

            </td>

        </tr>
        <tr>
            <td colspan="2">
                添加图片：<input type="file" name="uploadFile"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input class="create" type="submit" value="创建"/>
                <span class="msg">${msg}</span>
            </td>

        </tr>
    </table>
</form>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>
    //发布文章
   $("#form1").submit(function () {
       //获取标题
       var title = $("#title").val();
       //获取内容
       var content = $("#wysiwyg").val();
       if(title.trim().length==0){
           alert("标题不能为空")
           return false;
       }else{
           if(content.trim().length==0){
               alert("内容不能为空");
               return false;
           }else{
               return true;
           }
       }

   })

    //检查标题
    function checkTitle() {
        var title = $("#title").val()
        if(title.trim().length==0){
            alert("标题不能为空");
            return false
        }else{
            return true;
        }
    }
    //检查内容
    function checkContext() {
        var content = $("#wysiwyg").val();
        if(content.trim().length==0){
            alert("内容不能为空");
            return false
        }else{
            return true;
        }
    }

</script>
</html>

