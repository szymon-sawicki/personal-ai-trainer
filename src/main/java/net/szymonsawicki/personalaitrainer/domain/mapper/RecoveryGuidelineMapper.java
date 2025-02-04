package net.szymonsawicki.personalaitrainer.domain.mapper;

import net.szymonsawicki.personalaitrainer.domain.dto.RecoveryGuidelineDto;
import net.szymonsawicki.personalaitrainer.domain.entity.RecoveryGuideline;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecoveryGuidelineMapper {
  RecoveryGuidelineDto toDto(RecoveryGuideline entity);

  RecoveryGuideline toEntity(RecoveryGuidelineDto dto);
}
