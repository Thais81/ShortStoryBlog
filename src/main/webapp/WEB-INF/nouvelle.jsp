<%--
    Document   : nouvelle
    Created on : 19 mars 2024, 13:21:41
    Author     : kevinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouvelle</title>
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">
        <link rel="shortcut icon" href="<c:url value="/assets/img/logoLivre.png"/>" type="livre"/>

    </head>

    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main>
            <div class="article">
                <h1><c:out value="${nouvelle.titre}"/></h1>
                <h2><c:out value="${nouvelle.descriptif}"/></h2>

                <div><c:out value="${nouvelle.contenu}"/></div><br>
                <div>Écrit par <c:out value="${nouvelle.id_Utilisateur.pseudo}"/> le ${nouvelle.date_publication}</div>
            </div><br>
            <c:if test="${sessionScope.user != null}">
                <div>
                    <form action="vote" method="post">
                        <input type="hidden" name="id_Nouvelle" value="${nouvelle.id_Nouvelle}">
                        <button type="submit" name="qualite" value="positif">Pouce en l'air</button>
                        <button type="submit" name="qualite" value="negatif">Pouce en bas</button>
                    </form>
                </div>

            </c:if>


            <div>${param.msg}</div><br>
            <div>${requestScope.errors.contenu}</div><br>

            <c:if test="${sessionScope.user != null}">
                <form action="nouvelle.jsp" method="post">

                    <div class="error">${requestScope.errors.contenu}</div>

                    <div>
                        <form action="<c:url value="/nouvelle?id=${requestScope.nouvelle.id_Nouvelle}"/>" method="post">
                            <input type="hidden" name="id_nouvelle" value="${nouvelle.id_Nouvelle}">
                            <label for="commentaire">Ajouter un commentaire :</label><br>
                            <textarea id="contenu" name="contenu" rows="4" cols="50"></textarea><br>
                            <input type="submit" value="Envoyer">
                            <input type="reset" value="Annuler" onclick="history.back()">
                        </form>
                    </div>

                </c:if>


                <h2>Liste des commentaires</h2>
                <c:forEach var="commentaire" items="${requestScope.commentaires}">
                    <input type="hidden" name="id_nouvelle" value="${nouvelle.id_Nouvelle}">
                    <article>
                        <div class="under">Écrit par ${commentaire.id_Utilisateur.pseudo} le ${commentaire.date_publication}</div><br>
                        <div>${commentaire.contenu}</div><br>
                        <button>signaler</button>
                    </article>
                </c:forEach>


        </main>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>

</html>
