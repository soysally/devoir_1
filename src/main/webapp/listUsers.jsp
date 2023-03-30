<%@page import="com.example.devoir_1.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>


<table class="table">
  <%

    ArrayList<User> users = (ArrayList<User>) request.getAttribute("listUsers");
    for(User it : users){
      PrintWriter o = response.getWriter();

      o.print("<tr>");
      o.print("<td>");
      o.print(it.getPrenom());
      o.print("</td>");
      o.print("<td>");
      o.print(it.getBestscore());
      o.print("</td>");
      o.print("</tr>");
    }

  %>
</table>


</body>
</html>