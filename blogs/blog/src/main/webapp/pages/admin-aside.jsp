<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/14 0014
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">

                <img src="${pageContext.request.contextPath}/picture/${userInfo.picture}" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>
                    <security:authentication property="principal.username"></security:authentication>
                </p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
    <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="搜索...">
        <span class="input-group-btn">
        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
        </button>
      </span>
    </div>
</form>-->
        <!-- /.search form -->


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/pages/admin-index.jsp"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <!-- 菜单 -->



            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cogs"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="admin-login">
                        <a href="${pageContext.request.contextPath}/index/show">
                            <i class="fa fa-circle-o"></i> 首页管理
                        </a>
                    </li>

                    <li id="admin-404">
                        <a href="${pageContext.request.contextPath}/user/showAll?pageNum=1&pageSize=4">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>
                    </a>
                </ul>
            </li>



            <!--日志管理-->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>日志管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="travellog-manage">
                        <a href="${pageContext.request.contextPath}/syslog/findAll?pageNum&pageSize=6">
                            <i class="fa fa-circle-o"></i> 查看日志
                        </a>
                    </li>

                </ul>
            </li>
            <!--日志管理-->

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->
