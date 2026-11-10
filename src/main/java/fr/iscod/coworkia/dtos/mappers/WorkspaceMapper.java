package fr.iscod.coworkia.dtos.mappers;

import fr.iscod.coworkia.dtos.responses.WorkspaceResponse;
import fr.iscod.coworkia.entities.Workspace;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceMapper {

    public WorkspaceResponse toResponse(Workspace workspace) {
        return new WorkspaceResponse(
                workspace.getId(),
                workspace.getOffice().getId(),
                workspace.getCode(),
                workspace.getName(),
                workspace.getCapacity());
    }

}
