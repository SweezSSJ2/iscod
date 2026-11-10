package fr.iscod.coworkia.dtos.requests;

import jakarta.validation.constraints.NotBlank;

public record OfficeRequest(
        @NotBlank String name,
        @NotBlank String address
) {}