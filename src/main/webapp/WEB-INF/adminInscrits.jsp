<%--
    Document   : adminListeUtilisateurs
    Created on : 19 mars 2024, 14:58:05
    Author     : Amelie Solanas Pruvost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="assets/css/style.css"/>">
        <link rel="shortcut icon" href="<c:url value="/assets/img/logoLivre.png"/>" type="livre"/>

        <title>Admin Inscrits</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <h2>Voici la liste des utilisateurs</h2>

        <c:forEach var="utilisateur" items="${requestScope.utilisateurs}">
            <c:if test="${utilisateur.id_Utilisateur !=1}">
                <fieldset>
                    <legend><h3><c:out value="${utilisateur.pseudo}"/></h3></legend>
                    <div>
                        <input type="submit" value="Supprimer">
                        <input type="submit" value="Désactiver">
                        <input type="submit" value="Réactiver">
                    </div>
                </fieldset>
            </c:if>
        </c:forEach>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
