package med.voll.api.dtos.UserDTOS;

import jakarta.validation.constraints.NotNull;

public record Login(
        @NotNull
        String name,
        @NotNull
        String password
) {
}
