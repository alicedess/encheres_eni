package com.eni.encheres.dao;

import com.eni.encheres.bo.Article;
import com.eni.encheres.bo.Article;

import java.util.List;

public interface ArticleDAO {
    List<Article> selectArticlesByUser(String userId); // Articles d’un utilisateur
    List<Article> selectActiveArticles(); // articles actifs pour les enchères
    void insertArticle(Article article); // on insére un nouvel article

    void deleteById(Integer articleId); //suppression
}
