package org.example.eksamensprojektbilabonnement.Controller;

import org.example.eksamensprojektbilabonnement.Model.Bil;
import org.example.eksamensprojektbilabonnement.Model.Kunder;
import org.example.eksamensprojektbilabonnement.Model.LejeAftale;
import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.example.eksamensprojektbilabonnement.Repository.KunderRepo;
import org.example.eksamensprojektbilabonnement.Repository.LejeAftaleRepo;
import org.example.eksamensprojektbilabonnement.Service.LejeAftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class LejeAftaleController
{
    @Autowired
    private LejeAftaleService service;

    @GetMapping("/lejeaftale")
    public String opretAftale(Model model)
    {
        model.addAttribute("lejeaftale", new LejeAftale());
        return "lejeaftale";
    }


    @PostMapping("/lejeaftale")
    public String gemEllerOpdaterLejeaftale(@ModelAttribute LejeAftale lejeAftale)
    {
        if(lejeAftale.getLejeaftaleId() != null)
        {
            service.opdaterLejeaftale(lejeAftale);
        } else {
            service.opretLejeaftale(lejeAftale.getKundeId(), lejeAftale.getBilId(), lejeAftale.getStartDato(), lejeAftale.getSlutDato());
        }
        return "redirect:/lejeAftaleListe";
    }


    @GetMapping("/lejeaftaler")
    public String visAlle(Model model)
    {
        model.addAttribute("lejeaftaler", service.hentAlleLejeaftaler());
        return "lejeAftaleListe";
    }


    @GetMapping("/lejeaftale/slet/{id}")
    public String sletLejeaftale(@PathVariable Long id)
    {
        service.sletLejeaftale(id);
        return "redirect:/lejeaftaler";
    }


    @GetMapping("/lejeaftale/rediger/{id}")
    public String redigerForm(@PathVariable Long id, Model model)
    {
        LejeAftale aftale = service.hentLejeaftaleMedId(id);
        model.addAttribute("lejeaftale", aftale);
        return "lejeAftale";
    }




}


/*
@PostMapping("/lejeaftale")
public String gemLejeaftale(@ModelAttribute LejeAftale lejeaftale)
{
    service.opretLejeaftale(lejeaftale.getKundeId(), lejeaftale.getBilId(), lejeaftale.getStartDato(), lejeaftale.getSlutDato());
    return "redirect:/dataForside";
}
@PostMapping("/lejeaftale/opdater")
public String opdaterLejeaftale(@ModelAttribute LejeAftale lejeaftale)
{
    service.opdaterLejeaftale(lejeaftale);
    return "redirect:/lejeaftaler";
}
*/





    /*
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
        model.addAttribute("kunder", kunderRepo.findAll());
        model.addAttribute("biler", bilRepo.findAll());
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
        return "redirect:/lejeAftaleListe";
    }

    @GetMapping("/lejeAftaleListe")
    public String showLejeAftaler(Model model) {
        model.addAttribute("lejeAftaler", lejeAftaleRepo.findAll());
        return "lejeAftaleListe";
    }

    @GetMapping("/lejeAftale/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        LejeAftale lejeAftale = lejeAftaleRepo.findById(id).orElseThrow();
        model.addAttribute("lejeAftale", lejeAftale);
        model.addAttribute("kunder", kunderRepo.findAll());
        model.addAttribute("biler", bilRepo.findAll());
        return "redigerLejeAftale";
    }

    @PostMapping("/lejeAftale/update")
    public String updateLejeAftale(@ModelAttribute LejeAftale lejeAftale) {
        lejeAftaleRepo.save(lejeAftale);
        return "redirect:/lejeAftaleListe";
    }

    @GetMapping("/lejeAftale/delete/{id}")
    public String deleteLejeAftale(@PathVariable long id) {
        lejeAftaleRepo.deleteById(id);
        return "redirect:/lejeAftaleListe";
    }
}*/
