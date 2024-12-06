package com.eni.encheres.dao;

import com.eni.encheres.bo.Adresse;

import java.util.List;

public interface AdresseDAO {
    Adresse find(Integer id);

    Adresse findComplete(Adresse adresse);

    int create(Adresse adresse);

    List<Adresse> findAll();
}
