package org.example.eksamensprojektbilabonnement.Repository;

import org.example.eksamensprojektbilabonnement.Model.Kunder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface KunderRepo extends JpaRepository<Kunder, Long> {

}
