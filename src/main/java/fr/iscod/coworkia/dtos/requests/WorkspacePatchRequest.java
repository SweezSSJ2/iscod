package fr.iscod.coworkia.dtos.requests;

import jakarta.validation.constraints.Positive;

public record WorkspacePatchRequest(
        String code,
        String name,
        @Positive Integer capacity
) {}