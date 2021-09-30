package pl.WojtekMalka.csvReader.service;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.Assert.*;


class ClientDataParserTest {

    @Test
    public void parseDate() {
        String inputDate = "1999.1.1";
        String result = ClientDataParser.parseDate(inputDate);
        assertEquals("1999.01.01", result);
    }
}