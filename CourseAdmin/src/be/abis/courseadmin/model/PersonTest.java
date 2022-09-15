package be.abis.courseadmin.model;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p;

    @BeforeEach
    void setup() {
        p = new Person("Mary", "Jane", new Company("SpaceX"));
    }

    @org.junit.jupiter.api.Test
    void addHobby() {
        p.addHobby("Fencing");
        p.getHobbies().get(0);
        assertEquals("Fencing", p.getHobbies().get(0));
    }

    @org.junit.jupiter.api.Test
    void addHobbies() {
        String[] arrayHobbies = new String[]{"Fencing", "Reading", "Sky-diving", "walking", "playing video games"};
        List<String> hobbies = Arrays.asList(arrayHobbies);
        p.addHobbies(arrayHobbies);
        assertEquals(hobbies, p.getHobbies());
    }
}