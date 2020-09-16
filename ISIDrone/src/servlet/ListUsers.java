/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.MAdmin;
import action.ActionAdmin;
import util.Const;
import entities.*;

/**
 *
 * @author rcorroch
 */
@WebServlet(name = "ListUsers", urlPatterns = {"/ListUsers"})
public class ListUsers extends HttpServlet {

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
        String AfficherUsers = request.getParameter("afficherUsers");
       /* String itemAAjouter = request.getParameter("ajouterItem");
        String newProduct = request.getParameter("newProduct");
        String afficherTout = request.getParameter("afficherTout");*/
        /**
         * REQUEST DANS LE POST POUR AJOUTER UN PRODUIT****
         */
       /* String productName = request.getParameter("productName");
        String productCat = request.getParameter("productCat");
        String productDesc = request.getParameter("descProduct");
        String productPrice = request.getParameter("priceProduct");
        String productSerial = request.getParameter("serialProduct");
        String productQte = request.getParameter("qteProduct");
        String productActive = request.getParameter("active");
        entities.Item itemAjouter = null;*/
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            /*else {
                ActionAdmin.getallitems(request);
                request.getRequestDispatcher(Const.PATH_PAGE_LIST_PRODUCTS).forward(request, response);
            }*/

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
        processRequest(request, response);
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
