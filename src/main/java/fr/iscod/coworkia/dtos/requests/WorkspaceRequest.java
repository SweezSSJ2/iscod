package fr.iscod.coworkia.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record WorkspaceRequest(
    @NotBlank String code,
    @NotBlank String name,
    @NotNull @Positive Integer capacity
) {}