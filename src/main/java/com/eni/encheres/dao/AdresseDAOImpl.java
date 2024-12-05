package com.eni.encheres.dao;

import com.eni.encheres.bo.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AdresseDAOImpl implements AdresseDAO {
    private final String FIND_BY_ID = "SELECT no_adresse, rue, code_postal, adresse_eni, ville from adresses WHERE no_adresse = :id";
    private final String FIND_BY_COMPlETE = "SELECT no_adresse, rue, code_postal, adresse_eni, ville from adresses WHERE rue = :rue AND code_postal = :codePostal AND ville = :ville";
    private final String INSERT = "INSERT INTO adresses (rue, code_postal, ville, adresse_eni) VALUES(:rue, :codePostal, :ville, :adresseEni)";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

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
        mapSqlParameterSource.addValue("codePostal", adresse.getCodePostal());
        mapSqlParameterSource.addValue("ville", adresse.getVille());
        return jdbcTemplate.queryForObject(FIND_BY_COMPlETE, mapSqlParameterSource, new AdresseRowMapper());
    }

    @Override
    public int create(Adresse adresse) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("rue", adresse.getRue());
        mapSqlParameterSource.addValue("codePostal", adresse.getCodePostal());
        mapSqlParameterSource.addValue("ville", adresse.getVille());
        mapSqlParameterSource.addValue("adresseEni", adresse.getAdresseEni());
        jdbcTemplate.update(INSERT, mapSqlParameterSource, keyHolder);

        if (keyHolder != null && keyHolder.getKey() != null) {
            adresse.setNoAdresse(keyHolder.getKey().intValue());
        }
        return adresse.getNoAdresse();
    }

    class AdresseRowMapper implements RowMapper<Adresse> {

        @Override
        public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {
            Adresse a = new Adresse();
            a.setNoAdresse(rs.getInt("no_adresse"));
            a.setRue(rs.getString("rue"));
            a.setCodePostal(rs.getString("code_postal"));
            a.setVille(rs.getString("ville"));
            a.setAdresseEni(rs.getBoolean("adresse_eni"));
            return a;
        }

    }
}
