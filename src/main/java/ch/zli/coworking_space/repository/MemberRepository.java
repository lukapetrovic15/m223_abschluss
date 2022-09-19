package ch.zli.coworking_space.repository;

import ch.zli.coworking_space.model.MemberEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends CrudRepository<MemberEntity, UUID> {

    Optional<MemberEntity> findByEmail(String email);

}
