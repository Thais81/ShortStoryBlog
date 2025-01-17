<%--
    Document   : adminCommentaires
    Created on : 19 mars 2024, 15:39:51
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

        <title>Admin Comm</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <h2>Voici la liste des commentaires</h2>

        <c:forEach var="commentaire" items="${requestScope.commentaires}">
            <c:if test="${commentaires.etat == signale}">
                <fieldset>
                    <legend><h3><c:out value="${utilisateur.pseudo}"/></h3></legend>
                    <div>
                        <c:out value="${commentaire.contenu}"/>
                        <%-- ici fonctionnalités secondaires,
                        pas prioritaires
                        <input type="submit" value="Supprimer">
                        <input type="submit" value="Valider">
                        <input type="submit" value="Plus">--%>
                    </div>
                </fieldset>
            </c:if>
        </c:forEach>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
