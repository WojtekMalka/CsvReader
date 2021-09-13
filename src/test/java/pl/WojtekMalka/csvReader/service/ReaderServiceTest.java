package pl.WojtekMalka.csvReader.service;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReaderServiceTest {

    @Test
    void shouldThrowNullPointerWhenTryReadFile() throws IOException, CsvException {
        assertThrows(
                NullPointerException.class,
                () -> ReaderService.readFile(null));
    }

    @Test
    void shouldReadfirstLine() throws IOException, CsvException {
        List<String[]> sourceFile = ReaderService.readFile("C:\\Users\\WojtekM\\Repozytorium\\testInput.csv");
        assertEquals(Arrays.asList("Stefan", "Testowy", "1988.11.11", "600700800"), ReaderService.oneReadedLine(sourceFile, 0));
    }
}