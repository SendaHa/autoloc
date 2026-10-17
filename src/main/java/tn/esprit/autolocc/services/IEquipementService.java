package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Equipement;
import java.util.List;
import java.util.Optional;

public interface IEquipementService {
    Equipement ajouter(Equipement equipement);
    Optional<Equipement> recupererParId(Long idEquipement);
    List<Equipement> recupererTous();
    Equipement modifier(Equipement equipement);
    void supprimer(Long idEquipement);
}