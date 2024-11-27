package com.eni.encheres.bll;

import com.eni.encheres.bo.ArticleAVendre;
import com.eni.encheres.dao.ArticleAVendreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleAVendreRepository daoArticle;

    public List<ArticleAVendre> getAll() {
        // Récupérer les articles via la DAO
        List<ArticleAVendre> articles = daoArticle.selectArticles();

        System.out.println("ici" + articles.toString());
        return articles;
    }
}
