package net.szymonsawicki.personalaitrainer.domain.mapper;

import net.szymonsawicki.personalaitrainer.domain.dto.ProgressionStrategyDto;
import net.szymonsawicki.personalaitrainer.domain.entity.ProgressionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgressionStrategyMapper {
  ProgressionStrategyDto toDto(ProgressionStrategy entity);

  ProgressionStrategy toEntity(ProgressionStrategyDto dto);
}
