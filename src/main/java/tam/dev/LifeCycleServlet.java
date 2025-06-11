package tam.dev;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "lifeCycleServlet", value = "/lifecycle")
public class LifeCycleServlet extends HttpServlet {
    @Override
    public void init() {
        System.out.println("init duoc goi");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet duoc goi");
        response.getWriter().println("Hello from LifeCycleServlet!");
    }
    @Override
    public void destroy() {
        System.out.println("destroy duoc goi");
    }
}