package com.eni.encheres.bo;

public class Adresse {
    private Integer no_adresse;
    private String rue;
    private String code_postal;
    private String ville;
    private Boolean adresse_eni;

    public Adresse() {
    }

    public Integer getNo_adresse() {
        return no_adresse;
    }

    public void setNo_adresse(Integer no_adresse) {
        this.no_adresse = no_adresse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Boolean getAdresse_eni() {
        return adresse_eni;
    }

    public void setAdresse_eni(Boolean adresse_eni) {
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
