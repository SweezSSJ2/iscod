package fr.iscod.coworkia.controllers;

import fr.iscod.coworkia.dtos.requests.ComputerPatchRequest;
import fr.iscod.coworkia.dtos.requests.ComputerRequest;
import fr.iscod.coworkia.dtos.responses.ComputerResponse;
import fr.iscod.coworkia.services.ComputerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    /*@Operation(summary = "Récupérer un espace de coworking")
    @GetMapping("/{id}")
    public ComputerResponse findById(@PathVariable UUID id) {
        return computerService.findById(id);
    }*/

    @Operation(summary = "Récupérer tout les espaces de coworking")
    @GetMapping
    public List<ComputerResponse> findAll() {
        return computerService.findAll();
    }

    @Operation(summary = "Créer un espace de coworking")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UUID create(@RequestBody ComputerRequest computer) {
        return computerService.create(computer);
    }

    @Operation(summary = "Modifier les infos d'un espace de coworking")
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable UUID id, @RequestBody ComputerRequest computer) {
        computerService.update(id, computer);
    }

    @Operation(summary = "Modifier certaines infos d'un espace de coworking")
    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable UUID id, @RequestBody ComputerPatchRequest update) {
        computerService.partialUpdate(id, update);
    }

    @Operation(summary = "Supprimer un espace de coworking")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        computerService.delete(id);
    }
}
