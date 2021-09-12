package pl.WojtekMalka.csvReader.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientId;

    private String first_name;
    private String last_name;
    private String birth_date;
    private String phone_no;

    public Client() {
    }
}
