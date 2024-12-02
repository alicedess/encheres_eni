package com.eni.encheres.dao;

import com.eni.encheres.bo.Categorie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategorieDAOImpl implements CategorieDAO {

     public List<Categorie> findAll() {
        // à remplacer par une requête sql ?
        List<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie(1, "Ameublement"));
        categories.add(new Categorie(2, "Électronique"));
        categories.add(new Categorie(3, "Loisirs"));
        return categories;
    }
}
