package com.eni.encheres.dao;

import com.eni.encheres.bo.Article;
import java.util.List;

public interface ArticleDAO {
    List<Article> selectArticlesByUser(String userId);
    List<Article> selectActiveArticles();
    void insertArticle(Article article);
    void deleteById(Integer articleId);
    List<Article> selectArticles(int catId, String name);
}