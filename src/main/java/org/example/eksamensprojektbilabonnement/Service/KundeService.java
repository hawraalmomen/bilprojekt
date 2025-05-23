package org.example.eksamensprojektbilabonnement.Service;

import org.example.eksamensprojektbilabonnement.Model.Kunder;
import org.example.eksamensprojektbilabonnement.Repository.KunderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KundeService
{
    @Autowired
    private KunderRepo kunderRepo;


    // hent alle kunder
    public List<Kunder> hentAlleKunder()
    {
        return kunderRepo.hentAlleKunder();
    }


    // hent kunde med ID
    public Optional<Kunder> hentKundeMedId(Long id)
    {
        return kunderRepo.hentKundeMedId(id);
    }


    // opret kunde
    public void opretKunde(Kunder kunde)
    {
        kunderRepo.opretKunde(kunde);
    }


    // opdater kunde
    public void opdaterKunde(Kunder kunde)
    {
        kunderRepo.opdaterKunde(kunde);
    }


    // slet kunde
    public void sletKunde(Long id)
    {
        kunderRepo.sletKunde(id);
    }

}