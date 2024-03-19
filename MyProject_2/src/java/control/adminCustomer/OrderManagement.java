/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.adminCustomer;

import DAO.OrderCartDao;
import DAO.OrderDetailDAO;
import enity.OrderCart;
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
@WebServlet(name = "CustomerOrder", urlPatterns = {"/orderManagement"})
public class OrderManagement extends HttpServlet {

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
            out.println("<title>Servlet CustomerOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerOrder at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        OrderCartDao ocd = new OrderCartDao();

        List<OrderCart> orderCarts = new ArrayList<>();

        String fullname = (request.getParameter("username") == null
                || (request.getParameter("username").equals("")) ? "" : (request.getParameter("username")));

        if (fullname.equals("")) {
            orderCarts = ocd.getAllOrderCart();
        } else {
            orderCarts = ocd.getOrderCartByName(fullname);
            
        }

        request.setAttribute("listOrderCart", orderCarts);

        request.getRequestDispatcher("admin/orderMangement.jsp").forward(request, response);
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

        OrderDetailDAO oddao = new OrderDetailDAO();

        String action = request.getParameter("action");

        OrderCartDao ocd = new OrderCartDao();

        List<OrderCart> orderCarts = new ArrayList<>();

        switch (action) {
            case "edit": {

                int orderID = Integer.parseInt(request.getParameter("orderID"));

                String location = request.getParameter("location");

                int status = Integer.parseInt(request.getParameter("status"));

                String comment = (request.getParameter("comment") == null || request.getParameter("comment").equals(""))
                        ? "" : (request.getParameter("comment"));

                oddao.updateOrderDetaolByOrderID(orderID, location, status, comment);

                orderCarts = ocd.getAllOrderCart();
                break;
            }

            case "delete": {
                int orderDetailID = Integer.parseInt(request.getParameter("orderDetailID"));

                oddao.deleteOrderDetailByOrderDetailId(orderDetailID);

                orderCarts = ocd.getAllOrderCart();
                break;
            }

            case "changeSatus": {
                int orderDetailID = Integer.parseInt(request.getParameter("orderDetailID"));
                int status = Integer.parseInt(request.getParameter("status"));

                oddao.updateStatusOrderDetaolByOrderID(orderDetailID, status);
                orderCarts = ocd.getAllOrderCart();

                break;
            }

            case "searchByStatus": {

                int statusSearch = Integer.parseInt(request.getParameter("searchByStatus"));

                orderCarts = ocd.getOrderCartBySatus(statusSearch);
                request.setAttribute("status", statusSearch);

                
                break;
            }
        }

        request.setAttribute("listOrderCart", orderCarts);

        request.getRequestDispatcher("admin/orderMangement.jsp").forward(request, response);
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
