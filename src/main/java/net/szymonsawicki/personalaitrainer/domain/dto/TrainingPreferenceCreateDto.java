package net.szymonsawicki.personalaitrainer.domain.dto;

import net.szymonsawicki.personalaitrainer.domain.type.CurrentFitnessState;
import net.szymonsawicki.personalaitrainer.domain.type.DayOfWeek;
import net.szymonsawicki.personalaitrainer.domain.type.TrainingPlace;
import net.szymonsawicki.personalaitrainer.domain.type.TrainingTarget;

import java.time.LocalDate;
import java.util.List;

public record TrainingPreferenceCreateDto(
        Long personId,
        Integer timesPerWeek,
        List<TrainingPlace> trainingPlaces,
        List<DayOfWeek> preferredDays,
        TrainingTarget trainingTarget,
        CurrentFitnessState fitnessState,
        LocalDate preferredStart
) {}
