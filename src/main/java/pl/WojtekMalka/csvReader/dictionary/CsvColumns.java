package pl.WojtekMalka.csvReader.dictionary;

import java.util.LinkedHashMap;
import java.util.Map;

public enum CsvColumns {
    FIRST_NAME,
    LAST_NAME,
    BIRTH_DATE,
    PHONE_NO;

    CsvColumns() {
    }

    public static Map<CsvColumns, String> getCsvColumnsMap() {
        Map<CsvColumns, String> csvColumnsNames = new LinkedHashMap<>();
        for (CsvColumns columnName : CsvColumns.values()) {
            csvColumnsNames.put(columnName, "");
        }
        return csvColumnsNames;
    }
}
