package net.szymonsawicki.personalaitrainer.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record TrainingPlanDto(
    Long id,
    Long trainingPreferenceId,
    Long personId,
    LocalDate startDate,
    LocalDate endDate,
    List<WeeklyScheduleDto> weeklySchedules,
    NutritionGuidelineDto nutritionGuidelines,
    RecoveryGuidelineDto recoveryGuidelines,
    ProgressionStrategyDto progressionStrategy) {}
