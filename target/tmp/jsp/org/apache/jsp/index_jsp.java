package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"css/custom.css\" rel=\"stylesheet\">\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("<style>\n");
      out.write("* {\n");
      out.write("\tmargin: 0;\n");
      out.write("\tpadding: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("html {\n");
      out.write("\tbackground:\n");
      out.write("\t\turl(http://www.robkalescancer.com/wp-content/uploads/2014/05/Most-Frequently-Challenged-Book-ftr.jpg)\n");
      out.write("\t\tno-repeat center center fixed;\n");
      out.write("\t-webkit-background-size: cover;\n");
      out.write("\t-moz-background-size: cover;\n");
      out.write("\t-o-background-size: cover;\n");
      out.write("\tbackground-size: cover;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#page-wrap {\n");
      out.write("\twidth: 1000px;\n");
      out.write("\tmargin: 50px auto;\n");
      out.write("\tpadding: 20px;\n");
      out.write("\tbackground: white;\n");
      out.write("\t-moz-box-shadow: 0 0 20px black;\n");
      out.write("\t-webkit-box-shadow: 0 0 20px black;\n");
      out.write("\tbox-shadow: 0 0 20px black;\n");
      out.write("}\n");
      out.write("\n");
      out.write("p {\n");
      out.write("\tfont: 15px/2 Georgia, Serif;\n");
      out.write("\tmargin: 0 0 30px 0;\n");
      out.write("\ttext-indent: 40px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<title>Social Library</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write(" \n");
      out.write("\t<div id=\"page-wrap\" class=\"page-header\"\n");
      out.write("\t\tstyle=\"background-color: #f0ad4e;\">\n");
      out.write("\t\t<img src=\"http://www.mtzion.lib.il.us/logo15.jpg/image_preview\">\n");
      out.write("\t\t<strong><large> Social Library</large></strong> </img>\n");
      out.write("\t</div>\n");
      out.write("\t\t<div class=\"row container\">\n");
      out.write("\t\t\t<div class=\"col-md-4  container\">\n");
      out.write("\t\t\t\t<form action=\"MainPage\" role=\"form\" method=\"POST\">\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"exampleInputEmail1\">Username</label> <input\n");
      out.write("\t\t\t\t\t\t\ttype=\"input\" class=\"form-control\" name=\"username\"\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"Enter username\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"exampleInputPassword1\">Password</label> <input\n");
      out.write("\t\t\t\t\t\t\ttype=\"password\" class=\"form-control\" name=\"password\"\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"Enter Password\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-default\">Login</button>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"col-md-5 container\">\n");
      out.write("\t\t\t\t<large>This is a Social Library which allows you to share\n");
      out.write("\t\t\t\tand borrow books among your group of friends. It also helps you keep\n");
      out.write("\t\t\t\ttrack of your books making it. </br>\n");
      out.write("\t\t\t\t</br>\n");
      out.write("\t\t\t\tGet started by registering and creating a group. </large>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\n");
      out.write("</body>\n");
      out.write("</html>");
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
