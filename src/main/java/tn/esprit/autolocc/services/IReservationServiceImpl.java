package tn.esprit.autolocc.Services;

import org.springframework.stereotype.Service;
import tn.esprit.autolocc.entities.Reservation;
import tn.esprit.autolocc.repositories.ReservationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class IReservationServiceImpl implements IReservationService {
    private final ReservationRepository reservationRepository;
    public IReservationServiceImpl(ReservationRepository reservationRepository) { this.reservationRepository = reservationRepository; }
    public Reservation ajouter(Reservation reservation) { return reservationRepository.save(reservation); }
    public Optional<Reservation> recupererParId(Long idReservation) { return reservationRepository.findById(idReservation); }
    public List<Reservation> recupererTous() { return reservationRepository.findAll(); }
    public Reservation modifier(Reservation reservation) { return reservationRepository.save(reservation); }
    public void supprimer(Long idReservation) { reservationRepository.deleteById(idReservation); }
}