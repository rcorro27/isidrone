<%-- 
    Document   : listProducts
    Created on : Sep 4, 2020, 10:31:17 AM
    Author     : rcorroch
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Item"%>
<%@page import="manager.MCategory" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="entities.ItemCart"%>
<%@page import="java.util.List"%>
<%@page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<%ArrayList<User> users = (ArrayList<User>) request.getAttribute("listusers");%>
<!DOCTYPE html>

<div class="container">
    <div>
        <h3>Desirez vous rechercher un utilisateur ?? </h3>
    </div>
    <div class="row">
        <form class="navbar-form" action="ListUsers?">
            <div id="auto-search" class="form-group"  style="padding-right:0;">
                <input class="form-control biginput" id="autocomplet" placeholder="Rechercher utilisateur" type="text" name="search" autocomplete="off">
            </div>
            <button type="submit" class="btn btn-info">Rechercher</button>
        </form>

        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><strong>Liste des Utilisateurs</strong></h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-condensed">
                            <%
                                if (users != null && users.size() != 0) {
                            %>
                            <thead>
                                <tr>

                                    <td class="text-center"><strong>Nom</strong></td>
                                    <td class="text-center"><strong>Prénom</strong></td>
                                    <td class="text-center"><strong>Email</strong></td>
                                    <td class="text-center"><strong>Action</strong></td>
                                </tr>
                            </thead>
                            <%
                            } else {
                            %>
                            <span>Aucune utilisateurs dans la base de donnes </span>
                            <%
                                }
                            %>
                            <%
                                int i = 0;
                                for (User user : users) {
                                    i++;
                            %>

                            <tr>
                                <td style="hover"><%=user.getLastName()%></td>
                                <td class="text-center"><%=user.getFirstName()%></td>
                                <td class="text-center"><%=user.getEmail()%></td>
                                <td><a href="ListUsers?modifierUser=true&userId=<%=user.getId()%>" class="btn btn-info" >modifier</a></td>
                            <td class="text-center">
                                <button class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal_<%=user.getId()%>">future action</button>
                                <div id="myModal_<%=user.getId()%>" class="modal fade" role="dialog">
                                    <div class="modal-dialog">
                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h1 class="modal-title">ATTENTION </h1>
                                            </div>
                                            <div class="modal-body">
                                                <h2>Future texte a mettre :)  </h2>
                                            </div>
                                            <div class="modal-footer">


                                                <a href="ListUsers?afficherTout=true" class="btn btn-success" >oui</a> <!--class="btn btn-success" data-dismiss="modal">oui</a>-->
                                                <a href="ListUsers?afficherTout=true" class="btn btn-danger" >non </a>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </td>
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
    <a class="btn btn-info" href="ListUsers?afficherTout=true">Afficher tout les  utilisateurs</a>

</div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>