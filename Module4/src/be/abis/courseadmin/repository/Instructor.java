package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.Course;

@FunctionalInterface
public interface Instructor {
    public void teachCourse(Course course);
}
