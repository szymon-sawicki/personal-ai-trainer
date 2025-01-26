package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import net.szymonsawicki.personalaitrainer.domain.entity.TrainingPreference;
import net.szymonsawicki.personalaitrainer.domain.type.TrainingTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingPreferenceRepository extends JpaRepository<TrainingPreference, Long> {
  Optional<TrainingPreference> findByPersonId(Long personId);

  List<TrainingPreference> findByTrainingTarget(TrainingTarget trainingTarget);
}
