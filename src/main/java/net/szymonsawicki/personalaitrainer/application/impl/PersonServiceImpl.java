package net.szymonsawicki.personalaitrainer.application.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import net.szymonsawicki.personalaitrainer.application.service.PersonService;
import net.szymonsawicki.personalaitrainer.domain.dto.PersonCreateDto;
import net.szymonsawicki.personalaitrainer.domain.dto.PersonDto;
import net.szymonsawicki.personalaitrainer.domain.entity.Person;
import net.szymonsawicki.personalaitrainer.domain.mapper.PersonMapper;
import net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    @Transactional
    public PersonDto createPerson(PersonCreateDto personDto) {
        if (existsByMailAddress(personDto.mailAddress())) {
            throw new IllegalArgumentException("Person with this email already exists");
        }

        Person person = personMapper.toEntity(personDto);
        Person savedPerson = personRepository.save(person);
        return personMapper.toDto(savedPerson);
    }

    @Override
    @Transactional
    public PersonDto updatePerson(Long id, PersonCreateDto personDto) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + id));

        // Check if email is being changed and if new email already exists
        if (!person.getMailAddress().equals(personDto.mailAddress()) &&
                existsByMailAddress(personDto.mailAddress())) {
            throw new IllegalArgumentException("Person with this email already exists");
        }

        personMapper.updateEntity(person, personDto);
        Person updatedPerson = personRepository.save(person);
        return personMapper.toDto(updatedPerson);
    }

    @Override
    public PersonDto getPersonById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + id));
        return personMapper.toDto(person);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException("Person not found with id: " + id);
        }
        personRepository.deleteById(id);
    }

    @Override
    public boolean existsByMailAddress(String mailAddress) {
        return personRepository.existsByMailAddress(mailAddress);
    }
}