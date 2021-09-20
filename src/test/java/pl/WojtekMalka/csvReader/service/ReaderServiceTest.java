package pl.WojtekMalka.csvReader.service;

import com.opencsv.exceptions.CsvException;
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

    @Test
    void shouldReadFirstLine() throws IOException, CsvException {
        List<String[]> sourceFile = readFile("C:\\Users\\WojtekM\\Repozytorium\\testInput.csv");
        EnumMap<ClientDictionary, String> oneLineInMap = new EnumMap<>(ClientDictionary.class);
        oneLineInMap.put(ClientDictionary.FIRST_NAME, "Stefan");
        oneLineInMap.put(ClientDictionary.LAST_NAME, "Testowy");
        oneLineInMap.put(ClientDictionary.BIRTH_DATE, "1988.11.11");
        oneLineInMap.put(ClientDictionary.PHONE_NO, "600700800");
        assertEquals(oneLineInMap, getOneClientData(sourceFile, 0));
    }
}