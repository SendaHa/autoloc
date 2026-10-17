package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocc.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}