package com.eni.encheres.dao;

import com.eni.encheres.bo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArticleDAOImplementation implements ArticleDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public final RowMapper<Article> ARTICLE_ROW_MAPPER = new RowMapper<Article>() {
        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            Article article = new Article();

            article.setNo_article(rs.getInt("no_article"));
            article.setNom_article(rs.getString("nom_article"));
            article.setPhoto(rs.getString("photo"));
            article.setDate_debut_encheres(rs.getDate("date_debut_encheres"));
            article.setDate_fin_encheres(rs.getDate("date_fin_encheres"));
            article.setStatut_enchere(rs.getInt("statut_enchere"));
            article.setPrix_initial(rs.getInt("prix_initial"));
            article.setId_utilisateur(rs.getString("id_utilisateur"));
            article.setNo_categorie(rs.getInt("no_categorie"));
            article.setNo_adresse_retrait(rs.getInt("no_adresse_retrait"));

            return article;
        }
    };
    @Override
    public List<Article> selectArticles(int catId) {
        String sqlRequest = "SELECT * FROM encheres_db.articles_a_vendre";
        if (catId > 0) {
            sqlRequest = sqlRequest + " WHERE no_categorie = " + catId;
        }
        return jdbcTemplate.query(sqlRequest, ARTICLE_ROW_MAPPER);
    }

}
