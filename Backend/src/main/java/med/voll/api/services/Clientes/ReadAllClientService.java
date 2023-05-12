package med.voll.api.services.Clientes;

import lombok.RequiredArgsConstructor;
import med.voll.api.models.Client;
import med.voll.api.models.Project;
import med.voll.api.repositories.ClientRepository;
import med.voll.api.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadAllClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> execute(){
        List<Client> clientes = (List<Client>) clientRepository.findAll();
        return clientes;
    }

}