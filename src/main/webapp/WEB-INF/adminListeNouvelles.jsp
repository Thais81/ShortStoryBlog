<%-- 
    Document   : adminListeNouvelles
    Created on : 19 mars 2024, 10:11:05
    Author     : Jopaups et Thaïs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/css/admin.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/css/accueilAdmin.css"/>">
<%@include file="/WEB-INF/jspf/header.jspf" %>
<%--<header>
 <div>
        <h1><em>RTL2: le blog des nouvelles</em></h1>
        <nav>
            <ul>
                <li><a href="<c:url value="/accueilAdmin"/>">Accueil</a></li>
                <li><a href="<c:url value="/deconnexion"/>">Se déconnecter</a></li>
                <li><a href="<c:url value="/adminInscrits"/>">Liste des inscrit</a></li>
            </ul>
        </nav>
    </div>
</header>--%>
<body>
        <h2>Voici la liste nouvelles :</h2>

        <c:forEach var="nouvelle" items="${requestScope.nouvelles}">
            <fieldset>
                    <legend><h3><c:out value="${nouvelle.id_Utilisateur.pseudo}"/></h3></legend>
                    <div><c:out value="${nouvelle.titre}"/></div>
                    <div><c:out value="${nouvelle.descriptif}"/></div>
                    <div><c:out value="${nouvelle.contenu}"/></div>
                    <button>supprimer nouvelle</button>
                </fieldset>
        </c:forEach>
    </body>
    <%@include file="/WEB-INF/jspf/footer.jspf" %>
</html>
