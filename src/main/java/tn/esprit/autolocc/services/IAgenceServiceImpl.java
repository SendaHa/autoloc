package tn.esprit.autolocc.Services;

import org.springframework.stereotype.Service;
import tn.esprit.autolocc.entities.Agence;
import tn.esprit.autolocc.repositories.AgenceRepository;
import java.util.List;
import java.util.Optional;

@Service
public class IAgenceServiceImpl implements IAgenceService {
    private final AgenceRepository agenceRepository;
    public IAgenceServiceImpl(AgenceRepository agenceRepository) { this.agenceRepository = agenceRepository; }
    public Agence ajouter(Agence agence) { return agenceRepository.save(agence); }
    public Optional<Agence> recupererParId(Long idAgence) { return agenceRepository.findById(idAgence); }
    public List<Agence> recupererTous() { return agenceRepository.findAll(); }
    public Agence modifier(Agence agence) { return agenceRepository.save(agence); }
    public void supprimer(Long idAgence) { agenceRepository.deleteById(idAgence); }
}