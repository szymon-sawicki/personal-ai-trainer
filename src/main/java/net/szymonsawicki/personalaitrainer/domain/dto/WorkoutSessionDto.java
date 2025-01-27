package net.szymonsawicki.personalaitrainer.domain.dto;

import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.type.DayOfWeek;

public record WorkoutSessionDto(
    Long id,
    DayOfWeek dayOfWeek,
    Integer sessionDuration,
    WarmUpDto warmUp,
    List<ExerciseDto> mainExercises,
    CoolDownDto coolDown) {}
