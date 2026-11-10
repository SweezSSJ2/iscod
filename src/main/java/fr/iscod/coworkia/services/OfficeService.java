package fr.iscod.coworkia.services;

import fr.iscod.coworkia.dtos.mappers.OfficeMapper;
import fr.iscod.coworkia.dtos.requests.OfficePatchRequest;
import fr.iscod.coworkia.dtos.requests.OfficeRequest;
import fr.iscod.coworkia.dtos.responses.OfficeInfoResponse;
import fr.iscod.coworkia.dtos.responses.OfficeResponse;
import fr.iscod.coworkia.entities.Office;
import fr.iscod.coworkia.exceptions.ResourceNotFoundException;
import fr.iscod.coworkia.interfaces.repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;

    public OfficeService(OfficeRepository officeRepository, OfficeMapper officeMapper) {
        this.officeRepository = officeRepository;
        this.officeMapper = officeMapper;
    }

    public OfficeInfoResponse findById(UUID id) {
        return officeMapper.toInfoResponse(getOrThrow(id));
    }

    public List<OfficeResponse> findAll() {
        return officeRepository.findAll().stream().map(officeMapper::toResponse).toList();
    }

    public UUID create(OfficeRequest request) {
        return officeRepository.save(officeMapper.toEntity(request)).getId();
    }

    public void update(UUID id, OfficeRequest request) {
        officeMapper.applyUpdate(getOrThrow(id), request);
    }

    public void partialUpdate(UUID id, OfficePatchRequest request) {
        officeMapper.applyPatch(getOrThrow(id), request);
    }

    public void delete(UUID id) {
        officeRepository.delete(getOrThrow(id));
    }

    private Office getOrThrow(UUID id) {
        return officeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
