package org.example.eksamensprojektbilabonnement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TilstandsrapportController {
    @GetMapping("/tilstandsrapport")
    public String visTilstand() {
        return "tilstandsrapport";
    }

    @PostMapping("/tilstandsrapport")
    public String gemTilstand(@RequestParam String reparation, @RequestParam("bilNavn") String bilNavn, @RequestParam("bilModel") String bilModel, @RequestParam("stelnummer") int stelnummer, @RequestParam("rapDato") String rapDato, @RequestParam("fejlPris") double fejlPris, @RequestParam("totalPris") double totalPris)
    {
        System.out.println("Bilnavn: "+bilNavn);
        System.out.println("BilModel: "+bilModel);
        System.out.println("Stelnummer: "+stelnummer);
        System.out.println("rapDato: "+rapDato);
        System.out.println("FejlPris: "+fejlPris);
        System.out.println("TotalPris: "+totalPris);

        return "redirect:/tilstandsrapport";
    }
}

