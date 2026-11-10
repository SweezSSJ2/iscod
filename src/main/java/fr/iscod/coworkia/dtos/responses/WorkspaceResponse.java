package fr.iscod.coworkia.dtos.responses;

import java.util.UUID;

public record WorkspaceResponse(
        UUID id,
        UUID officeId,
        String code,
        String name,
        Integer capacity
) {}