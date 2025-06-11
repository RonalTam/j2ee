package tam.dev;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "welcomeServlet", urlPatterns = "/welcome")
public class WelcomeServlet extends HttpServlet {
    private String message;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        if (session != null) {
            String username = (String) session.getAttribute("username");
            if (username != null) {
                out.println("<h2>Chào mừng, " + username + "!</h2>");
                out.println("<a href='logout'>Đăng xuất</a>");
            } else {
                out.println("<h2>Bạn chưa đăng nhập.</h2>");
                out.println("<a href='login'>Đăng nhập</a>");
            }
        } else {
            out.println("<h2>Phiên làm việc đã hết hạn.</h2>");
            out.println("<a href='login.html'>Đăng nhập lại</a>");
        }


    }

}
