package org.example.eksamensprojektbilabonnement.Model;

import jakarta.persistence.*;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loginId;

    private String brugernavn;
    private String password;

    @ManyToOne
    private BrugerType brugerId;

    public Login() {}

    public Login(long loginId, String brugernavn, String password, BrugerType brugerId) {
        this.loginId = loginId;
        this.brugernavn = brugernavn;
        this.password = password;
        this.brugerId = brugerId;
    }

    public long getLoginId() {
        return loginId;
    }

    public void setLoginId(long loginId) {
        this.loginId = loginId;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BrugerType getBrugerId() {
        return brugerId;
    }

    public void setBrugerId(BrugerType brugerId) {
        this.brugerId = brugerId;
    }
}
