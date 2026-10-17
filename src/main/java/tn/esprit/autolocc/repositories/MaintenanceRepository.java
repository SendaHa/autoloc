package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocc.entities.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}