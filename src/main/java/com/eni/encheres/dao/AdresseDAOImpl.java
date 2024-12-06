package com.eni.encheres.dao;

import com.eni.encheres.bo.Adresse;
import com.eni.encheres.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdresseDAOImpl implements AdresseDAO {
    private final String FIND_BY_ID = "SELECT no_adresse, rue, code_postal, adresse_eni, ville from adresses WHERE no_adresse = :id";
    private final String FIND_ALL = "SELECT no_adresse, rue, code_postal, adresse_eni, ville FROM adresses";
    private final String FIND_BY_COMPlETE = "SELECT no_adresse, rue, code_postal, adresse_eni, ville from adresses WHERE rue = :rue AND code_postal = :codePostal AND ville = :ville";
    private final String INSERT = "INSERT INTO adresses (rue, code_postal, ville, adresse_eni) VALUES(:rue, :codePostal, :ville, :adresseEni)";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

     @Override
    public List<Adresse> findAll() {
        return jdbcTemplate.query(FIND_ALL, new AdresseRowMapper());
    }

    @Override
    public Adresse find(Integer id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return jdbcTemplate.queryForObject(FIND_BY_ID, mapSqlParameterSource, new AdresseRowMapper());
    }

    @Override
    public Adresse findComplete(Adresse adresse) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("rue", adresse.getRue());
        mapSqlParameterSource.addValue("codePostal", adresse.getCode_postal());
        mapSqlParameterSource.addValue("ville", adresse.getVille());
        return jdbcTemplate.queryForObject(FIND_BY_COMPlETE, mapSqlParameterSource, new AdresseRowMapper());
    }

    @Override
    public int create(Adresse adresse) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("rue", adresse.getRue());
        mapSqlParameterSource.addValue("codePostal", adresse.getCode_postal());
        mapSqlParameterSource.addValue("ville", adresse.getVille());
        mapSqlParameterSource.addValue("adresseEni", adresse.getAdresse_eni());
        jdbcTemplate.update(INSERT, mapSqlParameterSource, keyHolder);

        if (keyHolder != null && keyHolder.getKey() != null) {
            adresse.setNo_adresse(keyHolder.getKey().intValue());
        }
        return adresse.getNo_adresse();
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
