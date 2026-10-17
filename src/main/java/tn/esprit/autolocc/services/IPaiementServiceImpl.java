package tn.esprit.autolocc.Services;

import org.springframework.stereotype.Service;
import tn.esprit.autolocc.entities.Paiement;
import tn.esprit.autolocc.repositories.PaiementRepository;
import java.util.List;
import java.util.Optional;

@Service
public class IPaiementServiceImpl implements IPaiementService {
    private final PaiementRepository paiementRepository;
    public IPaiementServiceImpl(PaiementRepository paiementRepository) { this.paiementRepository = paiementRepository; }
    public Paiement ajouter(Paiement paiement) { return paiementRepository.save(paiement); }
    public Optional<Paiement> recupererParId(Long idPaiement) { return paiementRepository.findById(idPaiement); }
    public List<Paiement> recupererTous() { return paiementRepository.findAll(); }
    public Paiement modifier(Paiement paiement) { return paiementRepository.save(paiement); }
    public void supprimer(Long idPaiement) { paiementRepository.deleteById(idPaiement); }
}