package com.example.liveexercise.controllers;

import com.example.liveexercise.Person;
import com.example.liveexercise.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping(path = "/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable String id) {
        if (service.checkId(id)) {
            return ResponseEntity.status(HttpStatus.FOUND).body(service.getPerson(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(path = "/person/{id}")
    public ResponseEntity<Person> addNewPerson(@PathVariable String id, @RequestBody Person person) {
        if (service.checkId(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Person person1 = service.createPerson(id, person);
        return ResponseEntity.status(HttpStatus.CREATED).body(person1);
    }


}

