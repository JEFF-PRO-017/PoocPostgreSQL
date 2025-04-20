package com.pooc.poocpostgresql.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private  PersonRepository repository;

    @Autowired
    private  PersonProducer producer;


    @GetMapping
    public List<Person> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        Person saved = repository.save(person);
        producer.sendUserCreatedEvent("User created: " + saved.getName());
        return repository.save(person);
    }
}