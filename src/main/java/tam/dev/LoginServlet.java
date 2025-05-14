package tam.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin".equals(password)) {
            // Tạo session và lưu thông tin người dùng
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Chuyển hướng đến trang chính
            response.sendRedirect("welcome.html");
        } else {
            // Nếu thông tin đăng nhập không hợp lệ, hiển thị thông báo lỗi
           response.getWriter().println("Tên đăng nhập hoặc mật khẩu không đúng.");
           response.sendRedirect("login.html");
        }
    }
}
