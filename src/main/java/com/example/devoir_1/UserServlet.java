package com.example.devoir_1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext cntx = getServletContext();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if (action != null && action.equals("list")) {

            ArrayList<User> list = (ArrayList<User>) cntx.getAttribute("listusers");
            if (list != null) {
                request.setAttribute("listUsers", list);
                request.getRequestDispatcher("listUsers.jsp").forward(request, response);
                return;

            }

        } else if (action != null && action.equals("create")) {

            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String motdepasse = request.getParameter("motdepasse");
            if (nom == null || prenom == null || motdepasse == null) {
                out.println(" vous devez remplire tous les champs , pour creer un compte!");
                return;
            } else if (nom.isEmpty() || prenom.isEmpty() || motdepasse.isEmpty()) {
                out.println(" vous devez remplire tous les champs , pour creer un compte!");
                return;
            } else {
                ArrayList<User> list;
                if (cntx.getAttribute("listusers") == null) {
                    list = new ArrayList<>();
                    cntx.setAttribute("listusers", list);
                } else if(cntx.getAttribute("listusers") != null){
                    System.out.println("je verifie dans la boucle");

                    list = (ArrayList<User>) cntx.getAttribute("listusers");
                    for (User it : list) {

                        if (nom.equals(it.getNom()) && prenom.equals(it.getPrenom())) {
                            out.println("le nom et le prenom que vous venez d entrer sont deja utilise , merci de changer " +
                                    ", ( vous pouvez ajouter votre annee de naissance a cote du prenom si vous voulez)");
                            return;
                        }


                    }}
                    User user = new User();
                    user.setNom(nom);
                    user.setPrenom(prenom);
                    user.setMotdepassse(motdepasse);
                    list = (ArrayList<User>) cntx.getAttribute("listusers");
                    list.add(user);
                    out.println(nom + " " + prenom + " , votre compte est cree avec succee!");
                    System.out.println("l utilisateur " + prenom + " est cree avec succes");
                    out.println("<a href=\"index.jsp\"> page d acceuil </a>");
                }
            }
        }

    }

