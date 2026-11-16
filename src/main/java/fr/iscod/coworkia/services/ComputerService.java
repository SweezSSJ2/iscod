package fr.iscod.coworkia.services;

import fr.iscod.coworkia.dtos.mappers.ComputerMapper;
import fr.iscod.coworkia.dtos.requests.ComputerPatchRequest;
import fr.iscod.coworkia.dtos.requests.ComputerRequest;
import fr.iscod.coworkia.dtos.responses.ComputerResponse;
import fr.iscod.coworkia.entities.Computer;
import fr.iscod.coworkia.exceptions.ResourceNotFoundException;
import fr.iscod.coworkia.interfaces.repositories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;
    private final ComputerMapper computerMapper;

    public ComputerService(ComputerRepository computerRepository, ComputerMapper computerMapper) {
        this.computerRepository = computerRepository;
        this.computerMapper = computerMapper;
    }

    /*public ComputerResponse findById(UUID id) {
        return computerMapper.toInfoResponse(getOrThrow(id));
    }*/

    public List<ComputerResponse> findAll() {
        return computerRepository.findAll().stream().map(computerMapper::toResponse).toList();
    }

    public UUID create(ComputerRequest request) {
        return computerRepository.save(computerMapper.toEntity(request)).getId();
    }

    public void update(UUID id, ComputerRequest request) {
        computerMapper.applyUpdate(getOrThrow(id), request);
    }

    public void partialUpdate(UUID id, ComputerPatchRequest request) {
        computerMapper.applyPatch(getOrThrow(id), request);
    }

    public void delete(UUID id) {
        computerRepository.delete(getOrThrow(id));
    }

    private Computer getOrThrow(UUID id) {
        return computerRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
