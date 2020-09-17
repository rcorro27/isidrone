/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import action.ActionOrder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ybenhail
 */
@WebServlet(name = "ListOrders", urlPatterns = {"/listOrders"})
public class ListOrders extends HttpServlet {

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
        String orderASupprimer = request.getParameter("order");
        String effacer = request.getParameter("effacer");
        

        if (orderASupprimer != null && Boolean.valueOf(effacer)) {
            action.ActionAdmin.deleteorder(request, Integer.parseInt(orderASupprimer));
            ActionOrder.getOrders(request, response);
            request.getRequestDispatcher("/WEB-INF/listOrders.jsp").forward(request, response);
        } else if (!Boolean.valueOf(effacer)) {
            
            ActionOrder.getOrders(request, response);
            request.getRequestDispatcher("/WEB-INF/listOrders.jsp").forward(request, response);
        }
        
        /* if (orderAModifier != null && Boolean.valueOf(update)) {
             if (state=="1"){
              action.ActionAdmin.updateShippedOrderState(request, 0,Integer.parseInt(orderAModifier));   
             }else {
                 action.ActionAdmin.updateShippedOrderState(request, 1,Integer.parseInt(orderAModifier));  
             }
            
            ActionOrder.getOrders(request, response);
            request.getRequestDispatcher("/WEB-INF/listOrders.jsp").forward(request, response);
        } else if (!Boolean.valueOf(update)) {
            ActionOrder.getOrders(request, response);
            request.getRequestDispatcher("/WEB-INF/listOrders.jsp").forward(request, response);
        }*/

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
