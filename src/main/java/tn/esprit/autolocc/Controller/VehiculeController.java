package tn.esprit.autolocc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocc.Services.IVehiculeService;
import tn.esprit.autolocc.entities.Vehicule;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {
    private final IVehiculeService vehiculeService;
    public VehiculeController(IVehiculeService vehiculeService) { this.vehiculeService = vehiculeService; }
    @PostMapping public ResponseEntity<Vehicule> ajouter(@RequestBody Vehicule vehicule) { return ResponseEntity.ok(vehiculeService.ajouter(vehicule)); }
    @GetMapping public List<Vehicule> recupererTous() { return vehiculeService.recupererTous(); }
    @GetMapping("/{id}") public ResponseEntity<Vehicule> recupererParId(@PathVariable Long id) { return vehiculeService.recupererParId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PutMapping("/{id}") public ResponseEntity<Vehicule> modifier(@PathVariable Long id, @RequestBody Vehicule vehicule) { if (vehiculeService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); vehicule.setIdVehicule(id); return ResponseEntity.ok(vehiculeService.modifier(vehicule)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) { if (vehiculeService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); vehiculeService.supprimer(id); return ResponseEntity.noContent().build(); }
}