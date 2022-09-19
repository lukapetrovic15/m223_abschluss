package ch.zli.coworking_space.controller;

import ch.zli.coworking_space.exception.ObjectNotFoundException;
import ch.zli.coworking_space.model.PlaceEntity;
import ch.zli.coworking_space.service.PlaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/places")
@Tag(name = "Places", description = "Places management endpoints")
public class PlaceController {

    private final PlaceService placeService;

    PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Operation(
            summary = "Get all places",
            description = "Loads all places from database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @GetMapping
    List<PlaceEntity> loadAll() {
        return placeService.loadAll();
    }

    @Operation(
            summary = "Get one specific place",
            description = "Loads one specific place from database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @GetMapping("/{id}")
    PlaceEntity loadOne(@PathVariable UUID id) {
        return placeService.loadOne(id)
                .orElseThrow(() -> new ObjectNotFoundException("Member with id " + id + " not found!"));
    }

    @Operation(
            summary = "Create a new place",
            description = "Creates a new place in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    PlaceEntity create(@RequestBody PlaceEntity entity) {
        return placeService.create(entity);
    }

    @Operation(
            summary = "Update an existing place",
            description = "Updates one specific and existing place in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    PlaceEntity update(@RequestBody PlaceEntity placeEntity, @PathVariable UUID id) {
        return placeService.update(placeEntity);
    }

    @Operation(
            summary = "Delete an existing place",
            description = "Deletes one specific and existing place in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        placeService.delete(id);
    }

}
