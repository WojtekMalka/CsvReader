package pl.WojtekMalka.csvReader.DTO;

import lombok.Data;

@Data
public class ClientDTO {
    private String first_name;
    private String last_name;
    private String birth_date;
    private String phone_no;
    private Long client_age;

}
