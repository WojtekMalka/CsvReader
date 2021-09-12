package pl.WojtekMalka.csvReader.service;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderServiceTest {

    @Test
    void readFile() throws IOException, CsvException {
        assertThrows(
                NullPointerException.class,
                () -> ReaderService.readFile(null));
    }

    @Test
    void oneReadedLine() {
    }
}