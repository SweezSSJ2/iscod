package fr.iscod.coworkia.dtos.responses;

import java.util.UUID;

public record OfficeResponse(
        UUID id,
        String name,
        String address
) {}