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

@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext cntx = getServletContext();

        PrintWriter out = response.getWriter();

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String motdepasse = request.getParameter("motdepasse");

        ArrayList<User> users = (ArrayList<User>) cntx.getAttribute("listusers");

        if (users != null && !users.isEmpty()) {
            User foundUser = null;
            for (User it : users) {
                if (it.getMotdepassse().equals(motdepasse) && it.getPrenom().equals(prenom)&& it.getNom().equals(nom)) {
                    foundUser = it;
                    break;
                }
            }

            if (foundUser != null) {
                request.getSession().setAttribute("connecteduser", foundUser);
                request.getRequestDispatcher("play.jsp").forward(request, response);
                return;

            } else {
                out.print("Login ou mot de passe incorrects");

            }
        } else {
            out.print("Login ou mot de passe incorrects");
        }

    }

}
