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
                                <td class="text-center">
                                    <button class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal_<%=cat.getId()%>">Supprimer</button>
                                    <div id="myModal_<%=cat.getId()%>" class="modal fade" role="dialog">
                                        <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h1 class="modal-title">ATTENTION </h1>
                                                </div>
                                                <div class="modal-body">
                                                    <h2>Est vous sure de vouloir supprimer cette categorie ?</h2>
                                                </div>
                                                <div class="modal-footer">


                                                    <a href="listCategories?idCategoryToDelete=<%=cat.getId()%>" class="btn btn-success" >oui</a> <!--class="btn btn-success" data-dismiss="modal">oui</a>-->
                                                    <a href="listCategories" class="btn btn-danger" >non </a>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </td>
                                
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
