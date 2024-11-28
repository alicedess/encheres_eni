package com.eni.encheres.dao;

import com.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

    Utilisateur read(String pseudo);
}
