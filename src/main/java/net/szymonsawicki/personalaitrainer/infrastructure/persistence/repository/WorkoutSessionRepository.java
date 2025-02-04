package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.entity.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {
  List<WorkoutSession> findByWeeklyScheduleId(Long weeklyScheduleId);
}
