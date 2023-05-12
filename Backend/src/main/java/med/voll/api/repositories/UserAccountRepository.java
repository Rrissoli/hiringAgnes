package med.voll.api.repositories;

import med.voll.api.models.UserAccount;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    UserAccount findByName(String name);

}
