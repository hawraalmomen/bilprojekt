package org.example.bilabonnement.Service;

import org.example.bilabonnement.Model.Bil;
import org.example.bilabonnement.Model.Kunder;
import org.example.bilabonnement.Model.LejeAftale;
import org.example.bilabonnement.Repository.LejeAftaleRepo;
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
