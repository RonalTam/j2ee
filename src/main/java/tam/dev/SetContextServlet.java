package tam.dev;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/SetContextServlet")
public class SetContextServlet extends HttpServlet {

    int count = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        context.setAttribute("siteName", "Học Lập Trình");
        context.setAttribute("count", ++count);
        resp.getWriter().println("Đã lưu dữ liệu vào ServletContext'");
    }
}
