package com.timposulabs.springboot.dto.stream.service;

import com.timposulabs.springboot.dto.stream.dto.PersonDTO;
import com.timposulabs.springboot.dto.stream.exception.NotFoundException;
import com.timposulabs.springboot.dto.stream.model.Person;
import com.timposulabs.springboot.dto.stream.repository.PersonRepository;
import com.timposulabs.springboot.dto.stream.util.PersonMapperToDTO;
import com.timposulabs.springboot.dto.stream.util.PersonMapperToEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapperToDTO personMapperToDTO;
    private final PersonMapperToEntity personMapperToEntity;

    public PersonService(PersonRepository personRepository, PersonMapperToDTO personMapperToDTO, PersonMapperToEntity personMapperToEntity) {
        this.personRepository = personRepository;
        this.personMapperToDTO = personMapperToDTO;
        this.personMapperToEntity = personMapperToEntity;
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll()
                .stream()
                .map(person -> personMapperToDTO.apply(person))
                .collect(Collectors.toList());
    }

    public PersonDTO findByID(Long id) {
        return personRepository.findById(id)
                .map(person -> personMapperToDTO.apply(person))
                .orElseThrow(() -> new NotFoundException("ID Not Found"));
    }

    public PersonDTO create(PersonDTO personDTO) {
        return personMapperToDTO.apply(personRepository.save(personMapperToEntity.apply(personDTO)));
    }

    public PersonDTO update(Long id, PersonDTO personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID Not Found"));
        person.setFirstName(personDTO.firstName());
        person.setLastName(personDTO.lastName());
        return personMapperToDTO.apply(personRepository.save(person));
    }

    public void delete(Long id) {
        personRepository.delete(personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID Not Found")));
    }
}
