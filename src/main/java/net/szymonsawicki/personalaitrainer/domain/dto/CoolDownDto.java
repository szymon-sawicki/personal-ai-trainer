package net.szymonsawicki.personalaitrainer.domain.dto;

import java.util.List;

public record CoolDownDto(Long id, List<ExerciseDto> exercises, Integer duration) {}
