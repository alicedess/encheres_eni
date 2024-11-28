package com.eni.encheres.bll.contexte;

import com.eni.encheres.bo.Utilisateur;

public interface UtilisateurService {

    Utilisateur getByPseudo(String pseudo);
}
