package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.JumsHelper;
import jums.UserDataDTO;
import javax.servlet.http.HttpSession;

public final class delete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS削除確認</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function check(){\n");
      out.write("                if(confirm(\"本当にこの情報を削除しますか？\")){\n");
      out.write("                    return true;\n");
      out.write("                }else{\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <h1>削除確認</h1>\n");
      out.write("    <strong>以下の内容を削除します。よろしいですか？</strong><br><br>\n");
      out.write("    名前:");
      out.print( udd.getName());
      out.write("<br>\n");
      out.write("    生年月日:");
      out.print( udd.getBirthday());
      out.write("<br>\n");
      out.write("    種別:");
      out.print( jh.exTypenum(udd.getType()));
      out.write("<br>\n");
      out.write("    電話番号:");
      out.print( udd.getTell());
      out.write("<br>\n");
      out.write("    自己紹介:");
      out.print( udd.getComment());
      out.write("<br>\n");
      out.write("    登録日時:");
      out.print( udd.getNewDate());
      out.write("<br><br>\n");
      out.write("    \n");
      out.write("    <form action=\"DeleteResult\" method=\"POST\" onsubmit=\"return check()\">\n");
      out.write("      <input type=\"hidden\" name=\"acs\" value=\"");
      out.print(hs.getAttribute("acs"));
      out.write("\">  <!--アクセス用-->\n");
      out.write("      <input type=\"submit\" name=\"YES\" value=\"はい\" style=\"width:100px\">\n");
      out.write("    </form><br>\n");
      out.write("    <form action=\"ResultDetail\" method=\"POST\">\n");
      out.write("      <input type=\"submit\" name=\"NO\" value=\"いいえ\" style=\"width:100px\">\n");
      out.write("    </form>\n");
      out.write("    <br><br>\n");
      out.write("    ");
      out.print(jh.resultDetail());
      out.write("  <!--検索結果画面リンク(必要ない可能性が高いですが)-->\n");
      out.write("    <hr>\n");
      out.write("    ");
      out.print(jh.home());
      out.write(" <!--ホーム画面リンク-->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
