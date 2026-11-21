package fr.iscod.coworkia.services;

import fr.iscod.coworkia.dtos.mappers.WorkspaceMapper;
import fr.iscod.coworkia.dtos.requests.WorkspacePatchRequest;
import fr.iscod.coworkia.dtos.requests.WorkspaceRequest;
import fr.iscod.coworkia.dtos.responses.WorkspaceResponse;
import fr.iscod.coworkia.entities.Office;
import fr.iscod.coworkia.entities.Workspace;
import fr.iscod.coworkia.exceptions.ResourceNotFoundException;
import fr.iscod.coworkia.interfaces.repositories.OfficeRepository;
import fr.iscod.coworkia.interfaces.repositories.WorkspaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final OfficeRepository officeRepository;
    private final WorkspaceMapper workspaceMapper;

    public WorkspaceService(WorkspaceRepository workspaceRepository,
                            OfficeRepository officeRepository,
                            WorkspaceMapper workspaceMapper) {
        this.workspaceRepository = workspaceRepository;
        this.officeRepository = officeRepository;
        this.workspaceMapper = workspaceMapper;
    }

    public List<WorkspaceResponse> findAll() {
        return workspaceRepository.findAll().stream().map(workspaceMapper::toResponse).toList();
    }

    public List<WorkspaceResponse> findAllByOffice(UUID officeId) {
        if (!officeRepository.existsById(officeId)) {
            throw new ResourceNotFoundException("Office", officeId);
        }
        return workspaceRepository.findAllByOfficeId(officeId).stream()
                .map(workspaceMapper::toResponse)
                .toList();
    }

    public WorkspaceResponse findById(UUID id) {
        return workspaceMapper.toResponse(getOrThrow(id));
    }

    @Transactional
    public UUID create(UUID officeId, WorkspaceRequest request) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new ResourceNotFoundException("Office", officeId));
        return workspaceRepository.save(workspaceMapper.toEntity(request, office)).getId();
    }

    @Transactional
    public void update(UUID id, WorkspaceRequest request) {
        workspaceMapper.applyUpdate(getOrThrow(id), request);
    }

    @Transactional
    public void partialUpdate(UUID id, WorkspacePatchRequest request) {
        workspaceMapper.applyPatch(getOrThrow(id), request);
    }

    @Transactional
    public void delete(UUID id) {
        workspaceRepository.delete(getOrThrow(id));
    }

    private Workspace getOrThrow(UUID id) {
        return workspaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workspace", id));
    }
}