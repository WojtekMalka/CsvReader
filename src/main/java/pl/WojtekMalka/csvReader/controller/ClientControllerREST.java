package pl.WojtekMalka.csvReader.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.WojtekMalka.csvReader.entity.Client;
import pl.WojtekMalka.csvReader.repository.ClientRepository;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientControllerREST {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientControllerREST.class);

    private final ClientRepository clientRepository;

    public ClientControllerREST(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Client>> readAllClients() {
        if (clientRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientRepository.findAll());
    }
//
//    @GetMapping("/sortedByAge")
//    ResponseEntity<List<Client>> readAllClientsSortedByAge() {
//        if (clientRepository.findByBirth_dateByOOrderByBirth_date().isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(clientRepository.findByBirth_dateByOOrderByBirth_date());
//    }
//
//    @GetMapping("/count")
//    ResponseEntity<Integer> countClients() {
//        return ResponseEntity.ok(clientRepository.countClientByClientId());
//    }
//
//    @GetMapping("/getClientOrderByAgeAndNotNullPhone")
//    ResponseEntity<Client> getClientOrderByAgeAndNotNullPhone() {
//        if (Objects.isNull(clientRepository.findClientByBirth_dateAndPhone_noIsNotNull())) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(clientRepository.findClientByBirth_dateAndPhone_noIsNotNull());
//    }
}

