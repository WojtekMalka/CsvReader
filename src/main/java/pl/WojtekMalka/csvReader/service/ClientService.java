package pl.WojtekMalka.csvReader.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.WojtekMalka.csvReader.DTO.ClientDTO;
import pl.WojtekMalka.csvReader.entity.Client;
import pl.WojtekMalka.csvReader.repository.ClientRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {
    private static final ModelMapper modelMapper = new ModelMapper();
    private final ClientRepository clientRepository;

    public void save(MultipartFile file) {
        try {
            clientRepository.saveAll(creatClientsFromCSVFile(file));
        } catch (IOException e) {
            throw new RuntimeException("Fail to store csv data: " + e.getMessage());
        }
    }

    private List<Client> creatClientsFromCSVFile(MultipartFile file) throws IOException {
        return FileReader.readCSV(file.getInputStream());
    }

    public long getClientsNumber() {
        return clientRepository.count();
    }

    public List<ClientDTO> getAllClients() {
        return ((List<Client>) clientRepository.findAll())
                .stream()
                .map(this::mapClientToClientDTO)
                .collect(Collectors.toList());
    }

    private ClientDTO mapClientToClientDTO(Client client) {
        ClientDTO clientDTO = modelMapper
                .map(client, ClientDTO.class);
        return clientDTO;
    }
}