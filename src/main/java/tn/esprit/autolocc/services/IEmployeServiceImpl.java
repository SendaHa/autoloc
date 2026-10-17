package tn.esprit.autolocc.Services;

import org.springframework.stereotype.Service;
import tn.esprit.autolocc.entities.Employe;
import tn.esprit.autolocc.repositories.EmployeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class IEmployeServiceImpl implements IEmployeService {
    private final EmployeRepository employeRepository;
    public IEmployeServiceImpl(EmployeRepository employeRepository) { this.employeRepository = employeRepository; }
    public Employe ajouter(Employe employe) { return employeRepository.save(employe); }
    public Optional<Employe> recupererParId(Long idEmploye) { return employeRepository.findById(idEmploye); }
    public List<Employe> recupererTous() { return employeRepository.findAll(); }
    public Employe modifier(Employe employe) { return employeRepository.save(employe); }
    public void supprimer(Long idEmploye) { employeRepository.deleteById(idEmploye); }
}