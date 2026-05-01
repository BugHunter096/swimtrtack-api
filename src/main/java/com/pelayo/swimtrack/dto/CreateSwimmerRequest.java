package com.pelayo.swimtrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateSwimmerRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @NotBlank(message = "La categoría es obligatoria")
        String category,

        @Pattern(regexp = "M|F|Otro", message = "El sexo debe ser M, F u Otro")
        String sex
) {
}
