package pl.WojtekMalka.csvReader;

import com.opencsv.exceptions.CsvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.WojtekMalka.csvReader.service.ReaderService;

import java.io.IOException;

@SpringBootApplication
public class CsvReaderApplication {

    public static void main(String[] args) throws IOException, CsvException {
//        SpringApplication.run(CsvReaderApplication.class, args);
//        ReaderService.readAndParseCSV();
    }
}
