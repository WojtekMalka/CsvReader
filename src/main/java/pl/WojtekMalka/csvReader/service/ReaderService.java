package pl.WojtekMalka.csvReader.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;
import pl.WojtekMalka.csvReader.dictionary.ClientDictionary;

import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.List;

@Service
public class ReaderService {

    /*TODO -logowanie*/

    private static final String fileSourceDirectory = "C:\\Users\\WojtekM\\Repozytorium\\testInput.csv";

    public ReaderService() {
    }

    public ReaderService(String fileSource) {
    }

    public static List<String[]> readFile(String fileSourceDirectory) throws IOException, CsvException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(fileSourceDirectory))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            return reader.readAll();
        }
        /*TODO -stworzyć błąd NonFileFound, obsługa błędu */
    }

    public static EnumMap<ClientDictionary, String> getOneClientData(List<String[]> input, Integer lineNumber) {
        String[] strings = input.get(lineNumber);
        EnumMap<ClientDictionary, String> oneLineInMap = new EnumMap<>(ClientDictionary.class);

        oneLineInMap.put(ClientDictionary.FIRST_NAME, strings[0]);
        oneLineInMap.put(ClientDictionary.LAST_NAME, strings[1]);
        oneLineInMap.put(ClientDictionary.BIRTH_DATE, strings[2]);
        oneLineInMap.put(ClientDictionary.PHONE_NO, strings[3]);

        return oneLineInMap;
    }
}