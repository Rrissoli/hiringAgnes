package med.voll.api.repositories;


import jakarta.transaction.Transactional;
import med.voll.api.enums.Status;
import med.voll.api.models.Activities_list;
import med.voll.api.models.Activity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository  extends CrudRepository<Activity,Long> {

    Optional<Activity> findById(Long id);
    Iterable<Activity> findAll();
    Activity save(Activity activity);
    @Transactional
    @Modifying
    @Query("UPDATE Activity a SET a.status = COALESCE(:status, a.status) WHERE a.id = :id")
    void updateStatusActivity(@Param("id") Long id, @Param("status") String status);
}
