package org.example.eksamensprojektbilabonnement.Service;

import org.example.eksamensprojektbilabonnement.Model.LejeAftale;
import org.example.eksamensprojektbilabonnement.Repository.LejeAftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LejeAftaleService
{
    @Autowired
    private LejeAftaleRepo lejeAftaleRepo;

    // opret lejeaftale
    public void opretLejeaftale(LejeAftale lejeaftale)
    {
        lejeAftaleRepo.opretLejeaftale(lejeaftale);
    }


    // hent alle lejeaftaler
    public List<LejeAftale> hentAlleLejeaftaler()
    {
        return lejeAftaleRepo.hentAlleLejeaftaler();
    }


    // slet lejeaftale
    public void sletLejeaftale(Long id)
    {
        lejeAftaleRepo.sletLejeaftale(id);
    }


    // hent lejeaftale med ID
    public LejeAftale hentLejeaftaleMedId(Long id)
    {
        return lejeAftaleRepo.hentLejeaftaleMedId(id);
    }


    // opdater lejeaftale
    public void opdaterLejeaftale(LejeAftale lejeAftale)
    {
        lejeAftaleRepo.opdaterLejeaftale(lejeAftale);
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

    public long getAntalLejetBiler(){
        return lejeAftaleRepo.count();
    }
}





    // hent lejeaftaler
    public Map<Long, LejeAftale> hentLejeaftaler()
    {
        List<LejeAftale> lejeaftaler = LejeAftaleRepo.hentAlleLejeaftaler();

        Map<Long, LejeAftale> map = new HashMap<>();
        for(LejeAftale l : lejeaftaler)
        {
            map.put(l.getLejeaftaleId(), l);
        }

        return map;
    }

*/