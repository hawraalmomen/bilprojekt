package org.example.bilabonnement.Model;

import jakarta.persistence.*;

@Entity
public class Bil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bilId;

    private String nummerPlade;
    private String stelNummer;
    private double pris;
    private String currentStatus;

}
