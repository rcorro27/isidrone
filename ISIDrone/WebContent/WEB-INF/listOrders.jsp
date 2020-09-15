<%-- 
    Document   : listOrders
    Created on : Sep. 15, 2020, 8:36:24 a.m.
    Author     : ybenhail
--%>

<%@page import="entities.Item"%>
<%@page import="util.Const"%>
<%@page import="entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<% ArrayList<entities.OrderByUserName> orders = (ArrayList<entities.OrderByUserName>) request.getAttribute("orders");


%>
<!DOCTYPE html>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><strong>Liste des commandes</strong></h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-condensed">
                            <%                                if (orders.size() > 0) {
                            %>
                            <thead>
                                <tr>
                                    <td><strong>Nom</strong></td>
                                    <td class="text-center"><strong>Date commande </strong></td>
                                    <td class="text-center"><strong>Suppression </strong></td>
                                    <td class="text-center"><strong>Etat Livraison  </strong></td>
                                </tr>
                            </thead>
                            <%
                            } else {
                            %>
                            <span>Aucune commandes dans la base de donnes </span>
                            <%}%>
                            <%
                                for (entities.OrderByUserName order : orders) {
                            %>
                            <tr>
                                <td><%=order.getNameUser()%></td>
                                <td class="text-center"><%=order.getDateOrder()%></td>
                                <td class="text-center">
                                    <button class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal_<%=order.getId()%>" <%=(order.getIsShipped() == 1 ? "disabled" : "")%>>Supprimer</button>
                                    <div id="myModal_<%=order.getId()%>" class="modal fade" role="dialog">
                                        <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h1 class="modal-title">ATTENTION </h1>
                                                </div>
                                                <div class="modal-body">
                                                    <h2>Est vous sure de vouloir supprimer cette Commande ?</h2>
                                                </div>
                                                <div class="modal-footer">


                                                    <a href="listOrders?order=<%=order.getId()%>&effacer=true" class="btn btn-success" >oui</a> <!--class="btn btn-success" data-dismiss="modal">oui</a>-->
                                                    <a href="listOrders?effacer=false" class="btn btn-danger" >non </a>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </td>


                                <td class="text-center">
                                    <button class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal_<%=order.getId()%>">
                                        <%if (order.getIsShipped() == 1) {%>En cours d expedition <% } else {%>Expedier <%}%></button>
                                    <div id="myModal_<%=order.getId()%>" class="modal fade" role="dialog">
                                        <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h1 class="modal-title">ATTENTION </h1>
                                                </div>
                                                <div class="modal-body">
                                                    <h2>Est vous sure de vouloir supprimer cette Order ?</h2>
                                                </div>
                                                <div class="modal-footer">


                                                    <a href="items?category=<%=order.getId()%>&effacer=true" class="btn btn-success" >oui</a> <!--class="btn btn-success" data-dismiss="modal">oui</a>-->
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
