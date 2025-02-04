package net.szymonsawicki.personalaitrainer.domain.mapper;

import net.szymonsawicki.personalaitrainer.domain.dto.WorkoutSessionDto;
import net.szymonsawicki.personalaitrainer.domain.entity.WorkoutSession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkoutSessionMapper {
  WorkoutSessionDto toDto(WorkoutSession entity);

  WorkoutSession toEntity(WorkoutSessionDto dto);
}
