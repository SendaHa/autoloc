package tn.esprit.autolocc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocc.Services.IEmployeService;
import tn.esprit.autolocc.entities.Employe;
import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    private final IEmployeService employeService;
    public EmployeController(IEmployeService employeService) { this.employeService = employeService; }
    @PostMapping public ResponseEntity<Employe> ajouter(@RequestBody Employe employe) { return ResponseEntity.ok(employeService.ajouter(employe)); }
    @GetMapping public List<Employe> recupererTous() { return employeService.recupererTous(); }
    @GetMapping("/{id}") public ResponseEntity<Employe> recupererParId(@PathVariable Long id) { return employeService.recupererParId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PutMapping("/{id}") public ResponseEntity<Employe> modifier(@PathVariable Long id, @RequestBody Employe employe) { if (employeService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); employe.setIdEmploye(id); return ResponseEntity.ok(employeService.modifier(employe)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) { if (employeService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); employeService.supprimer(id); return ResponseEntity.noContent().build(); }
}