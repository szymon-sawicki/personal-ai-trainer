package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import net.szymonsawicki.personalaitrainer.domain.type.DayOfWeek;

@Entity
@Table(name = "workout_sessions")
@Getter
@Setter
public class WorkoutSession {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "day_of_week")
  private DayOfWeek dayOfWeek;

  @Column(name = "session_duration")
  private Integer sessionDuration;

  @ManyToOne
  @JoinColumn(name = "weekly_schedule_id")
  private WeeklySchedule weeklySchedule;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "warm_up_id")
  private WarmUp warmUp;

  @OneToMany(mappedBy = "workoutSession", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Exercise> mainExercises = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "cool_down_id")
  private CoolDown coolDown;
}
