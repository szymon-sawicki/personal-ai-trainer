package net.szymonsawicki.personalaitrainer.application.service;

import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceCreateDto;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;

public interface TrainingPreferenceService {
  TrainingPreferenceDto createTrainingPreference(TrainingPreferenceCreateDto preferenceDto);

  TrainingPreferenceDto updateTrainingPreference(
      Long id, TrainingPreferenceCreateDto preferenceDto);

  TrainingPreferenceDto getTrainingPreferenceById(Long id);

  TrainingPreferenceDto getTrainingPreferenceByPersonId(Long personId);

  List<TrainingPreferenceDto> getAllTrainingPreferences();

  void deleteTrainingPreference(Long id);
}
