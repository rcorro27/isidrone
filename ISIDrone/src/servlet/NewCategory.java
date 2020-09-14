/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import action.*;
import entities.Category;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.MCategory;
import util.Const;

/**
 *
 * @author ybenhail
 */
@WebServlet(name = "newCategory", urlPatterns = {"/newCategory"})
public class NewCategory extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewCategory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewCategory at " + request.getContextPath() + "</h1>");
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
        //  processRequest(request, response);
        request.getRequestDispatcher(Const.PATH_ADD_CATEGORY).forward(request, response);

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
        // processRequest(request, response);
        String test = request.getParameter("active");
        Category category = new Category();
        category.setName(request.getParameter("nameCat"));
        category.setDescription(request.getParameter("descCat"));
        category.setOrder(Integer.parseInt(request.getParameter("position")));

        if (request.getParameter("active") == null) {
            category.setActiver(0);
        } else {
            category.setActiver(1);

        }
        int rep = MCategory.addCategorie(category);
        if (rep == 0) {
            request.setAttribute("error", "accountExisting");
            request.getRequestDispatcher(Const.PATH_PAGE_NEW_CATEGORIE).forward(request, response);

        }else 
        {
        ActionCategory.getCategories(request, response);
        request.getRequestDispatcher(Const.PATH_PAGE_LIST_CATEGORIES).forward(request, response);
        }
        

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
