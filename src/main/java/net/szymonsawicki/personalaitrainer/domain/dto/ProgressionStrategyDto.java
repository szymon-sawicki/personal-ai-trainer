package net.szymonsawicki.personalaitrainer.domain.dto;

import java.util.List;

public record ProgressionStrategyDto(
    Long id,
    Integer progressionTimeframeWeeks,
    String progressionMethod,
    List<String> progressionMilestones,
    List<String> adjustmentGuidelines) {}
