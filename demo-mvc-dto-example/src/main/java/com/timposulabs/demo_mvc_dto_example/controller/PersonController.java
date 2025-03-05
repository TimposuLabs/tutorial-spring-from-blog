package com.timposulabs.demo_mvc_dto_example.controller;

import com.timposulabs.demo_mvc_dto_example.dto.PersonDTO;
import com.timposulabs.demo_mvc_dto_example.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // ✅ GET: get all person (200 OK)
    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    // ✅ GET: get person by id (200 OK / 404 Not Found)
    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    // ✅ POST: create person (201 Created)
    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personDTO) {
        PersonDTO dto = personService.createPerson(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // ✅ PUT: update person (200 OK / 404 Not Found)
    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.updatePerson(id, personDTO));
    }

    // ✅ DELETE: delete person (200 OK / 404 Not Found)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
