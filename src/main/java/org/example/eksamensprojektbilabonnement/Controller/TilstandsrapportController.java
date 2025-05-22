package org.example.eksamensprojektbilabonnement.Controller;

import org.example.eksamensprojektbilabonnement.Model.TilstandsRapport;
import org.example.eksamensprojektbilabonnement.Service.TilstandsrapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class TilstandsrapportController
{

    private final TilstandsrapportService tilstandsrapportService;

    @Autowired
    public TilstandsrapportController(TilstandsrapportService tilstandsrapportService)
    {
        this.tilstandsrapportService = tilstandsrapportService;
    }


    @GetMapping("/tilstandsrapport")
    public String visTilstand(Model model) {
        model.addAttribute("rapport", new TilstandsRapport());
        model.addAttribute("kunder", kunderRepo.findAll());
        model.addAttribute("biler", bilRepo.findAll());
        model.addAttribute("lejeaftaler", lejeaftaleRepo.findAll());
        return "tilstandsrapport";
    }



    /*
    @GetMapping("/tilstandsrapport")
    public String visTilstand(Model model)
    {
        model.addAttribute("rapport", new TilstandsRapport());
        return "tilstandsrapport";
    }*/


    /* @PostMapping("/tilstandsrapport")
    public String gemTilstand(@RequestParam String reparation, @RequestParam("bilNavn") String bilNavn, @RequestParam("bilModel") String bilModel, @RequestParam("stelnummer") int stelnummer, @RequestParam("rapDato") String rapDato, @RequestParam("fejlPris") double fejlPris, @RequestParam("totalPris") double totalPris)
    {
        System.out.println("Bilnavn: "+bilNavn);
        System.out.println("BilModel: "+bilModel);
        System.out.println("Stelnummer: "+stelnummer);
        System.out.println("rapDato: "+rapDato);
        System.out.println("FejlPris: "+fejlPris);
        System.out.println("TotalPris: "+totalPris);

        return "redirect:/tilstandsrapport";
    }*/



    @PostMapping("/tilstandsrapport")
    public String gemTilstandsrapport(@ModelAttribute TilstandsRapport rapport)
    {
        rapport.setDato(LocalDate.now());
        tilstandsrapportService.save(rapport);
        return "redirect:/tilstandsrapport";
    }




}

