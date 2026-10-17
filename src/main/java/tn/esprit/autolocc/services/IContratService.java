package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Contrat;
import java.util.List;
import java.util.Optional;

public interface IContratService {
    Contrat ajouter(Contrat contrat);
    Optional<Contrat> recupererParId(Long idContrat);
    List<Contrat> recupererTous();
    Contrat modifier(Contrat contrat);
    void supprimer(Long idContrat);
}