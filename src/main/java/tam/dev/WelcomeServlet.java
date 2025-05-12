package tam.dev;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class WelcomeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Welcome to the Java Web Application!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
