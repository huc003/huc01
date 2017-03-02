package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
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

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    <title>后台</title>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/zui.min.css\">\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/lib/jquery/jquery.js\"></script>\r\n");
      out.write("\t<!-- ZUI 标准版压缩后的 JavaScript 文件 -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/zui.min.js\"></script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user/login\" method=\"post\">\r\n");
      out.write("    \t<div class=\"container-fixed-xs\" style=\"padding-top:220px;\">\r\n");
      out.write("\t   \t\t<div class=\"container-fixed-xs\" style=\"padding-bottom:20px;text-align:center\">\r\n");
      out.write("\t   \t\t\t<h1>后台管理系统</h1>\r\n");
      out.write("\t   \t\t</div>\r\n");
      out.write("\t   \t\t<div class=\"container-fixed-xs\" style=\"padding-top:0px;\">\r\n");
      out.write("\t   \t\t\t<input class=\"form-control form-focus\" autofocus type=\"text\" placeholder=\"用户名\">\r\n");
      out.write("\t   \t\t</div>\r\n");
      out.write("\t   \t\t<div class=\"container-fixed-xs\" style=\"padding-top:30px;\">\r\n");
      out.write("\t   \t\t\t<input class=\"form-control form-focus\" autofocus type=\"text\" placeholder=\"密码\">\r\n");
      out.write("\t   \t\t</div>\r\n");
      out.write("\t   \t\t<div class=\"container-fixed-xs\" style=\"padding-top:30px;\">\r\n");
      out.write("\t   \t\t\t<button class=\"btn btn-block btn-primary\" type=\"submit\">登录</button>\r\n");
      out.write("\t   \t\t</div>\r\n");
      out.write("\t   \t</div>\r\n");
      out.write("    </form>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
