package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocc.entities.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
}