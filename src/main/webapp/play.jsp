<%@page import="com.example.devoir_1.AuthenticationServlet"%>
<%@page import="java.util.ArrayList"%>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 20/03/2023
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.example.devoir_1.AuthenticationServlet"%>
<%@ page import="com.example.devoir_1.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>play</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous">
</head>
<body>
<form action="GameServlet" method="POST">
    <h4>entrer le numero du des a lancé , puis cliquer sur le bouton</h4>
    <label>Numéro du de:</label> <input type="number" name="numero"><br>

    <input type="submit" value="lancer le de">



</form>

</body>
</html>
