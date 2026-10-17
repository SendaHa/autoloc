package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Agence;
import java.util.List;
import java.util.Optional;

public interface IAgenceService {
    Agence ajouter(Agence agence);
    Optional<Agence> recupererParId(Long idAgence);
    List<Agence> recupererTous();
    Agence modifier(Agence agence);
    void supprimer(Long idAgence);
}