package com.eni.encheres.dao;

import com.eni.encheres.bo.Article;
import com.eni.encheres.bo.Categorie;

import java.util.List;

public interface CategorieDAO {
    List<Categorie> getCategories();
}
