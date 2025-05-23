package org.example.eksamensprojektbilabonnement.Service;

import org.example.eksamensprojektbilabonnement.Model.Fejl;
import org.example.eksamensprojektbilabonnement.Repository.FejlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FejlService
{
    @Autowired
    private FejlRepo fejlrepo;


    // hent alle fejl
    public List<Fejl> hentAlleFejl()
    {
        return fejlrepo.hentAlleFejl();
    }

    // hent fejl med id
    public Fejl hentFejlMedId(Long id)
    {
        return fejlrepo.hentFejlMedId(id);
    }


    // opret fejl
    public void opretFejl(Fejl fejl)
    {
        fejlrepo.opretFejl(fejl);
    }


    // opdater fejl
    public void opdaterFejl(Fejl fejl)
    {
        fejlrepo.opdaterFejl(fejl);
    }


    // slet fejl
    public void sletFejl(Long id)
    {
        fejlrepo.sletFejl(id);
    }

}