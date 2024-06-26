package com.example.liveexercise;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person {

    private final String name;

    private final String surname;

    private final int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}

