package org.example.eksamensprojektbilabonnement.Model;

import jakarta.persistence.*;

@Entity
public class Bil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bil_id")
    private int bilId;

    private String brand;
    private String model;
    private String nummerPlade;
    private String stelNummer;
    private double pris;
    private String currentStatus;
    private int produktionAar;
    private String braendstoftype;

    public Bil() {}

    public Bil(String brand, String model, String nummerPlade, String stelNummer, double pris, String currentStatus, int produktionAar, String braendstoftype) {
        this.brand = brand;
        this.model = model;
        this.nummerPlade = nummerPlade;
        this.stelNummer = stelNummer;
        this.pris = pris;
        this.currentStatus = currentStatus;
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

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
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
