package tn.esprit.autolocc.Services;

import org.springframework.stereotype.Service;
import tn.esprit.autolocc.entities.Contrat;
import tn.esprit.autolocc.repositories.ContratRepository;
import java.util.List;
import java.util.Optional;

@Service
public class IContratServiceImpl implements IContratService {
    private final ContratRepository contratRepository;
    public IContratServiceImpl(ContratRepository contratRepository) { this.contratRepository = contratRepository; }
    public Contrat ajouter(Contrat contrat) { return contratRepository.save(contrat); }
    public Optional<Contrat> recupererParId(Long idContrat) { return contratRepository.findById(idContrat); }
    public List<Contrat> recupererTous() { return contratRepository.findAll(); }
    public Contrat modifier(Contrat contrat) { return contratRepository.save(contrat); }
    public void supprimer(Long idContrat) { contratRepository.deleteById(idContrat); }
}