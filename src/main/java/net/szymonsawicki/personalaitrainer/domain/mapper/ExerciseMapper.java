package net.szymonsawicki.personalaitrainer.domain.mapper;

import net.szymonsawicki.personalaitrainer.domain.dto.ExerciseDto;
import net.szymonsawicki.personalaitrainer.domain.entity.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
  ExerciseDto toDto(Exercise entity);

  @Mapping(target = "workoutSession", ignore = true)
  @Mapping(target = "warmUp", ignore = true)
  @Mapping(target = "coolDown", ignore = true)
  Exercise toEntity(ExerciseDto dto);
}
