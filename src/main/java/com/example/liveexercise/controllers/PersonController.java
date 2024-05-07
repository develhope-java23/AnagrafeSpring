package com.example.liveexercise.controllers;

import com.example.liveexercise.Person;
import com.example.liveexercise.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping(path = "/person/{id}")
    public Person getPerson(@PathVariable String id) {
        return service.getPerson(id);
    }

    @PostMapping(path = "/person/{id}")
    public Person addNewPerson(@PathVariable String id, @RequestBody Person person) {
        return service.createPerson(id, person);
    }
}
