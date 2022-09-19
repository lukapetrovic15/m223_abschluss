package ch.zli.coworking_space.service;

import ch.zli.coworking_space.model.PlaceEntity;
import ch.zli.coworking_space.repository.PlaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class PlaceService {

    private final PlaceRepository repository;

    PlaceService(PlaceRepository repository) {
        this.repository = repository;
    }

    public List<PlaceEntity> loadAll() {
        log.info("Executing find all places ...");
        return (List<PlaceEntity>) repository.findAll();
    }

    public Optional<PlaceEntity> loadOne(UUID id) {
        log.info("Executing find place with id " + id + " ...");
        return repository.findById(id);
    }

    public PlaceEntity create(PlaceEntity place) {
        log.info("Executing create place with id " + place.getId() + " ...");
        return repository.save(place);
    }

    public PlaceEntity update(PlaceEntity updatedPlace) {
        log.info("Executing update place with id " + updatedPlace.getId() + " ...");
        return repository.save(updatedPlace);
    }

    public void delete(UUID id) {
        log.info("Executing delete place with id " + id + " ...");
        repository.deleteById(id);
    }
}
