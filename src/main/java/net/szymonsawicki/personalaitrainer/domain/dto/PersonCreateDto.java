package net.szymonsawicki.personalaitrainer.domain.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import net.szymonsawicki.personalaitrainer.domain.type.Gender;

public record PersonCreateDto(
    @NotBlank(message = "First name is required") String firstName,
    @NotBlank(message = "Last name is required") String lastName,
    @NotBlank(message = "Email address is required") @Email(message = "Invalid email format")
        String mailAddress,
    @NotNull(message = "Gender is required") Gender gender,
    @NotNull(message = "Height is required")
        @Min(value = 1, message = "Height must be greater than 0")
        @Max(value = 300, message = "Height must be less than 300")
        Integer height,
    @NotNull(message = "Starting weight is required")
        @Min(value = 1, message = "Weight must be greater than 0")
        @Max(value = 500, message = "Weight must be less than 500")
        Integer startingWeight,
    @NotNull(message = "Birth date is required") @Past(message = "Birth date must be in the past")
        LocalDate birthDate,
    String chronicIllnesses,
    @NotNull(message = "Experience years is required")
        @Min(value = 0, message = "Experience years must be 0 or greater")
        @Max(value = 100, message = "Experience years must be less than 100")
        Integer experienceYears,
    String injuries) {}
