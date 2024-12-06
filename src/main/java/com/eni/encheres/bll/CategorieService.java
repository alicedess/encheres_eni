package com.eni.encheres.bll;

import com.eni.encheres.bo.Categorie;
import com.eni.encheres.dao.CategorieDAO;
import com.eni.encheres.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieDAO categorieDAO;

    public List<Categorie> getAllCategories() {
        return categorieDAO.findAll();
    }
}

