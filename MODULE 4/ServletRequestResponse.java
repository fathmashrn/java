import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/student")
public class ServletRequestResponse extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            name = "Student";
        }

        out.println("<html><body>");
        out.println("<h2>Servlet Request and Response</h2>");
        out.println("<p>Welcome, " + name + "!</p>");
        out.println("</body></html>");
    }
}
