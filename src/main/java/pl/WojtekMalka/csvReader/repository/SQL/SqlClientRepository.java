package pl.WojtekMalka.csvReader.repository.SQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.WojtekMalka.csvReader.entity.Client;
import pl.WojtekMalka.csvReader.repository.ClientRepository;

import java.util.List;

@Repository
interface SqlClientRepository extends ClientRepository, JpaRepository<Client, Long> {
//    @Override
//    List<Client> findClientByBirth_dateAndPhone_noIsNotNull;
}
