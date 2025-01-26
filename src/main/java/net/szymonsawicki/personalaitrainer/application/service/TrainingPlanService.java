package net.szymonsawicki.personalaitrainer.application.service;

import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;

public interface TrainingPlanService {
  String generateTrainingPlanInTextForm(TrainingPreferenceDto trainingPreferenceDto);
}
