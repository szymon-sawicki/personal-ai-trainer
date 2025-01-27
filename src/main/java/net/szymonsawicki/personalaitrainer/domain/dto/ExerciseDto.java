package net.szymonsawicki.personalaitrainer.domain.dto;

import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.type.ExerciseType;
import net.szymonsawicki.personalaitrainer.domain.type.HomeEquipment;
import net.szymonsawicki.personalaitrainer.domain.type.TrainingPlace;

public record ExerciseDto(
    Long id,
    String name,
    String description,
    Integer sets,
    Integer reps,
    Integer restPeriodSeconds,
    String notes,
    ExerciseType type,
    TrainingPlace place,
    List<HomeEquipment> requiredEquipment) {}
