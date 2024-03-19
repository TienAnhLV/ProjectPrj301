/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAO.OrderDetailDAO;
import DAO.OrderItemDAO;
import DAO.ProductDAO;
import enity.Account;
import enity.Cart;
import enity.Item;
import enity.OrderDetail;
import enity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "PayWithAccountController", urlPatterns = {"/payWithAccountController"})
public class PayWithAccountController extends HttpServlet {

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
            out.println("<title>Servlet PayWithAccountController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PayWithAccountController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("acc");

        String locationOrderDate = request.getParameter("address");
        
        String payMethodString = request.getParameter("payMethod");
        
        if(payMethodString==null||payMethodString.equals("")){
            payMethodString = "1";
        }
        
        int payMethod = Integer.parseInt(payMethodString);
        
        //insert enity orderdetail
        OrderDetailDAO oddao = new OrderDetailDAO();

        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = simpleDateFormat.format(d);

        oddao.insertOrderDetail(dateString, account.getUserID(), locationOrderDate, payMethod);
        System.out.println("hihihi");
        //insert orderItem
        ProductDAO pdao = new ProductDAO();
        OrderItemDAO oidao = new OrderItemDAO();
        Cart cart = (Cart) session.getAttribute("cart");

        int orderIDnew = oddao.getCountOrderDetail();
        System.out.println(orderIDnew);

        //SEND DATA
        OrderDetail orderDetail = oddao.getOrderDetailByID(orderIDnew);
        System.out.println(orderDetail.toString());
        
        for (Item item : cart.getListItem()) {
            Product product = pdao.getElementProductByPid(item.getProduct().getProductID());
            oidao.insertOrderItem(orderDetail.getOrderDetailID(), product.getProductID(), item.getQuanity());
        }

        //SEND DATA
        List<Item> listItem = oidao.getListItemByOrderDetailId(orderIDnew);
        
      
        request.setAttribute("payID", payMethod);
        request.setAttribute("orderDetail", orderDetail);
        request.setAttribute("listItem", listItem);
        request.setAttribute("acc", account);
        session.removeAttribute("cart");
        request.getRequestDispatcher("/Bill/bill.jsp").forward(request, response);
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
