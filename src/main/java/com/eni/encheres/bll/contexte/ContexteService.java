package com.eni.encheres.bll.contexte;

import com.eni.encheres.bo.Utilisateur;

public interface ContexteService {

    Utilisateur charger(String pseudo);
}
