package fr.iscod.coworkia.dtos.mappers;

import fr.iscod.coworkia.dtos.requests.ComputerPatchRequest;
import fr.iscod.coworkia.dtos.requests.ComputerRequest;
import fr.iscod.coworkia.dtos.responses.ComputerResponse;
import fr.iscod.coworkia.entities.Computer;
import fr.iscod.coworkia.entities.Workspace;
import org.springframework.stereotype.Component;

@Component
public class ComputerMapper {

    public Computer toEntity(ComputerRequest request, Workspace workspace) {
        Computer computer = new Computer();
        computer.setName(request.name());
        computer.setWorkspace(workspace);
        return computer;
    }

    public void applyUpdate(Computer computer, ComputerRequest request, Workspace workspace) {
        computer.setName(request.name());
        computer.setWorkspace(workspace);
    }

    public void applyPatch(Computer computer, ComputerPatchRequest patch, Workspace workspaceOrNull) {
        if (patch.name() != null) computer.setName(patch.name());
        if (workspaceOrNull != null) computer.setWorkspace(workspaceOrNull);
    }

    public ComputerResponse toResponse(Computer computer) {
        return new ComputerResponse(
                computer.getId(), computer.getName(), computer.getWorkspace().getId());
    }
}
