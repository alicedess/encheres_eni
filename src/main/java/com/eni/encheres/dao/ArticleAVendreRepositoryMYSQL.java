package com.eni.encheres.dao;

import com.eni.encheres.bo.ArticleAVendre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Profile("mysql")
@Component
public class ArticleAVendreRepositoryMYSQL implements ArticleAVendreRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public final RowMapper<ArticleAVendre> ARTICLE_ROW_MAPPER = new RowMapper<ArticleAVendre>() {
        @Override
        public ArticleAVendre mapRow(ResultSet rs, int rowNum) throws SQLException {
            ArticleAVendre article = new ArticleAVendre();

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
    public List<ArticleAVendre> selectArticles() {
        return jdbcTemplate.query("SELECT * FROM encheres_db.articles_a_vendre", ARTICLE_ROW_MAPPER);
    }

}
