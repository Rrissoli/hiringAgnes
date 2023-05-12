package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dtos.ClientDTOS.CreateClientDTO;
import med.voll.api.models.Client;
import med.voll.api.repositories.ClientRepository;
import med.voll.api.services.Clientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("clients")
public class ClientController {

        @Autowired
        private ClientRepository clientRepository;
        @Autowired
        private CreateClientService services;

        @Autowired
        private ReadAllClientService readsAll;

        @Autowired
        private ReadOnlyClientService readOnly;


        @Autowired
        private DeleteClientService deleteClientService;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Client create(@RequestBody @Valid CreateClientDTO clientDTO){
            return services.createClient(clientDTO);
        }
        @GetMapping
        public List<Client> getAllBoards() {
                return readsAll.execute();
        }
        @GetMapping("{id}")
        public Client getById(@PathVariable String id) {
                return readOnly.execute(Long.valueOf(id));
        }

        @PatchMapping("{id}")
        public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientUpdates) {
                Optional<Client> optionalClient = clientRepository.findById(id);
                if (optionalClient.isEmpty()) {
                        return ResponseEntity.notFound().build();
                }
                Client client = optionalClient.get();
                if (clientUpdates.getName() != null ) {
                        clientRepository.updateClient(id, clientUpdates.getName());
                } else {
                        return ResponseEntity.badRequest().build();
                }
                return ResponseEntity.ok(clientRepository.findById(id).get());
        }

        @DeleteMapping("{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable String id) {
                deleteClientService.delete(Long.valueOf(id));
        }


}
