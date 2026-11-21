package fr.iscod.coworkia.dtos.responses;

import java.util.UUID;

public record ComputerResponse(
        UUID id,
        String name,
        UUID workspaceId
) {}