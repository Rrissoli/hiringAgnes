package med.voll.api.repositories;

import jakarta.transaction.Transactional;
import med.voll.api.models.Activities_list;
import med.voll.api.models.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {

   Optional<Client> findById(Long id);
    List<Client> findAll();
    Client save(Client client);
    void delete(Client client);

    @Transactional
    @Modifying
    @Query("UPDATE Client c SET c.name = COALESCE(:name, c.name) WHERE c.id = :id")
    void updateClient(@Param("id") Long id, @Param("name") String name);

}
