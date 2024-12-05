package com.eni.encheres.bll;

import com.eni.encheres.bo.Adresse;
import com.eni.encheres.bo.Utilisateur;
import com.eni.encheres.dao.AdresseDAO;
import com.eni.encheres.dao.UtilisateurDAO;
import com.eni.encheres.exception.BusinessException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
        utilisateur.setAdresse(adresseDAO.find(utilisateur.getAdresse().getNoAdresse()));
        return utilisateur;
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public void createUtilisateur(Utilisateur utilisateur) throws BusinessException {

        BusinessException be = new BusinessException();


        boolean isPseudoValid = checkPseudo(utilisateur, be);
        boolean isEmailValid = checkEmail(utilisateur, be);

        if (isPseudoValid && isEmailValid) {
            int adresseId = createAdresse(utilisateur, be);
            try {
                Adresse adresse = new Adresse();
                adresse.setNoAdresse(adresseId);
                if (utilisateur.getTelephone().isEmpty()) {
                    utilisateur.setTelephone(null);
                }
                utilisateur.setAdresse(adresse);
                utilisateurDAO.create(utilisateur);
                //
            } catch (DataAccessException e) {
                e.printStackTrace();
                be.add("Erreur lors de la création du film");
                throw be;
            }
        } else {
            throw be;
        }

    }

    private boolean checkPseudo(Utilisateur utilisateur, BusinessException be) {
        boolean isValid = true;
        Utilisateur utilisateur1 = null;
        try {
            utilisateur1 = utilisateurDAO.find(utilisateur.getPseudo());

        } catch (EmptyResultDataAccessException e) {
            System.out.println("le pseudo n'est pas utilisé");
        }
        if (utilisateur1 != null) {
            isValid = false;
            be.add("Pseudo déjà utilisé");
        }
        return isValid;
    }

    private boolean checkEmail(Utilisateur utilisateur, BusinessException be) {
        boolean isValid = true;
        Utilisateur utilisateur1 = null;
        try {
            utilisateur1 = utilisateurDAO.findByEmail(utilisateur.getEmail());

        } catch (EmptyResultDataAccessException e) {
            System.out.println("l'email n'est pas utilisé");
        }
        if (utilisateur1 != null) {
            isValid = false;
            be.add("Email déjà utilisé");
        }

        return isValid;
    }

    private int createAdresse(Utilisateur utilisateur, BusinessException be) {
        Adresse adresse = null;
        int adresseId = 0;
        try {
            adresse = adresseDAO.findComplete(utilisateur.getAdresse());
        } catch (EmptyResultDataAccessException e) {
            System.out.println("l'adresse existe pas");
        }
        if (adresse == null) {
            try {
                adresseId = adresseDAO.create(utilisateur.getAdresse());

            } catch (DataAccessException e) {
                e.printStackTrace();
                be.add("Erreur lors de la création de l'adresse");
            }
        } else {
            adresseId = adresse.getNoAdresse();
        }
        return adresseId;
    }

}
