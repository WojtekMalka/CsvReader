package pl.WojtekMalka.csvReader.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderService {

    private static final String fileName = "C:\\Users\\WojtekM\\Repozytorium\\testInput.csv";

    public static void readLine() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        }
    }
}
