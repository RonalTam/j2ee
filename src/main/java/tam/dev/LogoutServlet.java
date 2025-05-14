package tam.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xóa thông tin người dùng khỏi session
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            resp.getWriter().println("Đã đăng xuất thành công.");
            resp.sendRedirect("login.html");
        } else {
            resp.getWriter().println("Phiên làm việc đã hết hạn.");
            resp.getWriter().println("<br><a href='login.html'>Đăng nhập</a>");
        }


    }
}
