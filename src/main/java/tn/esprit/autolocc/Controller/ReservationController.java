package tn.esprit.autolocc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocc.Services.IReservationService;
import tn.esprit.autolocc.entities.Reservation;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final IReservationService reservationService;
    public ReservationController(IReservationService reservationService) { this.reservationService = reservationService; }
    @PostMapping public ResponseEntity<Reservation> ajouter(@RequestBody Reservation reservation) { return ResponseEntity.ok(reservationService.ajouter(reservation)); }
    @GetMapping public List<Reservation> recupererTous() { return reservationService.recupererTous(); }
    @GetMapping("/{id}") public ResponseEntity<Reservation> recupererParId(@PathVariable Long id) { return reservationService.recupererParId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PutMapping("/{id}") public ResponseEntity<Reservation> modifier(@PathVariable Long id, @RequestBody Reservation reservation) { if (reservationService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); reservation.setIdReservation(id); return ResponseEntity.ok(reservationService.modifier(reservation)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) { if (reservationService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); reservationService.supprimer(id); return ResponseEntity.noContent().build(); }
}