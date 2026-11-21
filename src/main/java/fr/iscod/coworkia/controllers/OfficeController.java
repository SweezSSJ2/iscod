package fr.iscod.coworkia.controllers;

import fr.iscod.coworkia.dtos.requests.OfficePatchRequest;
import fr.iscod.coworkia.dtos.requests.OfficeRequest;
import fr.iscod.coworkia.dtos.responses.OfficeInfoResponse;
import fr.iscod.coworkia.dtos.responses.OfficeResponse;
import fr.iscod.coworkia.services.OfficeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @Operation(summary = "Récupérer un espace de coworking avec ses zones")
    @GetMapping("/{id}")
    public OfficeInfoResponse findById(@PathVariable UUID id) {
        return officeService.findById(id);
    }

    @Operation(summary = "Lister les espaces de coworking")
    @GetMapping
    public List<OfficeResponse> findAll() {
        return officeService.findAll();
    }

    @Operation(summary = "Créer un espace de coworking")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID create(@Valid @RequestBody OfficeRequest request) {
        return officeService.create(request);
    }

    @Operation(summary = "Remplacer un espace de coworking")
    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @Valid @RequestBody OfficeRequest request) {
        officeService.update(id, request);
    }

    @Operation(summary = "Modifier partiellement un espace de coworking")
    @PatchMapping("/{id}")
    public void partialUpdate(@PathVariable UUID id, @Valid @RequestBody OfficePatchRequest request) {
        officeService.partialUpdate(id, request);
    }

    @Operation(summary = "Supprimer un espace de coworking")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        officeService.delete(id);
    }
}
