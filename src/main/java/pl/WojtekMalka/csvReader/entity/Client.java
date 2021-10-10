package pl.WojtekMalka.csvReader.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.YEARS;
import static pl.WojtekMalka.csvReader.message.EntityValidatorMessages.EMPTY_VALUE;
import static pl.WojtekMalka.csvReader.message.EntityValidatorMessages.WRONG_LENGTH;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @NotEmpty(message = EMPTY_VALUE)
    private String first_name;

    @NotEmpty(message = EMPTY_VALUE)
    private String last_name;

    @NotEmpty(message = EMPTY_VALUE)
    private String birth_date;

    @Column(unique = true)
    @Size(min = 9, max = 9, message = WRONG_LENGTH)
    private String phone_no;
    private Long client_age;

    @PrePersist
    private void countClientAge() {
        client_age = Long.valueOf(YEARS.between(LocalDate.parse(birth_date,
                DateTimeFormatter.ofPattern("yyyy.MM.dd")), LocalDate.now()));
    }
}