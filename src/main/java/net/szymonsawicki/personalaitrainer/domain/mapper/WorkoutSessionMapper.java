package net.szymonsawicki.personalaitrainer.domain.mapper;

import net.szymonsawicki.personalaitrainer.domain.dto.WorkoutSessionDto;
import net.szymonsawicki.personalaitrainer.domain.entity.WorkoutSession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkoutSessionMapper {
  WorkoutSessionDto toDto(WorkoutSession entity);

  @Mapping(target = "sessionDuration", ignore = true)
  @Mapping(target = "warmUp", ignore = true)
  @Mapping(target = "coolDown", ignore = true)
  @Mapping(target = "weeklySchedule", ignore = true)
  WorkoutSession toEntity(WorkoutSessionDto dto);
}
