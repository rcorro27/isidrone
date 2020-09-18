<%-- 
    Document   : editCategory
    Created on : Sep 11, 2020, 8:19:54 AM
    Author     : samue
--%>

<%@page import="entities.Category"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="util.Const"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Format a deux decimal
    DecimalFormat df = new DecimalFormat("####0.00");

    Category cat = (Category) request.getAttribute("category");
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Category</title>
    </head>
    <body>
        <h1>Modifier catégorie</h1>
        <%--
        
        Ajouter contraintes pour le formulaire
        Changer BD depedemement de ce qu'on change dans le form pour le produit
        Doit etre en get
        
        
        Nom 
    Description 
    Position 
    Actif ou pas
        
        --%>
        <form action="editProduct" method="get">
            <div class="form-group">
                <label for="productName">Nom</label>
                <input type="text" class="form-control" id="productName" name="productName" value="<%=cat.getName()%>"  maxlength = "100"s required>
            </div>
            <input type="hidden" name="idProduct" value="<%=cat.getId()%>">

            <div class="form-group">
                <label for="descProduct">Description </label>
                <textarea class="form-control" id="descProduct" rows="3" name="descProduct" maxlength = "200"  required> <%=cat.getDescription()%></textarea>
            </div>
            <div class="form-group">
                <label for="priceProduct">Position</label>
                <input type="number" class="form-control" id="priceProduct" name="priceProduct" value="<%=cat.getOrder()%>" min="1" max="1000000"  step=0.01  required>
            </div>
            <div class="form-group">
                <label for="serialProduct">Actif ou pas</label>
                <input type="text" class="form-control" id="serialProduct" name="serialProduct"  value="<%=cat.getActiver()%>" maxlength = "30"  required>
            </div>
            <div class="form-group form-check">

                <%
        if (item.isActive()) {%>
                <input type='hidden' value="0" name="active">

                <input type="checkbox" class="form-check-input" id="exampleCheck1" value="2" checked name="test">


                <% } else {%>
                <input type='hidden' value="1" name="active">
                <input type="checkbox" class="form-check-input" id="exampleCheck1" value="1" name="active"> 

                <% }

                %>

                <label class="form-check-label" for="exampleCheck1" >Produit valide</label>
            </div>
            <button type="submit" class="btn btn-primary">Modifier</button>
            <button type="button" class="btn btn-dark">Annuler</button>
        </form>
    </body>
    <!-- footer -->
    <jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
</html>
