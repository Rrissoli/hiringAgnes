package med.voll.api.dtos.Activity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateActivityDTO {

    @NotBlank(message = "campo titulo está em branco")
    @Size(min = 3, max = 100, message = "O campo precisa ter no minimo 3 à 200 caracteres")
    private String title;
    @NotBlank(message = "campo titulo está em branco")
    @Size(min = 10, max = 200, message = "O campo precisa ter no minimo 10 à 200 caracteres")
    private String description;
    @NotBlank(message = "campo data está em branco")
    private String start_date;
    @NotBlank(message = "campo prazo está em branco")
    private String dae_date;
    @NotNull
    private int show_order;

    private Status status;


    @NotNull(message = "Tarefa precisa estar vinculada com uma lista de atividades")
    private Long activities_list_id;
}
