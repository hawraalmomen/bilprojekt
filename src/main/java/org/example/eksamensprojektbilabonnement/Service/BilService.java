package org.example.eksamensprojektbilabonnement.Service;

import org.example.eksamensprojektbilabonnement.Model.Bil;
import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BilService {

    @Autowired
    private BilRepo bilRepo;

    //giver antalet af biler
    public long getAntalBiler() {
        return bilRepo.count();
    }

    public BigDecimal getSamletPris() {
        return bilRepo.findAll().stream()
                .map(Bil::getPris)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
