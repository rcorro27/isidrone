<%-- 
    Document   : editUser
    Created on : Sep 17, 2020, 12:35:42 AM
    Author     : rcorroch
--%>

<%@page import="entities.User"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList, entities.Category"%>
<%@page import="entities.Cart"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%
    //Format a deux decimal
    DecimalFormat df = new DecimalFormat("####0.00");

    User user = (User) request.getAttribute("user");
    ArrayList<User> users = (ArrayList<User>) request.getAttribute("listusers");
%>

<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<!-- /.container -->
<!-- Page Content -->
<div class="container">
    <%
        if (user != null) {
    %>
    <form action="editProduct" method="post">
        <div class="form-group">
            <label for="productName">Nom</label>
            <input type="text" class="form-control" id="productName" name="productName" value=""  maxlength = "100"s required>
        </div>
        <div class="form-group">
            <label for="productName">Prenom</label>
            <input type="text" class="form-control" id="productName" name="productName" value=""  maxlength = "100"s required>
        </div>
        <div class="form-group">
            <label for="productName">Email</label>
            <input type="text" class="form-control" id="productName" name="productName" value=""  maxlength = "100"s required>
        </div>
        <div>
            <h1>adresse</h1>
        </div>

        <div class="form-group">
            <label for="descProduct">Numero civique</label>
            <textarea class="form-control" id="descProduct" rows="3" name="descProduct" maxlength = "200"  required> </textarea>
        </div>
        <div class="form-group">
            <label for="priceProduct">Appartement</label>
            <input type="number" class="form-control" id="priceProduct" name="priceProduct" value="" min="1" max="1000000"  step=0.01  required>
        </div>
        <div class="form-group">
            <label for="serialProduct">Rue</label>
            <input type="text" class="form-control" id="serialProduct" name="serialProduct"  value="" maxlength = "30"  required>
        </div>
        <div class="form-group">
            <label for="qteProduct">Code postal</label>
            <input type="text" class="form-control" id="qteProduct"  name="qteProduct" value="" maxlength = "7"  required>
        </div>
        <div class="form-group">
            <label for="qteProduct">  Ville</label>
            <input type="text" class="form-control" id="qteProduct"  name="qteProduct" value="" maxlength = "7"  required>
        </div>
        <div class="form-group">
            <label for="qteProduct">Province</label>
            <input type="text" class="form-control" id="qteProduct"  name="qteProduct" value="" maxlength = "7"  required>
        </div>
        <div class="form-group">
            <label for="qteProduct">Pays</label>
            <input type="text" class="form-control" id="qteProduct"  name="qteProduct" value="" maxlength = "7"  required>
        </div>
        <div class="form-group">
            <label for="qteProduct">Téléphone</label>
            <input type="text" class="form-control" id="qteProduct"  name="qteProduct" value="" maxlength = "7"  required>
        </div>

        <button type="submit" class="btn btn-primary">Modifier</button>
        <button type="button" class="btn btn-dark">Annuler</button>
    </form>
    <%        } else {
    %>
    <div class="alert alert-info">
        Aucun utilisateur ne correspond à votre demande.
    </div>
    <a href="ListUsers?afficherTout=true" class="btn btn-default">Retour à liste de utilisateurs</a>
    <%
        }
    %>
</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
