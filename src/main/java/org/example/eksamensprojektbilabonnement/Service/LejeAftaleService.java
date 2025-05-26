package org.example.eksamensprojektbilabonnement.Service;

import org.example.eksamensprojektbilabonnement.Model.Bil;
import org.example.eksamensprojektbilabonnement.Model.Kunder;
import org.example.eksamensprojektbilabonnement.Model.LejeAftale;
import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.example.eksamensprojektbilabonnement.Repository.KunderRepo;
import org.example.eksamensprojektbilabonnement.Repository.LejeAftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LejeAftaleService
{
    @Autowired
    private LejeAftaleRepo lejeAftaleRepo;
    @Autowired
    private KunderRepo kunderRepo;
    @Autowired
    private BilRepo bilRepo;

    // opret lejeaftaler
    public void opretLejeaftale(Long kundeId, Long bilId, LocalDate startDato, LocalDate slutDato)
    {
        LejeAftale aftale = new LejeAftale(null, kundeId, bilId, startDato, slutDato);
        lejeAftaleRepo.opretLejeaftale(aftale);
    }

    public Map<Long, LejeAftale> hentLejeaftaler()
    {
        List<LejeAftale> lejeaftaler = lejeAftaleRepo.hentAlleLejeaftaler();

        Map<Long, LejeAftale> map = new HashMap<>();
        for(LejeAftale l : lejeaftaler)
        {
            map.put(l.getLejeaftaleId(), l);
        }

        return map;
    }

    // controlleren kan foretage listevisning
    public List<LejeAftale> hentAlleLejeaftaler()
    {
        return lejeAftaleRepo.hentAlleLejeaftaler();
    }

    // slet lejeaftale
    public void sletLejeaftale(Long id)
    {
        lejeAftaleRepo.sletLejeaftale(id);
    }

    // hent lejeaftale til redigering
    public LejeAftale hentLejeaftaleMedId(Long id)
    {
        return lejeAftaleRepo.hentLejeaftaleMedId(id);
    }

    // opdatere en aftale
    public void opdaterLejeaftale(LejeAftale lejeAftale)
    {
        lejeAftaleRepo.opdaterLejeaftale(lejeAftale);
    }

    // Viser fornavn, efternavn og email i steden for ids
    public List<Map<String, Object>> hentLejeAftalerTilVisning(){
        List<LejeAftale> lejeAftaler =lejeAftaleRepo.hentAlleLejeaftaler();

        Map<Long, Kunder> kunder = kunderRepo.hentAlleKunder().stream()
                .collect(Collectors.toMap(Kunder::getKundeId, k -> k));

        Map<Long, Bil> biler = bilRepo.hentAlleBiler().stream()
                .collect(Collectors.toMap(Bil::getBilId, b -> b));

        List<Map<String, Object>> visningListe = new ArrayList<>();

        for (LejeAftale l : lejeAftaler) {
            Map<String, Object> map = new HashMap<>();
            map.put("lejeAftale", l);
            map.put("kunde", l.getKundeId());
            map.put("bil", l.getBilId());
            visningListe.add(map);
        }
        return visningListe;
    }

    public long getAntalLejetBiler(){
        return lejeAftaleRepo.hentAlleLejeaftaler().size();
    }
}




/*
// controlleren kan foretage listevisning
public List<LejeAftale> hentAlleLejeaftaler()
{
    return lejeAftaleRepo.hentAlleLejeaftaler();
}
*/





    /*
{
    @Autowired
    private LejeAftaleRepo lejeAftaleRepo;

    public LejeAftale createLejeAftale(Kunder kunder, Bil bil, LocalDate startDato, LocalDate slutDato){
        LejeAftale leje = new LejeAftale();
        leje.setBil(bil);
        leje.setStartDato(startDato);
        leje.setSlutDato(slutDato);

        return lejeAftaleRepo.save(leje);
    }


}
*/