package com.SBJ.Project.repositories;

import com.SBJ.Project.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
