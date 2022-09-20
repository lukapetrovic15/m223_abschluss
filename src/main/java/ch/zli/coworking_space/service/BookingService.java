package ch.zli.coworking_space.service;

import ch.zli.coworking_space.exception.ObjectNotFoundException;
import ch.zli.coworking_space.repository.BookingRepository;
import ch.zli.coworking_space.model.BookingEntity;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public List<BookingEntity> loadAll() {
        log.info("Executing find all members ...");
        return repository.findAll();
    }

    @Transactional
    public Optional<BookingEntity> loadOne(UUID id) {
        log.info("Executing find member with id " + id + " ...");
        return repository.findById(id);
    }

    @Transactional
    public BookingEntity create(BookingEntity booking) {
        log.info("Executing create booking with id " + booking.getId() + " ...");
        return repository.save(booking);
    }

    @Transactional
    public BookingEntity update(BookingEntity booking) {
        log.info("Executing update booking with id " + booking.getId() + " ...");
        val bookingId = booking.getId();
        repository.findById(bookingId).orElseThrow(() -> new ObjectNotFoundException("Booking not found with id " + bookingId));
        return repository.save(booking);
    }

    @Transactional
    public void delete(UUID id) {
        log.info("Executing delete member with id " + id + " ...");
        repository.deleteById(id);
    }

}
