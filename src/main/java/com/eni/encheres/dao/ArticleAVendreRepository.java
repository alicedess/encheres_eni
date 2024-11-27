package com.eni.encheres.dao;

import com.eni.encheres.bo.ArticleAVendre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleAVendreRepository {
    List<ArticleAVendre> selectArticles();
}
