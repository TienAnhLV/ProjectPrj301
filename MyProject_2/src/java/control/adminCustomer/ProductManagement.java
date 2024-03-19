/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.adminCustomer;

import DAO.ProductDAO;
import enity.Category;
import enity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "ProductManagement", urlPatterns = {"/productManagement"})
public class ProductManagement extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductManagement</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductManagement at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        ProductDAO pdao = new ProductDAO();

        List<Product> listProduct = pdao.getAllProduct();

        List<Category> listCategory = pdao.getAllCate();

        request.setAttribute("listP", listProduct);
        request.setAttribute("listC", listCategory);

        request.getRequestDispatcher("admin/productManagement.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String action = request.getParameter("action");
        ProductDAO pdao = new ProductDAO();

        List<Product> listProduct = new ArrayList<>();

        switch (action) {
            case "add": {
                String productName = request.getParameter("productName");

                double price = Double.parseDouble(request.getParameter("price"));

                String img = request.getParameter("img");

                String des = request.getParameter("des");

                int categoryID = Integer.parseInt(request.getParameter("categoryID"));

                int saleID = Integer.parseInt(request.getParameter("saleID"));

                pdao.insertProduct(productName, price, img, des, categoryID, saleID);
                listProduct = pdao.getAllProduct();
                break;
            }

            case "search": {
                String productName = request.getParameter("productname");

                listProduct = pdao.getListProductByName(productName);

                break;
            }

            case "edit": {

                int productID = Integer.parseInt(request.getParameter("productId"));

                String productName = request.getParameter("productName");

                double price = Double.parseDouble(request.getParameter("price"));

                String img = request.getParameter("img");

                String des = request.getParameter("des");

                int categoryID = Integer.parseInt(request.getParameter("categoryID"));

                int saleID = Integer.parseInt(request.getParameter("saleID"));

                pdao.updateProductByProductID(productName, price, img, des, categoryID, saleID, productID);

                listProduct = pdao.getAllProduct();
                break;
            }

            case "delete": {
                int productID = Integer.parseInt(request.getParameter("productId"));
                
                pdao.deleteProductByProductID(productID);
                
                listProduct = pdao.getAllProduct();
                break;
            }
        }
        request.setAttribute("listP", listProduct);
        List<Category> listCategory = pdao.getAllCate();

        request.setAttribute("listC", listCategory);

        request.getRequestDispatcher("admin/productManagement.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
