package org.example.eksamensprojektbilabonnement.Model;

public class BrugerType {

    private long brugerTypeId;

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
