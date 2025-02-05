package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "training_plans")
@Getter
@Setter
public class TrainingPlan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "training_preference_id")
  private Long trainingPreferenceId;

  @ManyToOne
  @JoinColumn(name = "person_id", referencedColumnName = "id")
  private Person person;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @OneToMany(mappedBy = "trainingPlan", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<WeeklySchedule> weeklySchedules = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "nutrition_guideline_id")
  private NutritionGuideline nutritionGuidelines;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "recovery_guideline_id")
  private RecoveryGuideline recoveryGuidelines;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "progression_strategy_id")
  private ProgressionStrategy progressionStrategy;
}
