package fr.iscod.coworkia.dtos.responses;

import java.util.List;
import java.util.UUID;

public record OfficeInfoResponse(
        UUID id,
        String name,
        String address,
        List<WorkspaceInfos> workspaces) {
    public record WorkspaceInfos(
            UUID id,
            String code,
            String name,
            Integer capacity
    ) {}
}