package net.szymonsawicki.personalaitrainer.domain.dto;

import java.util.List;

public record RecoveryGuidelineDto(
    Long id,
    List<String> recoveryActivities,
    Integer recommendedSleepHours,
    List<String> stretchingRoutines,
    List<String> mobilityExercises) {}
