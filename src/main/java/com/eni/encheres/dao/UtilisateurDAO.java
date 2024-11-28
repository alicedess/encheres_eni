package com.eni.encheres.dao;

import com.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

    Utilisateur find(String pseudo);
}
