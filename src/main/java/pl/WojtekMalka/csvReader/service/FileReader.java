package pl.WojtekMalka.csvReader.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.WojtekMalka.csvReader.entity.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static pl.WojtekMalka.csvReader.service.ClientDataParser.*;

@Service
public class FileReader {
    private static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        } else {
            return true;
        }
    }

    public static List<Client> readCSVToClient(InputStream inputStream) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.EXCEL.withDelimiter(';').withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withIgnoreEmptyLines());) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            List<Client> clients = new ArrayList<>();

            for (CSVRecord csvRecord : csvRecords) {
                Client client = new Client();
                client.setFirst_name(parseName(csvRecord.get("first_name")));
                client.setLast_name(parseName(csvRecord.get("last_name")));
                client.setBirth_date(parseDate(csvRecord.get("birth_date")));
                client.setPhone_no((csvRecord.get("phone_no")));
                clients.add(client);
            }
            return clients;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}