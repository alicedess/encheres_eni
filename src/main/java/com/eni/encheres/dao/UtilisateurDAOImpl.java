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

@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {

    private final String FIND_BY_PSEUDO = "SELECT pseudo, email, nom, prenom, telephone, credit, administrateur, no_adresse from utilisateurs WHERE pseudo = :pseudo";
    private final String FIND_BY_EMAIL = "SELECT pseudo, email, nom, prenom, telephone, credit, administrateur, no_adresse from utilisateurs WHERE email = :email";
    private static final String INSERT = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, mot_de_passe, credit, administrateur, no_adresse) VALUES (:pseudo, :nom, :prenom, :email, :telephone, :mot_de_passe,:credit, :administrateur, :no_adresse)";


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AdresseDAOImpl adresseDAOImpl;

    @Override
    public Utilisateur find(String pseudo) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("pseudo", pseudo);
        return jdbcTemplate.queryForObject(FIND_BY_PSEUDO, mapSqlParameterSource, new UtilisateurRowMapper());
    }

    @Override
    public Utilisateur findByEmail(String email) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("email", email);
        return jdbcTemplate.queryForObject(FIND_BY_EMAIL, mapSqlParameterSource, new UtilisateurRowMapper());
    }

    @Override
    public void create(Utilisateur utilisateur) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("pseudo", utilisateur.getPseudo());
        mapSqlParameterSource.addValue("nom", utilisateur.getNom());
        mapSqlParameterSource.addValue("prenom", utilisateur.getPrenom());
        mapSqlParameterSource.addValue("email", utilisateur.getEmail());
        mapSqlParameterSource.addValue("telephone", utilisateur.getTelephone());
        mapSqlParameterSource.addValue("mot_de_passe", utilisateur.getMotDePasse());
        mapSqlParameterSource.addValue("credit", utilisateur.getCredit());
        mapSqlParameterSource.addValue("administrateur", utilisateur.getAdministrateur());
        mapSqlParameterSource.addValue("no_adresse", utilisateur.getAdresse().getNoAdresse());

        jdbcTemplate.update(INSERT, mapSqlParameterSource);

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

            Adresse adresse = new Adresse();
            adresse.setNoAdresse(rs.getInt("no_adresse"));
            u.setAdresse(adresse);
            return u;
        }

    }

}
