package test;

import enumm.Gender;
import model.Address;
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
        Address address = new Address("Central Avenue", "21", "1000", "Metro polis", "Usa", "23");
        p = new Person("Mary", "Jane", 33, Gender.FEMALE, new Company("SpaceX", address));
    }

    @org.junit.jupiter.api.Test
    void addHobby() {
        p.addHobby("Fencing");
        assertEquals(true, p.getHobbies().contains("Fencing"));
    }

    @org.junit.jupiter.api.Test
    void addHobbies() {
        String[] arrayHobbies = new String[]{"Fencing", "Reading", "Sky-diving", "walking", "playing video games"};
        List<String> hobbies = Arrays.asList(arrayHobbies);
        p.addHobbies(arrayHobbies);
        assertEquals(hobbies, p.getHobbies());
    }
}