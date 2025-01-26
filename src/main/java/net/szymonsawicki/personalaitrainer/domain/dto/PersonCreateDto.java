package net.szymonsawicki.personalaitrainer.domain.dto;

import java.time.LocalDate;
import net.szymonsawicki.personalaitrainer.domain.type.Gender;

public record PersonCreateDto(
    String firstName,
    String lastName,
    String mailAddress,
    Gender gender,
    Integer height,
    Integer startingWeight,
    LocalDate birthDate,
    String chronicIllnesses) {}
