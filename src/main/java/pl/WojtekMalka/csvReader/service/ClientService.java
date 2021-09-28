package pl.WojtekMalka.csvReader.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.WojtekMalka.csvReader.DTO.ClientDTO;
import pl.WojtekMalka.csvReader.entity.Client;
import pl.WojtekMalka.csvReader.repository.ClientRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.YEARS;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void save(MultipartFile file) {
        try {
            List<Client> clients = FileReader.readCSVToClient(file.getInputStream());
            clientRepository.saveAll(clients);
        } catch (IOException e) {
            throw new RuntimeException("Fail to store csv data: " + e.getMessage());
        }
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public long getClientsNumber() {
        return clientRepository.count();
    }

    /*TODO
    *  zmienić na stream*/
    public List<ClientDTO> getClientsListSortedByAge() {
        List<Client> clientRepositoryAll = clientRepository.findAll();
        List<ClientDTO> result = new ArrayList<>();
        for (Client client : clientRepositoryAll) {
            ClientDTO clientDTOBuilder = ClientDTO.builder()
                    .first_name(client.getFirst_name())
                    .last_name(client.getLast_name())
                    .client_age(countClientAge(client.getBirth_date()))
                    .phone_no(client.getPhone_no()).build();
            result.add(clientDTOBuilder);
        }
        return result;
    }

    private int countClientAge(String birth_date) {
        return (int) YEARS.between(LocalDate.parse(birth_date, DateTimeFormatter.ofPattern("yyyy.MM.dd")), LocalDate.now());
    }
}