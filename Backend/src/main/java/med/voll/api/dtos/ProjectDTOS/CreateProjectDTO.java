package med.voll.api.dtos.ProjectDTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.models.UserAccount;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateProjectDTO {
    @NotBlank(message = "O Campo \"name\" não pode ser em branco")
    @Size(min = 3, max = 100, message = "O campo precisa ter no minimo 3 à 200 caracteres")
    private String name;
    @NotBlank(message = "O Campo \"color\" não pode ser em branco")
    @Size(min = 7, max = 255, message = "O campo precisa ter no minimo 3 à 200 caracteres")
    private String background;
    @NotNull
    private Long client_id;
}
