/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAO.PayDAO;
import DAO.ProductDAO;
import enity.Cart;
import enity.Category;
import enity.PayMethod;
import enity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "ShoppingCartController", urlPatterns = {"/shoppingCartController"})
public class ShoppingCartController extends HttpServlet {

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
            out.println("<title>Servlet ShoppingCartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingCartController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        ProductDAO pdao = new ProductDAO();
        if (cart == null) {
            cart = new Cart();
        }

        String action = request.getParameter("action");
        
        PayDAO payDAO = new PayDAO();
        
        List<PayMethod> payMethods = payDAO.getAllPayMethod();
        
        request.setAttribute("payMethods", payMethods);
        
        switch (action) {
            case "put": {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Product product = pdao.getElementProductByPid(pid);
                cart.add(product);
                session.setAttribute("cart", cart);
                response.sendRedirect("detailProduct?pid=" + pid);
                break;
            }

            case "get": {
                List<Category> listCate = pdao.getAllCate();
                request.setAttribute("listC", listCate);
                request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
                break;
            }
            case "post": {
                String fuction = request.getParameter("function");
                int id = Integer.parseInt(request.getParameter("id"));

                if (fuction.equals("increase")) {
                    cart.updateQuantity(id);
                } else {
                    cart.deleteQuantity(id);
                }
                List<Category> listCate = pdao.getAllCate();
                request.setAttribute("listC", listCate);
                request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
                break;
            }

            case "delete": {
                int id = Integer.parseInt(request.getParameter("id"));
                cart.deleteProduct(id);
                List<Category> listCate = pdao.getAllCate();
                request.setAttribute("listC", listCate);
                request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
                break;
            }

            default: {
                int pid = Integer.parseInt(request.getParameter("id"));
                Product product = pdao.getElementProductByPid(pid);
                cart.add(product);
                session.setAttribute("cart", cart);
                List<Category> listCate = pdao.getAllCate();
                request.setAttribute("listC", listCate);
                request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
                break;
            }
        }

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     *
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
