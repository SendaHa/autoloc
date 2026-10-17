package tn.esprit.autolocc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocc.Services.IEquipementService;
import tn.esprit.autolocc.entities.Equipement;
import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {
    private final IEquipementService equipementService;
    public EquipementController(IEquipementService equipementService) { this.equipementService = equipementService; }
    @PostMapping public ResponseEntity<Equipement> ajouter(@RequestBody Equipement equipement) { return ResponseEntity.ok(equipementService.ajouter(equipement)); }
    @GetMapping public List<Equipement> recupererTous() { return equipementService.recupererTous(); }
    @GetMapping("/{id}") public ResponseEntity<Equipement> recupererParId(@PathVariable Long id) { return equipementService.recupererParId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PutMapping("/{id}") public ResponseEntity<Equipement> modifier(@PathVariable Long id, @RequestBody Equipement equipement) { if (equipementService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); equipement.setIdEquipement(id); return ResponseEntity.ok(equipementService.modifier(equipement)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) { if (equipementService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); equipementService.supprimer(id); return ResponseEntity.noContent().build(); }
}