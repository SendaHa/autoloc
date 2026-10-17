package tn.esprit.autolocc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocc.Services.IContratService;
import tn.esprit.autolocc.entities.Contrat;
import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {
    private final IContratService contratService;
    public ContratController(IContratService contratService) { this.contratService = contratService; }
    @PostMapping public ResponseEntity<Contrat> ajouter(@RequestBody Contrat contrat) { return ResponseEntity.ok(contratService.ajouter(contrat)); }
    @GetMapping public List<Contrat> recupererTous() { return contratService.recupererTous(); }
    @GetMapping("/{id}") public ResponseEntity<Contrat> recupererParId(@PathVariable Long id) { return contratService.recupererParId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PutMapping("/{id}") public ResponseEntity<Contrat> modifier(@PathVariable Long id, @RequestBody Contrat contrat) { if (contratService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); contrat.setIdContrat(id); return ResponseEntity.ok(contratService.modifier(contrat)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) { if (contratService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); contratService.supprimer(id); return ResponseEntity.noContent().build(); }
}