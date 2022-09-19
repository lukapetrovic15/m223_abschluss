package ch.zli.coworking_space.service;

import ch.zli.coworking_space.repository.BookingRepository;
import ch.zli.coworking_space.model.BookingEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class BookingService {

    private final BookingRepository repository;

    BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public List<BookingEntity> loadAll() {
        log.info("Executing find all members ...");
        return repository.findAll();
    }

    public Optional<BookingEntity> loadOne(UUID id) {
        log.info("Executing find member with id " + id + " ...");
        return repository.findById(id);
    }

    public BookingEntity create(BookingEntity booking) {
        log.info("Executing create booking with id " + booking.getId() + " ...");
        return repository.save(booking);
    }

    public BookingEntity update(BookingEntity updatedBooking) {
        log.info("Executing update member with id " + updatedBooking.getId() + " ...");
        return repository.save(updatedBooking);
    }

    public void delete(UUID id) {
        log.info("Executing delete member with id " + id + " ...");
        repository.deleteById(id);
    }

}
