package net.szymonsawicki.personalaitrainer.application.service;

import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPlanDto;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;

public interface TrainingPlanService {
  TrainingPlanDto generateTrainingPlanInTextForm(TrainingPreferenceDto trainingPreferenceDto);
}
