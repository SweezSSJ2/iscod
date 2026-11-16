package fr.iscod.coworkia.dtos.responses;

import java.util.List;
import java.util.UUID;

public record ComputerInfoResponse(
        UUID id,
        String name,
        String address,
        List<BookingInfo> booking) {
    public record BookingInfo(
            UUID id,
            String code,
            String name,
            Integer capacity
    ) {}
}