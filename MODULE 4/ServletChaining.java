import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/first")
public class ServletChaining extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("message", "Hello from First Servlet!");

        RequestDispatcher rd =
            request.getRequestDispatcher("/second");

        rd.forward(request, response);
    }
}

@WebServlet("/second")
class SecondServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String message =
            (String) request.getAttribute("message");

        out.println("<h2>Servlet Chaining</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<p>Received by Second Servlet.</p>");
    }
}
