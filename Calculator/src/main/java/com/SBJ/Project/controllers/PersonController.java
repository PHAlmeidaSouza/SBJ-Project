package com.SBJ.Project.controllers;

import com.SBJ.Project.models.Person;
import com.SBJ.Project.services.PersonService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") Long id) throws Exception {
        return personService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
