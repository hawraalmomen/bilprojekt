package org.example.eksamensprojektbilabonnement.Repository;


import org.example.eksamensprojektbilabonnement.Model.Fejl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class FejlRepo
{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    // hent fejl liste
    public List<Fejl> hentAlleFejl()
    {
        String sql = "select * from fejl";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fejl.class));
    }


    // hent fejl med ID
    public Fejl hentFejlMedId(Long id)
    {
        String sql = "select * from fejl where fejl_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Fejl.class), id);
    }


    // opret fejl
    public void opretFejl(Fejl fejl)
    {
        String sql = "insert into fejl(tilstandsrapport_id, beskrivelse, pris) values (?,?,?)";
        jdbcTemplate.update(sql,
                fejl.getTilstandsrapport(),
                fejl.getBeskrivelse(),
                fejl.getPris()
        );
    }


    // opdater fejl
    public void opdaterFejl(Fejl fejl)
    {
        String sql = "update fejl set tilstandsrapport_id = ?, beskrivelse = ?, pris = ? where fejl_id = ?";
        jdbcTemplate.update(sql,
                fejl.getTilstandsrapport(),
                fejl.getBeskrivelse(),
                fejl.getPris(),
                fejl.getFejlId()
        );
    }


    // slet fejl
    public void sletFejl(Long id)
    {
        String sql = "delete from fejl where fejl_id = ?";
        jdbcTemplate.update(sql, id);
    }

    // opdater tilstandsrapport
    public void opdaterTilstandsrapportId(Long fejlId, Long tilstandsrapportId) {
        String sql = "UPDATE fejl SET tilstandsrapport = ? WHERE fejl_id = ?";
        jdbcTemplate.update(sql, tilstandsrapportId, fejlId);
    }

    // henter fejl med id liste
    public List<Fejl> hentFejlMedIdListe(List<Long> ids) {
        String placeholders = ids.stream().map(id -> "?").collect(Collectors.joining(","));
        String sql = "SELECT * FROM fejl WHERE id IN (" + placeholders + ")";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fejl.class), ids.toArray());
    }
}