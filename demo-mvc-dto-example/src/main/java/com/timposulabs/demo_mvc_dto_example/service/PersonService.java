package com.timposulabs.demo_mvc_dto_example.service;

import com.timposulabs.demo_mvc_dto_example.dto.PersonDTO;
import com.timposulabs.demo_mvc_dto_example.exception.PersonNotFoundException;
import com.timposulabs.demo_mvc_dto_example.mapper.PersonMapper;
import com.timposulabs.demo_mvc_dto_example.model.Person;
import com.timposulabs.demo_mvc_dto_example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonDTO> getAll() {
        return personRepository.findAll().stream()
                .map(personMapper::toPersonDTO)
                .toList();
    }

    public PersonDTO getPersonById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::toPersonDTO)
                .orElseThrow(() -> new PersonNotFoundException("Id not found"));
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = personRepository.save(personMapper.toPerson(personDTO));
        return personMapper.toPersonDTO(person);
    }

    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Id not found"));
        person.setFirstName(personDTO.firstName());
        person.setLastName(personDTO.lastName());

        return personMapper.toPersonDTO(personRepository.save(person));
    }

    public void deletePerson(Long id) {
        personRepository.delete(personRepository.findById(id).orElseThrow(
                () -> new PersonNotFoundException("Id not found")));
    }
}
