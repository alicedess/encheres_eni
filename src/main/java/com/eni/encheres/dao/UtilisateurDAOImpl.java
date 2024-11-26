package com.eni.encheres.dao;

import com.eni.encheres.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {

    private final String FIND_BY_PSEUDO = "SELECT pseudo, email, nom, prenom, telephone, credit, administrateur from utilisateurs WHERE pseudo = :pseudo";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Utilisateur read(String pseudo) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("pseudo", pseudo);
        return jdbcTemplate.queryForObject(FIND_BY_PSEUDO, mapSqlParameterSource, new UtilisateurRowMapper());
    }

    class UtilisateurRowMapper implements RowMapper<Utilisateur> {

        @Override
        public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
            Utilisateur u = new Utilisateur();
            u.setPseudo(rs.getString("pseudo"));
            u.setEmail(rs.getString("email"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setTelephone(rs.getString("telephone"));
            u.setCredit(rs.getInt("credit"));
            u.setAdministrateur(rs.getBoolean("administrateur"));

            return u;
        }

    }

}
