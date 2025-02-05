package net.szymonsawicki.personalaitrainer.domain.mapper;

import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPlanDto;
import net.szymonsawicki.personalaitrainer.domain.entity.TrainingPlan;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = {
      NutritionGuidelineMapper.class,
      RecoveryGuidelineMapper.class,
      ProgressionStrategyMapper.class
    })
public interface TrainingPlanMapper {

  @Mapping(target = "personId", source = "person.id")
  @Mapping(target = "weeklySchedules", source = "weeklySchedules")
  @Mapping(target = "nutritionGuidelines", source = "nutritionGuidelines")
  @Mapping(target = "recoveryGuidelines", source = "recoveryGuidelines")
  @Mapping(target = "progressionStrategy", source = "progressionStrategy")
  TrainingPlanDto toDto(TrainingPlan entity);

  @Mapping(target = "person.id", source = "personId")
  @Mapping(target = "weeklySchedules", source = "weeklySchedules")
  @Mapping(target = "nutritionGuidelines", source = "nutritionGuidelines")
  @Mapping(target = "recoveryGuidelines", source = "recoveryGuidelines")
  @Mapping(target = "progressionStrategy", source = "progressionStrategy")
  TrainingPlan toEntity(TrainingPlanDto dto);

  List<TrainingPlanDto> toDtoList(List<TrainingPlan> entities);

  @AfterMapping
  default void linkWeeklySchedules(@MappingTarget TrainingPlan trainingPlan) {
    if (trainingPlan.getWeeklySchedules() != null) {
      trainingPlan.getWeeklySchedules().forEach(schedule -> schedule.setTrainingPlan(trainingPlan));
    }
  }
}
