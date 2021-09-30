package pl.WojtekMalka.csvReader.service;

import org.apache.commons.lang3.text.WordUtils;

public class ClientDataParser {
    private static final String INCORRECT_DATE_FORMAT = "^\\d{4}\\.([1-9])\\.([1-9])$";
    public static final String S_0 = "0";
    public static final String REGEX_DOT = "\\.";
    public static final String DOT = ".";

    public static String parseName(String input) {
        input.trim().toLowerCase();
        WordUtils.capitalize(input);
        return input;
    }

    public static String parseDate(String input) {
        if (input.matches(INCORRECT_DATE_FORMAT)) {
            String[] splitedInput = input.split(REGEX_DOT);
            String correctMonth = "";
            String correctDay = "";

            if (splitedInput[1].length() == 1) {
                correctMonth += S_0 + splitedInput[1].toString();
            }
            if (splitedInput[2].length() == 1) {
                correctDay += S_0 + splitedInput[2].toString();
            }
            StringBuilder sb = new StringBuilder();
            return sb.append(splitedInput[0]).append(DOT).append(correctMonth).append(DOT).append(correctDay).toString();
        }
        return input;
    }
}
