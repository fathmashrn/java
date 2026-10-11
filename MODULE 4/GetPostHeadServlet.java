import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/requests")
public class GetPostHeadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>GET Request</h2>");
        out.println("<p>This is a GET request.</p>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>POST Request</h2>");
        out.println("<p>This is a POST request.</p>");
    }

    protected void doHead(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        response.setHeader("Message", "This is a HEAD request");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
