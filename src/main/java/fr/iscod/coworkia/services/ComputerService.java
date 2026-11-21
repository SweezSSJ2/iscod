package fr.iscod.coworkia.services;

import fr.iscod.coworkia.dtos.mappers.ComputerMapper;
import fr.iscod.coworkia.dtos.requests.ComputerPatchRequest;
import fr.iscod.coworkia.dtos.requests.ComputerRequest;
import fr.iscod.coworkia.dtos.responses.ComputerResponse;
import fr.iscod.coworkia.entities.Computer;
import fr.iscod.coworkia.entities.Workspace;
import fr.iscod.coworkia.exceptions.ResourceNotFoundException;
import fr.iscod.coworkia.interfaces.repositories.ComputerRepository;
import fr.iscod.coworkia.interfaces.repositories.WorkspaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final WorkspaceRepository workspaceRepository;
    private final ComputerMapper computerMapper;

    public ComputerService(ComputerRepository computerRepository,
                           WorkspaceRepository workspaceRepository,
                           ComputerMapper computerMapper) {
        this.computerRepository = computerRepository;
        this.workspaceRepository = workspaceRepository;
        this.computerMapper = computerMapper;
    }

    public List<ComputerResponse> findAll() {
        return computerRepository.findAll().stream().map(computerMapper::toResponse).toList();
    }

    public List<ComputerResponse> findAllByWorkspace(UUID workspaceId) {
        if (!workspaceRepository.existsById(workspaceId)) {
            throw new ResourceNotFoundException("Workspace", workspaceId);
        }
        return computerRepository.findAllByWorkspaceIdOrderByNameAsc(workspaceId).stream()
                .map(computerMapper::toResponse)
                .toList();
    }

    @Transactional
    public UUID create(ComputerRequest request) {
        Workspace workspace = getWorkspaceOrThrow(request.workspaceId());
        return computerRepository.save(computerMapper.toEntity(request, workspace)).getId();
    }

    @Transactional
    public void update(UUID id, ComputerRequest request) {
        Computer computer = getOrThrow(id);
        computerMapper.applyUpdate(computer, request, getWorkspaceOrThrow(request.workspaceId()));
    }

    @Transactional
    public void partialUpdate(UUID id, ComputerPatchRequest request) {
        Computer computer = getOrThrow(id);
        Workspace workspace = request.workspaceId() == null
                ? null : getWorkspaceOrThrow(request.workspaceId());
        computerMapper.applyPatch(computer, request, workspace);
    }

    @Transactional
    public void delete(UUID id) {
        computerRepository.delete(getOrThrow(id));
    }

    private Computer getOrThrow(UUID id) {
        return computerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Computer", id));
    }

    private Workspace getWorkspaceOrThrow(UUID id) {
        return workspaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workspace", id));
    }
}