package ch.zli.coworking_space.service;

import ch.zli.coworking_space.exception.ObjectNotFoundException;
import ch.zli.coworking_space.model.PlaceEntity;
import ch.zli.coworking_space.repository.PlaceRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class PlaceService {

    private final PlaceRepository repository;

    PlaceService(PlaceRepository repository) { this.repository = repository; }

    @Transactional
    public List<PlaceEntity> loadAll() {
        log.info("Executing find all places ...");
        return (List<PlaceEntity>) repository.findAll();
    }

    @Transactional
    public Optional<PlaceEntity> loadOne(UUID id) {
        log.info("Executing find place with id " + id + " ...");
        return repository.findById(id);
    }

    @Transactional
    public PlaceEntity create(PlaceEntity place) {
        log.info("Executing create place with id " + place.getId() + " ...");
        return repository.save(place);
    }

    @Transactional
    public PlaceEntity update(PlaceEntity place) {
        log.info("Executing update place with id " + place.getId() + " ...");
        val placeId = place.getId();
        repository.findById(placeId).orElseThrow(() -> new ObjectNotFoundException("Place not found with id " + placeId));
        return repository.save(place);
    }

    public void delete(UUID id) {
        log.info("Executing delete place with id " + id + " ...");
        repository.deleteById(id);
    }
}
