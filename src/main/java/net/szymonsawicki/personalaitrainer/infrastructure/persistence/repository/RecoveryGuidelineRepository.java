package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import net.szymonsawicki.personalaitrainer.domain.entity.RecoveryGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryGuidelineRepository extends JpaRepository<RecoveryGuideline, Long> {}
