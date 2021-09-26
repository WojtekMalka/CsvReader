package pl.WojtekMalka.csvReader.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.WojtekMalka.csvReader.entity.Client;
import pl.WojtekMalka.csvReader.repository.ClientRepository;

import java.io.IOException;
import java.util.List;

@Service
public class ClientService {

    ClientRepository clientRepository;

    public void save(MultipartFile file) {
        try {
            List<Client> clients = FileReader.readCSVToClient(file.getInputStream());
            clientRepository.saveAll(clients);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}