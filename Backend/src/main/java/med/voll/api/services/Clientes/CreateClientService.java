package med.voll.api.services.Clientes;

import lombok.RequiredArgsConstructor;
import med.voll.api.dtos.ClientDTOS.CreateClientDTO;
import med.voll.api.models.Client;
import med.voll.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("clients")
public class CreateClientService {


    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(CreateClientDTO clientDTO) {
       Client saved = clientRepository.save(new Client(clientDTO));
       return saved;
    }

}
