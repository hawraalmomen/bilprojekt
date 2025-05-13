package org.example.bilabonnement.Repository;

import org.example.bilabonnement.Model.Bil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilRepo extends JpaRepository<Bil, Long> {

}