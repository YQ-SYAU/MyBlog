/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-07-12 01:35:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <!-- meta -->\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("    <meta property=\"qc:admins\" content=\"23635710066417756375\" />\r\n");
      out.write("    <meta name=\"baidu-site-verification\" content=\"QIQ6KC1oZ6\" />\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width\"/>\r\n");
      out.write("\r\n");
      out.write("    <title>注册</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/dmaku.css\" />\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        .error{\r\n");
      out.write("            color: red;\r\n");
      out.write("            font-size: 15px;\r\n");
      out.write("        }\r\n");
      out.write("        .msg{\r\n");
      out.write("            color: red;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            font-weight:bold;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<header id=\"header\">\r\n");
      out.write("    <a href=\"javascript:;\" class=\"logo\"></a>\r\n");
      out.write("\r\n");
      out.write("</header><!-- /header -->\r\n");
      out.write("\r\n");
      out.write("<!-- 页面主体START -->\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" value = \"false\" id = \"isVisiable_request_form_verifyCode\" />\r\n");
      out.write("<input type=\"hidden\" value = \"true\" id = \"is_must_show_verify_code\" />\r\n");
      out.write("\r\n");
      out.write("<section id=\"main\" style=\"background: rgba(255,255,255,0.3)\">\r\n");
      out.write("    <h1>注册帐号</h1>\r\n");
      out.write("    <form  id=\"registerForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/register\" accept-charset=\"utf-8\" data-view=\"phoneRegister\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"username\" data-propertyname=\"namea\" data-controltype=\"Name\">\r\n");
      out.write("            <input onblur=\"checkUsername()\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text\" id=\"username\" name=\"username\" placeholder=\"用户名（最多20字符）\" data-required=\"required\" autocomplete=\"off\" >\r\n");
      out.write("            <span id=\"s_username\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"clearfix\" data-propertyname=\"password\" data-controltype=\"Password\">\r\n");
      out.write("            <input onblur=\"checkPassword()\"  type=\"password\" id=\"password\" name=\"password\" placeholder=\"请输入密码（3~20位）\" data-required=\"required\" autocomplete=\"off\" >\r\n");
      out.write("            <span id=\"s_password\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"clearfix\" data-propertyname=\"password\" data-controltype=\"Password\">\r\n");
      out.write("            <input onblur=\"checkRepassword()\" type=\"password\" id=\"repassword\" name=\"\" placeholder=\"请确认密码\" data-required=\"required\" autocomplete=\"off\" >\r\n");
      out.write("            <span id=\"s_repassword\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"phone_prefix clearfix\" data-propertyname=\"phone\" data-controltype=\"Phone\">\r\n");
      out.write("            <div>qq</div>\r\n");
      out.write("            <input onblur=\"checkQQ()\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.qq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text\" id=\"qq\" name=\"qq\" placeholder=\"输入qq号码绑定邮箱获取验证码\" data-required=\"required\" autocomplete=\"off\" >\r\n");
      out.write("            <span id=\"s_qq\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div data-propertyname=\"phoneVerificationCode\" data-controltype=\"PhoneVerificationCode\">\r\n");
      out.write("            <div class=\"input_group clearfix\">\r\n");
      out.write("                <input onblur=\"checkCode()\" type=\"text\" class=\"first_child\" id=\"code\" name=\"random\" placeholder=\"输入邮箱验证码\" data-required=\"required\" autocomplete=\"off\" >\r\n");
      out.write("                <input onclick=\"sendEmail()\" type=\"button\" class=\"last_child\" value=\"获取验证码\" data-required=\"required\">\r\n");
      out.write("                <span id=\"s_code\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"msg clearfix box_checkbox\" data-propertyname=\"protocol\" data-controltype=\"CheckBox\">\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"clearfix btn_login\" data-propertyname=\"submit\" data-controltype=\"Botton\">\r\n");
      out.write("            <input type=\"submit\" value=\"注册\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"clearfix goregister\">\r\n");
      out.write("            <span class=\"reg_now\">已有帐号？</span>\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/pages/login.jsp\">登录</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<!-- 页面主体END -->\r\n");
      out.write("\r\n");
      out.write("<footer id=\"footer\">\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <p>Copyright ? 2019 </p>\r\n");
      out.write("</footer><!-- jquery lib -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    /**\r\n");
      out.write("     * 校验表单\r\n");
      out.write("        1.给表单绑定onsubmit事件。监听器中判断每一个方法校验的结果。\r\n");
      out.write("            如果都为true,则监听器方法放回true\r\n");
      out.write("            有一个为false,则返回false\r\n");
      out.write("        2.定义一些方法分别校验表单项\r\n");
      out.write("        3.给各个表单绑定onblur事件。（离焦事件）\r\n");
      out.write("     */\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    //1.给表单绑定事件\r\n");
      out.write("    $(\"#registerForm\").submit(function () {\r\n");
      out.write("        return checkUsername()&&checkQQ()&&checkCode()&&checkPassword()&&checkRepassword();\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
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
      out.write("/user/checkUsername\",\r\n");
      out.write("                \"username=\"+username,\r\n");
      out.write("                function (data) {\r\n");
      out.write("                    if(data==\"false\"){\r\n");
      out.write("\r\n");
      out.write("                        $(\"#s_username\").html(\"此用户名太受欢迎啦，请换一个\");\r\n");
      out.write("                        $(\"#s_username\").addClass(\"error\");\r\n");
      out.write("                    }else{\r\n");
      out.write("                        $(\"#s_username\").html(\"<img width='35' height='25' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/gou.png'/>\");\r\n");
      out.write("                        return true;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("           );\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //校验qq\r\n");
      out.write("    function checkQQ() {\r\n");
      out.write("        var QQ = $(\"#qq\").val();\r\n");
      out.write("        //定义正则 8-10位的数字\r\n");
      out.write("        var reg = /^\\d{8,10}$/;\r\n");
      out.write("        //判断是否否和正则表达式\r\n");
      out.write("        var flag = reg.test(QQ);\r\n");
      out.write("        if(flag){\r\n");
      out.write("            $(\"#s_qq\").html(\"<img width='35' height='25' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/gou.png'/>\");\r\n");
      out.write("            return true;\r\n");
      out.write("        }else{\r\n");
      out.write("            $(\"#s_qq\").html(\"QQ格式不正确\");\r\n");
      out.write("            $(\"#s_qq\").addClass(\"error\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //校验验证码\r\n");
      out.write("    function checkCode() {\r\n");
      out.write("        var code = $(\"#code\").val();\r\n");
      out.write("        var reg = /^\\d{5,6}$/;\r\n");
      out.write("        //判断是否否和正则表达式\r\n");
      out.write("        var flag = reg.test(code);\r\n");
      out.write("        if(flag){\r\n");
      out.write("            $(\"#s_code\").html(\"\");\r\n");
      out.write("            return true;\r\n");
      out.write("        }else{\r\n");
      out.write("            $(\"#s_code\").html(\"验证码由6位数字组成\");\r\n");
      out.write("            $(\"#s_code\").addClass(\"error\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //校验密码\r\n");
      out.write("    function checkPassword() {\r\n");
      out.write("        var password = $(\"#password\").val();\r\n");
      out.write("        if(password.length<3 ||password.length>20){\r\n");
      out.write("            $(\"#s_password\").html(\"密码由3-20位字符组成\");\r\n");
      out.write("            $(\"#s_password\").addClass(\"error\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }else{\r\n");
      out.write("            $(\"#s_password\").html(\"<img width='35' height='25' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/gou.png'/>\");\r\n");
      out.write("            return true;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    //校验确认密码\r\n");
      out.write("    function checkRepassword() {\r\n");
      out.write("        var password = $(\"#password\").val();\r\n");
      out.write("        var repassword = $(\"#repassword\").val();\r\n");
      out.write("        if(password.length!=0&&password!=null){\r\n");
      out.write("            //判断密码是否相等\r\n");
      out.write("            if(password==repassword){\r\n");
      out.write("                $(\"#s_repassword\").html(\"<img width='35' height='25' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/gou.png'/>\");\r\n");
      out.write("                return true;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        $(\"#s_repassword\").html(\"两次密码不一致\");\r\n");
      out.write("        $(\"#s_repassword\").addClass(\"error\");\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    //发送邮件\r\n");
      out.write("    function sendEmail() {\r\n");
      out.write("        //获取qq号\r\n");
      out.write("        var QQ = $(\"#qq\").val();\r\n");
      out.write("        if(QQ.length==0){\r\n");
      out.write("            alert(\"请先填写QQ号\");\r\n");
      out.write("        }else{\r\n");
      out.write("            //发送ajax请求\r\n");
      out.write("            alert(\"正在发送，请稍等...\")\r\n");
      out.write("            $.post(\r\n");
      out.write("                \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/getRegistrationCode\",\r\n");
      out.write("                \"qq=\"+QQ,\r\n");
      out.write("                function (data) {\r\n");
      out.write("                    alert(data);\r\n");
      out.write("                }\r\n");
      out.write("                ,\"text\");\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
