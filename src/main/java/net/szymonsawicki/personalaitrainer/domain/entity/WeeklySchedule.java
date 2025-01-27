package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "weekly_schedules")
@Getter
@Setter
public class WeeklySchedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "week_number")
  private Integer weekNumber;

  @ManyToOne
  @JoinColumn(name = "training_plan_id")
  private TrainingPlan trainingPlan;

  @OneToMany(mappedBy = "weeklySchedule", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<WorkoutSession> sessions = new ArrayList<>();
}
