package fr.iscod.coworkia.dtos.requests;

import java.util.UUID;

public record ComputerPatchRequest(
        String name,
        UUID workspaceId
) {}
