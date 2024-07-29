package com.SBJ.Project.services;


import com.SBJ.Project.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding by id: " + id);
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("John");
        person.setLastName("Smith");
        person.setAddress("Uberlandia - Minas Gerais");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating person: " + person);
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating person: " + person);
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting person: " + id);
    }

    private Person mockPerson(int i) {
        logger.info("Find all people!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Person lastname " + i);
        person.setAddress("Some address " + i);
        person.setGender("Male");
        return person;
    }

}
