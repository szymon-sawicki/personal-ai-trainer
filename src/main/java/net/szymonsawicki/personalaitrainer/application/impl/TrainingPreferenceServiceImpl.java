package net.szymonsawicki.personalaitrainer.application.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.szymonsawicki.personalaitrainer.application.service.TrainingPreferenceService;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceCreateDto;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;
import net.szymonsawicki.personalaitrainer.domain.entity.Person;
import net.szymonsawicki.personalaitrainer.domain.entity.TrainingPreference;
import net.szymonsawicki.personalaitrainer.domain.mapper.TrainingPreferenceMapper;
import net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository.PersonRepository;
import net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository.TrainingPreferenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TrainingPreferenceServiceImpl implements TrainingPreferenceService {
  private final TrainingPreferenceRepository trainingPreferenceRepository;
  private final PersonRepository personRepository;
  private final TrainingPreferenceMapper trainingPreferenceMapper;

  @Override
  @Transactional
  public TrainingPreferenceDto createTrainingPreference(TrainingPreferenceCreateDto preferenceDto) {
    // Verify person exists
    Person person =
        personRepository
            .findById(preferenceDto.personId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Person not found with id: " + preferenceDto.personId()));

    // Check if person already has training preferences
    if (trainingPreferenceRepository.findByPersonId(preferenceDto.personId()).isPresent()) {
      throw new IllegalStateException("Training preference already exists for this person");
    }

    TrainingPreference preference = trainingPreferenceMapper.toEntity(preferenceDto);
    preference.setPerson(person);
    TrainingPreference savedPreference = trainingPreferenceRepository.save(preference);
    return trainingPreferenceMapper.toDto(savedPreference);
  }

  @Override
  @Transactional
  public TrainingPreferenceDto updateTrainingPreference(
      Long id, TrainingPreferenceCreateDto preferenceDto) {
    TrainingPreference preference =
        trainingPreferenceRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Training preference not found with id: " + id));

    trainingPreferenceMapper.updateEntity(preference, preferenceDto);
    TrainingPreference updatedPreference = trainingPreferenceRepository.save(preference);
    return trainingPreferenceMapper.toDto(updatedPreference);
  }

  @Override
  public TrainingPreferenceDto getTrainingPreferenceById(Long id) {
    TrainingPreference preference =
        trainingPreferenceRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Training preference not found with id: " + id));
    return trainingPreferenceMapper.toDto(preference);
  }

  @Override
  public TrainingPreferenceDto getTrainingPreferenceByPersonId(Long personId) {
    TrainingPreference preference =
        trainingPreferenceRepository
            .findByPersonId(personId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Training preference not found for person id: " + personId));
    return trainingPreferenceMapper.toDto(preference);
  }

  @Override
  public List<TrainingPreferenceDto> getAllTrainingPreferences() {
    return trainingPreferenceRepository.findAll().stream()
        .map(trainingPreferenceMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void deleteTrainingPreference(Long id) {
    if (!trainingPreferenceRepository.existsById(id)) {
      throw new EntityNotFoundException("Training preference not found with id: " + id);
    }
    trainingPreferenceRepository.deleteById(id);
  }
}
