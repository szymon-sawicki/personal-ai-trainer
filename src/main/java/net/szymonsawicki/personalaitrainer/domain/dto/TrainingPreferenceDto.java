package net.szymonsawicki.personalaitrainer.domain.dto;

import java.time.LocalDate;
import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.type.*;

public record TrainingPreferenceDto(
    Long id,
    Long personId,
    Integer timesPerWeek,
    List<TrainingPlace> trainingPlaces,
    List<DayOfWeek> preferredDays,
    TrainingTarget trainingTarget,
    CurrentFitnessState fitnessState,
    LocalDate preferredStart,
    Integer sessionDuration,
    List<HomeEquipment> availableEquipment,
    String excludedExercises) {}
