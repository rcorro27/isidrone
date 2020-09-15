package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Const;
import action.ActionCart;
import action.ActionCategory;
import action.ActionItems;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class Products
 */
@WebServlet(name = "products", urlPatterns = {"/items"})
public class Items extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Items() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Si le paramètre category est présent

        String idCategoryToDelete = request.getParameter("category");
        String effacer = request.getParameter("effacer");
        String searchResult = request.getParameter("search");
        ArrayList<entities.Item> itemsCategoryAverifier = null;

        if (!Boolean.valueOf(effacer) && effacer != null) {
            ActionCategory.getCategories(request, response);
            ActionItems.getItems(request, response);
            request.getRequestDispatcher(Const.PATH_PAGE_ITEMS).forward(request, response);
        }

        if (searchResult != null) {
            ActionItems.getSearchItems(searchResult, request, response);
            request.setAttribute(Const.ATTIBUT_SEARCH, searchResult);
        }
        if (Boolean.valueOf(effacer) && effacer != null) {
            if (idCategoryToDelete != null) {
                itemsCategoryAverifier = ActionItems.getItems(request, response);
                if (itemsCategoryAverifier.isEmpty()) {
                    ActionCategory.deleteCategory(request, Integer.parseInt(idCategoryToDelete));
                    ActionCategory.getCategories(request, response);
                    request.getRequestDispatcher(Const.PATH_PAGE_LIST_CATEGORIES).forward(request, response);
                } else if (!itemsCategoryAverifier.isEmpty()) {
                    try ( PrintWriter out = response.getWriter()) {
                        ActionCategory.getCategories(request, response);
                       //out.println("<h1>vous ne pouvez pas effacer cette categorie des produits utilisent </h1>");
                        request.getRequestDispatcher(Const.PATH_PAGE_LIST_CATEGORIES).forward(request, response);
                    }
                }

            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("itemId");
        String strQty = request.getParameter("qty");

        ActionCart.addItem(request, response, strId, strQty);

        doGet(request, response);
    }
}
