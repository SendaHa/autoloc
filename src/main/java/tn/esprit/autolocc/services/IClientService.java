package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Client;
import java.util.List;
import java.util.Optional;

public interface IClientService {
    Client ajouter(Client client);
    Optional<Client> recupererParId(Long idClient);
    List<Client> recupererTous();
    Client modifier(Client client);
    void supprimer(Long idClient);
}