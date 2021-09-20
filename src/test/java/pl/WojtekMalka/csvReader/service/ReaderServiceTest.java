package pl.WojtekMalka.csvReader.service;

import com.opencsv.exceptions.CsvException;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.WojtekMalka.csvReader.dictionary.ClientDictionary;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.WojtekMalka.csvReader.service.ReaderService.*;

class ReaderServiceTest {

    @BeforeEach
    public void init() {
        ReaderService readerService = new ReaderService("C:\\Users\\WojtekM\\Repozytorium\\testInput.csv");
    }

    @Test
    void shouldThrowNullPointerWhenTryReadFile() throws IOException, CsvException {
        assertThrows(
                NullPointerException.class,
                () -> readFile(null));
    }
}