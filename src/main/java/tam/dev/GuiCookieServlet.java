package tam.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(name = "GuiCookieServlet", urlPatterns = "/GuiCookieServlet")
public class GuiCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        // Tạo cookie để lưu trữ thông tin người dùng
        Cookie cookie = new Cookie("user", name + "," + age);
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().println("Cookie đã được tạo");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
