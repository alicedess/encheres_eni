package com.eni.encheres.bll.contexte;

import com.eni.encheres.bo.Utilisateur;
import com.eni.encheres.dao.AdresseDAO;
import com.eni.encheres.dao.UtilisateurDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurDAO utilisateurDAO;
    private AdresseDAO adresseDAO;

    public UtilisateurServiceImpl(UtilisateurDAO utilisateurDAO, AdresseDAO adresseDAO) {
        this.utilisateurDAO = utilisateurDAO;
        this.adresseDAO = adresseDAO;
    }


    @Override
    public Utilisateur getByPseudo(String pseudo) {
        Utilisateur utilisateur = this.utilisateurDAO.find(pseudo);
        utilisateur.setAdresse(adresseDAO.find(utilisateur.getAdresse().getNo_adresse()));
        return utilisateur;
    }

}
