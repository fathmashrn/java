import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/secure")
public class ServletSecurity extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username)
                && "1234".equals(password)) {

            out.println("<h2>Login Successful</h2>");
            out.println("<p>Welcome, Admin!</p>");

        } else {

            response.setStatus(
                HttpServletResponse.SC_UNAUTHORIZED
            );

            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid username or password.</p>");
        }
    }
}
