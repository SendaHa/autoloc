package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Employe;
import java.util.List;
import java.util.Optional;

public interface IEmployeService {
    Employe ajouter(Employe employe);
    Optional<Employe> recupererParId(Long idEmploye);
    List<Employe> recupererTous();
    Employe modifier(Employe employe);
    void supprimer(Long idEmploye);
}