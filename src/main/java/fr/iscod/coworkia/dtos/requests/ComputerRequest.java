package fr.iscod.coworkia.dtos.requests;

import fr.iscod.coworkia.entities.Workspace;
import jakarta.validation.constraints.NotBlank;

public record ComputerRequest(
        @NotBlank String name,
        @NotBlank Workspace workspace
) {}