import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookiesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie c = new Cookie("username", "Sherin");
        response.addCookie(c);

        out.println("<h2>Cookie Created Successfully!</h2>");
        out.println("<p>Username: Sherin</p>");
    }
}
