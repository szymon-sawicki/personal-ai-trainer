package net.szymonsawicki.personalaitrainer.application.impl;

import lombok.RequiredArgsConstructor;
import net.szymonsawicki.personalaitrainer.application.service.PersonService;
import net.szymonsawicki.personalaitrainer.application.service.TrainingPlanService;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;
import net.szymonsawicki.personalaitrainer.infrastructure.ai.TrainingPlanAiService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {
  private final TrainingPlanAiService trainingPlanAiService;
  private final PersonService personService;

  @Override
  public String generateTrainingPlanInTextForm(TrainingPreferenceDto trainingPreferenceDto) {
    var person = personService.getPersonById(trainingPreferenceDto.personId());
    return trainingPlanAiService.createTrainingPlan(person, trainingPreferenceDto,trainingPreferenceDto.id());
  }
}
