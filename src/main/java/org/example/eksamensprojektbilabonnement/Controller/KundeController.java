package org.example.eksamensprojektbilabonnement.Controller;

import org.example.eksamensprojektbilabonnement.Model.Kunder;
import org.example.eksamensprojektbilabonnement.Repository.KunderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KundeController {

    @Autowired
    KunderRepo kunderRepo;

    @GetMapping("/kunde")
    public String showKundeForm(Model model) {
        model.addAttribute("kunde", new Kunder());
        return "kunde";
    }

    @PostMapping("/kunde")
    public String opretKunde(@ModelAttribute Kunder kunde) {
        kunderRepo.opretKunde(kunde);
        return "redirect:/kundeListe";
    }

    @GetMapping("/kundeListe")
    public String showKunderForm(Model model) {
        model.addAttribute("kunder", kunderRepo.hentAlleKunder());
        return "kundeListe";
    }

    @GetMapping("/kunder/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Kunder kunde = kunderRepo.hentKundeMedId(id).orElseThrow();
        model.addAttribute("kunde", kunde);
        return "redigerKunde";
    }

    @PostMapping("/kunder/update")
    public String updateKunde(@ModelAttribute Kunder kunde) {
        kunderRepo.opdaterKunde(kunde);
        return "redirect:/kundeListe";
    }

    @GetMapping("/kunde/delete/{id}")
    public String deleteKunde(@PathVariable long id) {
        kunderRepo.sletKunde(id);
        return "redirect:/kundeListe";
    }
}