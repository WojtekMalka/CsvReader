package pl.WojtekMalka.csvReader.service;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class ClientDataParserTest {

    @Test
    public void whenIncorrectInputDateFormaat_thenParseDate() {
        String inputDate = "1999.1.1";
        assertEquals("1999.01.01", ClientDataParser.parseIncorrectDateFormat(inputDate));
    }

    @Test
    public void whenIncorrectInputNameFormat_thenParseName() {
        String inputName = " wOjCiECh ";
        assertEquals("Wojciech", ClientDataParser.parsenIncorecctNameFormat(inputName));
    }
}