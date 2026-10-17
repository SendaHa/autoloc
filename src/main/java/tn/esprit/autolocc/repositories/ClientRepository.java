package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocc.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}