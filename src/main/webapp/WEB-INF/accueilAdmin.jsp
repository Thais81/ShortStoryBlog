<%--
    Document   : accueilAdmin
    Created on : 20 mars 2024, 10:43:05
    Author     : Thaïs GENIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<link rel="stylesheet" href="<c:url value="/assets/CSS/style.css"/>">
<link rel="shortcut icon" href="<c:url value="/assets/img/logoLivre.png"/>" type="livre"/>

<header>
    <h1>RTL2: le meilleur de vos nouvelles</h1>
    <h2>Bienvenue Admin</h2>
    <a href="deconnexion">Se déconnecter</a>

    <nav>
        <ul>
            <li><a href="<c:url value="/adminListeNouvelles"/>">Liste des nouvelles</a></li>
            <li><a href="<c:url value="/adminListeIsncrits"/>">Liste des iscrits</a></li>
            <li><a href="<c:url value="/adminListeCommentaires"/>">Liste des commentaires</a></li>

        </ul>
    </nav>

    <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>
