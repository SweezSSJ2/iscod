package fr.iscod.coworkia.controllers;

import fr.iscod.coworkia.dtos.requests.ComputerPatchRequest;
import fr.iscod.coworkia.dtos.requests.ComputerRequest;
import fr.iscod.coworkia.dtos.responses.ComputerResponse;
import fr.iscod.coworkia.services.ComputerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ComputerController {

    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @Operation(summary = "Lister tous les postes")
    @GetMapping("/computers")
    public List<ComputerResponse> findAll() {
        return computerService.findAll();
    }

    @Operation(summary = "Lister les postes d'une zone")
    @GetMapping("/workspaces/{workspaceId}/computers")
    public List<ComputerResponse> findAllByWorkspace(@PathVariable UUID workspaceId) {
        return computerService.findAllByWorkspace(workspaceId);
    }

    @Operation(summary = "Créer un poste")
    @PostMapping("/computers")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID create(@Valid @RequestBody ComputerRequest request) {
        return computerService.create(request);
    }

    @Operation(summary = "Remplacer un poste")
    @PutMapping("/computers/{id}")
    public void update(@PathVariable UUID id, @Valid @RequestBody ComputerRequest request) {
        computerService.update(id, request);
    }

    @Operation(summary = "Modifier partiellement un poste")
    @PatchMapping("/computers/{id}")
    public void partialUpdate(@PathVariable UUID id, @Valid @RequestBody ComputerPatchRequest request) {
        computerService.partialUpdate(id, request);
    }

    @Operation(summary = "Supprimer un poste")
    @DeleteMapping("/computers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        computerService.delete(id);
    }
}
