package com.eni.encheres.bo;

import jakarta.validation.constraints.NotBlank;

public class Adresse {

    private Integer no_adresse; // Propriété renommée

    @NotBlank(message = "Ce champs ne peut pas être vide ")
    private String rue;

    @NotBlank(message = "Ce champs ne peut pas être vide ")
    private String code_postal; // Propriété renommée

    @NotBlank(message = "Ce champs ne peut pas être vide ")
    private String ville;

    private Boolean adresse_eni; // Propriété renommée

    public Adresse() {
        this.adresse_eni = false; // Initialisation par défaut
    }

    public Integer getNo_adresse() { // Getter mis à jour
        return no_adresse;
    }

    public void setNo_adresse(Integer no_adresse) { // Setter mis à jour
        this.no_adresse = no_adresse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() { // Getter mis à jour
        return code_postal;
    }

    public void setCode_postal(String code_postal) { // Setter mis à jour
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Boolean getAdresse_eni() { // Getter mis à jour
        return adresse_eni;
    }

    public void setAdresse_eni(Boolean adresse_eni) { // Setter mis à jour
        this.adresse_eni = adresse_eni;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "no_adresse=" + no_adresse +
                ", rue='" + rue + '\'' +
                ", code_postal='" + code_postal + '\'' +
                ", ville='" + ville + '\'' +
                ", adresse_eni=" + adresse_eni +
                '}';
    }
}
