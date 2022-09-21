package ch.zli.coworking_space.service;

import ch.zli.coworking_space.exception.ObjectNotFoundException;
import ch.zli.coworking_space.model.MemberEntity;
import ch.zli.coworking_space.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class MemberService {

    private final MemberRepository repository;

    MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<MemberEntity> loadAll() {
        log.info("Executing find all games ...");
        return repository.findAll();
    }

    public Optional<MemberEntity> loadOne(UUID id) {
        log.info("Executing find member with id " + id + " ...");
        return repository.findById(id);
    }

    public MemberEntity create(MemberEntity category) {
        log.info("Executing create category with id " + category.getId() + " ...");
        return repository.save(category);
    }

    @Transactional
    public MemberEntity update(MemberEntity member) {
        log.info("Executing update member with id " + member.getId() + " ...");
        val memberId = member.getId();
        repository.findById(memberId).orElseThrow(() -> new ObjectNotFoundException("Member not found with id " + memberId));
        return repository.save(member);
    }

    public void delete(UUID id) {
        log.info("Executing delete member with id " + id + " ...");
        repository.deleteById(id);
    }

}
