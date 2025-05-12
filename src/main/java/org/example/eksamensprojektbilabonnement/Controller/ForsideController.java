package org.example.eksamensprojektbilabonnement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForsideController
{
    @GetMapping("/skadeForside")
    public String skadeForside()
    {
        return "skadeForside";
    }


    @GetMapping("/dataForside")
    public String dataForside()
    {
        return "dataForside";
    }


    @GetMapping("/foretUdviklForside")
    public String foretUdviklForside()
    {
        return "foretUdviklForside";
    }


}
