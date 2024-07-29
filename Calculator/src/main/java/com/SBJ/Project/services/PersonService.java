package com.SBJ.Project.services;


import com.SBJ.Project.exceptions.ResourceNotFoundException;
import com.SBJ.Project.models.Person;
import com.SBJ.Project.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {

        logger.info("Find all people!");

        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding by id: " + id);

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    }

    public Person create(Person person) {
        logger.info("Creating person: " + person);
        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating person: " + person);

        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting person: " + id);

        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        personRepository.delete(entity);
    }

}
