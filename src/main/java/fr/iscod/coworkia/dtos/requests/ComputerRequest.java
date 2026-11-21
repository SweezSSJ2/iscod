package fr.iscod.coworkia.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ComputerRequest(
        @NotBlank String name,
        @NotNull UUID workspaceId
) {}