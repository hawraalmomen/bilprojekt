package org.example.eksamensprojektbilabonnement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
   @GetMapping("/login")
    public String login() {
       return "login";
   }

   @PostMapping("/login")
    public String loginformation(@RequestParam String username, @RequestParam String password) {
       if("username".equals(username) && "password".equals(password)) {
           return "redirect:/";
       } else {
           return "login";
       }
   }
}
