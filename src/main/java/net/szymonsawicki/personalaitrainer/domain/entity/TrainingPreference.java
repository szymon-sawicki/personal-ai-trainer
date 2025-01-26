package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import net.szymonsawicki.personalaitrainer.domain.type.CurrentFitnessState;
import net.szymonsawicki.personalaitrainer.domain.type.DayOfWeek;
import net.szymonsawicki.personalaitrainer.domain.type.TrainingPlace;
import net.szymonsawicki.personalaitrainer.domain.type.TrainingTarget;

@Entity
@Table(name = "training_preferences")
@Getter
@Setter
public class TrainingPreference {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id", nullable = false)
  private Person person;

  @Column(name = "times_per_week", nullable = false)
  private Integer timesPerWeek;

  @Column(name = "session_duration", nullable = false)
  private Integer sessionDuration;

  @ElementCollection
  @CollectionTable(
      name = "training_places",
      joinColumns = @JoinColumn(name = "training_preference_id"))
  @Enumerated(EnumType.STRING)
  @Column(name = "training_place")
  private List<TrainingPlace> trainingPlaces;

  @ElementCollection
  @CollectionTable(
      name = "preferred_days",
      joinColumns = @JoinColumn(name = "training_preference_id"))
  @Enumerated(EnumType.STRING)
  @Column(name = "day_of_week")
  private List<DayOfWeek> preferredDays;

  @Enumerated(EnumType.STRING)
  @Column(name = "training_target", nullable = false)
  private TrainingTarget trainingTarget;

  @Enumerated(EnumType.STRING)
  @Column(name = "fitness_state", nullable = false)
  private CurrentFitnessState fitnessState;

  @Column(name = "preferred_start", nullable = false)
  private LocalDate preferredStart;

  @Column(name = "excluded_exercises")
  private String excludedExercises;
}
