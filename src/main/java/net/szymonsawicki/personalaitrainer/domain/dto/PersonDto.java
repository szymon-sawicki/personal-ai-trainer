package net.szymonsawicki.personalaitrainer.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import net.szymonsawicki.personalaitrainer.domain.type.Gender;

public record PersonDto(
    Long id,
    String firstName,
    String lastName,
    String mailAddress,
    Gender gender,
    Integer height,
    Integer startingWeight,
    LocalDate birthDate,
    String chronicIllnesses,
    String injuries,
    Integer experienceYears,
    TrainingPreferenceDto trainingPreference,
    TrainingPlanDto trainingPlan,
    LocalDateTime createdAt,
    LocalDateTime modifiedAt) {}
