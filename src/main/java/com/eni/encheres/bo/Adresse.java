package com.eni.encheres.bo;

import jakarta.validation.constraints.NotBlank;

public class Adresse {


    private Integer noAdresse;

    @NotBlank(message = "Ce champs ne peut pas être vide ")
    private String rue;

    @NotBlank(message = "Ce champs ne peut pas être vide ")
    private String codePostal;

    @NotBlank(message = "Ce champs ne peut pas être vide ")
    private String ville;


    private Boolean adresseEni;

    public Adresse() {
        this.adresseEni = false;
    }

    public Integer getNoAdresse() {
        return noAdresse;
    }

    public void setNoAdresse(Integer noAdresse) {
        this.noAdresse = noAdresse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Boolean getAdresseEni() {
        return adresseEni;
    }

    public void setAdresseEni(Boolean adresseEni) {
        this.adresseEni = adresseEni;
    }


    @Override
    public String toString() {
        return "Adresse{" +
                "no_adresse=" + noAdresse +
                ", rue='" + rue + '\'' +
                ", code_postal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", adresse_eni=" + adresseEni +
                '}';
    }
}
