package net.szymonsawicki.personalaitrainer.domain.dto;

import java.util.List;

public record WarmUpDto(Long id, List<ExerciseDto> exercises, Integer duration) {}
