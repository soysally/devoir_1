package com.example.devoir_1;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession();
        User user = (User) s.getAttribute("connecteduser");
        Random rd = new Random();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int score = -2;
        int numero = Integer.parseInt(request.getParameter("numero"));
        if (numero != 1 && numero != 2 && numero != 3 ) {
            out.println("<h3>les des a choisir sont numerote de 1 a 3 , merci d enter un nombre correcte!</h3>");
        }else {
        if (user != null) {
                if(s.getAttribute("listdesresult")!= null) {
                    HashMap<Integer, Integer> dictionnaire = (HashMap<Integer, Integer>) s.getAttribute("listdesresult");
                    for (int cle : dictionnaire.keySet()) {
                        if (cle == numero ) {
                            score = -1;
                            break;
                        }
                    }
                    int resultat = 1 + rd.nextInt(6);
                    for (int cle : dictionnaire.keySet()) {
                        //le numero du de existe deja => GAME OVER
                        if (resultat == dictionnaire.get(cle) ) {
                            score = 0;
                            break;
                        }
                    }
                    dictionnaire.put(numero,resultat);
                    System.out.println(numero+" "+ dictionnaire.get(numero) );
                    if (numero == 2 && dictionnaire.get(2) == 6) {
                        //( la premiere condition) car il n ya pas de nombre plus que 6 => GAME OVER
                        // (pour la deuxieme condition) il sera soit egal a le de 1 soit plus grand que lui => GAME OVER
                            score = 0;
                            System.out.println(numero + " : " + dictionnaire.get(numero));
                    }


                    if (dictionnaire.size() == 3 ) {
                        if (dictionnaire.get(1) < dictionnaire.get(2) && dictionnaire.get(2) < dictionnaire.get(3)) {
                            score = dictionnaire.get(1) + dictionnaire.get(2) + dictionnaire.get(3);

                        } else if (dictionnaire.get(1) > dictionnaire.get(2) && dictionnaire.get(2) > dictionnaire.get(3)) {
                            score = dictionnaire.get(1) * dictionnaire.get(2) * dictionnaire.get(3);

                        } else {
                            score = 0;

                        }

                    }
                    if (score >=-1) {
                        if (score >= user.getBestscore()) {
                            user.setBestscore(score);
                        }
                        System.out.println("1 : " + dictionnaire.get(1) + " |2 : " + dictionnaire.get(2) + " |3:" + dictionnaire.get(3));
                        out.println("<h1> Partie terminé!</h1> | Votre Score : " + score + " | Meilleur score : " + user.getBestscore());
                        out.println("<a href=\"index.jsp\"> page d acceuil </a>");
                        out.println("<a href=\"play.jsp\"> Rejouer </a>");
                        s.removeAttribute("listdesresult");
                    } else {
                        request.getRequestDispatcher("play.jsp").forward(request, response);
                    }
                }else{
                    HashMap<Integer, Integer> dictionnaire = new HashMap<>();
                    s.setAttribute("listdesresult",dictionnaire );
                    System.out.println("la session dico est cree");
                    int resultat = 1 + rd.nextInt(6);
                    dictionnaire.put(numero,resultat);
                    System.out.println(numero+" "+ dictionnaire.get(numero) );
                    if (numero == 2 && dictionnaire.get(2) == 6) {
                        //( la premiere condition) car il n ya pas de nombre plus que 6 => GAME OVER
                        // (pour la deuxieme condition) il sera soit egal a le de 1 soit plus grand que lui => GAME OVER
                            score = 0;
                            System.out.println(numero + " : " + dictionnaire.get(numero));
                            if (score >= user.getBestscore()) {
                                user.setBestscore(score);
                            }
                            out.println("<h1> Partie terminé!</h1> | Votre Score : " + score + " | Meilleur score : " + user.getBestscore());
                            out.println("<a href=\"index.jsp\"> page d acceuil </a>");
                            out.println("<a href=\"play.jsp\"> Rejouer </a>");
                            s.removeAttribute("listdesresult");
                    }else{
                    request.getRequestDispatcher("play.jsp").forward(request, response);}
                }

        } else {
            request.getRequestDispatcher("loginForm.jsp").forward(request, response);
            return;

        }}

    }

}
