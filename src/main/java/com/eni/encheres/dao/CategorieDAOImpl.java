package com.eni.encheres.dao;

import com.eni.encheres.bo.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategorieDAOImpl implements CategorieDAO {

    private static final String FIND_ALL = "SELECT no_categorie, libelle FROM categories";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Categorie> findAll() {
        return jdbcTemplate.query(FIND_ALL, new CategorieRowMapper());
    }

    class CategorieRowMapper implements RowMapper<Categorie> {
        @Override
        public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Categorie categorie = new Categorie();
            categorie.setNo_categorie(rs.getInt("no_categorie"));
            categorie.setLibelle(rs.getString("libelle"));
            return categorie;
        }
    }
}
