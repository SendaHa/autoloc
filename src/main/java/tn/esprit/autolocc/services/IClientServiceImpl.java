package tn.esprit.autolocc.Services;

import org.springframework.stereotype.Service;
import tn.esprit.autolocc.entities.Client;
import tn.esprit.autolocc.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;

@Service
public class IClientServiceImpl implements IClientService {
    private final ClientRepository clientRepository;
    public IClientServiceImpl(ClientRepository clientRepository) { this.clientRepository = clientRepository; }
    public Client ajouter(Client client) { return clientRepository.save(client); }
    public Optional<Client> recupererParId(Long idClient) { return clientRepository.findById(idClient); }
    public List<Client> recupererTous() { return clientRepository.findAll(); }
    public Client modifier(Client client) { return clientRepository.save(client); }
    public void supprimer(Long idClient) { clientRepository.deleteById(idClient); }
}