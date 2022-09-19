package ch.zli.coworking_space.repository;

import ch.zli.coworking_space.model.PlaceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PlaceRepository extends CrudRepository<PlaceEntity, UUID> {

    List<PlaceEntity> findAll();
}
