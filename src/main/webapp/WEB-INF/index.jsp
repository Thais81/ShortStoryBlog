<%-- Document : index Created on : 8 mars 2024, 14:04:52 Author : Herbert Caffarel --%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">
    </head>

    <body>        
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main>
            <h1>Bienvenue sur mon blog</h1>
            <h2>Voici la liste de tous les articles</h2>
            <c:forEach var="article" items="${requestScope.nouvelle}">
                <article>
                    <h3><c:out value="${nouvelle.title}" /></h3>
                    <div class="under">&Eacute;crit par <c:out value="${nouvelle.pseudo}" /> le ${nouvelle.created}</div>
                    <div><c:out value="${nouvelle.contenu}"/></div>
                    <div class="more"><a href="<c:url value="/article?id=${nouvelle.id}" />">En savoir plus</a></div>
                </article>
            </c:forEach>
        </main>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>

</html>