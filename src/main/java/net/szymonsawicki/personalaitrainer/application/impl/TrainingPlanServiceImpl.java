package net.szymonsawicki.personalaitrainer.application.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.model.bedrock.BedrockAnthropicMessageChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import lombok.RequiredArgsConstructor;
import net.szymonsawicki.personalaitrainer.application.service.PersonService;
import net.szymonsawicki.personalaitrainer.application.service.TrainingPlanService;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPlanDto;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;
import net.szymonsawicki.personalaitrainer.infrastructure.ai.TrainingPlanAiService;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;

@Service
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {
  private final PersonService personService;
  private final ObjectMapper objectMapper;

  @Override
  public TrainingPlanDto generateTrainingPlanInTextForm(
      TrainingPreferenceDto trainingPreferenceDto) {
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
        service.createTrainingPlan(person, trainingPreferenceDto, trainingPreferenceDto.id());
    try {
      trainingPlanDto = objectMapper.readValue(responseFromLllm, TrainingPlanDto.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return trainingPlanDto;
  }
}
