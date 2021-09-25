package pl.WojtekMalka.csvReader.service;

import lombok.NoArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@NoArgsConstructor
public class ReaderService {
    private static Logger logger = LoggerFactory.getLogger(ReaderService.class);

    public static List<String[]> readFile(URL sourceURL) {
        logger.info("ReaderService service input: {}", sourceURL.toString());
        CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase();

        try (CSVParser csvParser = CSVParser.parse(sourceURL, StandardCharsets.UTF_8, csvFormat)) {
            for (CSVRecord csvRecord : csvParser) {
                String firstName = csvRecord.get("First Name");
                String lastName = csvRecord.get("Last Name");
                String email = csvRecord.get("Email");
                String phoneNumber = csvRecord.get("Phone Number");
            }
            /*TODO -stworzyć błąd NonFileFound, obsługa błędu */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }