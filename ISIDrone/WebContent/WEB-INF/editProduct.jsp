<%-- 
    Document   : editProduct
    Created on : Sep. 8, 2020, 8:15:06 a.m.
    Author     : ybenhail
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList, entities.Category"%>
<%@page import="entities.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%
    //Format a deux decimal
    DecimalFormat df = new DecimalFormat("####0.00");

    Item item = (Item) request.getAttribute("item");
%>

<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<!-- /.container -->
<!-- Page Content -->
<div class="container">
    <%
        if (item != null) {
    %>
    <form action="editProduct" method="post">
        <div class="form-group">
            <label for="productName">Nom</label>
            <input type="text" class="form-control" id="productName" name="productName" value="<%=item.getName()%>">
        </div>
        <input type="hidden" name="idProduct" value="<%=item.getId()%>">



        <div class="form-group">
            <label for="exampleFormControlInput1">Categorie</label>
            <select class="form-control"  name="productCat">
                <option value="1"  <%= (item.getCategory() == 2 ? "selected" : "")%>>Avec Camera</option>
                <option value="2" <%= (item.getCategory() == 3 ? "selected" : "")%>>Recreatif</option>
                <option value="3" <%= (item.getCategory() == 4 ? "selected" : "")%>>Performance</option>
                <option value="4" <%= (item.getCategory() == 5 ? "selected" : "")%>>Materiaux</option>
            </select>
        </div>

        <div class="form-group">
            <label for="descProduct">Description </label>
            <textarea class="form-control" id="descProduct" rows="3" name="descProduct"> <%=item.getDescription()%></textarea>
        </div>
        <div class="form-group">
            <label for="priceProduct">Prix</label>
            <input type="text" class="form-control" id="priceProduct" name="priceProduct" value="<%=item.getPrice()%>">
        </div>
        <div class="form-group">
            <label for="serialProduct">Numero de série</label>
            <input type="text" class="form-control" id="serialProduct" name="serialProduct"  value="<%=item.getSerial()%>">
        </div>
        <div class="form-group">
            <label for="qteProduct">Quantité en stock</label>
            <input type="text" class="form-control" id="qteProduct"  name="qteProduct" value="<%=item.getStock()%>">
        </div>
         <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1" value="2">
    <label class="form-check-label" for="exampleCheck1" name="active">Produit valide</label>
  </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
        <button type="button" class="btn btn-dark">Annuler</button>
    </form>
        <%
        } else {
        %>
    <div class="alert alert-info">
        Aucun produit ne correspond à votre demande.
    </div>
    <a href="items?category=1" class="btn btn-default">Retour à l'inventaire</a>
    <%
        }
    %>
</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>