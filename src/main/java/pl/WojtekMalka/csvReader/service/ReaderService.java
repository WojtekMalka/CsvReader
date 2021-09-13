package pl.WojtekMalka.csvReader.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderService {

    /*TODO -logowanie*/

    private static final String fileSourceDirectory = "C:\\Users\\WojtekM\\Repozytorium\\testInput.csv";

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

    public static List<String> oneReadedLine(List<String[]> input, Integer lineNumber) {
        String[] strings = input.get(lineNumber);
        return Arrays.stream(strings).collect(Collectors.toList());
    }


}