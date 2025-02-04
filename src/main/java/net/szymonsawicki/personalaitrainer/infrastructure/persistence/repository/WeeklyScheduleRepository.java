package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.entity.WeeklySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyScheduleRepository extends JpaRepository<WeeklySchedule, Long> {
  List<WeeklySchedule> findByTrainingPlanId(Long trainingPlanId);
}
