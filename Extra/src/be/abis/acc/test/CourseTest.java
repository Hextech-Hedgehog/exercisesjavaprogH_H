package be.abis.acc.test;

import be.abis.acc.model.AbisEmployee;
import be.abis.acc.model.Address;
import be.abis.acc.model.Company;
import be.abis.acc.model.Course;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course course;

    @BeforeEach
    public void setup() {
        Address address = new Address("Wayne avenue", "10", "200", "sim city", "Phillipines", "57");
        AbisEmployee employee = new AbisEmployee("Jeff", "Chun", 33, 20, 3000.0, new Address("Corridor avenue", "5", "1000", "Paris", "Phillipines", "57"), "Wayne enterprise", address);
        course = new Course("Fencing", 30, 60, false, new ArrayList<>(){{add(employee);}});
    }

    @Test
    void calculateTotalPrice() {
        assertEquals(1800, course.calculateTotalPrice());
    }

    @Test
    void testToString() {
        assertEquals("Fencing", course.toString().substring(13));
    }
}