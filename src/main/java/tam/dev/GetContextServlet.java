package tam.dev;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/GetContextServlet")
public class GetContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String siteName = (String) context.getAttribute("siteName");
        int count = (int) context.getAttribute("count");
        resp.getWriter().println("Dữ liệu từ ServletContext: " + siteName);
        resp.getWriter().println("Số lần truy cập: " + count);
    }
}
