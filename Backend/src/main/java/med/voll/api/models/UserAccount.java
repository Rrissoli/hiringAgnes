package med.voll.api.models;


import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dtos.UserDTOS.Registese;


import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity(name = "User")
@Table(name = "user_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserAccount  extends  WithTimestamp{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password ;
    private String bio;

    private Date createdAt;
    private Date updatedAt;

    private boolean enabled;

    public UserAccount(Registese dadosRegistese){
    this.name = dadosRegistese.name();
    this.email = dadosRegistese.email();
    this.password = dadosRegistese.password();
    this.enabled = true;
    this.createdAt = new Date();

    }
}
