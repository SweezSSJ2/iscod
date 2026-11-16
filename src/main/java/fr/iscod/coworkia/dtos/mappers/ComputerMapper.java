package fr.iscod.coworkia.dtos.mappers;

import fr.iscod.coworkia.dtos.requests.ComputerPatchRequest;
import fr.iscod.coworkia.dtos.requests.ComputerRequest;
import fr.iscod.coworkia.dtos.responses.ComputerResponse;
import fr.iscod.coworkia.entities.Computer;
import org.springframework.stereotype.Component;

@Component
public class ComputerMapper {

    public Computer toEntity(ComputerRequest request) {
        Computer computer = new Computer();
        computer.setName(request.name());
        computer.setWorkspace(request.workspace());
        return computer;
    }

    public void applyPatch(Computer computer, ComputerPatchRequest patch) {
        if (patch.name() != null) computer.setName(patch.name());
        if (patch.workspace() != null) computer.setWorkspace(patch.workspace());
    }

    public void applyUpdate(Computer computer, ComputerRequest request) {
        computer.setName(request.name());
        computer.setWorkspace(request.workspace());
    }

    public ComputerResponse toResponse(Computer computer) {
        return new ComputerResponse(computer.getId(), computer.getName(), computer.getWorkspace());
    }

    /*public ComputerInfoResponse toInfoResponse(Computer computer) {
        List<ComputerInfoResponse.BookingSummary> computers = computer.getBookings().stream()
                .map(b -> new ComputerInfoResponse.BookingSummary(
                        b.getId(), b.getCode(), b.getName(), b.getCapacity()))
                .toList();
        return new ComputerInfoResponse(computer.getId(), computer.getName(), computer.getAddress(), bookings);
    }*/
}
