package org.example.eksamensprojektbilabonnement.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Bil {

    public enum BilStatus{
        Klar, Udlejet, Skadet
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bil_id")
    private int bilId;

    @Enumerated(EnumType.STRING)
    private BilStatus bilStatus;



    private String brand;
    private String model;
    private String nummerPlade;
    private String stelNummer;
    private BigDecimal pris;

    private int produktionAar;
    private String braendstoftype;

    public Bil() {}

    public Bil(String brand, String model, String nummerPlade, String stelNummer, BigDecimal pris, BilStatus bilStatus, int produktionAar, String braendstoftype) {
        this.brand = brand;
        this.model = model;
        this.nummerPlade = nummerPlade;
        this.stelNummer = stelNummer;
        this.pris = pris;
        this.bilStatus = bilStatus;
        this.produktionAar = produktionAar;
        this.braendstoftype = braendstoftype;
    }

    public int getBilId() {
        return bilId;
    }

    public void setBilId(int bilId) {
        this.bilId = bilId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNummerPlade() {
        return nummerPlade;
    }

    public void setNummerPlade(String nummerPlade) {
        this.nummerPlade = nummerPlade;
    }

    public String getStelNummer() {
        return stelNummer;
    }

    public void setStelNummer(String stelNummer) {
        this.stelNummer = stelNummer;
    }

    public BigDecimal getPris() {
        return pris;
    }

    public void setPris(BigDecimal pris) {
        this.pris = pris;
    }
    public BilStatus getBilStatus() {
        return bilStatus;
    }

    public void setBilStatus(BilStatus bilStatus) {
        this.bilStatus = bilStatus;
    }

    public int getProduktionAar() {
        return produktionAar;
    }

    public void setProduktionAar(int produktionAar) {
        this.produktionAar = produktionAar;
    }

    public String getBraendstoftype() {
        return braendstoftype;
    }

    public void setBraendstoftype(String braendstoftype) {
        this.braendstoftype = braendstoftype;
    }
}
