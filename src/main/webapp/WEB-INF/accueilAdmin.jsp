<%--
    Document   : accueilAdmin
    Created on : 20 mars 2024, 10:43:05
    Author     : Thaïs GENIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/css/admin.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/css/accueilAdmin.css"/>">
<header>
    <h1>RTL2: le meilleur de vos nouvelles</h1>
    <h2>Bienvenu Admin</h2>
    <a href="deconnexion">Se déconnecter</a>
    <nav>
        <ul>
            <li><a href="<c:url value="/adminNouvelles"/>">Liste des nouvelles</a></li>
            <li><a href="<c:url value="/adminInscrits"/>">Liste des inscrits</a></li>
                <%-- <li><a href="<c:url value="/adminListeCommentaires"/>">Liste des commentaires</a></li> --%>
        </ul>
    </nav>
    <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>
