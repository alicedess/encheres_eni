package com.eni.encheres.bo;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Article {
    private Integer no_article;

    @NotNull(message = "Le nom de l'article est obligatoire.")
    @Size(min = 3, max = 50, message = "Le nom de l'article doit contenir entre 3 et 50 caractères.")
    private String nom_article;

    private String photo;

    @NotNull(message = "La description est obligatoire.")
    @Size(min = 10, max = 255, message = "La description doit contenir entre 10 et 255 caractères.")
    private String description;

    @FutureOrPresent(message = "La date de début doit être dans le futur ou aujourd'hui.")
    private LocalDateTime date_debut_encheres;

    @Future(message = "La date de fin doit être dans le futur.")
    private LocalDateTime date_fin_encheres;

    private Integer statut_enchere;

    @NotNull(message = "Le prix initial est obligatoire.")
    private Integer prix_initial;

    private String id_utilisateur;

    private Integer no_categorie;

    private Integer no_adresse_retrait;


    public Article() {
        this.statut_enchere = 0;
        this.no_adresse_retrait = null;
    }

    // Getters et Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate_debut_encheres() {
        return date_debut_encheres;
    }

    public void setDate_debut_encheres(LocalDateTime date_debut_encheres) {
        this.date_debut_encheres = date_debut_encheres;
    }

    public LocalDateTime getDate_fin_encheres() {
        return date_fin_encheres;
    }

    public void setDate_fin_encheres(LocalDateTime date_fin_encheres) {
        this.date_fin_encheres = date_fin_encheres;
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

    @Override
    public String toString() {
        return "Article{" +
                "no_article=" + no_article +
                ", nom_article='" + nom_article + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", date_debut_encheres=" + date_debut_encheres +
                ", date_fin_encheres=" + date_fin_encheres +
                ", statut_enchere=" + statut_enchere +
                ", prix_initial=" + prix_initial +
                ", id_utilisateur='" + id_utilisateur + '\'' +
                ", no_categorie=" + no_categorie +
                ", no_adresse_retrait=" + no_adresse_retrait +
                '}';
    }
}
