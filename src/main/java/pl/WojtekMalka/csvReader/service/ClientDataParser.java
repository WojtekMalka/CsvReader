package pl.WojtekMalka.csvReader.service;

import org.apache.commons.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class ClientDataParser {

    private static Logger logger = LoggerFactory.getLogger(ReaderService.class);

    public static void parse(String input) {
        logger.info("ClientDataParser input: {}", input);
        cleanWhiteSpacesAndFillsUpEmpty(input);
        correctLettersSizeInString(input);
        logger.info("ClientDataParser output: {}", input);
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
