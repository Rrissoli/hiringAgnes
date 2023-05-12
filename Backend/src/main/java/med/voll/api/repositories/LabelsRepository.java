package med.voll.api.repositories;

import med.voll.api.models.Label;
import org.springframework.data.repository.CrudRepository;

public interface LabelsRepository extends CrudRepository<Label,Long> {
}
