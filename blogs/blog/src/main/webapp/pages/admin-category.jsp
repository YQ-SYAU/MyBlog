
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>精英 - 博客</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/admin/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
    <style type="text/css">

        .lunbotu-body{
            width: 100%;
            background-color: white;
        }

        .lunbotu{
            display: inline-block;
            width: 220px;
            height: 100px;
            margin-top: 40px;
            margin-left: 60px;
            margin-bottom: 200px;
            text-align: center;
        }

        .lunbotu input{
            display: inline-block;
           margin-top: 5px;
        }

        .lunbotu button{
            display: inline-block;
            width: 180px;
            height: 30px;
            margin-top: 5px;
        }

        form{
            display: inline-block;
        }
        .imgs{
            height:100px;
            width:220px;
        }
    </style>
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="admin-header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="admin-aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                首页管理
                <small>数据列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">首页管理</a></li>
                <li class="active">数据列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">分类列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"  name="addCategory"><i class="fa fa-file-o" ></i> 新建</button>
                                    <button id="delAllCategory" type="button" class="btn btn-default" title="删除"><i class="fa fa-trash-o"></i> 删除</button>
                                    <button type="button" class="btn btn-default" title="修改"><i class="fa fa-check"></i> 修改</button>
                                    <button type="button" class="btn btn-default" title="刷新"><i class="fa fa-refresh" onclick="refresh()"></i> 刷新</button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm" placeholder="搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right:0px;">
                                    <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting_asc ">编号</th>
                                <th class="sorting_desc sorting_desc_disabled">分类名称</th>
                                <th class="text-center sorting_desc_disabled">操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${category}" var="c" varStatus="status">
                                <tr>
                                    <td><input name="ids" type="checkbox"></td>
                                    <td>${status.index+1}</td>
                                    <td>${c.cname}
                                    </td>
                                    <td class="text-center">
                                        <button type="button" class="btn bg-olive btn-xs" name="addCategory">添加</button>
                                        <button type="button" class="btn bg-olive btn-xs" onclick="delCategory('${c.id}')">删除</button>
                                        <button type="button" class="btn bg-olive btn-xs" onclick="updateCategory('${c.id}')">编辑</button>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <!--数据列表/-->

                    </div>
                    <!-- 数据表格 /-->
                </div>
                <!-- /.box-body -->
            </div>


            <!-- 修改轮播图-->

            <div class="lunbotu-body">
                <div class="box-header with-border">
                    <h3 class="box-title">修改轮播图</h3>
                </div>

                    <%--<div class="lunbotu">--%>
                        <form  action="${pageContext.request.contextPath}/index/slideshow" id="form1" method="post"  enctype="multipart/form-data" class="lunbotu">
                        <img src="${pageContext.request.contextPath}/picture/${slideshow.picture1}" class="imgs">
                           <input type="file" name="uploadFile" id="file1">
                            <input type="hidden" value="1" name="flag">
                        <td class="text-center">
                            <button type="submit" class="btn bg-olive btn-xs postPicture" >更换</button>
                        </td>
                        </form>
                    <%--</div>--%>


                    <%--<div class="lunbotu">--%>
                        <form  action="${pageContext.request.contextPath}/index/slideshow" id="form2" method="post"  enctype="multipart/form-data" class="lunbotu">
                        <img src="${pageContext.request.contextPath}/picture/${slideshow.picture2}" class="imgs">
                           <input type="file" name="uploadFile" id="file2">
                            <input type="hidden" value="2" name="flag">
                        <td class="text-center">
                            <button type="submit" class="btn bg-olive btn-xs postPicture" >更换</button>
                        </td>
                        </form>
                    <%--</div>--%>


                    <%--<div class="lunbotu">--%>
                <form  action="${pageContext.request.contextPath}/index/slideshow" id="form3" method="post"  enctype="multipart/form-data" class="lunbotu">
                        <img src="${pageContext.request.contextPath}/picture/${slideshow.picture3}" class="imgs">
                            <input type="file" name="uploadFile" id="file3">
                            <input type="hidden" value="3" name="flag">
                        <td class="text-center">
                            <button type="submit" class="btn bg-olive btn-xs postPicture">更换</button>
                        </td>
                        </form>
                    <%--</div>--%>


                <br/>

            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2019 <a href="http://www.itcast.cn">精英战队</a>.</strong> All rights reserved.
    </footer>
    <!-- 底部导航 /-->

</div>
</body>
<script src="${pageContext.request.contextPath}/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>$.widget.bridge('uibutton', $.ui.button);</script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" >
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });


    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }


    $(document).ready(function() {

        // 激活导航位置
        setSidebarActive("admin-datalist");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function() {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>

<script>
    //添加分类
    $("button[name='addCategory']").click(function () {
        var cname = prompt("请输入分类名称");
        //除了空字符串("")，其他都是true  自动转换
        if(cname!=null && cname!=false){
            //发送ajax请求
            $.ajax({
                url:"${pageContext.request.contextPath}/index/save",
                type:"post",
                data:{"cname":cname},//请求参数
                // success:function (data) {
                //     alert(data);
                // },//响应成功后的回调函数
                success:function(){
                    //刷新，重新加载文档
                    location.reload();
                },
                error:function(){
                    alert("添加失败。。。")
                },//请求响应出现错误，执行的回调函数
                dataType:"text"//设置接受到的响应数据的格式
            });
        }
    });

    //删除分类
    function delCategory(cid){
        if(confirm("你确认要删除吗?")){//确认删除,发送ajax
            //* 语法：$.get(url, [data], [callback], [type])
            $.get("${pageContext.request.contextPath}/index/delete",{"id":cid},
                function () {
                    location.reload();
                });
        }
    };

    //修改分类
    function updateCategory(cid) {
        var cname = prompt("分类名称修改为：");
        //除了空字符串("")，其他都是true  自动转换
        if(cname!=null && cname!=false){
            //* 语法：$.post(url, [data], [callback], [type])
            //$.get("${pageContext.request.contextPath}/index/update","id="+cid+"&cname="+cname);
            $.post("${pageContext.request.contextPath}/index/update",{"id":cid,"cname":cname},
                function () {
                    location.reload();
                });
        }
    }

    //修改轮播图
    $("#form1").submit(function () {
        //检查是否选择了文件
        console.log("1");

        if(document.getElementById("file1").files.length==0){
            alert("请选择文件,,,,,,,,,,,,,,,");
            return false;
        }else {
            console.log(2);
            return true;
        }

    });

    //修改轮播图
    $("#form2").submit(function () {
        //检查是否选择了文件
        if($("#file1").files.length==0){
            alert("请选择文件");
            return false;
        }else{
            return true;
        }
    })
    //修改轮播图
    $("#form3").submit(function () {
        //检查是否选择了文件
        if($("#file1").files.length==0){
            alert("请选择文件");
            return false;
        }else{
            return true;
        }
    })

    //刷新
    function refresh() {
        location.reload(true);
    }

    //批量删除
    $("#delAllCategory").click(function () {
        //获取所有的复选框
        //var cheeck $("input[name='ids']");
    })
</script>

</html></html>
