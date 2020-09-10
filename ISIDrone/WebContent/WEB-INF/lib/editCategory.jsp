<%-- 
    Document   : editCategory
    Created on : Sep 10, 2020, 8:20:39 AM
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier une catégorie</title>
    </head>
    <body>
        <h1>Edit Category</h1>
        My parameter <b><%= request.getParameter("category_id")%></b>

        <%--
        Parametre modifiable 
        Nom du produit
        Description du produit
        Position du produit
        Produit actif ou non
        --%>
        <form>
            <label for="catName">Nom de la catégorie</label>
            <input type="text" id="catName" name="catName">
            <label for="descCat">Description de la catégorie:</label>
            <input type="text" id="descCat" name="descCat">
            <label for="posCat">Position de la catégorie:</label>
            <input type="text" id="posCat" name="posCat">
            <label for="activeOrNotCat">Catégorie active ou non:</label>
            <input type="text" id="activeOrNotCat" name="activeOrNotCat">
        </form>
        
    </body>
</html>
