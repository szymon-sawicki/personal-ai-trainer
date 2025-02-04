package net.szymonsawicki.personalaitrainer.domain.mapper;

import java.util.List;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPlanDto;
import net.szymonsawicki.personalaitrainer.domain.entity.TrainingPlan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingPlanMapper {
  TrainingPlanDto toDto(TrainingPlan entity);

  TrainingPlan toEntity(TrainingPlanDto dto);

  List<TrainingPlanDto> toDtoList(List<TrainingPlan> entities);
}
