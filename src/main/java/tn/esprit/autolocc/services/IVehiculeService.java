package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Vehicule;
import java.util.List;
import java.util.Optional;

public interface IVehiculeService {
    Vehicule ajouter(Vehicule vehicule);
    Optional<Vehicule> recupererParId(Long idVehicule);
    List<Vehicule> recupererTous();
    Vehicule modifier(Vehicule vehicule);
    void supprimer(Long idVehicule);
}