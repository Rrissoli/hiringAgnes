package med.voll.api.dtos.ActivitiesListDTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateActivityListDTO {
    @NotBlank(message = "O Campo \"name\" não pode ser em branco")
    @Size(min = 3, max = 100, message = "O campo precisa ter no minimo 3 à 200 caracteres")
    private String name;

    @NotNull(message = "O Campo \"ordem\" não pode ser em branco")
    private int show_order;

    @NotNull(message = "O Campo \"backlog\" não pode ser em branco")
    private boolean backlog;

    @NotNull
    private Long project_id;

}
