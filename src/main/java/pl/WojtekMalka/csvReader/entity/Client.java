package pl.WojtekMalka.csvReader.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String first_name;
    private String last_name;
    private String birth_date;
    private String phone_no;

    public Client(String first_name, String last_name, String birth_date, String phone_no) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.phone_no = phone_no;
    }
}
