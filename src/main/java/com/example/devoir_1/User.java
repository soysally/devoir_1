package com.example.devoir_1;
public class User {
    private String nom ;
    private String prenom ;
    private String motdepassse;
    private int bestscore = -1;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotdepassse() {
        return motdepassse;
    }

    public void setMotdepassse(String motdepassse) {
        this.motdepassse = motdepassse;
    }

    public int getBestscore() {
        return bestscore;
    }

    public void setBestscore(int bestscore) {
        this.bestscore = bestscore;
    }
}

