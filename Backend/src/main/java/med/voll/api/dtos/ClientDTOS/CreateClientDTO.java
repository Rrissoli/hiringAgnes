package med.voll.api.dtos.ClientDTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateClientDTO {
    @NotBlank(message = "O Campo \"name\" não pode ser em branco")
    @Size(min = 3, max = 100, message = "O campo precisa ter no minimo 3 à 200 caracteres")
    private String name;
}
