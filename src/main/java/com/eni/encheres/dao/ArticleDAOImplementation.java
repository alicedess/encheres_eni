package com.eni.encheres.dao;

import com.eni.encheres.bo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Article> selectArticles(int catId, String name) {
        StringBuilder sqlRequest = new StringBuilder("SELECT * FROM encheres_db.articles_a_vendre");
        Map<String, Object> params = new HashMap<>();

        boolean hasWhere = false;
        if (catId > 0) {
            sqlRequest.append(" WHERE no_categorie = :catId");
            params.put("catId", catId);
            hasWhere = true;
        }
        if (name != null && !name.isEmpty()) {
            sqlRequest.append(hasWhere ? " AND" : " WHERE");
            sqlRequest.append(" nom_article LIKE :name");
            params.put("name", "%" + name + "%");
        }

        return namedParameterJdbcTemplate.query(sqlRequest.toString(), params, ARTICLE_ROW_MAPPER);
    }

}
