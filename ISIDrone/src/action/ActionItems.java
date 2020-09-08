package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MItem;

public class ActionItems {
	
	public static void getItems(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("items", MItem.getItems(ActionCategory.getSelectedCategory(request, response)));
	}

	public static void getItemById(int id, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("item", MItem.getItemById(id));
                //request.setAttribute("items", MItem.getItemById(id));
	}
        
        public static void getSearchItems(String search, HttpServletRequest request, HttpServletResponse response){
            request.setAttribute("items", MItem.getSearchItem(search));
        }
    
	
}
