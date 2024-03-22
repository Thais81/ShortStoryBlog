<%--
    Document   : adminListeNouvelles
    Created on : 19 mars 2024, 10:11:05
    Author     : Jopaups et Thaïs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/form.css"/>">
    <link rel="shortcut icon" href="<c:url value="/assets/img/logoLivre.png"/>" type="livre"/>

</head>
<header>
    <div>
        <img src="<c:url value="/assets/img/rtl2.png" />" width="200px" height="100px"  alt="logoRTL2">
        <h1> le meilleur de vos nouvelles</h1>
    </div>

    <nav>
        <ul>
            <li><a href="<c:url value="/accueilAdmin"/>">Accueil</a></li>
            <li><a href="<c:url value="/deconnexion"/>">Se déconnecter</a></li>
            <li><a href="<c:url value="/adminInscrits"/>">Liste des inscrits</a></li>
        </ul>
    </nav>
</header>
<body>
    <h2>Voici la liste nouvelles :</h2>

    <c:forEach var="nouvelle" items="${requestScope.nouvelles}">
        <fieldset>
            <legend><h3><c:out value="${nouvelle.id_Utilisateur.pseudo}"/></h3></legend>
            <div><c:out value="${nouvelle.titre}"/></div><br>
            <div><c:out value="${nouvelle.descriptif}"/></div><br>
            <div><c:out value="${nouvelle.contenu}"/></div><br>
            <button>supprimer nouvelle</button>
        </fieldset>
    </c:forEach>
</body>
<%@include file="/WEB-INF/jspf/footer.jspf" %>
</html>
