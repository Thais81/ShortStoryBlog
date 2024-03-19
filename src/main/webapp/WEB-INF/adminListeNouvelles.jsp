<%--
    Document   : adminListeNouvelles
    Created on : 19 mars 2024, 10:11:05
    Author     : Jopaups
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouvelles</title>
    </head>
    <body>
        <h2>Voici la liste nouvelles :</h2>

        <c:forEach var="nouvelle" items="${requestScope.nouvelles}">
            <c:if test="${utilisateur.id_Utilisateur !=1}">
                <fieldset>
                    <legend><h3><c:out value="${nouvelle.pseudo}"/></h3></legend>
                    <div><c:out value="${nouvelle.pseudo}"/></div>
                    <div>Titre de la nouvelle : ${nouvelle.titre}</div><br>
                    <div><c:out value="Mot de passe de l'utilisateur : ${person.password}"/></div>
                </fieldset>
            </c:if>
        </c:forEach>
    </body>
</html>
