package tn.esprit.autolocc.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocc.Services.IClientService;
import tn.esprit.autolocc.entities.Client;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final IClientService clientService;
    public ClientController(IClientService clientService) { this.clientService = clientService; }
    @PostMapping public ResponseEntity<Client> ajouter(@RequestBody Client client) { return ResponseEntity.ok(clientService.ajouter(client)); }
    @GetMapping public List<Client> recupererTous() { return clientService.recupererTous(); }
    @GetMapping("/{id}") public ResponseEntity<Client> recupererParId(@PathVariable Long id) { return clientService.recupererParId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PutMapping("/{id}") public ResponseEntity<Client> modifier(@PathVariable Long id, @RequestBody Client client) { if (clientService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); client.setIdClient(id); return ResponseEntity.ok(clientService.modifier(client)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) { if (clientService.recupererParId(id).isEmpty()) return ResponseEntity.notFound().build(); clientService.supprimer(id); return ResponseEntity.noContent().build(); }
}