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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.*;

@Controller
public class LejeAftaleController {
    @Autowired
    private LejeAftaleService service;

    @Autowired
    private BilRepo bilRepo;

    @Autowired
    private KunderRepo kunderRepo;

    @Autowired
    private LejeAftaleRepo lejeAftaleRepo;

    @GetMapping("/lejeAftale")
    public String showLejeAftaleForm(Model model) {
        model.addAttribute("lejeAftale", new LejeAftale());
        model.addAttribute("kunder", kunderRepo.hentAlleKunder());
        model.addAttribute("biler", bilRepo.hentAlleBiler());
        return "lejeAftale";
    }

    @PostMapping("/lejeAftale")
    public String opretAftale(@RequestParam Long kundeId,
                              @RequestParam Long bilId,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDato,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate slutDato, RedirectAttributes redirectAttributes) {
        Optional<Kunder> kunde = kunderRepo.hentKundeMedId(kundeId);
        Optional<Bil> bil = bilRepo.hentBilMedId(bilId);

        if (kunde.isEmpty() || bil.isEmpty()) {
            return "redirect:/lejeAftale?error";
        }

        try {
            LejeAftale leje = new LejeAftale();
            leje.setKundeId(kunde.get().getKundeId());
            leje.setBilId(bil.get().getBilId());
            leje.setStartDato(startDato);
            leje.setSlutDato(slutDato);

            service.opretLejeaftale(leje);
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/lejeAftale?error";
        }

        return "redirect:/lejeAftaleListe";
    }

    @GetMapping("/lejeAftaleListe")
    public String visAlle(Model model) {
        List<LejeAftale> lejeaftaler = service.hentAlleLejeaftaler();

        List<Map<String, Object>> enrichedLejeaftaler = new ArrayList<>();

        for (LejeAftale l : lejeaftaler) {
            Map<String, Object> row = new HashMap<>();
            row.put("lejeaftale", l);
            row.put("kunde", kunderRepo.hentKundeMedId(l.getKundeId()).orElse(null));
            row.put("bil", bilRepo.hentBilMedId(l.getBilId()).orElse(null));
            enrichedLejeaftaler.add(row);
        }

        model.addAttribute("lejeAftaler", enrichedLejeaftaler);
        return "lejeAftaleListe";
    }



    @GetMapping("/lejeAftale/slet/{id}")
    public String sletLejeaftale(@PathVariable Long id) {
        service.sletLejeAftale(id);
        return "redirect:/lejeAftaleListe";
    }


    @GetMapping("/lejeAftale/rediger/{id}")
    public String redigerForm(@PathVariable Long id, Model model) {
        LejeAftale aftale = service.hentLejeaftaleMedId(id);
        model.addAttribute("lejeaftale", aftale);
        model.addAttribute("kunder", kunderRepo.hentAlleKunder());
        model.addAttribute("ledigeBiler", bilRepo.findBilerDerRedigeres(aftale.getBilId()));
        return "redigerLejeAftale";
    }

    @PostMapping("/lejeAftale/update")
    public String updateLejeAftale(@ModelAttribute LejeAftale lejeAftale) {
        service.opdaterLejeaftale(lejeAftale);
        return "redirect:/lejeAftaleListe";
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



    @GetMapping("/lejeAftale/delete/{id}")
    public String deleteLejeAftale(@PathVariable long id) {
        lejeAftaleRepo.deleteById(id);
        return "redirect:/lejeAftaleListe";
    }
}*/