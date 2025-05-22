package org.example.eksamensprojektbilabonnement.Repository;


import org.example.eksamensprojektbilabonnement.Model.TilstandsRapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TilstandsrapportRepo
{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    // hent tilstandsrapport liste
    public List<TilstandsRapport> hentAlleTilstandsrapport()
    {
        String sql = "select * from tilstandsrapport";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TilstandsRapport.class));
    }


    // hent tilstandsrapport med ID
    public TilstandsRapport hentTilstandsrapportMedId(Long id)
    {
        String sql = "select * from tilstandsrapport where tilstandsrapport_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(TilstandsRapport.class), id);
    }


    // opret tilstandsrapport
    public void opretTilstandsrapport(TilstandsRapport tilstandsrapport)
    {
        String sql = "insert into tilstandsrapport(lejeaftale_id, bil_id, kunde_id, dato) values (?,?,?,?)";
        jdbcTemplate.update(sql,
                tilstandsrapport.getLejeaftaleId(),
                tilstandsrapport.getBilId(),
                tilstandsrapport.getKundeId(),
                tilstandsrapport.getDato()
        );
    }


    // opdater tilstandsrapport
    public void opdaterTilstandsrapport(TilstandsRapport tilstandsrapport)
    {
        String sql = "update tilstandsrapport set lejeaftale_id = ?, bil_id = ?, kunde_id = ?, dato = ? where tilstandsrapport_id = ?";
        jdbcTemplate.update(sql,
                tilstandsrapport.getLejeaftaleId(),
                tilstandsrapport.getBilId(),
                tilstandsrapport.getKundeId(),
                tilstandsrapport.getDato(),
                tilstandsrapport.getTilstandsrapportId()
        );
    }


    // slet tilstandsrapport
    public void sletTilstandsrapport(Long id)
    {
        String sql = "delete from tilstandsrapport where tilstandsrapport_id = ?";
        jdbcTemplate.update(sql, id);
    }
    
}