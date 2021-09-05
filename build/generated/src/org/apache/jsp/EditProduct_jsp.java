package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EditProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <title>Manage Products</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto|Varela+Round\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/function.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-xl\">\n");
      out.write("            <div class=\"table-responsive\">\n");
      out.write("                <div class=\"table-wrapper\">\n");
      out.write("                    <div class=\"table-title\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <h2>Manage <b>Products</b></h2>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"SearchProducts\" method=\"GET\">\n");
      out.write("                        <div class=\"modal-body\">\t\t\t\t\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Name</label>\n");
      out.write("                                <input type=\"text\" name=\"q\" class=\"form-control\" required>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-success\" value=\"Search\">\n");
      out.write("                            </div>\t\t\t\t\t\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                    <div class=\"clearfix\">\n");
      out.write("                        <div class=\"hint-text\">Page-views: <b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageviews}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>        \n");
      out.write("        </div>\n");
      out.write("                    \n");
      out.write("       \n");
      out.write("        \n");
      out.write("        <!-- Edit Modal HTML -->\n");
      out.write("        <div id=\"editProduct\" class=\"modal fade\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <form action=\"EditProduct\" method=\"POST\">\n");
      out.write("                        <div class=\"modal-header\">\t\t\t\t\t\t\n");
      out.write("                            <h4 class=\"modal-title\">Edit Product</h4>\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <input type=\"number\" id=\"edit-id\" name=\"edit-id\" value=\"\" hidden=\"\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Name</label>\n");
      out.write("                                <input type=\"text\" id=\"edit-name\" name=\"name\" class=\"form-control\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Image</label>\n");
      out.write("                                <input type=\"text\" id=\"edit-image\" name=\"imageFile\" class=\"form-control\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Price</label>\n");
      out.write("                                <input type=\"number\" id=\"edit-price\" name=\"price\" class=\"form-control\" required>\n");
      out.write("                            </div>\t\t\t\t\t\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <input type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" value=\"Cancel\">\n");
      out.write("                            <input type=\"submit\" class=\"btn btn-info\" value=\"Save\">\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
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
