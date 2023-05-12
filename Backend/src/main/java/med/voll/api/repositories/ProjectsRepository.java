package med.voll.api.repositories;


import med.voll.api.models.Client;
import med.voll.api.models.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProjectsRepository extends CrudRepository<Project,Long> {
    Optional<Project> findById(Long id);
    Iterable<Project> findAll();
    Project save(Client client);
    void delete(Project project);

}
