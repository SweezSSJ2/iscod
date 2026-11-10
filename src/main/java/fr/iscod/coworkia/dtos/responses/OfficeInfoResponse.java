package fr.iscod.coworkia.dtos.responses;

import java.util.List;
import java.util.UUID;

public record OfficeInfoResponse(
        UUID id,
        String name,
        String address,
        List<WorkspaceSummary> workspaces) {
    public record WorkspaceSummary(
            UUID id,
            String code,
            String name,
            Integer capacity
    ) {}
}