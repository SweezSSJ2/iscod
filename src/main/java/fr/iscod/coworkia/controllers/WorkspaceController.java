package fr.iscod.coworkia.controllers;

import fr.iscod.coworkia.dtos.requests.WorkspacePatchRequest;
import fr.iscod.coworkia.dtos.requests.WorkspaceRequest;
import fr.iscod.coworkia.dtos.responses.WorkspaceResponse;
import fr.iscod.coworkia.services.WorkspaceService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @Operation(summary = "Lister toutes les zones")
    @GetMapping("/workspaces")
    public List<WorkspaceResponse> findAll() {
        return workspaceService.findAll();
    }

    @Operation(summary = "Récupérer une zone")
    @GetMapping("/workspaces/{id}")
    public WorkspaceResponse findById(@PathVariable UUID id) {
        return workspaceService.findById(id);
    }

    @Operation(summary = "Lister les zones d'un espace de coworking")
    @GetMapping("/offices/{officeId}/workspaces")
    public List<WorkspaceResponse> findAllByOffice(@PathVariable UUID officeId) {
        return workspaceService.findAllByOffice(officeId);
    }

    @Operation(summary = "Créer une zone dans un espace de coworking")
    @PostMapping("/offices/{officeId}/workspaces")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID create(@PathVariable UUID officeId, @Valid @RequestBody WorkspaceRequest request) {
        return workspaceService.create(officeId, request);
    }

    @Operation(summary = "Remplacer une zone")
    @PutMapping("/workspaces/{id}")
    public void update(@PathVariable UUID id, @Valid @RequestBody WorkspaceRequest request) {
        workspaceService.update(id, request);
    }

    @Operation(summary = "Modifier partiellement une zone")
    @PatchMapping("/workspaces/{id}")
    public void partialUpdate(@PathVariable UUID id, @Valid @RequestBody WorkspacePatchRequest request) {
        workspaceService.partialUpdate(id, request);
    }

    @Operation(summary = "Supprimer une zone")
    @DeleteMapping("/workspaces/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        workspaceService.delete(id);
    }
}
