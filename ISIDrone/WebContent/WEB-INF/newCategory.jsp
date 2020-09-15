<%-- 
    Document   : newCategory
    Created on : Sep. 10, 2020, 12:37:01 a.m.
    Author     : ybenhail
--%>

<%@page import="util.Misc"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<%
    @SuppressWarnings(  "unchecked")
    HashMap<String, String> hm_formParamValue = (HashMap<String, String>) request.getAttribute("hm_formParamValue");
    @SuppressWarnings(  "unchecked")
    HashMap<String, String> hm_fieldErrorMsg = (HashMap<String, String>) request.getAttribute("hm_fieldErrorMsg");
    //
    String nameCategorieVal = (String)request.getAttribute("name");
    String descriptionCategorieVal = (String)request.getAttribute("description");
    //int positionVal = (int)request.getAttribute("position");
    //
    String error = (String) request.getAttribute("error");
%>
<!-- Page Content -->
<div class="container">

    <%
        if (error != null) {
            if (error.equals("accountExisting")) {
    %>
    <div class="alert alert-info">
        Il existe  deja une categorie  avec ce nom
    </div>
    <%
    } else if (error.equals("DBProblem")) {
    %>
    <div class="alert alert-danger">
        Une erreur de connexion c'est produite. Veuillez attendre quelques temps avant de faire une nouvelle tentative.
        Si vous voyez ce message pour la deuxième fois, veuillez contactez l'administrateur du site pour lui informer du
        problème.
    </div>
    <%
            }
        }
    %>

    <form action="newCategory" method="post" class="panel panel-primary form-horizontal" style="float: unset; margin: auto;">
        <div class="panel-heading">
            <h3 class="panel-title">Ajouter une nouvelle categorie</h3>
        </div>
        <div class="panel-body">
            <fieldset class="col-sm-6 col-lg-6 col-md-6">
                <legend>Information Categorie</legend>
                <%
                    if (hm_fieldErrorMsg != null && hm_fieldErrorMsg.containsKey("lastName")) {
                %>
                <div class="alert alert-warning" style="margin-bottom: 0px; white-space: pre-line;"><%=hm_fieldErrorMsg.get("lastName")%></div>
                <%
                    }
                %>
                <div class="form-group">
                    <div class="col-sm-10">
                        <label for="nameCat" class="control-label">*Nom categorie</label>
                        <input type="text" id="nameCat" class="form-control" name="nameCat" required value=<%=nameCategorieVal == null ? "" : nameCategorieVal %>  />
                        
                    </div>
                </div>
                <%
                    if (hm_fieldErrorMsg != null && hm_fieldErrorMsg.containsKey("firstName")) {
                %>
                <div class="alert alert-warning" style="margin-bottom: 0px; white-space: pre-line;"><%=hm_fieldErrorMsg.get("firstName")%></div>
                <%
                    }
                %>
                <div class="form-group">
                    <div class="col-sm-10">
                        <label for="descCat" class="control-label">*Description </label>
                        <textarea type="text" id="descCat" class="form-control" name="descCat"  required value=<%=descriptionCategorieVal == null ? "" : descriptionCategorieVal %>></textarea>
                    </div>
                </div>
                <%
                    if (hm_fieldErrorMsg != null && hm_fieldErrorMsg.containsKey("email")) {
                %>
                <div class="alert alert-warning" style="margin-bottom: 0px; white-space: pre-line;"><%=hm_fieldErrorMsg.get("email")%></div>
                <%
                    }
                %>
                <div class="form-group">	
                    <div class="col-sm-10">
                        <label for="email" class="control-label">*Position</label>
                        <input type="number" min="1"  class="form-control" name="position"  required/>
                    </div>
                </div>
                <%
                    if (hm_fieldErrorMsg != null && hm_fieldErrorMsg.containsKey("confirmEmail")) {
                %>
                <div class="alert alert-warning" style="margin-bottom: 0px; white-space: pre-line;"><%=hm_fieldErrorMsg.get("confirmEmail")%></div>
                <%
                    }
                %>
                <div class="form-group">	
                    <div class="col-sm-10">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1" value="1" name="active"> 

                        <label for="exampleCheck1" class="control-label" style="padding-top: 0px;">Activer la categorie</label>
                    </div>
                </div>
                <%
                    if (hm_fieldErrorMsg != null && hm_fieldErrorMsg.containsKey("password")) {
                %>
                <div class="alert alert-warning" style="margin-bottom: 0px; white-space: pre-line;"><%=hm_fieldErrorMsg.get("password")%></div>
                <%
                    }
                %>


            </fieldset>

            <%
                if (request.getParameter("fromCart") != null) {
            %>
            <input type="hidden" name="fromCart" value="true">
            <%
                }
            %>
            <div class="form-group text-center" style="clear: left; top: 15px; margin-bottom: 15px;">
                <button type="submit" class="btn btn-default">Ajouter</button>
            </div>
        </div>
    </form>
</div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
