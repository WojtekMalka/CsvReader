package pl.WojtekMalka.csvReader.service;

import com.sun.xml.bind.v2.TODO;
import org.apache.commons.lang3.text.WordUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientDataParser {
    public static String parseName(String input) {
        input.trim().toLowerCase();
        WordUtils.capitalize(input);
        return input;
    }

    /*TODO
    *   do sparsowania 1999.1.1*/
    public static String parseDate(String input) {
        return String.valueOf(LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy.MM.dd")));
    }
}
