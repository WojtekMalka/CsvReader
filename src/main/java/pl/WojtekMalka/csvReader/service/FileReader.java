package pl.WojtekMalka.csvReader.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.WojtekMalka.csvReader.entity.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static pl.WojtekMalka.csvReader.service.ClientDataParser.parseIncorrectDateFormat;
import static pl.WojtekMalka.csvReader.service.ClientDataParser.parsenIncorecctNameFormat;

@Service
public class FileReader {
    private static final String UPLOADED_DOCUMENT_TYPE = "text/csv";
    private static final String ENCODE_TYPE = "UTF-8";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String BIRTH_DATE = "birth_date";
    public static final String PHONE_NO = "phone_no";

    public static boolean hasCSVFormat(MultipartFile file) {
        return UPLOADED_DOCUMENT_TYPE.equals(file.getContentType());
    }

    public static List<Client> readCSV(InputStream inputStream) {
        try (BufferedReader fileReader = getFileReader(inputStream);
             CSVParser csvParser = new CSVParser(fileReader, getFormat());) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            return createClients(csvRecords);
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    private static BufferedReader getFileReader(InputStream inputStream) throws UnsupportedEncodingException {
        return new BufferedReader(new InputStreamReader(inputStream, ENCODE_TYPE));
    }

    private static CSVFormat getFormat() {
        return CSVFormat.EXCEL.withDelimiter(';')
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withIgnoreEmptyLines(true)
                .withTrim();
    }

    private static List<Client> createClients(Iterable<CSVRecord> csvRecords) {
        List<Client> clients = new ArrayList<>();
        for (CSVRecord csvRecord : csvRecords) {
            if (!csvRecord.get(0).equals("")) {
                Client client = new Client();
                client.setFirst_name(getTextTypeDataFromColumn(csvRecord, FIRST_NAME));
                client.setLast_name(getTextTypeDataFromColumn(csvRecord, LAST_NAME));
                client.setBirth_date(getTimeTypeDataFromColumn(csvRecord, BIRTH_DATE));
                client.setPhone_no((getTextTypeDataFromColumn(csvRecord, PHONE_NO)));
                clients.add(client);
            }
        }
        return clients;
    }

    private static String getTextTypeDataFromColumn(CSVRecord csvRecord, String columnHeader) {
        return parsenIncorecctNameFormat(csvRecord.get(columnHeader));
    }

    private static String getTimeTypeDataFromColumn(CSVRecord csvRecord, String columnHeader) {
        return parseIncorrectDateFormat(csvRecord.get(columnHeader));
    }
}