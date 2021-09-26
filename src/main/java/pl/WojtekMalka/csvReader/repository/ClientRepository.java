package pl.WojtekMalka.csvReader.repository;

import pl.WojtekMalka.csvReader.entity.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();

    Client save(Client entity);

//    Integer countClientByClientId();
//    List<Client> findByBirth_dateByOOrderByBirth_date();
//
//    Client findClientByBirth_dateAndPhone_noIsNotNull();
}
