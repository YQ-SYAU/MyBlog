/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-07-11 09:20:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class my_002dspace_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>个人主页</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/favicon.ico\">\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"referrer\"content=\"always\">\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\"/>\r\n");
      out.write("    <meta name=\"force-rendering\" content=\"webkit\"/>\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge,chrome=1\"/>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        var CFG={\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/csdn1.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/csdn2.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/csdn3.css\">\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/csdn4.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/csdn5.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("        .error{\r\n");
      out.write("            color: red;\r\n");
      out.write("            font-size: 15px;\r\n");
      out.write("        }\r\n");
      out.write("        .ok{\r\n");
      out.write("            color: green;\r\n");
      out.write("            font-size: 15px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"me_wrap clearfix\">\r\n");
      out.write("    <div class=\"me_wrap_l my_tab_page clearfix\">\r\n");
      out.write("        <div class=\"me_wrap_lt clearfix\">\r\n");
      out.write("            <div class=\"lt_avatar\">\r\n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/picture/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.picture}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" alt=\"用户头像\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"lt_main clearfix\">\r\n");
      out.write("                <p class=\"lt_title\">\r\n");
      out.write("\r\n");
      out.write("                    <svg class=\"icon\" aria-hidden=\"true\">\r\n");
      out.write("                        <use xlink:href=\"#csdnc-years-rectangle\"></use>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("        </p>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"description clearfix\">\r\n");
      out.write("                    <svg class=\"icon\" aria-hidden=\"true\">\r\n");
      out.write("                        <use xlink:href=\"#csdnc-m-namecar\"></use>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                    <h3>邮箱：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.qq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("@qq.com</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"job clearfix\">\r\n");
      out.write("                    <svg class=\"icon _blank\" aria-hidden=\"true\">\r\n");
      out.write("                        <use xlink:href=\"#csdnc-m-namecar\"></use>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                    <h3>粉丝数目：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.fans}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"job clearfix\">\r\n");
      out.write("                    <svg class=\"icon _blank\" aria-hidden=\"true\">\r\n");
      out.write("                        <use xlink:href=\"#csdnc-m-namecar\"></use>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                    <h3>性别：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.gender}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"description clearfix\">\r\n");
      out.write("                    <svg class=\"icon\" aria-hidden=\"true\">\r\n");
      out.write("                        <use xlink:href=\"#csdnc-m-namecar\"></use>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                    <p class=\"description_detail\">\r\n");
      out.write("                        个人描述：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("                    </p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>        <div class=\"me_chanel_bar clearfix\">\r\n");
      out.write("        <ul class=\"me_chanel_list clearfix\">\r\n");
      out.write("            <li>\r\n");
      out.write("                <a class=\"tab_item tab_item_click\" href=\"/blog/qq_31792281\">\r\n");
      out.write("                    <label>\r\n");
      out.write("                        <span>个人信息</span>\r\n");
      out.write("\r\n");
      out.write("                    </label>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a target=\"_blank\" class=\"tab_item \" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/mySpace/findAllCategory\">\r\n");
      out.write("                    <label>\r\n");
      out.write("                        <span id=\"publish\">发布文章</span>\r\n");
      out.write("                    </label>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a target=\"_blank\" class=\"tab_item \" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/mySpace/myArticle\">\r\n");
      out.write("                    <label>\r\n");
      out.write("                        <span>我的发布</span>\r\n");
      out.write("                        <span class=\"count\">\r\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userArticleNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("                   </span>\r\n");
      out.write("                    </label>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a target=\"_blank\" class=\"tab_item \" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/mySpace/attention\">\r\n");
      out.write("                    <label>\r\n");
      out.write("                        <span>我的关注</span>\r\n");
      out.write("                        <span class=\"count\">\r\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${attentionNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("                    </span>\r\n");
      out.write("                    </label>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("            <h3>更换昵称：\r\n");
      out.write("                <input  onblur=\"checkUsername()\" id=\"username\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"20\">\r\n");
      out.write("                <span id=\"s_username\"></span>\r\n");
      out.write("            </h3>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td style=\"font-size: 100px\">性别: </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <select name=\"category\" id=\"select\" >\r\n");
      out.write("                        <option value=\"男\">男</option>\r\n");
      out.write("                        <option value=\"女\">女</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("            <h3>点击更换头像：\r\n");
      out.write("                <input type=\"file\"  id=\"picture\"/>\r\n");
      out.write("            </h3>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>个人描述:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <textarea id=\"description\" maxlength=\"300\" style=\"width:100%;height: 100px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <button type=\"button\" id=\"update\">确认修改</button>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"changepassword\">\r\n");
      out.write("            <h3>修改密码：\r\n");
      out.write("                <a target=\"_blank\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/pages/updatePassword.jsp\">点击修改</a></h3>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    var flag=1;\r\n");
      out.write("    //校验用户名\r\n");
      out.write("    function checkUsername() {\r\n");
      out.write("        var username = $(\"#username\").val();\r\n");
      out.write("\r\n");
      out.write("        if(username.trim().length==0 ||username.length>20){\r\n");
      out.write("            $(\"#s_username\").html(\"用户名格式有误\");\r\n");
      out.write("            $(\"#s_username\").addClass(\"error\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }else{\r\n");
      out.write("            //* 语法：$.post(url, [data], [callback], [type])\r\n");
      out.write("            $.post(\r\n");
      out.write("                \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/mySpace/checkUpdateUsername\",\r\n");
      out.write("                \"username=\"+username,\r\n");
      out.write("                function (data) {\r\n");
      out.write("                    if(data==\"false\"){\r\n");
      out.write("\r\n");
      out.write("                        $(\"#s_username\").html(\"此用户名太受欢迎啦，请换一个\");\r\n");
      out.write("                        $(\"#s_username\").removeClass(\"ok\");\r\n");
      out.write("                        $(\"#s_username\").addClass(\"error\");\r\n");
      out.write("                        flag=1;\r\n");
      out.write("                    }else{\r\n");
      out.write("                        $(\"#s_username\").html(\"用户名可用\");\r\n");
      out.write("                        $(\"#s_username\").removeClass(\"error\");\r\n");
      out.write("                        $(\"#s_username\").addClass(\"ok\");\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            );\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    //修改信息\r\n");
      out.write("    $(\"#update\").click(function () {\r\n");
      out.write("        if(flag==1){\r\n");
      out.write("            var formData = new FormData();\r\n");
      out.write("\r\n");
      out.write("            //获取用户名\r\n");
      out.write("            var username = $(\"#username\").val();\r\n");
      out.write("            //获取性别\r\n");
      out.write("            var gender = $(\"#select\").val();\r\n");
      out.write("            //获取个人描述\r\n");
      out.write("            var description = $(\"#description\").val();\r\n");
      out.write("            //获取头像\r\n");
      out.write("            var file = $(\"#picture\")[0].files[0]\r\n");
      out.write("            if(file==null){\r\n");
      out.write("                formData.append(\"username\",username);\r\n");
      out.write("                formData.append(\"gender\",gender);\r\n");
      out.write("                formData.append(\"description\",description);\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/mySpace/updateUserInfo2\",\r\n");
      out.write("                    type: \"POST\",\r\n");
      out.write("                    contentType: \"multipart/form-data\",\r\n");
      out.write("                    data: formData,\r\n");
      out.write("                    async: false, //异步\r\n");
      out.write("                    processData: false, //很重要，告诉jquery不要对form进行处理\r\n");
      out.write("                    contentType: false, //很重要，指定为false才能形成正确的Content-Type\r\n");
      out.write("                    success: function(res) {\r\n");
      out.write("                        location.reload(true);\r\n");
      out.write("                    },\r\n");
      out.write("                    error: function() {\r\n");
      out.write("                        alert(\"连接网络错误，请稍后再试\");\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }else{\r\n");
      out.write("                formData.append(\"uploadFile\",file);\r\n");
      out.write("                formData.append(\"username\",username);\r\n");
      out.write("                formData.append(\"gender\",gender);\r\n");
      out.write("                formData.append(\"description\",description);\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/mySpace/updateUserInfo1\",\r\n");
      out.write("                    type: \"POST\",\r\n");
      out.write("                    contentType: \"multipart/form-data\",\r\n");
      out.write("                    data: formData,\r\n");
      out.write("                    async: false, //异步\r\n");
      out.write("                    processData: false, //很重要，告诉jquery不要对form进行处理\r\n");
      out.write("                    contentType: false, //很重要，指定为false才能形成正确的Content-Type\r\n");
      out.write("                    success: function(res) {\r\n");
      out.write("                        location.reload(true);\r\n");
      out.write("                    },\r\n");
      out.write("                    error: function() {\r\n");
      out.write("                        alert(\"连接网络错误，请稍后再试\");\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
