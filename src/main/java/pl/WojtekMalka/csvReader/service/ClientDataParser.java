package pl.WojtekMalka.csvReader.service;

import org.apache.commons.lang3.text.WordUtils;

public class ClientDataParser {
    private static final String INCORRECT_DATE_FORMAT = "^\\d{4}\\.([1-9])\\.([1-9])$";
    private static final String S_0 = "0";
    private static final String REGEX_DOT = "\\.";
    private static final String DOT = ".";

    public static String parsenIncorecctNameFormat(String input) {
        return WordUtils.capitalize(input.trim().toLowerCase());
    }

    public static String parseIncorrectDateFormat(String input) {
        if (input.matches(INCORRECT_DATE_FORMAT)) {
            String[] splitedInput = getSplitedInput(input);
            String correctMonth;
            String correctDay;

            correctMonth = createCorrectMonthOrDayFormat(getMonth(splitedInput));
            correctDay = createCorrectMonthOrDayFormat(getDay(splitedInput));

            return buildCorrectDate(getYear(splitedInput), correctMonth, correctDay);
        }
        return input;
    }

    private static String[] getSplitedInput(String input) {
        String[] splitedInput = input.split(REGEX_DOT);
        return splitedInput;
    }

    private static String getYear(String[] splitedInput) {
        return splitedInput[0];
    }

    private static String getDay(String[] splitedInput) {
        return splitedInput[2];
    }

    private static String getMonth(String[] splitedInput) {
        return splitedInput[1];
    }

    private static String buildCorrectDate(String str, String correctMonth, String correctDay) {
        StringBuilder sb = new StringBuilder();
        return sb.append(str)
                .append(DOT)
                .append(correctMonth)
                .append(DOT)
                .append(correctDay)
                .toString();
    }

    private static String createCorrectMonthOrDayFormat(String splitedInput) {
        if (splitedInput.length() == 1) {
            return S_0 + splitedInput;
        }
        return splitedInput;
    }
}
