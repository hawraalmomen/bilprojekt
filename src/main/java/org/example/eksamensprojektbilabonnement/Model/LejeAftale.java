package org.example.eksamensprojektbilabonnement.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class LejeAftale
{
    private Long lejeaftaleId;
    private Long kundeId;
    private Long bilId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDato;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate slutDato;


    public LejeAftale() {}

    public LejeAftale(Long lejeaftaleId, Long kundeId, Long bilId, LocalDate startDato, LocalDate slutDato) {
        this.lejeaftaleId = lejeaftaleId;
        this.kundeId = kundeId;
        this.bilId = bilId;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    // Getters og Setters
    public Long getLejeaftaleId() {
        return lejeaftaleId;
    }

    public void setLejeaftaleId(Long lejeaftaleId) {
        this.lejeaftaleId = lejeaftaleId;
    }

    public Long getKundeId() {
        return kundeId;
    }

    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
    }

    public Long getBilId() {
        return bilId;
    }

    public void setBilId(Long bilId) {
        this.bilId = bilId;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }
}