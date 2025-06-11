package tam.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(name = "DocCookieServlet", urlPatterns = "/DocCookieServlet")
public class DocCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    String value = cookie.getValue();
                    String[] userInfo = value.split(",");
                    String name = userInfo[0];
                    String age = userInfo[1];
                    resp.getWriter().println("Tên: " + name + ", Tuổi: " + age);
                }
            }
        } else {
            resp.getWriter().println("Không có cookie nào được gửi từ client.");
        }
    }
}
