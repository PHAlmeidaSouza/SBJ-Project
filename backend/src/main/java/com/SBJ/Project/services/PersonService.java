package com.SBJ.Project.services;


import com.SBJ.Project.controllers.PersonController;
import com.SBJ.Project.data.vo.v1.PersonVO;
import com.SBJ.Project.data.vo.v2.PersonVOV2;
import com.SBJ.Project.exceptions.ResourceNotFoundException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.SBJ.Project.mapper.DozerMapper;
import com.SBJ.Project.mapper.custom.PersonMapper;
import com.SBJ.Project.models.Person;
import com.SBJ.Project.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonVO> findAll() {
        logger.info("Find all people!");
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) throws Exception {
        logger.info("Finding by id: " + id);
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        var vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating person: " + person);
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating person: " + person);
        var entity = personMapper.convertVoToEntity(person);
        return personMapper.convertEntityToVo(personRepository.save(entity));
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating person: " + person);
        var entity = personRepository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting person: " + id);
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        personRepository.delete(entity);
    }

}
