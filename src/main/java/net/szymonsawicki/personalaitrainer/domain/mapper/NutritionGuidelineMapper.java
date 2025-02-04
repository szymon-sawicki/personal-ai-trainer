package net.szymonsawicki.personalaitrainer.domain.mapper;

import net.szymonsawicki.personalaitrainer.domain.dto.NutritionGuidelineDto;
import net.szymonsawicki.personalaitrainer.domain.entity.NutritionGuideline;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NutritionGuidelineMapper {
  NutritionGuidelineDto toDto(NutritionGuideline entity);

  NutritionGuideline toEntity(NutritionGuidelineDto dto);
}
