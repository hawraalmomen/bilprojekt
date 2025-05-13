package org.example.bilabonnement.Model;

import jakarta.persistence.*;
import org.example.bilabonnement.Repository.KunderRepo;

import java.time.LocalDate;

@Entity
@Table(name = "lejeaftale")
public class LejeAftale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lejeId;

    @ManyToOne
    @JoinColumn(name = "kunde_id")
    private Kunder kunde;

    @ManyToOne
    @JoinColumn(name = "bil_id")
    private Bil bil;

    private LocalDate startDato;
    private LocalDate slutDato;

    public LejeAftale(Long lejeId,Kunder kunde, Bil bil, LocalDate startDato, LocalDate slutDato){
        this.lejeId = lejeId;
        this.kunde = kunde;
        this.bil = bil;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public LejeAftale() {}

    public void setLejeId(Long lejeId) {
        this.lejeId = lejeId;
    }

    public Long getLejeId() {
        return lejeId;
    }

    public Kunder getKunde() {
        return kunde;
    }

    public void setKunde(Kunder kunde) {
        this.kunde = kunde;
    }

    public Bil getBil() {
        return bil;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }
}
