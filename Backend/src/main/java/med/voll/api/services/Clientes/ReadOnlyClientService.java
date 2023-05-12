package med.voll.api.services.Clientes;

import lombok.RequiredArgsConstructor;
import med.voll.api.models.Client;
import med.voll.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReadOnlyClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client execute(Long id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        Client client = optionalClient.orElseThrow(() -> new RuntimeException("Não foi encontrado um cliente com o ID informado."));
        return client;
    }

}
