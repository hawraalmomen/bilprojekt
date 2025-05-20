package org.example.eksamensprojektbilabonnement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "brugertype")
public class BrugerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brugertype_id") // ✅ match the actual column in MySQL!
    private long brugerTypeId;

    @Column(name = "brugertype_navn") // optional: match your real MySQL column
    private String brugerTypeNavn;

    BrugerType(long brugerTypeId, String brugerTypeNavn) {
        this.brugerTypeId = brugerTypeId;
        this.brugerTypeNavn = brugerTypeNavn;
    }

    public BrugerType() {

    }

    public long getBrugerTypeId() {
        return brugerTypeId;
    }

    public String getBrugerTypeNavn() {
        return brugerTypeNavn;
    }
}
