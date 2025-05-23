package org.example.eksamensprojektbilabonnement.Controller;

import org.example.eksamensprojektbilabonnement.Model.TilstandsRapport;
import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.example.eksamensprojektbilabonnement.Repository.KunderRepo;
import org.example.eksamensprojektbilabonnement.Repository.LejeAftaleRepo;
import org.example.eksamensprojektbilabonnement.Repository.TilstandsrapportRepo;
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
    private final LejeAftaleRepo lejeAftaleRepo;
    private final BilRepo bilRepo;
    private final KunderRepo kunderRepo;
    private final TilstandsrapportRepo tilstandsrapportRepo;

    @Autowired
    public TilstandsrapportController(TilstandsrapportService tilstandsrapportService, LejeAftaleRepo lejeAftaleRepo, BilRepo bilRepo, KunderRepo kunderRepo, TilstandsrapportRepo tilstandsrapportRepo)
    {
        this.tilstandsrapportService = tilstandsrapportService;
        this.lejeAftaleRepo = lejeAftaleRepo;
        this.bilRepo = bilRepo;
        this.kunderRepo = kunderRepo;
        this.tilstandsrapportRepo = tilstandsrapportRepo;
    }


    @GetMapping("/tilstandsrapport")
    public String visTilstand(Model model) {
        model.addAttribute("rapport", new TilstandsRapport());
        model.addAttribute("kunder", kunderRepo.hentAlleKunder());
        model.addAttribute("biler", bilRepo.hentAlleBiler());
        model.addAttribute("lejeaftaler", lejeAftaleRepo.hentAlleLejeaftaler());
        return "tilstandsrapport";
    }

    @PostMapping("/tilstandsrapport")
    public String gemTilstandsrapport(@ModelAttribute TilstandsRapport rapport)
    {
        rapport.setDato(LocalDate.now());
        tilstandsrapportRepo.opretTilstandsrapport(rapport);
        return "redirect:/tilstandsrapport";
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




}
