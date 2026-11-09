package fr.iscod.coworkia.controllers;

import fr.iscod.coworkia.entities.Office;
import fr.iscod.coworkia.services.OfficeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @Operation(summary = "Récupérer un espace de coworking")
    @GetMapping("/{id}")
    public Office findById(@PathVariable UUID id) {
        return officeService.findById(id);
    }

    @Operation(summary = "Récupérer tout les espaces de coworking")
    @GetMapping
    public List<Office> findAll() {
        return officeService.findAll();
    }

    @Operation(summary = "Créer un espace de coworking")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UUID create(@RequestBody Office office) {
        return officeService.create(office);
    }

    @Operation(summary = "Modifier les infos d'un espace de coworking")
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable UUID id, @RequestBody Office office) {
        officeService.update(id, office);
    }

    @Operation(summary = "Modifier certaines infos d'un espace de coworking")
    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable UUID id, @RequestBody Map<String, Object> update) {
        officeService.partialUpdate(id, update);
    }

    @Operation(summary = "Supprimer un espace de coworking")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        officeService.findById(id);
        officeService.delete(id);
    }
}
