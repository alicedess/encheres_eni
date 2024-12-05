package com.eni.encheres.bo;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Utilisateur {
    @NotBlank(message = "Ce champs ne peut pas être vide ")
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "Le pseudo ne peut contenir que des lettres, chiffres ou le symbole '_'")
    private String pseudo;

    @NotBlank(message = "Ce champs ne peut pas être vide ")
    private String nom;

    @NotBlank(message = "Ce champs ne peut pas être vide ")
    private String prenom;

    @NotBlank(message = "Veuillez rentrer une adresse email valide")
    @Email(message = "Veuillez rentrer une adresse email valide")
    private String email;

    private String telephone;

    private Integer credit;

    private Boolean administrateur;

    @Valid
    private Adresse adresse;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,20}$", message = "Le mot de pass doit contenir au moins une majuscule, un chiffre et un character spécial")
    private String motDePasse;

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    public Utilisateur() {
        this.administrateur = false;
        this.credit = 10;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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
