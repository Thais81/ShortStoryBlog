<%--
    Document   : options
    Created on : 19 mars 2024, 11:28:13
    Author     : Amelie Solanas Pruvost
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Options</title>
        <link rel="stylesheet" href="<c:url value="/assets/css/form.css" />">
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">
        <link rel="shortcut icon" href="<c:url value="/assets/img/logoLivre.png"/>" type="livre"/>


    </head>
    <body>

        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <h1 class="titre">Que voulez-vous faire?</h1>
        <section>
            <div class="ok">${requestScope.change}</div>

            <form action="<c:url value="/profil/options" />" method="post">
                <fieldset>
                    <legend>Changer de mot de passe</legend>
                    <div>
                        <label for="mdp">Mot de passe actuel</label>
                        <input type="password" id="mdp" name="mdp">
                        <div class="error">${requestScope.errors.mot_de_passe}</div>
                    </div>
                    <div>
                        <label for="next">Nouveau mot de passe</label>
                        <input type="password" id="next" name="next">
                        <div class="error">${requestScope.errors.next}</div>
                    </div>
                    <div>
                        <label for="verif">Confirmation</label>
                        <input type="password" id="verif" name="verif">
                        <div class="error">${requestScope.errors.verif}</div>
                    </div>
                </fieldset>
                <div class="buttons">
                    <input type="submit" value="Envoyer">
                    <input type="reset" value="Annuler">
                </div>
            </form>
            <fieldset>
                <legend>Bye Bye!</legend>
                <form class='byebye'>
                    <div> Veux-tu vraiment nous quitter? </div>
                    <div><a> <input type="submit" value='Oui je le veux' href="<c:url value="/profil/suppcompte?id=${sessionScope.user.id}"/>"></a></div>
                </form>
            </fieldset>

        </section>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

