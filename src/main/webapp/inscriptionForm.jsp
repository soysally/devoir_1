<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 20/03/2023
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>inscription</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<form action="UserServlet" method="POST">
    <input type="hidden"  name="action" value="create">
    <label >Nom:</label> <input type="text"  name="nom"><br>
    <label >prenom:</label> <input type="text"  name="prenom"><br>
    <label >motdepasse:</label> <input type="password"  name="motdepasse"><br>
    <input type="submit" value="creer">



</form>
</body>
</html>
