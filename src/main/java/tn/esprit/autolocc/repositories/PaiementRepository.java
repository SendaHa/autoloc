package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocc.entities.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}