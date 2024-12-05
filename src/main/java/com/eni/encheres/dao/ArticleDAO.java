package com.eni.encheres.dao;

import com.eni.encheres.bo.Article;

import java.util.List;

public interface ArticleDAO {
    List<Article> selectArticles(int catId, String name);
}
