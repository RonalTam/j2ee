/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tam.dev;

import tam.dev.data.dao.CategoryDao;
import tam.dev.data.dao.DatabaseDao;
import tam.dev.data.dao.ProductDao;
import tam.dev.data.model.Category;
import tam.dev.data.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Welcome
 */
public class CategoryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);

        String categoryIdRaw = request.getParameter("categoryId");
        if (categoryIdRaw == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing categoryId");
            return;
        }
        int categoryId = Integer.parseInt(categoryIdRaw);
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = new ArrayList<>();

        if (request.getParameter("property") != null && request.getParameter("order") != null) {
            String property = request.getParameter("property");
            String order = request.getParameter("order");
            productList = productDao.filter(categoryId, property, order);
        } else {
            productList = productDao.findByCategory(categoryId);
        }

        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = categoryDao.find(categoryId);

        request.setAttribute("productList", productList);
        request.setAttribute("category", category);

        request.getRequestDispatcher("category.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
