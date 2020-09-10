package action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import manager.MItem;

public class ActionFeaturedProduct {
	public static void getFeaturedProduct(HttpServletRequest request) throws IOException {
		request.setAttribute("featuredProduct", MItem.getFeaturedItems());
	}
}
