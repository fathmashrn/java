import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/lifecycle")
public class ServletLifeCycle extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("Servlet Initialized");
    }

    public void service(HttpServletRequest request,
                        HttpServletResponse response)
                        throws IOException, ServletException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Servlet Life Cycle</h2>");
        out.println("<p>Service Method Executed</p>");
        out.println("</body></html>");

        System.out.println("Service Method Executed");
    }

    public void destroy() {
        System.out.println("Servlet Destroyed");
    }
}
