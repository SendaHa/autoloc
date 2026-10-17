package tn.esprit.autolocc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocc.Services.IPaiementService;
import tn.esprit.autolocc.entities.Paiement;
import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {
    private final IPaiementService paiementService;
    public PaiementController(IPaiementService paiementService) { this.paiementService = paiementService; }
    @PostMapping public ResponseEntity<Paiement> ajouter(@RequestBody Paiement paiement) { return ResponseEntity.ok(paiementService.ajouter(paiement)); }
    @GetMapping public List<Paiement> recupererTous() { return paiementService.recupererTous(); }
    @GetMapping("/{id}") public ResponseEntity<Paiement> recupererParId(@PathVariable Long id) { return paiementService.recupererParId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PutMapping("/{id}") public ResponseEntity<Paiement> modifier(@PathVariable Long id, @RequestBody Paiement paiement) { if (paiementService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); paiement.setIdPaiement(id); return ResponseEntity.ok(paiementService.modifier(paiement)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) { if (paiementService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); paiementService.supprimer(id); return ResponseEntity.noContent().build(); }
}