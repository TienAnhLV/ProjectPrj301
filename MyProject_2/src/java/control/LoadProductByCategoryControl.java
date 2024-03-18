/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

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
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoadProductByCategoryControl", urlPatterns = {"/loadProductByCategory"})
public class LoadProductByCategoryControl extends HttpServlet {

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
            out.println("<title>Servlet LoadProductByCategoryControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadProductByCategoryControl at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);

        //take paramater in url
        int cid = Integer.parseInt(request.getParameter("cid"));
        String indexString = request.getParameter("index");

        if (indexString == null || indexString.equals("")) {
            indexString = "1";
        }

        int index = Integer.parseInt(indexString);
        
        //send data
        ProductDAO pdao = new ProductDAO();
        List<Category> listCate = pdao.getAllCate();
        
        int count = (pdao.totalProductByCategory(cid)%6==0)
                ?pdao.totalProductByCategory(cid)/6:(pdao.totalProductByCategory(cid)/6 + 1);
        
        List<Product> listP = pdao.getListProductPageByCidAndIndex(cid, index);
        
        request.setAttribute("listC", listCate);
        request.setAttribute("listPage", listP);
        request.setAttribute("endP", count);
        request.setAttribute("tag", index);
        request.setAttribute("cid", cid);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
