package ch.zli.coworking_space.repository;

import ch.zli.coworking_space.model.MemberEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends CrudRepository<MemberEntity, UUID> {
    Optional<MemberEntity> findByUsername(String username);

    List<MemberEntity> findAll();


}
