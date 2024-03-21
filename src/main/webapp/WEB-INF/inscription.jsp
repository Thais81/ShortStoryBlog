<%--
    Document   : connect
    Created on : 8 mars 2024, 14:10:22
    Author     : Caroline Bergé
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <link rel="stylesheet" href="<c:url value="assets/css/form.css"/>">
        <link rel="stylesheet" href="<c:url value="assets/css/style.css"/>">


    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>

        <h2>Veuillez entrer vos informations pour l'inscription</h2>
        <h2>Entre dans la secte, misérable insecte!</h2>
        <div>${requestScope.errorMsg}</div>

        <form action="inscription" method="POST">
            <fieldset>
                <legend>Informations d'inscription</legend>
                <legend>Par ici les infos --></legend>
                <div>

                    <label for="pseudo">Pseudo</label>
                    <input id="pseudo" name="pseudo" type="text" value="${requestScope.bean.pseudo}"><br>
                    <span class="error">${requestScope.errors.pseudo}</span>
                </div>
                <div>
                    <label for="password">Password</label>
                    <input id="mot_de_passe" name="mot_de_passe" type="password">
                    <span class="error">${requestScope.errors.mot_de_passe}</span>
                </div>
                <div>
                    <label for="verif">Vérification</label>
                    <input id="verif" name="verif" type="password">
                    <span class="error">${requestScope.errors.verif}</span>
                </div>
            </fieldset>
            <div>
                <input type="submit" value="Envoyer">
                <input type="reset" value="Annuler">
            </div>
        </form>

    </body>
    <%@include file="/WEB-INF/jspf/footer.jspf" %>

</html>
