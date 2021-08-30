package pl.WojtekMalka.csvReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.WojtekMalka.csvReader.service.ReaderService;

import java.io.IOException;

@SpringBootApplication
public class CsvReaderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CsvReaderApplication.class, args);
        ReaderService.readLine();
    }
}
