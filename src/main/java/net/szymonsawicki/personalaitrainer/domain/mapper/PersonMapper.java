package net.szymonsawicki.personalaitrainer.domain.mapper;

import net.szymonsawicki.personalaitrainer.domain.dto.PersonCreateDto;
import net.szymonsawicki.personalaitrainer.domain.dto.PersonDto;
import net.szymonsawicki.personalaitrainer.domain.entity.Person;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "trainingPreference", ignore = true)
    Person toEntity(PersonCreateDto dto);

    PersonDto toDto(Person entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Person entity, PersonCreateDto dto);
}