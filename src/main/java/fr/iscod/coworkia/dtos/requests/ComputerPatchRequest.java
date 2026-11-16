package fr.iscod.coworkia.dtos.requests;

import fr.iscod.coworkia.entities.Workspace;

public record ComputerPatchRequest(
        String name,
        Workspace workspace
) {
}
