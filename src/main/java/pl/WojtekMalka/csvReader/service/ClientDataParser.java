package pl.WojtekMalka.csvReader.service;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class ClientDataParser {
    public static void parse(String input) {
        cleanWhiteSpacesAndFillsUpEmpty(input);
        correctLettersSizeInString(input);
    }

    private static void correctLettersSizeInString(String input) {
        if (input.getClass().equals(String.class)) {
            input.toLowerCase();
            WordUtils.capitalize(input);
        }
    }

    private static void cleanWhiteSpacesAndFillsUpEmpty(String input) {
        if (isEmpty(input)) {
            input = "empty";
        } else {
            input.trim();
        }
    }
}
