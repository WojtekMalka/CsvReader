package pl.WojtekMalka.csvReader.service;

import org.apache.commons.lang3.text.WordUtils;

public class ClientDataParser {
    private static final String INCORRECT_DATE_FORMAT = "^\\d{4}\\.([1-9])\\.([1-9])$";
    private static final String S_0 = "0";
    private static final String REGEX_DOT = "\\.";
    private static final String DOT = ".";

    public static String parseName(String input) {
        return WordUtils.capitalize(input.trim().toLowerCase());
    }

    public static String parseDate(String input) {
        if (input.matches(INCORRECT_DATE_FORMAT)) {
            String[] splitedInput = input.split(REGEX_DOT);
            String correctMonth;
            String correctDay;

            correctMonth = getCorrectFormat(splitedInput[1]);
            correctDay = getCorrectFormat(splitedInput[2]);

            return correctDateBuilder(splitedInput[0], correctMonth, correctDay);
        }
        return input;
    }

    private static String correctDateBuilder(String str, String correctMonth, String correctDay) {
        StringBuilder sb = new StringBuilder();
        return sb.append(str)
                .append(DOT)
                .append(correctMonth)
                .append(DOT)
                .append(correctDay)
                .toString();
    }

    private static String getCorrectFormat(String splitedInput) {
        if (splitedInput.length() == 1) {
            return S_0 + splitedInput;
        }
        return splitedInput;
    }
}
