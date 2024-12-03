package com.eni.encheres.dao;

import com.eni.encheres.bo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Profile("mysql")
@Repository
public class ArticleDAOImpl implements ArticleDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<Article> ARTICLE_ROW_MAPPER = (rs, rowNum) -> {
        Article article = new Article();
        article.setNo_article(rs.getInt("no_article"));
        article.setNom_article(rs.getString("nom_article"));
        article.setPhoto(rs.getString("photo"));

        // Gestion des dates avec LocalDateTime
        Timestamp dateDebut = rs.getTimestamp("date_debut_encheres");
        Timestamp dateFin = rs.getTimestamp("date_fin_encheres");
        article.setDate_debut_encheres(dateDebut != null ? dateDebut.toLocalDateTime() : null);
        article.setDate_fin_encheres(dateFin != null ? dateFin.toLocalDateTime() : null);

        article.setStatut_enchere(rs.getInt("statut_enchere"));
        article.setPrix_initial(rs.getInt("prix_initial"));
        article.setId_utilisateur(rs.getString("id_utilisateur"));
        article.setNo_categorie(rs.getInt("no_categorie"));
        article.setNo_adresse_retrait(rs.getInt("no_adresse_retrait"));
        return article;
    };

    @Override
    public List<Article> selectArticlesByUser(String userId) {
        String sql = "SELECT * FROM articles_a_vendre WHERE id_utilisateur = ?";
        return jdbcTemplate.query(sql, ARTICLE_ROW_MAPPER, userId);
    }

    @Override
    public List<Article> selectActiveArticles() {
        String sql = "SELECT * FROM articles_a_vendre WHERE date_debut_encheres <= NOW() AND date_fin_encheres >= NOW()";
        return jdbcTemplate.query(sql, ARTICLE_ROW_MAPPER);
    }

    @Override
    public void insertArticle(Article article) {
        String sql = "INSERT INTO articles_a_vendre (nom_article, photo, date_debut_encheres, date_fin_encheres, statut_enchere, prix_initial, id_utilisateur, no_categorie, no_adresse_retrait) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, article.getNom_article());
            ps.setString(2, article.getPhoto());

            // Gestion des dates pour l'insertion
            ps.setTimestamp(3, article.getDate_debut_encheres() != null ? Timestamp.valueOf(article.getDate_debut_encheres()) : null);
            ps.setTimestamp(4, article.getDate_fin_encheres() != null ? Timestamp.valueOf(article.getDate_fin_encheres()) : null);

            ps.setInt(5, article.getStatut_enchere());
            ps.setInt(6, article.getPrix_initial());
            ps.setString(7, article.getId_utilisateur());
            ps.setInt(8, article.getNo_categorie());
            ps.setInt(9, article.getNo_adresse_retrait());
            return ps;
        });
    }

    @Override
    public void deleteById(Integer articleId) {
        String sql = "DELETE FROM articles_a_vendre WHERE no_article = ?";
        jdbcTemplate.update(sql, articleId);
    }
}
