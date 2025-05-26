package org.example.eksamensprojektbilabonnement.Service;

import org.example.eksamensprojektbilabonnement.Model.Login;
import org.example.eksamensprojektbilabonnement.Repository.LoginRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final LoginRepo loginRepo;

    // Constructor
    public LoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    //
    public boolean login(String brugernavn, String password) {
        //
        Optional<Login> login = loginRepo.findByBrugernavn(brugernavn);

        //
        return login.isPresent() && login.get().getKodeord().equals(password);

    }
}
