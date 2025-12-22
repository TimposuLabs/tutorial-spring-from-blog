package com.timposulabs.mvc.crud.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.timposulabs.mvc.crud.dto.PersonDTO;
import com.timposulabs.mvc.crud.model.Person;
import com.timposulabs.mvc.crud.repository.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;    

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Page<PersonDTO> getAllPersons(Pageable pageable) {
        return personRepository.findAll(pageable)
                .map(this::toDTO);
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        return personRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    @Override
    @Transactional
    public PersonDTO createPerson(PersonDTO personDTO) {
        return toDTO(personRepository.save(toEntity(personDTO)));
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setEmail(personDTO.getEmail());
        return toDTO(personRepository.save(person));
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
        personRepository.delete(person);
    }

    // handle email unique constraint for validation
    @Override
    public boolean isEmailUnique(String email, Long id) {
        if (id == null) {
            // Mode Create: tidak boleh ada email sama sekali
            return !personRepository.existsByEmail(email);
        } else {
            // Mode Update: tidak boleh ada email yang sama milik ORANG LAIN
            return !personRepository.existsByEmailAndIdNot(email, id);
        }
    }

    // Helper for convert between dto and entity
    private PersonDTO toDTO(Person person) {
        return new PersonDTO(
            person.getId(), 
            person.getFirstName(), 
            person.getLastName(), 
            person.getEmail());
    }

    private Person toEntity(PersonDTO personDTO) {
        return new Person(
            personDTO.getId(),
            personDTO.getFirstName(), 
            personDTO.getLastName(), 
            personDTO.getEmail());
    }
}
