package com.excursion.asiento.repository;

import com.excursion.asiento.model.Asiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AsientoRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Asiento> findAll() {
        return jdbc.query("SELECT * FROM TBL_ASIENTO", (rs, rowNum) -> {
            Asiento a = new Asiento();
            a.setIdAsiento(rs.getLong("ID_ASIENTO"));
            a.setNumero(rs.getString("NUMERO"));
            a.setIdAutobus(rs.getLong("ID_AUTOBUS"));
            a.setDisponible(rs.getString("DISPONIBLE"));
            return a;
        });
    }

    public Asiento findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM TBL_ASIENTO WHERE ID_ASIENTO = ?",
            new Object[]{id},
            (rs, rowNum) -> {
                Asiento a = new Asiento();
                a.setIdAsiento(rs.getLong("ID_ASIENTO"));
                a.setNumero(rs.getString("NUMERO"));
                a.setIdAutobus(rs.getLong("ID_AUTOBUS"));
                a.setDisponible(rs.getString("DISPONIBLE"));
                return a;
            });
    }

    public void save(Asiento a) {
        jdbc.update("INSERT INTO TBL_ASIENTO (NUMERO, ID_AUTOBUS, DISPONIBLE) VALUES (?, ?, ?)",
            a.getNumero(), a.getIdAutobus(), a.getDisponible());
    }

    public void update(Asiento a) {
        jdbc.update("UPDATE TBL_ASIENTO SET NUMERO = ?, ID_AUTOBUS = ?, DISPONIBLE = ? WHERE ID_ASIENTO = ?",
            a.getNumero(), a.getIdAutobus(), a.getDisponible(), a.getIdAsiento());
    }

    public void delete(Long id) {
        jdbc.update("DELETE FROM TBL_ASIENTO WHERE ID_ASIENTO = ?", id);
    }
}