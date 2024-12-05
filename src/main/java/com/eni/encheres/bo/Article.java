package com.eni.encheres.bo;

import java.util.Date;

public class Article {
    private Integer no_article;
    private String nom_article;
    private String photo;
    private Date date_debut_encheres;
    private Date date_fin_encheres;
    private Integer statut_enchere;
    private Integer prix_initial;
    private String id_utilisateur;
    private Integer no_categorie;
    private Integer no_adresse_retrait;


    public Article() {
    }

    public Integer getNo_article() {
        return no_article;
    }

    public void setNo_article(Integer no_article) {
        this.no_article = no_article;
    }

    public String getNom_article() {
        return nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Date getDate_fin_encheres() {
        return date_fin_encheres;
    }
    public void setDate_fin_encheres(Date date_fin_encheres) {
        this.date_fin_encheres = date_fin_encheres;
    }
    public Date getDate_debut_encheres() {
        return date_debut_encheres;
    }
    public void setDate_debut_encheres(Date date_debut_encheres) {
        this.date_debut_encheres = date_debut_encheres;
    }
    public Integer getStatut_enchere() {
        return statut_enchere;
    }
    public void setStatut_enchere(Integer statut_enchere) {
        this.statut_enchere = statut_enchere;
    }
    public Integer getPrix_initial() {
        return prix_initial;
    }
    public void setPrix_initial(Integer prix_initial) {
        this.prix_initial = prix_initial;
    }
    public String getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    public Integer getNo_categorie() {
        return no_categorie;
    }
    public void setNo_categorie(Integer no_categorie) {
        this.no_categorie = no_categorie;
    }
    public Integer getNo_adresse_retrait() {
        return no_adresse_retrait;
    }
    public void setNo_adresse_retrait(Integer no_adresse_retrait) {
        this.no_adresse_retrait = no_adresse_retrait;
    }
}
