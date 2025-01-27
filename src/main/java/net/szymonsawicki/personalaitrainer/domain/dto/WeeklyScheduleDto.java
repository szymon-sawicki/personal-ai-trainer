package net.szymonsawicki.personalaitrainer.domain.dto;

import java.util.List;

public record WeeklyScheduleDto(Long id, Integer weekNumber, List<WorkoutSessionDto> sessions) {}
