package org.example.eksamensprojektbilabonnement.Model;

import java.time.LocalDate;

public class TilstandsRapport
{
    private Long tilstandsrapportId;
    private Long lejeaftaleId;
    private LocalDate dato;

    public TilstandsRapport(){}

    public TilstandsRapport(Long tilstandsrapportId, Long lejeaftaleId, LocalDate dato)
    {
        this.tilstandsrapportId = tilstandsrapportId;
        this.lejeaftaleId = lejeaftaleId;
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

    public LocalDate getDato()
    {
        return dato;
    }
    public void setDato(LocalDate dato)
    {
        this.dato = dato;
    }


}