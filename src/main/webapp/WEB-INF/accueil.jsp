<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/form.css"/>">
        <link rel="shortcut icon" href="<c:url value="/assets/img/logoLivre.png"/>" type="livre"/>

    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main>
            <div class="rock">
                <img src="<c:url value="/assets/img/rock.png"/>" width="70px" height="100px">
                <h1 class="titre">LE BLOG DES HISTOIRES POP-ROCK</h1>
                <img src="<c:url value="/assets/img/rock.png"/>" width="70px" height="100px">
            </div>


            <h2>Les dix dernières nouvelles à la une:</h2>
            <c:forEach var="nouvelle" items="${requestScope.nouvelles}">
                <fieldset>
                    <legend> <h3><c:out value="${nouvelle.titre}"/></h3></legend>
                    <h4> Écrit par <c:out value="${nouvelle.utilisateur.pseudo}"/>
                        le <c:out value="${nouvelle.date_publication}"/></h4>
                    <div><c:out value="${nouvelle.descriptif}"/></div>
                    <div><a href="<c:url value="/nouvelle?id=${nouvelle.id_Nouvelle}"/>">Plus...</a></div>
                    <p><c:out value="${nouvelle.contenu}"/></p>
                </fieldset>
            </main>
        </c:forEach>

        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
