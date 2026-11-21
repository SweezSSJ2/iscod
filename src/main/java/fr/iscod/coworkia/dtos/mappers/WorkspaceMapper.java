package fr.iscod.coworkia.dtos.mappers;

import fr.iscod.coworkia.dtos.requests.WorkspacePatchRequest;
import fr.iscod.coworkia.dtos.requests.WorkspaceRequest;
import fr.iscod.coworkia.dtos.responses.WorkspaceResponse;
import fr.iscod.coworkia.entities.Office;
import fr.iscod.coworkia.entities.Workspace;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceMapper {

    public Workspace toEntity(WorkspaceRequest request, Office office) {
        Workspace workspace = new Workspace();
        workspace.setOffice(office);
        workspace.setCode(request.code());
        workspace.setName(request.name());
        workspace.setCapacity(request.capacity());
        return workspace;
    }

    public void applyUpdate(Workspace workspace, WorkspaceRequest request) {
        workspace.setCode(request.code());
        workspace.setName(request.name());
        workspace.setCapacity(request.capacity());
    }

    public void applyPatch(Workspace workspace, WorkspacePatchRequest patch) {
        if (patch.code() != null) workspace.setCode(patch.code());
        if (patch.name() != null) workspace.setName(patch.name());
        if (patch.capacity() != null) workspace.setCapacity(patch.capacity());
    }

    public WorkspaceResponse toResponse(Workspace workspace) {
        return new WorkspaceResponse(
                workspace.getId(),
                workspace.getOffice().getId(),
                workspace.getCode(),
                workspace.getName(),
                workspace.getCapacity());
    }
}
