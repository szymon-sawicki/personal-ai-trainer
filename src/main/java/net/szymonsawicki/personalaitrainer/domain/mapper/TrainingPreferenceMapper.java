package net.szymonsawicki.personalaitrainer.domain.mapper;

import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceCreateDto;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;
import net.szymonsawicki.personalaitrainer.domain.entity.TrainingPreference;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrainingPreferenceMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "person.id", source = "personId")
  TrainingPreference toEntity(TrainingPreferenceCreateDto dto);

  @Mapping(target = "personId", source = "person.id")
  TrainingPreferenceDto toDto(TrainingPreference entity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntity(@MappingTarget TrainingPreference entity, TrainingPreferenceCreateDto dto);
}
