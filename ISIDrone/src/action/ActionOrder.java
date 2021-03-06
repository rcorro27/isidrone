package action;

import java.util.List;

import entities.Cart;
import entities.Order;
import entities.User;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.MOrder;
import manager.MSendMail;

public class ActionOrder {
	
	// Methode executé lorse qu'une commande est completé
	public static int process(User user, Cart cart) throws IOException{
		
		// Ajoute la commande a la base de donnée
		int orderId = MOrder.add(user, cart);
		
		// Envoie d'un email de confirmation
		String to = user.getEmail();
		sendEmail(to);
		
		return orderId;
	}
	public static void getOrders(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("orders", MOrder.getOrders());
	}
	private static void sendEmail(String to){
		
		// Envoie d'un email de confirmation
		String sujet = "Achat completé";
		String message = "Félicitation, vous avez commander quelquechose.";
		
		MSendMail.sendEmail(message, to, sujet);
		
	}
	
	public static List<Order> getHistoryByUserID(int userId) throws IOException{
		List<Order> orderList = MOrder.getAllOrdersByUserId(userId);
		
		return orderList;
	}
}
