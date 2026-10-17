package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocc.entities.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}