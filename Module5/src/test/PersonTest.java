package test;

import enumm.Gender;
import model.Company;
import model.Person;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    Person p;

    @BeforeEach
    void setup() {
        p = new Person("Mary", "Jane", 33, Gender.FEMALE, new Company("SpaceX"));
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