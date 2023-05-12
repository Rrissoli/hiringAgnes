package med.voll.api.services.Clientes;

import lombok.RequiredArgsConstructor;
import med.voll.api.dtos.ClientDTOS.CreateClientDTO;
import med.voll.api.models.Client;
import med.voll.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("clients")
public class DeleteClientService {
    @Autowired
    private ClientRepository clientRepository;
    public void delete(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        Client client = optionalClient.orElseThrow(() -> new RuntimeException("Não foi encontrado um cliente com o ID informado."));
        clientRepository.delete(client);
    }

}
