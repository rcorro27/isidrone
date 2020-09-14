/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import action.ActionAdmin;
import action.ActionItems;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import manager.MItem;
import util.Const;

/**
 *
 * @author ybenhail
 */
@WebServlet(name = "EditProduct", urlPatterns = {"/editProduct"})
public class EditProduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int item;
        try {
            item = Integer.parseInt(request.getParameter("item"));
        } catch (NumberFormatException e) {
            item = -1;
        }

        ActionItems.getItemById(item, request, response);
        request.getRequestDispatcher(Const.PATH_PAGE_PRODUCT_EDIT).forward(request, response);
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
        //processRequest(request, response);
        //
        //HttpServletRequest r = request;
        String active = request.getParameter("active");
        entities.Item itemAmodifier = new entities.Item();
        itemAmodifier.setCategory(Integer.parseInt(request.getParameter("productCat")));
        itemAmodifier.setName(request.getParameter("productName"));
        itemAmodifier.setDescription(request.getParameter("descProduct"));
        itemAmodifier.setPrice(Double.parseDouble(request.getParameter("priceProduct")));
        itemAmodifier.setSerial(request.getParameter("serialProduct"));
        itemAmodifier.setStock(Integer.parseInt(request.getParameter("qteProduct")));
       // if(request.getParameter("active")=="1"){}
        itemAmodifier.setActiver(Integer.parseInt(active));
        itemAmodifier.setId(Integer.parseInt(request.getParameter("idProduct")));
        MItem.updateItem(itemAmodifier);
        ActionAdmin.getallitems(request);
        request.getRequestDispatcher("/WEB-INF/listProducts.jsp").forward(request, response); 

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
