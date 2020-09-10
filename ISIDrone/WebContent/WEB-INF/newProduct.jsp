<%-- 
    Document   : newProduct
    Created on : Sep 4, 2020, 12:25:23 PM
    Author     : samue


Champs necessaire a l'ajout de produits
Nom
Categorie
Description
Prix
Numero de série
Quantité en stock
Produit actif ou pas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Page d'ajout de nouveau(x) produit(s)</h1>

        <form>
            <label for="productName">Nom du produit: </label>
            <input type="text" id="fname" name="productName">
            <label for="productCategory">Catégorie du produit: </label>
            <input type="text" id="fname" name="productCategory">
            <label for="productDescription">Description du produit: </label>
            <input type="text" id="fname" name="productDescription">
            <label for="productPrice">Prix du produit: </label>
            <input type="text" id="fname" name="productPrice">
            <label for="productSerialNumber">Numéro de série du produit: </label>
            <input type="text" id="fname" name="productSerialNumber">
            <label for="productQuantityInStock">Quantité en stock: </label>
            <input type="text" id="fname" name="productQuantityInStock">
            <label for="isProductActive">Produit actif ou pas:</label>
            <input type="text" id="fname" name="isProductActive">
            <label for="">Image du produit:</label>
            <input type="text" id="fname" name="">

        </form>



    </body>
</html>
