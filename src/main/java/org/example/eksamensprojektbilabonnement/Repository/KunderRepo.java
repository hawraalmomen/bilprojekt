package org.example.eksamensprojektbilabonnement.Repository;

import org.example.eksamensprojektbilabonnement.Model.Kunder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class KunderRepo
{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    // hent kunde liste
    public List<Kunder> hentAlleKunder()
    {
        String sql = "select * from kunder";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Kunder.class));
    }


    // hent kunder med ID
    public Kunder hentKundeMedId(Long id)
    {
        String sql = "select * from kunder where kunde_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Kunder.class), id);
    }


    // opret kunde
    public void opretKunde(Kunder kunde)
    {
        String sql = "insert into kunder(fornavn, efternavn, f_dag, post_nr, adresse, email, tlf_nr) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                kunde.getFornavn(),
                kunde.getEfternavn(),
                kunde.getFDag(),
                kunde.getPostNr(),
                kunde.getAdresse(),
                kunde.getEmail(),
                kunde.getTlfNr()
        );
    }


    // opdater kunde
    public void opdaterKunde(Kunder kunde)
    {
        String sql = "update kunder set fornavn = ?, efternavn = ?, f_dag = ?, post_nr = ?, adresse = ?, email = ?, tlf_nr = ? where kunde_id = ?";
        jdbcTemplate.update(sql,
                kunde.getFornavn(),
                kunde.getEfternavn(),
                kunde.getFDag(),
                kunde.getPostNr(),
                kunde.getAdresse(),
                kunde.getEmail(),
                kunde.getTlfNr(),
                kunde.getKundeId()
        );
    }


    // slet kunde
    public void sletKunde(Long id)
    {
        String sql = "delete from kunder where kunde_id = ?";
        jdbcTemplate.update(sql, id);
    }


}
