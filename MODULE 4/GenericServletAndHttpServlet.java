import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/generic")
class GenericDemo extends GenericServlet {
    public void service(ServletRequest request,
                        ServletResponse response)
                        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>GenericServlet Example</h2>");
        out.println("<p>Hello from GenericServlet</p>");
        out.println("</body></html>");
    }
}

@WebServlet("/http")
class HttpDemo extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>HttpServlet Example</h2>");
        out.println("<p>Hello from HttpServlet</p>");
        out.println("</body></html>");
    }
}

public class GenericServletAndHttpServlet {
    public static void main(String[] args) {
        System.out.println("GenericServlet and HttpServlet");
        System.out.println("Deploy this program on a servlet container.");
    }
}
