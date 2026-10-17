package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Maintenance;
import java.util.List;
import java.util.Optional;

public interface IMaintenanceService {
    Maintenance ajouter(Maintenance maintenance);
    Optional<Maintenance> recupererParId(Long idMaintenance);
    List<Maintenance> recupererTous();
    Maintenance modifier(Maintenance maintenance);
    void supprimer(Long idMaintenance);
}