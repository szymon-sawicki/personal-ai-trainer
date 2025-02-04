package net.szymonsawicki.personalaitrainer.application.service;

import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.dto.*;

public interface TrainingPlanService {
  TrainingPlanDto generateTrainingPlanInTextForm(TrainingPreferenceDto trainingPreferenceDto);

  TrainingPlanDto createTrainingPlan(TrainingPlanDto trainingPlanDto);

  TrainingPlanDto getTrainingPlan(Long id);

  List<TrainingPlanDto> getTrainingPlansByPreference(Long preferenceId);

  TrainingPlanDto updateTrainingPlan(Long id, TrainingPlanDto trainingPlanDto);

  void deleteTrainingPlan(Long id);

  WeeklyScheduleDto addWeeklySchedule(Long trainingPlanId, WeeklyScheduleDto weeklyScheduleDto);

  WorkoutSessionDto addWorkoutSession(Long weeklyScheduleId, WorkoutSessionDto workoutSessionDto);

  ExerciseDto addExercise(Long workoutSessionId, ExerciseDto exerciseDto);
}
