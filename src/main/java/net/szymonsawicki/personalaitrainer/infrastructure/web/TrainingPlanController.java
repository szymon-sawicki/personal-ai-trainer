package net.szymonsawicki.personalaitrainer.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
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
@Tag(name = "Training Plan Controller", description = "Endpoints for managing training plans")
public class TrainingPlanController {
  private final TrainingPlanService trainingPlanService;

  @PostMapping
  @Operation(summary = "Create a new training plan")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "201", description = "Training plan created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              TrainingPlanDto>>
      createTrainingPlan(@Valid @RequestBody TrainingPreferenceDto planDto) {
    TrainingPlanDto created = trainingPlanService.generateTrainingPlanInTextForm(planDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
                "Training plan created successfully", created));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get training plan by ID")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Training plan found"),
        @ApiResponse(responseCode = "404", description = "Training plan not found")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              TrainingPlanDto>>
      getTrainingPlan(
          @Parameter(description = "Training Plan ID") @PathVariable(name = "id") Long id) {
    // TrainingPlanDto plan = trainingPlanService.getTrainingPlanById(id);
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Training plan retrieved successfully", null));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update training plan by ID")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Training plan updated successfully"),
        @ApiResponse(responseCode = "404", description = "Training plan not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              TrainingPlanDto>>
      updateTrainingPlan(
          @Parameter(description = "Training Plan ID") @PathVariable(name = "id") Long id,
          @Valid @RequestBody TrainingPlanDto planDto) {
    // TrainingPlanDto updated = trainingPlanService.updateTrainingPlan(id, planDto);
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Training plan updated successfully", null));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete training plan by ID")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "204", description = "Training plan deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Training plan not found")
      })
  public ResponseEntity<Void> deleteTrainingPlan(
      @Parameter(description = "Training Plan ID") @PathVariable(name = "id") Long id) {
    // trainingPlanService.deleteTrainingPlan(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  @Operation(summary = "Get all training plans")
  @ApiResponse(responseCode = "200", description = "List of training plans retrieved successfully")
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              List<TrainingPlanDto>>>
      getAllTrainingPlans() {
    // List<TrainingPlanDto> plans = trainingPlanService.getAllTrainingPlans();
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Training plans retrieved successfully", null));
  }
}
