package org.example.eksamensprojektbilabonnement.Controller;

import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.example.eksamensprojektbilabonnement.Repository.LejeAftaleRepo;
import org.example.eksamensprojektbilabonnement.Service.BilService;
import org.example.eksamensprojektbilabonnement.Service.LejeAftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForretningUdviklerController {
    @Autowired
    private BilService bilService;

    @Autowired
    private LejeAftaleService lejeAftaleService;

    @Autowired
    private BilRepo bilRepo;

    @Autowired
    private LejeAftaleRepo lejeAftaleRepo;

    @GetMapping("/foretUdviklForside")
    public String foretUdviklForside(Model model) {
        model.addAttribute("antalBiler", bilService.getAntalBiler());
        model.addAttribute("samletPris", bilService.getSamletPris());
        /*
        model.addAttribute("AntalLejetBiler", lejeAftaleService.getAntalLejetBiler());
         */
        return "foretUdviklForside";
}}