package tam.dev;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/call", initParams = {
        @WebInitParam(name = "message", value = "Xin chao from Annotation"),
})
public class Login extends HttpServlet {
    @Override
    public void init() {
        System.out.println("init duoc goi");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet duoc goi");
        String msg = getServletConfig().getInitParameter("message");
        response.getWriter().println(msg);
    }
    @Override
    public void destroy() {
        System.out.println("destroy duoc goi");
    }
}
