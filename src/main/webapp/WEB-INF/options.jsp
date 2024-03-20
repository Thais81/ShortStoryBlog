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

    </head>
    <body>
        <h1>Que voulez-vous faire?</h1>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <section>
            <div class="ok">${requestScope.change}</div>
            <h3>Changer de mot de passe</h3>
            <form action="<c:url value="/profil/options" />" method="post">
                <fieldset>
                    <legend>Modifications</legend>
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
                        <label for="verif">Vérification</label>
                        <input type="password" id="verif" name="verif">
                        <div class="error">${requestScope.errors.verif}</div>
                    </div>
                </fieldset>
                <div class="buttons">
                    <input type="submit" value="Envoyer">
                    <input type="reset" value="Annuler">
                </div>
            </form>

            <h3>Voulez-vous vraiment supprimer votre compte?</h3>
            <a href="<c:url value="/profil/suppCompte?id=${sessionScope.user.id}"/>">Oui je le veux</a>
        </section>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

