package tn.esprit.autolocc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocc.Services.IAgenceService;
import tn.esprit.autolocc.entities.Agence;
import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {
    private final IAgenceService agenceService;
    public AgenceController(IAgenceService agenceService) { this.agenceService = agenceService; }
    @PostMapping public ResponseEntity<Agence> ajouter(@RequestBody Agence agence) { return ResponseEntity.ok(agenceService.ajouter(agence)); }
    @GetMapping public List<Agence> recupererTous() { return agenceService.recupererTous(); }
    @GetMapping("/{id}") public ResponseEntity<Agence> recupererParId(@PathVariable Long id) { return agenceService.recupererParId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PutMapping("/{id}") public ResponseEntity<Agence> modifier(@PathVariable Long id, @RequestBody Agence agence) { if (agenceService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); agence.setIdAgence(id); return ResponseEntity.ok(agenceService.modifier(agence)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) { if (agenceService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); agenceService.supprimer(id); return ResponseEntity.noContent().build(); }
}