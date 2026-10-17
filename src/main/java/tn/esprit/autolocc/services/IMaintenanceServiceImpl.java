package tn.esprit.autolocc.Services;

import org.springframework.stereotype.Service;
import tn.esprit.autolocc.entities.Maintenance;
import tn.esprit.autolocc.repositories.MaintenanceRepository;
import java.util.List;
import java.util.Optional;

@Service
public class IMaintenanceServiceImpl implements IMaintenanceService {
    private final MaintenanceRepository maintenanceRepository;
    public IMaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) { this.maintenanceRepository = maintenanceRepository; }
    public Maintenance ajouter(Maintenance maintenance) { return maintenanceRepository.save(maintenance); }
    public Optional<Maintenance> recupererParId(Long idMaintenance) { return maintenanceRepository.findById(idMaintenance); }
    public List<Maintenance> recupererTous() { return maintenanceRepository.findAll(); }
    public Maintenance modifier(Maintenance maintenance) { return maintenanceRepository.save(maintenance); }
    public void supprimer(Long idMaintenance) { maintenanceRepository.deleteById(idMaintenance); }
}