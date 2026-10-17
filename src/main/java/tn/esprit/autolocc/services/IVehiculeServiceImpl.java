package tn.esprit.autolocc.Services;

import org.springframework.stereotype.Service;
import tn.esprit.autolocc.entities.Vehicule;
import tn.esprit.autolocc.repositories.VehiculeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class IVehiculeServiceImpl implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    public IVehiculeServiceImpl(VehiculeRepository vehiculeRepository) { this.vehiculeRepository = vehiculeRepository; }
    public Vehicule ajouter(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public Optional<Vehicule> recupererParId(Long idVehicule) { return vehiculeRepository.findById(idVehicule); }
    public List<Vehicule> recupererTous() { return vehiculeRepository.findAll(); }
    public Vehicule modifier(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public void supprimer(Long idVehicule) { vehiculeRepository.deleteById(idVehicule); }
}