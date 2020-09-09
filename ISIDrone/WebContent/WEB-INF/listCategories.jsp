<%-- 
    Document   : listCategories
    Created on : Sep 9, 2020, 8:32:10 AM
    Author     : aouattar
--%>
<%@page import="util.Const"%>
<%@page import="entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<% ArrayList <Category> categories = (ArrayList<Category>) request.getAttribute("categories");%>
<!DOCTYPE html>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><strong>Liste des Catgeories</strong></h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-condensed">
                            <%
                                if (categories.size() > 0) {
                            %>
                            <thead>
                                <tr>
                                    <td><strong>Nom</strong></td>
                                    <td class="text-center"><strong>Ordre d'affichage</strong></td>
                                </tr>
                            </thead>
                            <%
                            } else {
                            %>
                            <span>Aucune categorie dans la base de donnes </span>
                            <%}%>
                            <%
                                for (Category cat : categories) {
                            %>
                            <tr>
                                <td><%=cat.getName()%></td>
                                <td class="text-center"><%=cat.getOrder()%></td>
                            </tr>

                            <%}%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
