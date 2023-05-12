package med.voll.api.dtos.Activity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enums.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateStatusDto {
    @NotBlank
    private Status status;


}
