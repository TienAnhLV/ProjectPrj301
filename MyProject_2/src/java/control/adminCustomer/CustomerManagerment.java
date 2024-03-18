/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.adminCustomer;

import DAO.AccountDAO;
import enity.Account;
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
@WebServlet(name = "CustomerManagerment", urlPatterns = {"/customerManagerment"})
public class CustomerManagerment extends HttpServlet {

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
            out.println("<title>Servlet CustomerManagerment</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerManagerment at " + request.getContextPath() + "</h1>");
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

        AccountDAO adao = new AccountDAO();

        String userFind = (request.getParameter("username") == null) ? "" : (request.getParameter("username"));

        List<Account> listAcc = new ArrayList<>();

        if (userFind.equals("")) {

            listAcc = adao.getAllAccount();
        } else {
            listAcc = adao.searchAccountByUser(userFind);
        }

        request.setAttribute("listAcc", listAcc);

        request.getRequestDispatcher("admin/customerManagement.jsp").forward(request, response);
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
        String action = request.getParameter("action");

        AccountDAO adao = new AccountDAO();

        switch (action) {
            case "delete": {

                int userID = Integer.parseInt(request.getParameter("userId"));
                System.out.println(userID);
                adao.deleteAccountByID(userID);

                break;
            }

            case "add": {
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String location = request.getParameter("location");

                adao.insertNewAccount(user, pass, name, phone, email, location, 0);

                break;
            }

            case "update": {
                String email = request.getParameter("email");
                Account account = adao.getAccountByEmail(email);

                String password = request.getParameter("pass");
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String location = request.getParameter("location");

                adao.updateAccountInEditManagement(account.getUserID(), password, name, phone, location);
                break;
            }
        }

        List<Account> listAcc = adao.getAllAccount();
        request.setAttribute("listAcc", listAcc);

        request.getRequestDispatcher("admin/customerManagement.jsp").forward(request, response);
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
