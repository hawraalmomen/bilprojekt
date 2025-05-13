package org.example.eksamensprojektbilabonnement.Service;

import org.example.eksamensprojektbilabonnement.Model.Bil;
import org.example.eksamensprojektbilabonnement.Model.Kunder;
import org.example.eksamensprojektbilabonnement.Model.LejeAftale;
import org.example.eksamensprojektbilabonnement.Repository.LejeAftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LejeAftaleService {

    @Autowired
    private LejeAftaleRepo lejeAftaleRepo;

    public LejeAftale createLejeAftale(Kunder kunder, Bil bil, LocalDate startDato, LocalDate slutDato){
        LejeAftale leje = new LejeAftale();
        leje.setBil(bil);
        leje.setStartDato(startDato);
        leje.setSlutDato(slutDato);

        return lejeAftaleRepo.save(leje);
    }
}
