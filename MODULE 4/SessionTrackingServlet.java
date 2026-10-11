import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionTrackingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        session.setAttribute("username", "Sherin");

        out.println("<h2>Session Created Successfully!</h2>");
        out.println("<p>Welcome " +
                    session.getAttribute("username") + "</p>");
        out.println("<p>Session ID: " +
                    session.getId() + "</p>");
    }
}
