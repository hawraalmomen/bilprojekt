package org.example.eksamensprojektbilabonnement.Model;

public class Login {

    private long loginId;

    private String brugernavn;
    private String kodeord;

    private BrugerType brugerId;

    public Login() {}

    public Login(long loginId, String brugernavn, String kodeord, BrugerType brugerId) {
        this.loginId = loginId;
        this.brugernavn = brugernavn;
        this.kodeord = kodeord;
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

    public String getKodeord() {
        return kodeord;
    }

    public void setKodeord(String kodeord) {
        this.kodeord = kodeord;
    }

    public BrugerType getBrugerId() {
        return brugerId;
    }

    public void setBrugerId(BrugerType brugerId) {
        this.brugerId = brugerId;
    }
}
