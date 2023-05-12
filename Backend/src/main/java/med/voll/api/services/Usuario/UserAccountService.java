package med.voll.api.services.Usuario;

import med.voll.api.dtos.UserDTOS.Login;
import med.voll.api.dtos.UserDTOS.Registese;

import med.voll.api.models.UserAccount;
import med.voll.api.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository repository;

    public void register(Registese registese)  {
        repository.save(new UserAccount(registese));

    }
    public UserAccount Login(Login login) {
        UserAccount userAccount = repository.findByName(login.name());
        if (userAccount!= null && userAccount.getPassword().equals(login.password())) {
                return userAccount;
        } else {
            return null;
        }
    }
}
