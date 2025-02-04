package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
  List<Exercise> findByWorkoutSessionId(Long workoutSessionId);
}
