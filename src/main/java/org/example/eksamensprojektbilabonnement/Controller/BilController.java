package org.example.eksamensprojektbilabonnement.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.eksamensprojektbilabonnement.Model.Bil;
import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.example.eksamensprojektbilabonnement.Service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BilController {
    @Autowired
    private BilService bilService;

    @Autowired
    private BilRepo bilRepo;

    @GetMapping("/bil")
    public String showBilForm(Model model) {
        model.addAttribute("bil", new Bil());
        return "bil";
    }

    @PostMapping("/bil")
    public String opretBil(@ModelAttribute Bil bil) {
        bilRepo.save(bil);
        return "redirect:/bil";
    }

    @GetMapping("/bilListe")
    public String showBilListe(Model model) {
        model.addAttribute("bilListe", bilRepo.findAll());
        return "bilListe";
    }

    

}
