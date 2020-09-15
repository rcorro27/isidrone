<%-- 
    Document   : editProduct
    Created on : Sep. 8, 2020, 8:15:06 a.m.
    Author     : Rcorroch
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
    <form action="ListProducts?newProduct=1" method="post">
        <div class="form-group">
            <label for="productName">Nom</label>
            <input type="text" class="form-control" id="productName" name="productName" maxlength = "100"s required >
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">Categorie</label>
            <select class="form-control"  name="productCat"  required>
                <option value="1" >Tous</option>
                <option value="2" >Avec Camera</option>
                <option value="3" >Recreatif</option>
                <option value="4" >Performance</option>
                <option value="5" >Materiaux</option>
            </select>
        </div>
        <div class="form-group">
            <label for="descProduct">Description </label>
            <textarea class="form-control" id="descProduct" rows="3" name="descProduct"  maxlength = "200"  required></textarea>
        </div>
        <div class="form-group">
            <label for="priceProduct">Prix</label>
            <input type="number" class="form-control" id="priceProduct" name="priceProduct" min="1" max="1000000" step=0.01 required >
        </div>
        <div class="form-group">
            <label for="serialProduct">Numero de série</label>
            <input type="text" class="form-control" id="serialProduct" name="serialProduct" maxlength = "30" required>
        </div>
        <div class="form-group">
            <label for="qteProduct">Quantité en stock</label>
            <input type="number" class="form-control" id="qteProduct" min="1" max="1000000"  name="qteProduct"  required>
        </div>
        <div class="form-group ">
            <input type="checkbox" class="form-check-input" id="exampleCheck1"  name="active" value="1" >
            <label class="form-check-label" for="exampleCheck1" >Actif</label>
        </div>
        <div class="form-group ">
            <button type="submit" class="btn btn-primary">ajouter</button>
            <button type="button" class="btn btn-dark">Annuler</button>
        </div>
    </form>
</div>

<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>