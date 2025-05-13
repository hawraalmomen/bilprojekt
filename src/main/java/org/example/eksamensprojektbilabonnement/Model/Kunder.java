package org.example.eksamensprojektbilabonnement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
public class Kunder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kundeId;

    private String fornavn;
    private String efternavn;
    private LocalDate fDag;
    private String postNr;
    private String email;
    private String tlfNr;
    private String addresse;

    public Kunder(Long kundeId, String fornavn, String efternavn, LocalDate fDag, String postNr, String email, String tlfNr, String addresse) {
        this.kundeId = kundeId;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.fDag = fDag;
        this.postNr = postNr;
        this.email = email;
        this.tlfNr = tlfNr;
        this.addresse = addresse;
    }

    public Kunder() {

    }

    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
    }

    public Long getKundeId() {
        return kundeId;
    }

    public LocalDate getfDag() {
        return fDag;
    }

    public String getAddresse() {
        return addresse;
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

    public String getPostNr() {
        return postNr;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setfDag(LocalDate fDag) {
        this.fDag = fDag;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public void setPostNr(String postNr) {
        this.postNr = postNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }
}
