package org.example.eksamensprojektbilabonnement.Repository;

import org.example.eksamensprojektbilabonnement.Model.LejeAftale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LejeAftaleRepo
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // oprettelse af ny lejeaftale
    public void opretLejeaftale(LejeAftale lejeAftale)
    {
        String sql = "insert into lejeaftale(kunde_id, bil_id, start_dato, slut_dato) values(?,?,?,?)";
        jdbcTemplate.update(sql,
                lejeAftale.getKundeId(),
                lejeAftale.getBilId(),
                lejeAftale.getStartDato(),
                lejeAftale.getSlutDato());
    }


    // hent alle lejeaftaler
    public List<LejeAftale> hentAlleLejeaftaler()
    {
        String sql = "SELECT * FROM lejeaftale";
        return jdbcTemplate.query(sql, new RowMapper<LejeAftale>() {
            @Override
            public LejeAftale mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                LejeAftale lejeAftale = new LejeAftale();
                lejeAftale.setLejeaftaleId(rs.getLong("lejeaftale_id"));
                lejeAftale.setKundeId(rs.getLong("kunde_id"));
                lejeAftale.setBilId(rs.getLong("bil_id"));
                lejeAftale.setStartDato(rs.getDate("start_dato").toLocalDate());
                lejeAftale.setSlutDato(rs.getDate("slut_dato").toLocalDate());
                return lejeAftale;
            }
        });
    }


    // slet lejeaftale
    public void sletLejeaftale(Long id)
    {
        String sql = "delete from lejeaftale where lejeaftale_id = ?";
        jdbcTemplate.update(sql, id);
    }


    // hent specifik lejeaftale med ID
    public LejeAftale hentLejeaftaleMedId(Long id)
    {
        String sql = "select * from lejeaftale where lejeaftale_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(LejeAftale.class), id);
    }


    // opdater lejeaftale
    public void opdaterLejeaftale(LejeAftale lejeAftale)
    {
        String sql = "update lejeaftale set kunde_id = ?, bil_id = ?, start_dato = ?, slut_dato = ? where lejeaftale_id = ?";
        jdbcTemplate.update(sql, lejeAftale.getKundeId(), lejeAftale.getBilId(), lejeAftale.getStartDato(), lejeAftale.getSlutDato(), lejeAftale.getLejeaftaleId());
    }

}