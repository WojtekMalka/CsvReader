package pl.WojtekMalka.csvReader.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
@NoArgsConstructor
public class ReaderService {

    private static Logger logger = LoggerFactory.getLogger(ReaderService.class);

    private static final String fileSourceDirectory = "C:\\Users\\WojtekM\\Repozytorium\\testInput.csv";

    public ReaderService(String s) {
    }

    public static List<String[]> readFile(String fileSourceDirectory) throws IOException, CsvException {
        logger.info("ReaderService service input: {}", fileSourceDirectory);
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();

        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(fileSourceDirectory))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            List<String[]> result = reader.readAll();
            logger.info("ReaderService service output: {}", result);

            return result;
        }
        /*TODO -stworzyć błąd NonFileFound, obsługa błędu */
    }
}