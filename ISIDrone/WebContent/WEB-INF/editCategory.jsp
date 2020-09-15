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
        <div class="form-group">
            <form>
                <label for="categoryName">Nom de la catégorie:</label>
                <input type="text" id="categoryName" name="categoryName"><br>
                <label for="categoryDescription">Description de la catégorie:</label>
                <input type="text" id="categoryDescription" name="categoryDescription"><br>
                <label for="categoryPosition">Position de la catégorie:</label>
                <input type="text" id="categoryPosition" name="categoryPosition"><br>
                <label for="categoryActiveStatus">Catégorie active ou pas:</label>
                <input type="text" id="categoryActiveStatus" name="categoryActiveStatus"><br>
                <input type="submit">
            </form>
        </div>
    </body>
    <!-- footer -->
    <jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
</html>
