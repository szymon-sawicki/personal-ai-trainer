package net.szymonsawicki.personalaitrainer.domain.dto;

import net.szymonsawicki.personalaitrainer.domain.type.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {}
