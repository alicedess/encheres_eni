package com.eni.encheres.bll.contexte;

import com.eni.encheres.bo.Utilisateur;
import com.eni.encheres.dao.UtilisateurDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ContexteServiceImpl implements ContexteService {

    private UtilisateurDAO utilisateurDAO;

    public ContexteServiceImpl(UtilisateurDAO utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }


    @Override
    public Utilisateur charger(String pseudo) {
        return this.utilisateurDAO.read(pseudo);
    }

}
