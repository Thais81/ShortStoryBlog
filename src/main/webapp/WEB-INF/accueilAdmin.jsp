<%--
    Document   : accueilAdmin
    Created on : 20 mars 2024, 10:43:05
    Author     : Thaïs GENIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
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
                <li><a href="<c:url value="/deconnexion"/>">Se déconnecter</a></li>
                <li><a href="<c:url value="/adminNouvelles"/>">Liste des nouvelles</a></li>
                <li><a href="<c:url value="/adminInscrits"/>">Liste des inscrits</a></li>
                    <%-- <li><a href="<c:url value="/adminListeCommentaires"/>">Liste des commentaires</a></li> --%>
            </ul>
        </nav>
    </header>
    <body>
        <div class="rock">
            <img src="<c:url value="/assets/img/rock.png"/>" width="70px" height="100px">
            <h1 class="titre">Bienvenue dans ton antre Oh! Admin tout puissant!</h1>
            <img src="<c:url value="/assets/img/rock.png"/>" width="70px" height="100px">
        </div>

        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
