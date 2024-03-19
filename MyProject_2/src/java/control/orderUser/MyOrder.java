/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.orderUser;

import DAO.OrderCartDao;
import DAO.OrderDetailDAO;
import enity.Account;
import enity.OrderCart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "MyOrder", urlPatterns = {"/myOrder"})
public class MyOrder extends HttpServlet {

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
            out.println("<title>Servlet MyOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyOrder at " + request.getContextPath() + "</h1>");
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
        
        Account account = (Account)session.getAttribute("acc");
        
        int userID = account.getUserID();

        OrderCartDao cartDao = new OrderCartDao();
        
        String statusText = (request.getParameter("searchByStatus")==null)?"":(request.getParameter("searchByStatus"));
        
        List<OrderCart> carts = new ArrayList<>();
        
        if(statusText==null || statusText.equals("")){
            carts = cartDao.getAllOrderCartByUserID(userID);
        }else{
            int status = Integer.parseInt(statusText);
            carts = cartDao.getAllOrderCartByUserIDAndStatus(userID,status);
            request.setAttribute("status", status);
        }
        request.setAttribute("listOrderCart", carts);

        request.getRequestDispatcher("orderUser/MyOrderMangement.jsp").forward(request, response);
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
        
        OrderDetailDAO detailDAO = new OrderDetailDAO();

        List<OrderCart> orderCarts = new ArrayList<>();

        int orderID = Integer.parseInt(request.getParameter("orderID"));

        String location = request.getParameter("location");

        detailDAO.updateLocationByID(orderID, location);
        
        //take account in session
        HttpSession session = request.getSession();
        
        Account account = (Account)session.getAttribute("acc");
        
        orderCarts = ocd.getAllOrderCartByUserID(account.getUserID());
        
        request.setAttribute("listOrderCart", orderCarts);

        request.getRequestDispatcher("orderUser/MyOrderMangement.jsp").forward(request, response);
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
