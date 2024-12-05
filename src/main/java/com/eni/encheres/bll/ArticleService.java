package com.eni.encheres.bll;

import com.eni.encheres.bo.Adresse;
import com.eni.encheres.bo.Article;
import com.eni.encheres.bo.Categorie;
import com.eni.encheres.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eni.encheres.dao.CategorieDAO;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleDAO articleDAO;

    @Autowired
    CategorieDAO categorieDAO;

    public List<Article> getUserArticles(String userId) {
        return articleDAO.selectArticlesByUser(userId);
    }

    public List<Article> getActiveArticles() {
        return articleDAO.selectActiveArticles();
    }

    public void saveArticle(Article article) {
        articleDAO.insertArticle(article);
    }

    public void deleteArticle(Integer articleId) {
        articleDAO.deleteById(articleId);
    }


    public List<Categorie> getAllCategories() {
        return categorieDAO.findAll();
    }
}
