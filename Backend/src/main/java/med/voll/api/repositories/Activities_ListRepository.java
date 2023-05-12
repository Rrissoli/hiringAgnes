package med.voll.api.repositories;

import med.voll.api.models.Activities_list;
import med.voll.api.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Activities_ListRepository extends CrudRepository<Activities_list,Long> {
    Optional<Activities_list> findById(Long id);
    Iterable<Activities_list> findAll();
    Activities_list save(Activities_list activities);

}
