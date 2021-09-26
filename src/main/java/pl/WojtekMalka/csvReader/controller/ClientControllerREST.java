package pl.WojtekMalka.csvReader.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.WojtekMalka.csvReader.entity.Client;
import pl.WojtekMalka.csvReader.message.ResponseMessage;
import pl.WojtekMalka.csvReader.repository.ClientRepository;
import pl.WojtekMalka.csvReader.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientControllerREST {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientControllerREST.class);

    ClientService clientService;

    @GetMapping("/getAll")
    ResponseEntity<List<Client>> readAllClients() {
        if (clientService.getAllClients().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients());
    }
}

