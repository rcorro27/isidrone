package action;

import entities.Item;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MItem;

public class ActionItems {

    public static ArrayList<Item> getItems(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Item> itemsCategoryAverifier = MItem.getItems(ActionCategory.getSelectedCategory(request, response));
        request.setAttribute("items", MItem.getItems(ActionCategory.getSelectedCategory(request, response)));
        return itemsCategoryAverifier;
    }

    public static void getItemById(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("item", MItem.getItemById(id));
        //request.setAttribute("items", MItem.getItemById(id));
    }

    public static void getSearchItems(String search, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("items", MItem.getSearchItem(search));
    }

}
