package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocc.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
}