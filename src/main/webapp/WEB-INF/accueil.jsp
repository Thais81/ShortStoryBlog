<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value="assets/css/style.css"/>">
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main>
            <h1>Accueil</h1>
            <div>
                <h2>Les dix dernières nouvelles:</h2>
                <c:forEach var="nouvelle" items="${requestScope.nouvelles}">
                    <article>
                        <h3><c:out value="${nouvelle.titre}"/></h3>
                        <div>&Eacute; écrit par <c:out value="${nouvelle.id_Utilisateur.pseudo}"/>
                            le <c:out value="${nouvelle.date_publication}"/></div>
                        <div><c:out value="${nouvelle.contenu}"/></div>
                        <div><a href="<c:url value="/nouvelle?id=${nouvelle.id_Nouvelle}"/>">Plus...</a></div>

                        <p><c:out value="${nouvelle.contenu}"/></p>
                    </article>
                </div>
                    <div>
                </main>
                </c:forEach>
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
                </body>
                </html>
