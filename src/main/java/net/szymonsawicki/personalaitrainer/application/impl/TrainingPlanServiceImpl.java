package net.szymonsawicki.personalaitrainer.application.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.model.bedrock.BedrockAnthropicMessageChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.szymonsawicki.personalaitrainer.application.service.PersonService;
import net.szymonsawicki.personalaitrainer.application.service.TrainingPlanService;
import net.szymonsawicki.personalaitrainer.application.service.TrainingPreferenceService;
import net.szymonsawicki.personalaitrainer.domain.dto.*;
import net.szymonsawicki.personalaitrainer.domain.entity.TrainingPlan;
import net.szymonsawicki.personalaitrainer.domain.mapper.TrainingPlanMapper;
import net.szymonsawicki.personalaitrainer.infrastructure.ai.TrainingPlanAiService;
import net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository.ExerciseRepository;
import net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository.TrainingPlanRepository;
import net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository.WeeklyScheduleRepository;
import net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository.WorkoutSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.amazon.awssdk.regions.Region;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {
  private final PersonService personService;
  private final TrainingPreferenceService trainingPreferenceService;
  private final ObjectMapper objectMapper;
  private final TrainingPlanRepository trainingPlanRepository;
  private final TrainingPlanMapper trainingPlanMapper;
  private final WeeklyScheduleRepository weeklyScheduleRepository;
  private final WorkoutSessionRepository workoutSessionRepository;
  private final ExerciseRepository exerciseRepository;

  @Override
  public TrainingPlanDto generateTrainingPlan(TrainingPreferenceDto trainingPreferenceDto) {
    var person = personService.getPersonById(trainingPreferenceDto.personId());

    ChatLanguageModel model =
        BedrockAnthropicMessageChatModel.builder()
            .temperature(0.50f)
            .maxTokens(2000)
            .region(Region.US_EAST_1)
            .model("us.anthropic.claude-3-5-sonnet-20241022-v2:0")
            .maxRetries(1)
            // Other parameters can be set as well
            .build();

    var service = AiServices.create(TrainingPlanAiService.class, model);

    TrainingPlanDto trainingPlanDto;

    var responseFromLllm =
        service.createTrainingPlan(
            person,
            trainingPreferenceDto,
            trainingPreferenceDto.id(),
            trainingPreferenceDto.personId());
    try {
      trainingPlanDto = objectMapper.readValue(responseFromLllm, TrainingPlanDto.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return trainingPlanDto;
  }

  @Override
  public TrainingPlanDto generateAndSaveTrainingPlan(TrainingPreferenceDto trainingPreferenceDto) {
    var generatedTrainingPlan = generateTrainingPlan(trainingPreferenceDto);
    var savedTrainingPlan =
        trainingPlanRepository.save(trainingPlanMapper.toEntity(generatedTrainingPlan));
    return trainingPlanMapper.toDto(savedTrainingPlan);
  }

  public TrainingPlanDto createTrainingPlan(TrainingPlanDto trainingPlanDto) {
    log.info(
        "Creating new training plan for preference ID: {}", trainingPlanDto.trainingPreferenceId());
    TrainingPlan trainingPlan = trainingPlanMapper.toEntity(trainingPlanDto);
    TrainingPlan savedPlan = trainingPlanRepository.save(trainingPlan);
    return trainingPlanMapper.toDto(savedPlan);
  }

  public TrainingPlanDto getTrainingPlan(Long id) {
    log.info("Fetching training plan with ID: {}", id);
    return trainingPlanRepository
        .findById(id)
        .map(trainingPlanMapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException("Training plan not found with id: " + id));
  }

  public List<TrainingPlanDto> getTrainingPlansByPreference(Long preferenceId) {
    log.info("Fetching training plans for preference ID: {}", preferenceId);
    List<TrainingPlan> plans = trainingPlanRepository.findByTrainingPreferenceId(preferenceId);
    return trainingPlanMapper.toDtoList(plans);
  }

  @Override
  public List<TrainingPlanDto> getTrainingPlansByPersonId(Long personId) {
    log.info("Fetching training plans for person ID: {}", personId);
    List<TrainingPlan> plans = trainingPlanRepository.findAllByPersonId(personId);
    return trainingPlanMapper.toDtoList(plans);
  }

  public TrainingPlanDto updateTrainingPlan(Long id, TrainingPlanDto trainingPlanDto) {
    log.info("Updating training plan with ID: {}", id);
    if (!trainingPlanRepository.existsById(id)) {
      throw new EntityNotFoundException("Training plan not found with id: " + id);
    }
    TrainingPlan trainingPlan = trainingPlanMapper.toEntity(trainingPlanDto);
    trainingPlan.setId(id);
    TrainingPlan updatedPlan = trainingPlanRepository.save(trainingPlan);
    return trainingPlanMapper.toDto(updatedPlan);
  }

  public void deleteTrainingPlan(Long id) {
    log.info("Deleting training plan with ID: {}", id);
    if (!trainingPlanRepository.existsById(id)) {
      throw new EntityNotFoundException("Training plan not found with id: " + id);
    }
    trainingPlanRepository.deleteById(id);
  }

  public WeeklyScheduleDto addWeeklySchedule(
      Long trainingPlanId, WeeklyScheduleDto weeklyScheduleDto) {
    // Implementation for adding weekly schedule
    // Similar pattern as above
    return null; // TODO: Implement
  }

  public WorkoutSessionDto addWorkoutSession(
      Long weeklyScheduleId, WorkoutSessionDto workoutSessionDto) {
    // Implementation for adding workout session
    return null; // TODO: Implement
  }

  public ExerciseDto addExercise(Long workoutSessionId, ExerciseDto exerciseDto) {
    // Implementation for adding exercise
    return null; // TODO: Implement
  }
}
