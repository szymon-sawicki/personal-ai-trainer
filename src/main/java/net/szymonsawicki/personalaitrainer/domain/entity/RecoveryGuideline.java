package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recovery_guidelines")
@Getter
@Setter
public class RecoveryGuideline {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ElementCollection
  @CollectionTable(
      name = "recovery_activities",
      joinColumns = @JoinColumn(name = "recovery_guideline_id"))
  @Column(name = "activity", length = 500)
  private List<String> recoveryActivities = new ArrayList<>();

  @Column(name = "recommended_sleep_hours")
  private Integer recommendedSleepHours;

  @ElementCollection
  @CollectionTable(
      name = "stretching_routines",
      joinColumns = @JoinColumn(name = "recovery_guideline_id"))
  @Column(name = "routine", length = 500)
  private List<String> stretchingRoutines = new ArrayList<>();

  @ElementCollection
  @CollectionTable(
      name = "mobility_exercises",
      joinColumns = @JoinColumn(name = "recovery_guideline_id"))
  @Column(name = "exercise", length = 500)
  private List<String> mobilityExercises = new ArrayList<>();
}
