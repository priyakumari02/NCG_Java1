package com.adobe.prj.web;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet  extends HttpServlet  {

    // GET http://localhost:8080/products
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = new ProductDaoJdbcImpl(); // factory
        resp.setContentType("text/html"); // MIME type
        PrintWriter out = resp.getWriter(); // opens a character stream to client/browser
        out.println("<html><body>");
        out.println("<table border = \"1\">");
        out.println("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        try {
            List<Product> products = productDao.getProducts();
            for(Product p : products) {
               out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getName() + "</td>");
                out.println("<td>" + p.getPrice() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Product p = Product.builder()
               .name(req.getParameter("name"))
               .price(Double.parseDouble(req.getParameter("price")))
               .quantity(100)
               .build();
        ProductDao productDao = new ProductDaoJdbcImpl();
        try {
            productDao.addProduct(p);
            resp.sendRedirect("index.jsp?msg=Product added Successfully!!!");
        } catch (DaoException e) {
//            throw new RuntimeException(e);
            resp.sendRedirect("index.jsp?msg="+e.getMessage());
        }
    }
}
