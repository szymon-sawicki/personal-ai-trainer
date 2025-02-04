package net.szymonsawicki.personalaitrainer.domain.mapper;

import net.szymonsawicki.personalaitrainer.domain.dto.ExerciseDto;
import net.szymonsawicki.personalaitrainer.domain.entity.Exercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
  ExerciseDto toDto(Exercise entity);

  Exercise toEntity(ExerciseDto dto);
}
