package com.eni.encheres.bll;

import com.eni.encheres.bo.Article;
import com.eni.encheres.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleDAO articleDAO;

    public List<Article> getUserArticles(String userId) {
        return articleDAO.selectArticlesByUser(userId);
    }

    public List<Article> getActiveArticles() {
        return articleDAO.selectActiveArticles();
    }

    public void saveArticle(Article article) {
        articleDAO.insertArticle(article);
    }
}
