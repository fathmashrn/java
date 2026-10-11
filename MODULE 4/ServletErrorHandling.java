import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/error")
public class ServletErrorHandling extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        try {
            int a = 10;
            int b = 0;

            int result = a / b;

            response.getWriter().println("Result = " + result);

        } catch (ArithmeticException e) {

            response.setStatus(
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            );

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<h2>Error Handling</h2>");
            out.println("<p>Cannot divide by zero!</p>");
        }
    }
}
