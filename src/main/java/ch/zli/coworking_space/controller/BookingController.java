package ch.zli.coworking_space.controller;

import ch.zli.coworking_space.service.MemberService;
import ch.zli.coworking_space.service.PlaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import ch.zli.coworking_space.exception.ObjectNotFoundException;
import ch.zli.coworking_space.model.BookingEntity;
import ch.zli.coworking_space.service.BookingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookings")
@Tag(name = "Booking", description = "Booking management endpoints")
public class BookingController {

    private final BookingService bookingService;
    private final MemberService memberService;
    private final PlaceService placeService;


    BookingController(BookingService bookingService, MemberService memberService, PlaceService placeService) {
        this.bookingService = bookingService;
        this.memberService = memberService;
        this.placeService = placeService;
    }

    @Operation(
            summary = "Get all bookings",
            description = "Loads all bookings from database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @GetMapping
    List<BookingEntity> loadAll() {
        return bookingService.loadAll();
    }

    @Operation(
            summary = "Get one specific booking",
            description = "Loads one specific booking from database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @GetMapping("/{id}")
    BookingEntity loadOne(@PathVariable UUID id) {
        return bookingService.loadOne(id)
                .orElseThrow(() -> new ObjectNotFoundException("Booking with id " + id + " not found!"));
    }

    @Operation(
            summary = "Create a new booking",
            description = "Creates a new booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    BookingEntity create(@RequestBody BookingEntity entity) {

        return bookingService.create(entity);
    }

    @Operation(
            summary = "Update an existing booking",
            description = "Updates one specific and existing booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    BookingEntity update(@RequestBody BookingEntity updatedBookingEntity, @PathVariable UUID id) {

        return bookingService.update(updatedBookingEntity);
    }

    @Operation(
            summary = "Delete an existing booking",
            description = "Deletes one specific and existing booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        bookingService.delete(id);
    }

}
