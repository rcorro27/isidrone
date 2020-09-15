<%@page import="util.Const"%>
<%@page import="manager.MLogin"%>
<%@page import="action.ActionLogin"%>
<%@page import="manager.MCookies"%>
<%@ page import="entities.User"%>
<%@ page import="util.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    #userAction {
      display: none;
    position: absolute;
    z-index: 1;
    background-color: white;
    width: 200px;
    margin-top: 10px;
    margin-left: -121px;

}
    
#menuA{
        margin:0 0 10px 0;   

}
</style>
<%
//S'il n'y a pas d'utilisateur déjà de connecté
    User user = (User) session.getAttribute("user");

//S'il n'y a pas d'utilisaeur de connecté présentement, on vérifie dans les cookies
// et si nous somme pas en train de nous déconnecter
    if (user == null && request.getAttribute("logout") == null) {
        user = ActionLogin.getUserFromAutoLogin(request);
        session.setAttribute("user", user);
    }

//Si le autoLogin a fonctionné
    if (user != null) {%>
<li id="loginState">

    <a href="#" id="user"><%=user.getFirstName()%></a>
    <ul id="userAction" class="list-unstyled navbar navbar-default">
        <% if (user.getUserRole() == 1) { %>
        <li><a  href="ListProducts?afficherTout=1">Afficher tout les produits</a></li>
        <li><a  href="ListProducts?ajouterItem=1">Ajouter un produit</a></li>
        <li><a  href="listCategories">Categories</a></li> 
        <li><a  href="newCategory">Ajouter categorie</a></li> 
        <li><a  href="editCategory">Modifier categorie</a></li>
<% } else {%>
         <li><a href="<%="order-history"%>">Historique commande</a></li>
            <% } %>    
        
        <li><a href="login">Déconnexion</a></li>

    </ul>

</li>
<% } else {

%>
<li><a href="signup<%=(request.getParameter("fromCart") != null ? "?fromCart=true" : "")%>">S'enregistrer</a></li>
<li id="loginState"><a href="login">Connexion</a></li>
<%
    }
%>