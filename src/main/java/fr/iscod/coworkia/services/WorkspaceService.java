package fr.iscod.coworkia.services;

import fr.iscod.coworkia.dtos.mappers.WorkspaceMapper;
import fr.iscod.coworkia.dtos.responses.WorkspaceResponse;
import fr.iscod.coworkia.exceptions.ResourceNotFoundException;
import fr.iscod.coworkia.interfaces.repositories.OfficeRepository;
import fr.iscod.coworkia.interfaces.repositories.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private OfficeRepository officeRepository;
    private final WorkspaceMapper workspaceMapper;

    public WorkspaceService(OfficeRepository officeRepository, WorkspaceMapper workspaceMapper) {
        this.officeRepository = officeRepository;
        this.workspaceMapper = workspaceMapper;
    }

    public List<WorkspaceResponse> findAll() {
        return workspaceRepository.findAll().stream().map(workspaceMapper::toResponse).toList();
    }

    public List<WorkspaceResponse> findAllByOffice(UUID officeId) {
        if (!officeRepository.existsById(officeId)) {
            throw new ResourceNotFoundException();
        }
        return workspaceRepository.findAllByOfficeId(officeId).stream()
                .map(workspaceMapper::toResponse)
                .toList();
    }

}
