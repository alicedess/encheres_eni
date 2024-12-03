package com.eni.encheres.bll;

import com.eni.encheres.bo.Article;
import com.eni.encheres.dao.ArticleDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleDAO daoArticle;
    public ArticleService(ArticleDAO daoArticle) {
        this.daoArticle = daoArticle;
    }
    public List<Article> getArticles(int catId, String name) {
        // Récupérer les articles via la DAO

        return daoArticle.selectArticles(catId, name);
    }
}
