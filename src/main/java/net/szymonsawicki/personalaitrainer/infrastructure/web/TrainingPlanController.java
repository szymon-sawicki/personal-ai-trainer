package net.szymonsawicki.personalaitrainer.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.szymonsawicki.personalaitrainer.application.service.TrainingPlanService;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPlanDto;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/training-plans")
@RequiredArgsConstructor
@Tag(name = "Person Controller", description = "Endpoints for managing persons")
public class TrainingPlanController {
  private final TrainingPlanService trainingPlanService;

  @PostMapping
  @Operation(summary = "Create a new person")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "201", description = "Person created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              TrainingPlanDto>>
      createPerson(@Valid @RequestBody TrainingPreferenceDto trainingPreferenceDto) {
    TrainingPlanDto trainingPlan =
        trainingPlanService.generateTrainingPlanInTextForm(trainingPreferenceDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
                "Training plan create", trainingPlan));
  }
}
