package org.example.bilabonnement.Repository;

import org.example.bilabonnement.Model.Kunder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface KunderRepo extends JpaRepository<Kunder, Long> {

}
