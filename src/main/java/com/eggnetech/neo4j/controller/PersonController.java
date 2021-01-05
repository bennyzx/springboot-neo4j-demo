package com.eggnetech.neo4j.controller;

import com.eggnetech.neo4j.entity.Person;
import com.eggnetech.neo4j.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/list")
    public List<Person> listPerson() {
        List<Person> persons = new ArrayList<>();
        Iterable<Person> iterable = personRepository.findAll();
        iterable.forEach(persons::add);
        return persons;
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }
}
