<%-- 
    Document   : listProducts
    Created on : Sep 4, 2020, 10:31:17 AM
    Author     : rcorroch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="entities.ItemCart"%>
<%@page import="java.util.List"%>
<%@page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<%ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("listitems");%>
<!DOCTYPE html>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><strong>Liste des Produits</strong></h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-condensed">
                            <%
                                if (items.size() != 0) {
                            %>
                            <thead>
                                <tr>

                                    <td class="text-center"><strong>Nom</strong></td>
                                    <td class="text-center"><strong>Catégorie</strong></td>
                                    <td class="text-center"><strong>Quantité en stock</strong></td>
                                    <td class="text-center"><strong>Action</strong></td>
                                </tr>
                            </thead>
                            <%
                            } else {
                            %>
                            <span>Aucune item dans la base de donnes </span>
                            <%
                                }
                            %>
                            <%
                                int i = 0;
                                for (Item item : items) {
                                    i++;
                            %>

                            <tr>
                                <td style="hover"><%=item.getName()%></td>
                                <td class="text-center"><%=item.getCategory()%></td>
                                <td class="text-center"><%=item.getStock()%></td>
                                <td class="text-center"><a href="editProduct?item=<%=item.getId()%>">Modifier</a></td>
                            </tr>

                            <%
                                }
                            %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>