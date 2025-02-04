package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import net.szymonsawicki.personalaitrainer.domain.entity.ProgressionStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressionStrategyRepository extends JpaRepository<ProgressionStrategy, Long> {}
