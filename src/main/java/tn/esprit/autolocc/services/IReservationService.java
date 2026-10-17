package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    Reservation ajouter(Reservation reservation);
    Optional<Reservation> recupererParId(Long idReservation);
    List<Reservation> recupererTous();
    Reservation modifier(Reservation reservation);
    void supprimer(Long idReservation);
}