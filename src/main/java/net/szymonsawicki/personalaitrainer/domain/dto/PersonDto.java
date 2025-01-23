package net.szymonsawicki.personalaitrainer.domain.dto;

import net.szymonsawicki.personalaitrainer.domain.type.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {}
