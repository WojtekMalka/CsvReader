package pl.WojtekMalka.csvReader.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ReaderService {

    private static final String fileName = "C:\\Users\\WojtekM\\Repozytorium\\testInput.csv";

    public static void readAndParseCSV() throws IOException, CsvException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(fileName))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            List<String[]> line = reader.readAll();
            line.forEach(x -> System.out.println(Arrays.toString(x)));
        }
    }
}