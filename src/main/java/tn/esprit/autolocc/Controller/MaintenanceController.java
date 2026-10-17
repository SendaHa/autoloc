package tn.esprit.autolocc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocc.Services.IMaintenanceService;
import tn.esprit.autolocc.entities.Maintenance;
import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;
    public MaintenanceController(IMaintenanceService maintenanceService) { this.maintenanceService = maintenanceService; }
    @PostMapping public ResponseEntity<Maintenance> ajouter(@RequestBody Maintenance maintenance) { return ResponseEntity.ok(maintenanceService.ajouter(maintenance)); }
    @GetMapping public List<Maintenance> recupererTous() { return maintenanceService.recupererTous(); }
    @GetMapping("/{id}") public ResponseEntity<Maintenance> recupererParId(@PathVariable Long id) { return maintenanceService.recupererParId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PutMapping("/{id}") public ResponseEntity<Maintenance> modifier(@PathVariable Long id, @RequestBody Maintenance maintenance) { if (maintenanceService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); maintenance.setIdMaintenance(id); return ResponseEntity.ok(maintenanceService.modifier(maintenance)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) { if (maintenanceService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); maintenanceService.supprimer(id); return ResponseEntity.noContent().build(); }
}