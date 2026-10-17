package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocc.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}