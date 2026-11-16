package fr.iscod.coworkia.dtos.responses;

import fr.iscod.coworkia.entities.Workspace;

import java.util.UUID;

public record ComputerResponse(
        UUID id,
        String name,
        Workspace workspace
) {}