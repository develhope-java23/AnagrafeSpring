package com.example.liveexercise.services;

import com.example.liveexercise.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PersonService {

    private HashMap<String, Person> database;

    public PersonService() {
        this.database = new HashMap<>();
    }

    public Person getPerson(String id) {
        return database.get(id);
    }

    public Person createPerson(String id, Person person) {
        database.put(id, person);
        return person;
    }

    public boolean checkId (String id) {
        if(database.containsKey(id)) {
            return true;
        } else {
            return false;
        }
    }
}
