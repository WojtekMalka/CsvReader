package pl.WojtekMalka.csvReader.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.WojtekMalka.csvReader.DTO.ClientDTO;
import pl.WojtekMalka.csvReader.entity.Client;
import pl.WojtekMalka.csvReader.service.ClientService;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientControllerREST {
    private final ClientService clientService;

    @GetMapping("/countAll")
    ResponseEntity<Long> countAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientsNumber());
    }

    @GetMapping("/getAll")
    ResponseEntity<List<ClientDTO>> readAllClients() {
        if (clientService.getAllClients().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients());
    }

    @GetMapping("/getClientsListSortedByAge")
    ResponseEntity<List<ClientDTO>> getClientsListSortedByAge() {
        if (clientService.getClientsListSortedByAge().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientsListSortedByAge());
    }

    @GetMapping("/getOldestClient")
    ResponseEntity<ClientDTO> getOldestClient() {
        if (Objects.isNull(clientService.getOldestClient())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getOldestClient());
    }
}

