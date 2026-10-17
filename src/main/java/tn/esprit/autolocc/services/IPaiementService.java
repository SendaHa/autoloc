package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Paiement;
import java.util.List;
import java.util.Optional;

public interface IPaiementService {
    Paiement ajouter(Paiement paiement);
    Optional<Paiement> recupererParId(Long idPaiement);
    List<Paiement> recupererTous();
    Paiement modifier(Paiement paiement);
    void supprimer(Long idPaiement);
}