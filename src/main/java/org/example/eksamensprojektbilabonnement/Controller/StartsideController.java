package org.example.eksamensprojektbilabonnement.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartsideController
{
    @GetMapping("/")
    public String getStartside()
    {
        return "startside";
    }

}
