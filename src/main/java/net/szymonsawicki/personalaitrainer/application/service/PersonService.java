package net.szymonsawicki.personalaitrainer.application.service;

import net.szymonsawicki.personalaitrainer.domain.dto.PersonCreateDto;
import net.szymonsawicki.personalaitrainer.domain.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto createPerson(PersonCreateDto personDto);
    PersonDto updatePerson(Long id, PersonCreateDto personDto);
    PersonDto getPersonById(Long id);
    List<PersonDto> getAllPersons();
    void deletePerson(Long id);
    boolean existsByMailAddress(String mailAddress);
}