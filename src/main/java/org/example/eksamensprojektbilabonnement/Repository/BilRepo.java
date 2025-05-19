package org.example.eksamensprojektbilabonnement.Repository;

import org.example.eksamensprojektbilabonnement.Model.Bil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilRepo extends JpaRepository<Bil, Long> {

}