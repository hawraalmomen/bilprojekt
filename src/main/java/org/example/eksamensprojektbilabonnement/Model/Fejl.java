package org.example.eksamensprojektbilabonnement.Model;

import java.math.BigDecimal;


public class Fejl
{
    private Long fejlId;
    private Long tilstandsrapport;
    private String beskrivelse;
    private BigDecimal pris;


    public Fejl(){}

    public Fejl(Long fejlId, Long tilstandsrapport, String beskrivelse, BigDecimal pris)
    {
        this.fejlId = fejlId;
        this.tilstandsrapport = tilstandsrapport;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
    }


    public Long getFejlId()
    {
        return fejlId;
    }
    public void setFejlId(Long fejlId)
    {
        this.fejlId = fejlId;
    }

    public Long getTilstandsrapport(){return tilstandsrapport;}
    public void setTilstandsrapport(Long tilstandsrapport){this.tilstandsrapport = tilstandsrapport;}

    public String getBeskrivelse()
    {
        return beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse)
    {
        this.beskrivelse = beskrivelse;
    }

    public BigDecimal getPris()
    {
        return pris;
    }
    public void setPris(BigDecimal pris)
    {
        this.pris = pris;
    }

}


















    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fejlId;

    @ManyToOne
    @JoinColumn(name = "tilstandsrapport_id")
    private TilstandsRapport tilstandsrapport;

    private String beskrivelse;

    private BigDecimal pris;


    public Fejl(){}

    public Fejl(Long fejlId, String beskrivelse, BigDecimal pris)
    {
        this.fejlId = fejlId;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
    }


    public Long getFejlId()
    {
        return fejlId;
    }

    public void setFejlId(Long fejlId)
    {
        this.fejlId = fejlId;
    }


    public String getBeskrivelse()
    {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse)
    {
        this.beskrivelse = beskrivelse;
    }

    public BigDecimal getPris()
    {
        return pris;
    }

    public void setPris(BigDecimal pris)
    {
        this.pris = pris;
    }

}
*/