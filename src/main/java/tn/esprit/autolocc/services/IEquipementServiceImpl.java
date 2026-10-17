package tn.esprit.autolocc.Services;

import org.springframework.stereotype.Service;
import tn.esprit.autolocc.entities.Equipement;
import tn.esprit.autolocc.repositories.EquipementRepository;
import java.util.List;
import java.util.Optional;

@Service
public class IEquipementServiceImpl implements IEquipementService {
    private final EquipementRepository equipementRepository;
    public IEquipementServiceImpl(EquipementRepository equipementRepository) { this.equipementRepository = equipementRepository; }
    public Equipement ajouter(Equipement equipement) { return equipementRepository.save(equipement); }
    public Optional<Equipement> recupererParId(Long idEquipement) { return equipementRepository.findById(idEquipement); }
    public List<Equipement> recupererTous() { return equipementRepository.findAll(); }
    public Equipement modifier(Equipement equipement) { return equipementRepository.save(equipement); }
    public void supprimer(Long idEquipement) { equipementRepository.deleteById(idEquipement); }
}