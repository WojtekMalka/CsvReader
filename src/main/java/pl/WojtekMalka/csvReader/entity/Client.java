package pl.WojtekMalka.csvReader.entity;

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
    private Integer client_age;
}
