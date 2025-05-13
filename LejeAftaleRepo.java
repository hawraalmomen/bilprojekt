package org.example.bilabonnement.Repository;

import org.example.bilabonnement.Model.LejeAftale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LejeAftaleRepo extends JpaRepository<LejeAftale, Long> {

}
