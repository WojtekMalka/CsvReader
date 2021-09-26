package pl.WojtekMalka.csvReader.repository.SQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.WojtekMalka.csvReader.entity.Client;
import pl.WojtekMalka.csvReader.repository.ClientRepository;

@Repository
interface SqlClientRepository extends ClientRepository, JpaRepository<Client, Long> {
}
