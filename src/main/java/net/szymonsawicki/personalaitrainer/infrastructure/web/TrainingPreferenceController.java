package net.szymonsawicki.personalaitrainer.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.szymonsawicki.personalaitrainer.application.service.TrainingPreferenceService;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceCreateDto;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/training-preferences")
@RequiredArgsConstructor
@Tag(
    name = "Training Preference Controller",
    description = "Endpoints for managing training preferences")
public class TrainingPreferenceController {
  private final TrainingPreferenceService trainingPreferenceService;

  @PostMapping
  @Operation(summary = "Create a new training preference")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "201",
            description = "Training preference created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Person not found")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              TrainingPreferenceDto>>
      createTrainingPreference(@Valid @RequestBody TrainingPreferenceCreateDto preferenceDto) {
    TrainingPreferenceDto created =
        trainingPreferenceService.createTrainingPreference(preferenceDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
                "Training preference created successfully", created));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get training preference by ID")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Training preference found"),
        @ApiResponse(responseCode = "404", description = "Training preference not found")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              TrainingPreferenceDto>>
      getTrainingPreference(
          @Parameter(description = "Training Preference ID") @PathVariable Long id) {
    TrainingPreferenceDto preference = trainingPreferenceService.getTrainingPreferenceById(id);
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Training preference retrieved successfully", preference));
  }

  @GetMapping("/person/{personId}")
  @Operation(summary = "Get training preference by person ID")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Training preference found"),
        @ApiResponse(responseCode = "404", description = "Training preference not found")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              TrainingPreferenceDto>>
      getTrainingPreferenceByPersonId(
          @Parameter(description = "Person ID") @PathVariable Long personId) {
    TrainingPreferenceDto preference =
        trainingPreferenceService.getTrainingPreferenceByPersonId(personId);
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Training preference retrieved successfully", preference));
  }

  @GetMapping
  @Operation(summary = "Get all training preferences")
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              List<TrainingPreferenceDto>>>
      getAllTrainingPreferences() {
    List<TrainingPreferenceDto> preferences = trainingPreferenceService.getAllTrainingPreferences();
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Training preferences retrieved successfully", preferences));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update training preference by ID")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Training preference updated successfully"),
        @ApiResponse(responseCode = "404", description = "Training preference not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              TrainingPreferenceDto>>
      updateTrainingPreference(
          @Parameter(description = "Training Preference ID") @PathVariable Long id,
          @Valid @RequestBody TrainingPreferenceCreateDto preferenceDto) {
    TrainingPreferenceDto updated =
        trainingPreferenceService.updateTrainingPreference(id, preferenceDto);
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Training preference updated successfully", updated));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete training preference by ID")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "204",
            description = "Training preference deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Training preference not found")
      })
  public ResponseEntity<Void> deleteTrainingPreference(
      @Parameter(description = "Training Preference ID") @PathVariable Long id) {
    trainingPreferenceService.deleteTrainingPreference(id);
    return ResponseEntity.noContent().build();
  }
}
