package org.example.eksamensprojektbilabonnement.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TilstandsRapport
{
    private Long tilstandsrapportId;
    private Long lejeaftaleId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dato;

    private List<Fejl> fejlListe = new ArrayList<>();

    public TilstandsRapport(){}

    public TilstandsRapport(Long tilstandsrapportId, Long lejeaftaleId, LocalDate dato, List<Fejl> fejlListe)
    {
        this.tilstandsrapportId = tilstandsrapportId;
        this.lejeaftaleId = lejeaftaleId;
        this.dato = dato;
        this.fejlListe = fejlListe;
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

    public List<Fejl> getFejlListe() {
        return fejlListe;
    }

    public void setFejlListe(List<Fejl> fejlListe) {
        this.fejlListe = fejlListe;
    }
}