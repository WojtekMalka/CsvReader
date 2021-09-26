package pl.WojtekMalka.csvReader.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
import pl.WojtekMalka.csvReader.entity.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static pl.WojtekMalka.csvReader.service.ClientDataParser.cleanInput;

public class FileReader {
    public static List<Client> readCSVToClient(InputStream inputStream) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            List<Client> clients = new ArrayList<>();

            for (CSVRecord csvRecord : csvRecords) {
                Client client = new Client();
                client.setFirst_name(cleanInput(csvRecord.get("first_name")));
                client.setLast_name(cleanInput(csvRecord.get("last_name")));
                client.setBirth_date(cleanInput(csvRecord.get("birth_date")));
                client.setPhone_no(cleanInput(csvRecord.get("phone_number")));
                clients.add(client);
            }
            return clients;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}