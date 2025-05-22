package org.example.eksamensprojektbilabonnement.Model;

import java.time.LocalDate;

public class TilstandsRapport
{
    private Long tilstandsrapportId;
    private Long lejeaftaleId;
    private Long bilId;
    private Long kundeId;
    private LocalDate dato;


    public TilstandsRapport(){}

    public TilstandsRapport(Long tilstandsrapportId, Long lejeaftaleId, Long bilId, Long kundeId, LocalDate dato)
    {
        this.tilstandsrapportId = tilstandsrapportId;
        this.lejeaftaleId = lejeaftaleId;
        this.bilId = bilId;
        this.kundeId = kundeId;
        this.dato = dato;
    }


    // Getters og setters
    public long getTilstandsrapportId()
    {
        return tilstandsrapportId;
    }
    public void setTilstandsrapportId(Long tilstandsrapportId)
    {
        this.tilstandsrapportId = tilstandsrapportId;
    }


    public Long getLejeaftaleId()
    {
        return lejeaftaleId;
    }
    public void setLejeaftaleId(Long lejeaftaleId)
    {
        this.lejeaftaleId = lejeaftaleId;
    }

    public Long getBilId()
    {
        return bilId;
    }
    public void setBilId(Long bilId)
    {
        this.bilId = bilId;
    }

    public Long getKundeId()
    {
        return kundeId;
    }
    public void setKundeId(Long kundeId)
    {
        this.kundeId = kundeId;
    }

    public LocalDate getDato()
    {
        return dato;
    }
    public void setDato(LocalDate dato)
    {
        this.dato = dato;
    }


}
