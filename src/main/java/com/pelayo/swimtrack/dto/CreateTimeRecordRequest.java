package com.pelayo.swimtrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateTimeRecordRequest(
        @NotNull(message = "El id del nadador es obligatorio")
        Long swimmerId,

        @NotBlank(message = "El estilo es obligatorio")
        String style,

        @NotBlank(message = "El tipo de sesión es obligatorio")
        String sessionType,

        @Positive(message = "El tiempo debe ser positivo")
        double seconds,

        String notes
) {
}
