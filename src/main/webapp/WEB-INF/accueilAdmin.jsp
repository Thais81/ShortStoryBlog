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
    <body>
        <div>
            <img src="<c:url value="/assets/img/rtl2.png" />" width="200px" height="100px"  alt="clavier">
            <h1> le meilleur de vos nouvelles</h1>
        </div>

        <link rel="shortcut icon" href="<c:url value="/assets/img/logoLivre.png"/>" type="livre"/>


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
