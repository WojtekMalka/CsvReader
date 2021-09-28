package pl.WojtekMalka.csvReader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.WojtekMalka.csvReader.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Override
    <S extends Client> List<S> saveAll(Iterable<S> entities);

    @Override
    long count();

//    @Query(value = "SELECT first_name, last_name, DATEDIFF(year, '2017/08/25', '2011/08/25') AS client_age FROM clients c", nativeQuery = true)
//    List<Client> get();
}
