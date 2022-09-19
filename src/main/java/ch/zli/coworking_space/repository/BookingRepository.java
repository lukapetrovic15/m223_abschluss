package ch.zli.coworking_space.repository;

import ch.zli.coworking_space.model.BookingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends CrudRepository<BookingEntity, UUID> {

    List<BookingEntity> findAll();

}

