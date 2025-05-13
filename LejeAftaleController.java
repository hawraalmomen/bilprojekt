package org.example.bilabonnement.Controller;

import org.example.bilabonnement.Model.Bil;
import org.example.bilabonnement.Model.Kunder;
import org.example.bilabonnement.Model.LejeAftale;
import org.example.bilabonnement.Repository.BilRepo;
import org.example.bilabonnement.Repository.KunderRepo;
import org.example.bilabonnement.Repository.LejeAftaleRepo;
import org.example.bilabonnement.Service.LejeAftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class LejeAftaleController {
    @Autowired
    LejeAftaleRepo lejeAftaleRepo;

    @Autowired
    KunderRepo kunderRepo;

    @Autowired
    BilRepo bilRepo;

    @Autowired
    LejeAftaleService lejeAftaleService;

    @GetMapping("/lejeAftale")
    public String showLejeAftaleForm(Model model){
        model.addAttribute("lejeAftale", new LejeAftale());
        return "lejeAftale";
    }

    @PostMapping("/lejeAftale")
    public String opretAftale(@RequestParam int kundeId, @RequestParam int bilId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDato, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate slutDato){
        Kunder kunde = kunderRepo.findById((long) kundeId).orElseThrow();
        Bil bil = bilRepo.findById((long) bilId).orElseThrow();

        LejeAftale leje = new LejeAftale();
        leje.setKunde(kunde);
        leje.setBil(bil);
        leje.setStartDato(startDato);
        leje.setSlutDato(slutDato);

        lejeAftaleRepo.save(leje);
        return "redirect:/";
    }
}
