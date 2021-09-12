package pl.WojtekMalka.csvReader.repository;

import pl.WojtekMalka.csvReader.entity.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();

    Client save(Client entity);
}
