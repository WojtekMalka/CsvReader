package pl.WojtekMalka.csvReader.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.YEARS;

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
    private Long client_age;

    @PrePersist
    private void countClientAge() {
        client_age = Long.valueOf(YEARS.between(LocalDate.parse(birth_date,
                DateTimeFormatter.ofPattern("yyyy.MM.dd")), LocalDate.now()));
    }
}