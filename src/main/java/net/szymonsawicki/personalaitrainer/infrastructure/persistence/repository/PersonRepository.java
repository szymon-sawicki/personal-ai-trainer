package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import java.util.Optional;
import net.szymonsawicki.personalaitrainer.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
  boolean existsByMailAddress(String mailAddress);

  Optional<Person> findByMailAddress(String mailAddress);
}
