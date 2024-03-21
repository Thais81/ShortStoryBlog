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
<header>
    <div>
        <div>
            <img src="<c:url value="/assets/img/rtl2.png" />" width="200px" height="100px"  alt="clavier">
            <h1> le meilleur de vos nouvelles</h1>
        </div>

        <link rel="shortcut icon" href="<c:url value="/assets/img/logoLivre.png"/>" type="livre"/>
        <nav>
            <ul>
                <li><a href="<c:url value="/accueilAdmin"/>">Accueil</a></li>
                <li><a href="<c:url value="/deconnexion"/>">Se déconnecter</a></li>
                <li><a href="<c:url value="/adminNouvelles"/>">Liste des nouvelles</a></li>
            </ul>
        </nav>
    </div>
</header>
<body>
    <h2>Voici la liste utilisateurs :</h2>

<c:forEach var="user" items="${requestScope.users}">
    <c:if test="${user.id !=1}">
        <fieldset>
            <legend><h3><c:out value="${user.pseudo}"/></h3></legend>
            <button>supprimer utilisateur</button>
            <button>désactiver/réactiver utlisateur</button>
        </fieldset>
    </c:if>
</c:forEach>
</body>
<%@include file="/WEB-INF/jspf/footer.jspf" %>
</html>
