package pl.WojtekMalka.csvReader.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.WojtekMalka.csvReader.entity.Client;
import pl.WojtekMalka.csvReader.repository.ClientRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Controller
@RequiredArgsConstructor
@RequestMapping("/load")
public class LoadControllerREST {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadControllerREST.class);

    private final ClientRepository clientRepository;

    @PostMapping("/load/{sourceURL}")
    ResponseEntity<?> loadFile(@RequestParam("sourceURL") String sourceURL) throws MalformedURLException {
        URL url = new URL(sourceURL);

        CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase();

        try (CSVParser csvParser = CSVParser.parse(url, StandardCharsets.UTF_8, csvFormat)) {
            for (CSVRecord csvRecord : csvParser) {
                Client client = new Client();
                client.setFirst_name(csvRecord.get("first_name"));
                client.setLast_name(csvRecord.get("last_name"));
                client.setBirth_date(csvRecord.get("birth_date"));
                client.setPhone_no(csvRecord.get("phone_number"));
                clientRepository.save(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.created(URI.create(("/load/") + sourceURL)).build();
    }
}