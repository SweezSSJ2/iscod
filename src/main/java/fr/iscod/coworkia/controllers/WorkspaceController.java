package fr.iscod.coworkia.controllers;

import fr.iscod.coworkia.entities.Workspace;
import fr.iscod.coworkia.services.OfficeService;
import fr.iscod.coworkia.services.WorkspaceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;
    @Autowired
    private OfficeService officeService;

    @Operation(summary = "Récupérer tout les espaces de travail")
    @GetMapping("/workspaces")
    public List<Workspace> findAll() {
        return workspaceService.findAll();
    }

    @Operation(summary = "Récupérer tout les espaces de travail d'un office")
    @GetMapping("/offices/{officeId}/workspaces")
    public Set<Workspace> findAllByOffice(@PathVariable UUID officeId) {
        officeService.findById(officeId);
        return workspaceService.findAllByOffice(officeId);
    }
}
