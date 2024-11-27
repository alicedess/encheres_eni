package com.eni.encheres.bo;

public class Utilisateur {
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Integer credit;
    private Boolean administrateur;
    private Adresse adresse;

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    public Utilisateur() {
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Boolean getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Boolean administrateur) {
        this.administrateur = administrateur;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "pseudo='" + pseudo + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", credit=" + credit +
                ", administrateur=" + administrateur +
                ", adresse=" + adresse +
                '}';
    }

    public void setPublicUser(Utilisateur utilisateur) {
        this.pseudo = utilisateur.getPseudo();
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
        this.email = utilisateur.getEmail();
        this.telephone = utilisateur.getTelephone();
        this.credit = utilisateur.getCredit();
        this.administrateur = utilisateur.getAdministrateur();
        this.adresse = utilisateur.getAdresse();
    }
}
