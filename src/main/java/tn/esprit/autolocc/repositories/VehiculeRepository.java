package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocc.entities.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}