package pl.WojtekMalka.csvReader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.WojtekMalka.csvReader.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Override
    <S extends Client> List<S> saveAll(Iterable<S> entities);
}
