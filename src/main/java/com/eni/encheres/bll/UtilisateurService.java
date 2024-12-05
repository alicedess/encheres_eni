package com.eni.encheres.bll;

import com.eni.encheres.bo.Utilisateur;
import com.eni.encheres.exception.BusinessException;

public interface UtilisateurService {

    Utilisateur getByPseudo(String pseudo);

    public void createUtilisateur(Utilisateur utilisateur) throws BusinessException;

}
