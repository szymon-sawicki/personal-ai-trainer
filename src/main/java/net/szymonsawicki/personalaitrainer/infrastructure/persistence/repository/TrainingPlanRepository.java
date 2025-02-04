package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import net.szymonsawicki.personalaitrainer.domain.entity.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {
  List<TrainingPlan> findByTrainingPreferenceId(Long trainingPreferenceId);

  Optional<TrainingPlan> findByIdAndTrainingPreferenceId(Long id, Long trainingPreferenceId);
}
