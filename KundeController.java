package org.example.bilabonnement.Controller;

import org.example.bilabonnement.Model.Kunder;
import org.example.bilabonnement.Repository.KunderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        kunderRepo.save(kunde);
        return "redirect:/kunde";
    }
}
