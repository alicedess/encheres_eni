package com.eni.encheres.bll;

import com.eni.encheres.bo.Article;
import com.eni.encheres.bo.Categorie;
import com.eni.encheres.dao.ArticleDAO;
import com.eni.encheres.dao.CategorieDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieDAO daoCategorie;
    public CategorieService(CategorieDAO daoCategorie) {
        this.daoCategorie = daoCategorie;
    }
    public List<Categorie> getAll() {
        // Récupérer les articles via la DAO
        return daoCategorie.getCategories();
    }
}
