package fr.iscod.coworkia.dtos.mappers;

import fr.iscod.coworkia.dtos.requests.OfficePatchRequest;
import fr.iscod.coworkia.dtos.requests.OfficeRequest;
import fr.iscod.coworkia.dtos.responses.OfficeInfoResponse;
import fr.iscod.coworkia.dtos.responses.OfficeResponse;
import fr.iscod.coworkia.entities.Office;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfficeMapper {

    public Office toEntity(OfficeRequest request) {
        Office office = new Office();
        office.setName(request.name());
        office.setAddress(request.address());
        return office;
    }

    public void applyPatch(Office office, OfficePatchRequest patch) {
        if (patch.name() != null) office.setName(patch.name());
        if (patch.address() != null) office.setAddress(patch.address());
    }

    public void applyUpdate(Office office, OfficeRequest request) {
        office.setName(request.name());
        office.setAddress(request.address());
    }

    public OfficeResponse toResponse(Office office) {
        return new OfficeResponse(office.getId(), office.getName(), office.getAddress());
    }

    public OfficeInfoResponse toInfoResponse(Office office) {
        List<OfficeInfoResponse.WorkspaceSummary> workspaces = office.getWorkspaces().stream()
                .map(w -> new OfficeInfoResponse.WorkspaceSummary(
                        w.getId(), w.getCode(), w.getName(), w.getCapacity()))
                .toList();
        return new OfficeInfoResponse(office.getId(), office.getName(), office.getAddress(), workspaces);
    }
}
