package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import net.szymonsawicki.personalaitrainer.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByMailAddress(String mailAddress);
    Optional<Person> findByMailAddress(String mailAddress);
}