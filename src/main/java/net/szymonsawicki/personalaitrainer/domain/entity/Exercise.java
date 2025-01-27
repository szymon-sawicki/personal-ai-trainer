package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import net.szymonsawicki.personalaitrainer.domain.type.ExerciseType;
import net.szymonsawicki.personalaitrainer.domain.type.HomeEquipment;
import net.szymonsawicki.personalaitrainer.domain.type.TrainingPlace;

@Entity
@Table(name = "exercises")
@Getter
@Setter
public class Exercise {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description", length = 1000)
  private String description;

  @Column(name = "sets")
  private Integer sets;

  @Column(name = "reps")
  private Integer reps;

  @Column(name = "rest_period_seconds")
  private Integer restPeriodSeconds;

  @Column(name = "notes", length = 500)
  private String notes;

  @Enumerated(EnumType.STRING)
  @Column(name = "exercise_type")
  private ExerciseType type;

  @Enumerated(EnumType.STRING)
  @Column(name = "training_place")
  private TrainingPlace place;

  @ElementCollection
  @CollectionTable(name = "exercise_equipment", joinColumns = @JoinColumn(name = "exercise_id"))
  @Column(name = "equipment")
  @Enumerated(EnumType.STRING)
  private List<HomeEquipment> requiredEquipment = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "workout_session_id")
  private WorkoutSession workoutSession;

  @ManyToOne
  @JoinColumn(name = "warm_up_id")
  private WarmUp warmUp;

  @ManyToOne
  @JoinColumn(name = "cool_down_id")
  private CoolDown coolDown;
}
