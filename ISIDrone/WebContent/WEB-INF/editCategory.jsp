<%-- 
    Document   : editCategory
    Created on : Sep 11, 2020, 8:19:54 AM
    Author     : samue
--%>

<%@page import="util.Const"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        
        --%>
        <form action="editProduct" method="post">
        <div class="form-group">
            <label for="productName">Nom</label>
            <input type="text" class="form-control" id="productName" name="productName" value="<%=item.getName()%>"  maxlength = "100"s required>
        </div>
        <input type="hidden" name="idProduct" value="<%=item.getId()%>">



        <div class="form-group">
            <label for="exampleFormControlInput1">Categorie</label>
            <select class="form-control"  name="productCat" required>
                <option value="1"  <%= (item.getCategory() == 2 ? "selected" : "")%>>Avec Camera</option>
                <option value="2" <%= (item.getCategory() == 3 ? "selected" : "")%>>Recreatif</option>
                <option value="3" <%= (item.getCategory() == 4 ? "selected" : "")%>>Performance</option>
                <option value="4" <%= (item.getCategory() == 5 ? "selected" : "")%>>Materiaux</option>
            </select>
        </div>

        <div class="form-group">
            <label for="descProduct">Description </label>
            <textarea class="form-control" id="descProduct" rows="3" name="descProduct" maxlength = "200"  required> <%=item.getDescription()%></textarea>
        </div>
        <div class="form-group">
            <label for="priceProduct">Prix</label>
            <input type="number" class="form-control" id="priceProduct" name="priceProduct" value="<%=item.getPrice()%>" min="1" max="1000000"  step=0.01  required>
        </div>
        <div class="form-group">
            <label for="serialProduct">Numero de série</label>
            <input type="text" class="form-control" id="serialProduct" name="serialProduct"  value="<%=item.getSerial()%>" maxlength = "30"  required>
        </div>
        <div class="form-group">
            <label for="qteProduct">Quantité en stock</label>
            <input type="text" class="form-control" id="qteProduct"  name="qteProduct" value="<%=item.getStock()%>" maxlength = "7"  required>
        </div>
         <div class="form-group form-check">
    
    <%
    if (item.isActive()) {%>
        <input type='hidden' value="0" name="active">

        <input type="checkbox" class="form-check-input" id="exampleCheck1" value="2" checked name="test">

       
   <% } 
    else  {%>
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
