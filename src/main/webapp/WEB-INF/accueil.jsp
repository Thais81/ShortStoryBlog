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



            <div>
                <h2>Les dix dernières nouvelles:</h2>
                <c:forEach var="nouvelle" items="${requestScope.nouvelles}">
                    <article>
                        <h3><c:out value="${nouvelle.titre}"/></h3>
                        <h4><c:out value="${nouvelle.descriptif}"/></h4>
                        <div><c:out value="${nouvelle.contenu}"/></div>

                        <div>&Eacute;crit par <c:out value="${nouvelle.id_Utilisateur.pseudo}"/>
                            le <c:out value="${nouvelle.date_publication}"/></div>
                        <div><a href="<c:url value="/nouvelle?id=${nouvelle.id_Nouvelle}"/>">Plus...</a></div>
                        <a href="detailNouvelle.jsp?id=${nouvelle.id}"></a>
                        <c:choose>
                            <c:when test="${nouvelle.score == 0.0}">
                                Aucun vote
                            </c:when>
                            <c:otherwise>
                                (<c:out value="${nouvelle.score}"/> % de like)
                            </c:otherwise>
                        </c:choose>


                    </article>


                    <div>
                        </main>
                    </c:forEach>
                    <%@include file="/WEB-INF/jspf/footer.jspf" %>
                    </body>
                    </html>
