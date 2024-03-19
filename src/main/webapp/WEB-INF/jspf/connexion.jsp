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
        <title>Connexion</title>
        <link rel="stylesheet" href="<c:url value="assets/css/form.css"/>">
        <link rel="stylesheet" href="<c:url value="assets/css/style.css"/>">


    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>

        <h1>Veuillez entrer vos paramètres de connexion</h1>
        <div>${requestScope.errorMsg}</div>

        <form action="connect" method="POST">
            <fieldset>
                <legend>Informations de connexion</legend>
                <div>
                    <label for="login">Login</label>
                    <input id="login" name="login" type="text" value="${requestScope.bean.login}">
                    <span class="error">${requestScope.errors.login}</span>
                </div>
                <div>
                    <label for="password">Password</label>
                    <input id="password" name="password" type="password">
                    <span class="error">${requestScope.errors.password}</span>
                </div>
            </fieldset>

            <div>
                <input type="submit" value="Envoyer">
                <input type="reset" value="Annuler">
            </div>
            <div class="content">
                <img src="assets/img/canyon.jpg" alt="canyon">
            </div>
        </form>
    </body>
    <%@include file="/WEB-INF/jspf/footer.jspf" %>

</html>
