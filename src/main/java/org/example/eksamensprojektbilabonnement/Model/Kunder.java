package org.example.eksamensprojektbilabonnement.Model;

import java.time.LocalDate;


public class Kunder
{
    private Long kundeId;
    private String fornavn;
    private String efternavn;
    private LocalDate fDag;
    private int postNr;
    private String adresse;
    private String email;
    private String tlfNr;

    public Kunder(Long kundeId, String fornavn, String efternavn, LocalDate fDag, int postNr, String email, String tlfNr, String adresse) {
        this.kundeId = kundeId;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.fDag = fDag;
        this.postNr = postNr;
        this.email = email;
        this.tlfNr = tlfNr;
        this.adresse = adresse;
    }

    public Kunder() {

    }

    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
    }

    public Long getKundeId() {
        return kundeId;
    }

    public LocalDate getFDag() {
        return fDag;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public String getEmail() {
        return email;
    }

    public int getPostNr() {
        return postNr;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFDag(LocalDate fDag) {
        this.fDag = fDag;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public void setPostNr(int postNr) {
        this.postNr = postNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }
}