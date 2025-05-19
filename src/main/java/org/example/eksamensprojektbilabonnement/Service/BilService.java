package org.example.eksamensprojektbilabonnement.Service;

import org.example.eksamensprojektbilabonnement.Model.Bil;
import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilService {

    @Autowired
    private BilRepo bilRepo;

    public long getAntalBiler() {
        return bilRepo.count();
    }

    /*
    public double getSamletPris() {
        return bilRepo.findAll().stream()
                .mapToDouble(Bil::getPris)
                .sum();
    }

     */
}
