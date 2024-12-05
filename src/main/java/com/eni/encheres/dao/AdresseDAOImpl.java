package com.eni.encheres.dao;

import com.eni.encheres.bo.Adresse;
import com.eni.encheres.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdresseDAOImpl implements AdresseDAO {
    private final String FIND_BY_ID = "SELECT no_adresse, rue, code_postal, adresse_eni, ville from adresses WHERE no_adresse = :id";

    private final String FIND_ALL = "SELECT no_adresse, rue, code_postal, adresse_eni, ville FROM adresses";


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Adresse find(Integer id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return jdbcTemplate.queryForObject(FIND_BY_ID, mapSqlParameterSource, new AdresseRowMapper());
    }

    @Override
    public List<Adresse> findAll() {
        return jdbcTemplate.query(FIND_ALL, new AdresseRowMapper());
    }

    class AdresseRowMapper implements RowMapper<Adresse> {

        @Override
        public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {
            Adresse a = new Adresse();
            a.setNo_adresse(rs.getInt("no_adresse"));
            a.setRue(rs.getString("rue"));
            a.setCode_postal(rs.getString("code_postal"));
            a.setVille(rs.getString("ville"));
            a.setAdresse_eni(rs.getBoolean("adresse_eni"));
            return a;
        }

    }
}
