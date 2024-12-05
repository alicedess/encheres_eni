package com.eni.encheres.dao;

import com.eni.encheres.bo.Adresse;
import java.util.List;

public interface AdresseDAO {
    Adresse find(Integer id);
    List<Adresse> findAll();
}
