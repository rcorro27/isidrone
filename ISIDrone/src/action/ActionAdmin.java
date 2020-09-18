/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import manager.MAdmin;
import entities.*;

/**
 *
 * @author rcorroch
 */
public class ActionAdmin {

    public static void getallitems(HttpServletRequest request) throws IOException {
        request.setAttribute("listitems", MAdmin.getallitems());
    }

    public static void getallUsers(HttpServletRequest request) throws IOException {
        request.setAttribute("listusers", MAdmin.getallusers());
    }

    public static void getallUsersBySearch(HttpServletRequest request, String search) throws IOException {
        request.setAttribute("listusers", MAdmin.getSearchUser(search));
    }

    public static boolean deleteitem(HttpServletRequest request, int id) throws IOException {
        return MAdmin.Deletitem(id);
    }

    public static boolean deleteorder(HttpServletRequest request, int id) throws IOException {
        return MAdmin.DeleteOrder(id);
    }
     public static void updateShippedOrderState(HttpServletRequest request, int id,int isShipped) throws IOException {
         MAdmin.updateShippedOrderState(id,isShipped);
    }

    public static boolean additem(HttpServletRequest request, Item item) throws IOException {
        return MAdmin.addItem(item);
    }
}
