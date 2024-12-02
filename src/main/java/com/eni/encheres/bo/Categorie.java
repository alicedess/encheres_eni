package com.eni.encheres.bo;

public class Categorie {
    private Integer noCategorie;
    private String nom;

    public Categorie() {
    }

    public Categorie(Integer noCategorie, String nom) {
        this.noCategorie = noCategorie;
        this.nom = nom;
    }

    public Integer getNoCategorie() {
        return noCategorie;
    }

    public void setNoCategorie(Integer noCategorie) {
        this.noCategorie = noCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
