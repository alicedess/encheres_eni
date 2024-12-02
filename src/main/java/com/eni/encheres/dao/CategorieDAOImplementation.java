package com.eni.encheres.dao;

import com.eni.encheres.bo.Article;
import com.eni.encheres.bo.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategorieDAOImplementation implements CategorieDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public final RowMapper<Categorie> Categorie_ROW_MAPPER = new RowMapper<Categorie>() {
        @Override
        public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Categorie categorie = new Categorie();

            categorie.setNo_categorie(rs.getInt("no_categorie"));
            categorie.setLibelle(rs.getString("libelle"));

            return categorie;
        }
    };
    @Override
    public List<Categorie> getCategories() {
        return jdbcTemplate.query("SELECT * FROM encheres_db.categories", Categorie_ROW_MAPPER);
    }

}
