<%--
    Document   : erreur404
    Created on : 19 mars 2024, 10:29:17
    Author     : Amelie Solanas Pruvost
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERREUR 404</title>
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">
        <style>
            :root {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>Erreur 404!</h1>
        <div>
            <<img src="<c:url value="/assets/img/erreur404.jpg" />" alt="VincentVega"/>
        </div>
        <<h2>Vous vous êtes perdus semble-t-il...</h2>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
