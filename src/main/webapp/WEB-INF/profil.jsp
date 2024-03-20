<%--
    Document   : connect
    Created on : 8 mars 2024, 14:10:22
    Author     : Caroline Bergé
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mon Profil</title>
        <link rel="stylesheet" href="<c:url value="/assets/css/form.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">


    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>


        <fieldset>
            <legend>Liste de mes nouvelles</legend>
            <div class="nouvelles">
                <div class="nouvelle">
                <h2>Voici la liste de mes nouvelles</h2>
            <c:forEach var="nouvelle" items = "${requestScope.nouvelles}">
                <h3>${nouvelle.titre}</h3>
                <h4>${nouvelle.descriptif}</h4>
                <div class="under">$Eacute;crit par ${nouvelle.id_Utilisateur.pseudo} le ${nouvelle.date_publication}</div>
                <div>${nouvelle.contenu}</div>
                 <div class="more"><a href="<c:url value="/nouvelle?id=${nouvelle.id}"/>"> En savoir +</a></div>

            </c:forEach>

        </fieldset>

    </body>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>

    </html>

