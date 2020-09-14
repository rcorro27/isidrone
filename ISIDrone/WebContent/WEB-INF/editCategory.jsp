<%-- 
    Document   : editCategory
    Created on : Sep 11, 2020, 8:19:54 AM
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <form>
            <label for="categoryName">Nom de la catégorie:</label>
            <input type="text" id="categoryName" name="categoryName">
            <label for="categoryDescription">Description de la catégorie:</label>
            <input type="text" id="categoryDescription" name="categoryDescription">
            <label for="categoryPosition">Position de la catégorie:</label>
            <input type="text" id="categoryPosition" name="categoryPosition">
            <label for="categoryActiveStatus">Catégorie active ou pas:</label>
            <input type="text" id="categoryActiveStatus" name="categoryActiveStatus">
            <input type="submit">
        </form>
    </body>
</html>
