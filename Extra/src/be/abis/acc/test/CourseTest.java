package be.abis.acc.test;

import be.abis.acc.model.Course;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course course;

    @BeforeEach
    public void setup() {
        course = new Course("Fencing", 30, 60, false);
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