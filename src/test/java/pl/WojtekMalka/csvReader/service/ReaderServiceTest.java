package pl.WojtekMalka.csvReader.service;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.WojtekMalka.csvReader.dictionary.CsvColumns;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.WojtekMalka.csvReader.service.ReaderService.*;

class ReaderServiceTest {

    @BeforeEach
    public void init() {
        ReaderService readerService = new ReaderService();
    }

    @Test
    void shouldThrowNullPointerWhenTryReadFile() throws IOException, CsvException {
        assertThrows(
                NullPointerException.class,
                () -> readFile(null));
    }

    @Test
    void shouldReadFirstLine() throws IOException, CsvException {
        List<String[]> sourceFile = readFile("C:\\Users\\WojtekM\\Repozytorium\\testInput.csv");
        assertEquals(Arrays.asList("Stefan", "Testowy", "1988.11.11", "600700800"), readOneLine(sourceFile, 0));
    }

    @Test
    void shouldParseFileToMap() {

    }
}